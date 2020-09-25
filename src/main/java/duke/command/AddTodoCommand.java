package duke.command;

import duke.exception.DukeTodoException;
import duke.tasks.TaskList;
import duke.tasks.Todo;

/**
 * Adds an instance of the <code>Todo</code> class into a <code>TaskList</code>
 */
public class AddTodoCommand extends ExecuteCommand {
    private String fullCommand;

    public AddTodoCommand(String fullCommand){
        this.fullCommand = fullCommand;
    }

    /**
     * Adds an instance of the <code>Todo</code> class into a <code>TaskList</code>
     * @param taskList An instance of the <code>TaskList</code> class for the user to append to
     * @throws DukeTodoException If there are no parameters written to initialise the creation of a new Todo class
     */
    @Override
    public void execute(TaskList taskList) throws DukeTodoException {
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
            temp.printTodo(taskList);
        }
    }

    /**
     * Checks whether the the user exits the program
     * @return <code>true</code> if user exits the program
     */
    public boolean isExit(){
        return false;
    }
}
