public class AddEventCommand extends Command{
    private String fullCommand;

    public AddEventCommand(String fullCommand){
        this.fullCommand = fullCommand;
    }

    public void execute(TaskList taskList) throws DukeEventException{
        int startOfMessage = 6;
        int endOfMessage = fullCommand.indexOf("/at")-1;
        int startOfAt = fullCommand.indexOf("/at") + 4;
        int endOfAt = fullCommand.length();
        if(endOfMessage <= startOfMessage) {
            throw new DukeEventException();
        }
        String message = fullCommand.substring(startOfMessage, endOfMessage);
        String at = fullCommand.substring(startOfAt,endOfAt);
        if(message.isEmpty() || at.isEmpty()){
            throw new DukeEventException();
        }
        Event temp = new Event(message, false,at);
        taskList.getList().add(temp);
        temp.printEvent();
    }

    public boolean isExit(){
        return false;
    }
}
