package duke.storage;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.TaskList;
import duke.tasks.Todo;
import duke.ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Storage {

    private File file;
    private String fileName;

    public Storage(String fileName){
        this.fileName = fileName;
        this.file = new File(fileName);
    }

    public String getFileName(){
        return this.fileName;
    }

    public void load(TaskList taskList) {
        try {
            getFile(taskList);
        }catch(FileNotFoundException e){
            try{
                createFile();
                Ui.fileNotFoundError();
            }catch(IOException e1){
                Ui.createFileError();
            }
        }
    }

    private void getFile(TaskList taskList) throws FileNotFoundException {
        Scanner scan = new Scanner(this.file);
        while(scan.hasNextLine()){
            String content = scan.nextLine();
            String[] contents = content.split("\\s\\|\\s");
            String legend = contents[0].trim();
            Boolean done = (Integer.valueOf(contents[1].trim()) == 1) ? true : false;
            String action = contents[2].trim();
            String action2 = "";
            if(legend.equals("D") || legend.equals("E")){
                action2 = contents[3].trim();
            }
            if(legend.equals("T")){
                taskList.add(new Todo(action,done));
            }else if(legend.equals("D")){
                taskList.add(new Deadline(action,done,action2));
            }else if(legend.equals("E")){
                taskList.add(new Event(action,done,action2));
            }
        }
    }

    private void createFile() throws IOException{
        Path path = Paths.get(this.fileName);
        Files.createDirectory(path.getParent());
    }
}
