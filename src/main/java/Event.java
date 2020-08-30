public class Event extends Task{

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public void printEvent(){
        System.out.println("____________________________________________________________\n" +
                "Got it. I've added this task:\n  " + this + "\n" +
                "Now you have " + total + " tasks in the list.\n" +
                "____________________________________________________________");
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
