public class AddDeadlineCommand extends Command{
    private String fullCommand;

    public AddDeadlineCommand(String fullCommand){
        this.fullCommand = fullCommand;
    }

    public void execute(TaskList taskList) throws DukeDeadlineException{
        int startOfMessage = 9;
        int endOfMessage = fullCommand.indexOf("/by")-1;
        int startOfBy = fullCommand.indexOf("/by") + 4;
        int endOfBy = fullCommand.length();
        if(endOfMessage <= startOfMessage) {
            throw new DukeDeadlineException();
        }
        String message = fullCommand.substring(startOfMessage, endOfMessage);
        String by = fullCommand.substring(startOfBy,endOfBy);
        if(message.isEmpty() || by.isEmpty()){
            throw new DukeDeadlineException();
        }else {
            Deadline temp = new Deadline(message, false, by);
            taskList.getList().add(temp);
            temp.printDeadline();
        }
    }

    public boolean isExit(){
        return false;
    }
}
