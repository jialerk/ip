package duke.command;

import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.ui.Ui;

/**
 * Allows the Deletion of any <code>Task</code> in a <code>TaskList</code>
 */
public class DeleteCommand extends ExecuteCommand {
    private String fullCommand;
    
    public DeleteCommand(String fullCommand){
        this.fullCommand = fullCommand;
    }

    /**
     * Deletes a Task in a <code>taskList</code>
     * @param taskList the <code>TaskList</code> instance of the TaskList class for the user to delete from
     */
    public void execute(TaskList taskList){
        String[] message = this.fullCommand.split(" ");
        int number = Integer.valueOf(message[1]);
        Task task = taskList.getList().get(number-1);
        taskList.getList().remove(number-1);
        Ui.printDelete(task,taskList.getList().size());
    }

    /**
     * Checks whether the the user exits the program
     * @return <code>true</code> if user exits the program
     */
    public boolean isExit(){
        return false;
    }
}
