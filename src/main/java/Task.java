public class Task {
    protected String description;
    protected boolean isDone;
    protected static int total = 0;

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
        total++;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone(){
        this.isDone = true;
    }

    @Override
    public String toString(){
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
}
