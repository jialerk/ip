package duke.command;

import duke.tasks.TaskList;

/**
 * A class to allow the user to exit the program when they input "bye"
 */
public class ExitCommand extends Command {

    /**
     * Checks whether the the user exits the program
     * @return <code>true</code> if user exits the program
     */
    public boolean isExit(){
        return true;
    }
}
