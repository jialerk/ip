package duke;

import duke.command.Command;
import duke.command.ExecuteCommand;
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

/**
 * <h>DUKE</h>
 * The Duke program makes a mini to-do list helper for your everyday organisation
 *
 * @author ganjialerk
 * @version 0.2
 * @since 24 sep 2020
 */

public class Duke {
    public static String FILENAME = "data/duke.txt";

    private Storage storage;
    private TaskList tasks;

    /**
     * Initialises Duke
     * @param FileName of the <code>File</code> that stores the text data of the to-do list
     */
    public Duke(String FileName) {
        storage = new Storage(FileName);
        tasks = new TaskList(new ArrayList<>());
        storage.load(tasks);
    }

    /**
     * Runs the Duke program until the user exits the program
     */
    public void run() {
        Ui.printStart();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = Ui.readCommand();
                Command c = Parser.parse(fullCommand);
                if(c instanceof ExecuteCommand) {
                    ((ExecuteCommand) c).execute(tasks);
                }
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
            }catch (NumberFormatException e){
                Ui.printIndexError();
            }
        }
        Ui.printBye();
    }

    public static void main(String[] args) {
        new Duke(FILENAME).run();
    }
}