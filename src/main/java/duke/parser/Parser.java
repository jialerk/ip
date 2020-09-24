package duke.parser;

import duke.command.AddDeadlineCommand;
import duke.command.AddEventCommand;
import duke.command.AddTodoCommand;
import duke.command.Command;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.ExitCommand;
import duke.command.ListCommand;
import duke.command.SorryCommand;

/**
 * Allows the parsing of inputs provided by the user
 */
public class Parser {

    /**
     * Parses the inputs provided by the user
     * @param fullCommand
     * @return returns a command instance to execute a command
     */
    public static Command parse(String fullCommand){
        if(fullCommand.equals("bye")){
            return new ExitCommand();
        }else if (fullCommand.startsWith("done ")) {
            return new DoneCommand(fullCommand);
        } else if (fullCommand.equals("list")) {
            return new ListCommand();
        } else if (fullCommand.startsWith("todo")) {
            return new AddTodoCommand(fullCommand);
        } else if (fullCommand.startsWith("deadline")) {
            return new AddDeadlineCommand(fullCommand);
        } else if (fullCommand.startsWith("event")) {
            return new AddEventCommand(fullCommand);
        }else if (fullCommand.startsWith("delete ")){
            return new DeleteCommand(fullCommand);
        } else {
            return new SorryCommand();
        }
    }
}
