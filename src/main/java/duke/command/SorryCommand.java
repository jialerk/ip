package duke.command;

import duke.tasks.TaskList;
import duke.ui.Ui;

/**
 * Allows the printing of an error line if the user did not input correctly
 */
public class SorryCommand extends ExecuteCommand {

    /**
     * Prints an error if the user fails to input correctly
     * @param taskList nil
     */
    @Override
    public void execute(TaskList taskList){
        Ui.printError();
    }

    /**
     * Checks whether the the user exits the program
     * @return <code>true</code> if user exits the program
     */
    public boolean isExit(){
        return false;
    }
}
