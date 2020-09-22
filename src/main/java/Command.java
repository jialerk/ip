public abstract class Command {

    abstract void execute(TaskList tasklist) throws DukeException;
    abstract boolean isExit();
}
