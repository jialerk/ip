package duke.command;


import duke.exception.DukeException;
import duke.tasks.TaskList;

public abstract class Command {

    public abstract void execute(TaskList tasklist) throws DukeException;
    public abstract boolean isExit();
}
