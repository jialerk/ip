public class Todo extends Task{

    public Todo(String description) {
        super(description);
    }

    public void printTodo(){
        System.out.println("____________________________________________________________\n" +
                "Got it. I've added this task:\n  " + this + "\n" +
                "Now you have " + total + (total == 1 ? " task in the list.\n" : " tasks in the list.\n") +
                "____________________________________________________________");
    }

    @Override
    public String toString(){
        return "[T]" + super.toString();
    }
}
