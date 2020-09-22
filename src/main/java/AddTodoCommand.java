public class AddTodoCommand extends Command{
    private String fullCommand;

    public AddTodoCommand(String fullCommand){
        this.fullCommand = fullCommand;
    }

    public void execute(TaskList taskList) throws DukeTodoException{
        int startOfMessage = 5;
        int endOfMessage = fullCommand.length();
        if(endOfMessage <= startOfMessage){
            throw new DukeTodoException();
        }
        String message = fullCommand.substring(startOfMessage,endOfMessage);
        if(message.isEmpty()){
            throw new DukeTodoException();
        }else {
            Todo temp = new Todo(message, false);
            taskList.getList().add(temp);
            temp.printTodo();
        }
    }

    public boolean isExit(){
        return false;
    }
}
