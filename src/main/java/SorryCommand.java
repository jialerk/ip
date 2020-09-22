public class SorryCommand extends Command{

    public void execute(TaskList taskList){
        Ui.printError();
    }

    public boolean isExit(){
        return false;
    }
}
