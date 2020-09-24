package duke.command;

import duke.tasks.TaskList;
import duke.ui.Ui;

/**
 * A class that allows the user to list down the tasks they input into the <code>TaskList</code>
 */
public class ListCommand extends ExecuteCommand {

    /**
     * Prints the list of tasks in the TaskList
     * @param taskList the TaskList instance to list tasks from
     */
    public void execute(TaskList taskList){
        Ui.printList(taskList.getList());
    }

    /**
     * Checks whether the the user exits the program
     * @return <code>true</code> if user exits the program
     */
    public boolean isExit(){
        return false;
    }
}
