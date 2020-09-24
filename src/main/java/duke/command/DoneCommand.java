package duke.command;

import duke.tasks.TaskList;
import duke.ui.Ui;

public class DoneCommand extends Command {
    private String fullCommand;

    public DoneCommand(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    public void execute(TaskList taskList){
            String[] message = this.fullCommand.split(" ");
            int number = Integer.valueOf(message[1]);
            taskList.getList().get(number-1).markAsDone();
            Ui.printDone(taskList.getList().get(number-1));
    }

    public boolean isExit(){
        return false;
    }
}
