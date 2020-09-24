package duke.command;

import duke.tasks.TaskList;
import duke.ui.Ui;

public class ListCommand extends Command {

    public void execute(TaskList taskList){
        Ui.printList(taskList.getList());
    }

    public boolean isExit(){
        return false;
    }
}
