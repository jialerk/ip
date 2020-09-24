package duke;

import duke.command.Command;
import duke.exception.DukeDeadlineException;
import duke.exception.DukeEventException;
import duke.exception.DukeException;
import duke.exception.DukeTodoException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.tasks.TaskList;
import duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class Duke {
    public static String FILENAME = "data/duke.txt";

    private Storage storage;
    private TaskList tasks;

    public Duke(String FILENAME) {
        storage = new Storage(FILENAME);
        tasks = new TaskList(new ArrayList<>());
        storage.load(tasks);
    }

    public void run() {
        Ui.printStart();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = Ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks);
                isExit = c.isExit();
                tasks.saveTask(storage.getFileName());
            } catch (DukeTodoException e) {
                Ui.printTodoError();
            } catch (DukeDeadlineException e) {
                Ui.printDeadlineError();
            } catch (DukeEventException e) {
                Ui.printEventError();
            } catch (DukeException e) {
                Ui.printError();
            } catch (IOException e) {
                Ui.printWritingError();
            }
        }
        Ui.printBye();
    }

    public static void main(String[] args) {
        new Duke(FILENAME).run();
    }
}