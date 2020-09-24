package duke.command;

import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.ui.Ui;

public class DeleteCommand extends Command {
    private String fullCommand;
    
    public DeleteCommand(String fullCommand){
        this.fullCommand = fullCommand;
    }

    public void execute(TaskList taskList){
        String[] message = this.fullCommand.split(" ");
        int number = Integer.valueOf(message[1]);
        Task task = taskList.getList().get(number-1);
        taskList.getList().remove(number-1);
        Ui.printDelete(task,taskList.getList().size());
    }

    public boolean isExit(){
        return false;
    }
}
