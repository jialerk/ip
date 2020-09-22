import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class TaskList {
    private List<Task> taskList;

    public TaskList(List<Task> taskList){
        this.taskList = taskList;
    }

    public void add(Task task){
        this.taskList.add(task);
    }

    public List<Task> getList(){
        return this.taskList;
    }

    public void saveTask(String filename) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        for(Task task : this.taskList){
            if(task instanceof Todo){
                fileWriter.write("T | " + (task.isDone ? "1" : "0") + " | " +
                        task.description + "\n");
            }else if(task instanceof Deadline){
                String[] deadline =  task.description.split("/by");
                fileWriter.write("D | " + (task.isDone ? "1" : "0") + " | " +
                        task.description + " | " + ((Deadline) task).by + "\n");
            }else if(task instanceof Event) {
                fileWriter.write("E | " + (task.isDone ? "1" : "0") + " | " +
                        task.description + " | " + ((Event) task).at + "\n");
            }
        }
        fileWriter.close();
    }


}
