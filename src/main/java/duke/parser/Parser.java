package duke.parser;

import duke.command.*;

public class Parser {

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
