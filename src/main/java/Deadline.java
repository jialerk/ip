public class Deadline extends Task{

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public void printDeadline(){
        System.out.println("____________________________________________________________\n" +
                "Got it. I've added this task:\n  " + this + "\n" +
                "Now you have " + total + " tasks in the list.\n" +
                "____________________________________________________________");
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
