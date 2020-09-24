package duke.tasks;

/**
 * A class of <code>Deadline</code> for storage in a <code>TaskList</code>
 */
public class Deadline extends Task {

    protected String by;

    public Deadline(String description,boolean isDone, String by) {
        super(description,isDone);
        this.by = by;
    }

    public void printDeadline(TaskList taskList){
        System.out.println("____________________________________________________________\n" +
                "Got it. I've added this task:\n  " + this + "\n" +
                "Now you have " + taskList.getList().size() + (taskList.getList().size() == 1
                ? " task in the list.\n" : " duke.tasks in the list.\n") +
                "____________________________________________________________");
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
