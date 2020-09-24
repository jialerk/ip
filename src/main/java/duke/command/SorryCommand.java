package duke.command;

import duke.tasks.TaskList;
import duke.ui.Ui;

public class SorryCommand extends Command {

    public void execute(TaskList taskList){
        Ui.printError();
    }

    public boolean isExit(){
        return false;
    }
}
