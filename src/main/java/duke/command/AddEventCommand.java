package duke.command;

import duke.exception.DukeDeadlineException;
import duke.exception.DukeEventException;
import duke.exception.DukeTodoException;
import duke.tasks.Event;
import duke.tasks.TaskList;

/**
 * Adds an instance of the <code>Event</code> class into a <code>TaskList</code>
 */
public class AddEventCommand extends ExecuteCommand {
    private String fullCommand;

    public AddEventCommand(String fullCommand){
        this.fullCommand = fullCommand;
    }


    /**
     * Adds an instance of an <code>Event</code> class into a <code>TaskList</code>
     * @param taskList An instance of the <code>TaskList</code> class for the user to append to
     * @throws DukeTodoException If there are no parameters written to initialise the creation of a new Event class
     */
    public void execute(TaskList taskList) throws DukeEventException {
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
        temp.printEvent(taskList);
    }

    /**
     * Checks whether the the user exits the program
     * @return <code>true</code> if user exits the program
     */
    public boolean isExit(){
        return false;
    }
}
