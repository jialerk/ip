public class Deadline extends Task{

    protected String by;

    public Deadline(String description,boolean isDone, String by) {
        super(description,isDone);
        this.by = by;
    }

    public void printDeadline(){
        System.out.println("____________________________________________________________\n" +
                "Got it. I've added this task:\n  " + this + "\n" +
                "Now you have " + total + (total == 1 ? " task in the list.\n" : " tasks in the list.\n") +
                "____________________________________________________________");
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
