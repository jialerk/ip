package duke.command;


import duke.exception.DukeException;
import duke.tasks.TaskList;

/**
 * Various commands to use depending on the various inputs given by the user
 */
public abstract class Command {

    public abstract boolean isExit();
}
