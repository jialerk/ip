package duke.command;

import duke.exception.DukeException;
import duke.tasks.TaskList;

/**
 * Various commands that can be executed depending on the various inputs given by the user
 */
public abstract class ExecuteCommand extends Command{

    public abstract void execute(TaskList taskList) throws DukeException;
    public abstract boolean isExit();
}
