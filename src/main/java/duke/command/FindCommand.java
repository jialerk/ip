package duke.command;

import duke.tasks.TaskList;
import duke.ui.Ui;

public class FindCommand extends ExecuteCommand{
    private String fullcommand;

    public FindCommand(String fullcommand){
        this.fullcommand = fullcommand;
    }

    public void execute(TaskList taskList){
        String[] message = this.fullcommand.split(" ");
        Ui.printFind(taskList,message[1]);
    }

    /**
     * Checks whether the the user exits the program
     * @return <code>true</code> if user exits the program
     */
    public boolean isExit(){
        return false;
    }
}
