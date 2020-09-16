import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static String FILENAME = "data/duke.txt";
    public static File file = new File(FILENAME);
    public static List<Task> list = new ArrayList<>();

    public static void main(String[] args) {

        printStart();
        initialiseList();
        Scanner scan = new Scanner(System.in);
        while(true){
            int num = 1;
            //scan input
            String input = scan.nextLine();
            //check input and act based on different commands
            try {
                if (input.equals("bye")) {
                    break;
                } else if (input.startsWith("done ")) {
                    Task task = makeDone(list, input);
                    printDone(task);
                    saveTask(list);
                } else if (input.equals("list")) {
                    printList(list);
                } else if (input.startsWith("todo")) {
                    Todo todo = createTodo(input,false);
                    list.add(todo);
                    todo.printTodo();
                    saveTask(list);
                } else if (input.startsWith("deadline")) {
                    Deadline deadline = createDeadline(input,false);
                    list.add(deadline);
                    deadline.printDeadline();
                    saveTask(list);
                } else if (input.startsWith("event")) {
                    Event event = createEvent(input,false);
                    list.add(event);
                    event.printEvent();
                    saveTask(list);
                }else if (input.startsWith("delete ")){
                    Task task = makeDelete(list,input);
                    printDelete(task,list.size());
                    saveTask(list);
                } else {
                    throw new DukeException();
                }
            }catch (DukeTodoException e) {
                printTodoError();
            }catch (DukeDeadlineException e) {
                printDeadlineError();
            }catch (DukeEventException e) {
                printEventError();
            }catch (DukeException e) {
                printError();
            }catch (IOException e){
                System.out.println("Writing to file failed.");
            }
        }
        printBye();
    }

    private static void initialiseList() {
        try {
            getFile();
        }catch(FileNotFoundException e){
            try{
                createFile();
                System.out.println("File not found. Creating file...");
            }catch(IOException e1){
                System.out.println("Creating file failed.");
            }
        }
    }

    private static void getFile() throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String content = scan.nextLine();
            String[] contents = content.split("\\s\\|\\s");
            String legend = contents[0].trim();
            Boolean done = Boolean.valueOf(contents[1].trim());
            String action = contents[2].trim();
            String action2 = "";
            if(legend.equals("D") || legend.equals("E")){
                action2 = contents[3].trim();
            }
            Task task;
            if(legend.equals("T")){
                list.add(new Todo(action,done));
            }else if(legend.equals("D")){
                list.add(new Deadline(action,done,action2));
            }else if(legend.equals("E")){
                list.add(new Event(action,done,action2));
            }
        }
    }

    private static void createFile() throws IOException{
        Path path = Paths.get(FILENAME);
        Files.createDirectory(path.getParent());
    }

    private static void printStart(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("____________________________________________________________\n" +
                " Hello! I'm Duke\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n");
    }

    private static void printList(List<Task> list){
        int num = 1;
        System.out.println("____________________________________________________________\n" +
                "Here are the tasks in your list:");
        for(Task item : list){
            System.out.println(num+"."+item);
            num++;
        }
        System.out.println("____________________________________________________________");
    }

    private static void printDone(Task task){
        System.out.println("____________________________________________________________\n" +
                " Nice! I've marked this task as done:\n   " +
                task + "\n" +
                "__________________________________________________________");
    }

    private static void printDelete(Task task, int total){
        System.out.println("____________________________________________________________\n" +
                " Noted. I've removed this task:\n   " +
                task + "\n" +
                " Now you have " + total + (total == 1 ? " task in the list.\n" : " tasks in the list.\n") +
                "__________________________________________________________");
    }

    private static void printBye(){
        System.out.println("____________________________________________________________\n" +
                " Bye. Hope to see you again soon!\n" +
                "__________________________________________________________");
    }

    private static void printError(){
        System.out.println("____________________________________________________________\n" +
                " ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" +
                "__________________________________________________________");
    }

    private static void printTodoError(){
        System.out.println("____________________________________________________________\n" +
                " ☹ OOPS!!! The description of a todo cannot be empty.\n" +
                "__________________________________________________________");
    }

    private static void printDeadlineError(){
        System.out.println("____________________________________________________________\n" +
                " ☹ OOPS!!! The description of a deadline cannot be empty.\n" +
                "__________________________________________________________");
    }

    private static void printEventError(){
        System.out.println("____________________________________________________________\n" +
                " ☹ OOPS!!! The description of a event cannot be empty.\n" +
                "__________________________________________________________");
    }

    private static Task makeDone(List<Task> list, String input){
        String[] message = input.split(" ");
        int number = Integer.valueOf(message[1]);
        list.get(number-1).markAsDone();
        return list.get(number-1);
    }

    private static Task makeDelete(List<Task> list, String input){
        String[] message = input.split(" ");
        int number = Integer.valueOf(message[1]);
        Task task = list.get(number-1);
        list.remove(number-1);
        return task;
    }

    private static Todo createTodo(String input,boolean isDone) throws DukeTodoException{

        int startOfMessage = 5;
        int endOfMessage = input.length();
        if(endOfMessage <= startOfMessage){
            throw new DukeTodoException();
        }
        String message = input.substring(startOfMessage,endOfMessage);
        if(message.isEmpty()){
            throw new DukeTodoException();
        }else {
            Todo temp = new Todo(message, isDone);
            return temp;
        }
    }

    private static Deadline createDeadline(String input,boolean isDone) throws DukeDeadlineException{
        int startOfMessage = 9;
        int endOfMessage = input.indexOf("/by")-1;
        int startOfBy = input.indexOf("/by") + 4;
        int endOfBy = input.length();
        if(endOfMessage <= startOfMessage) {
            throw new DukeDeadlineException();
        }
        String message = input.substring(startOfMessage, endOfMessage);
        String by = input.substring(startOfBy,endOfBy);
        if(message.isEmpty() || by.isEmpty()){
            throw new DukeDeadlineException();
        }else {
            Deadline temp = new Deadline(message, isDone, by);
            return temp;
        }
    }

    private static Event createEvent(String input,boolean isDone) throws DukeEventException{
        int startOfMessage = 6;
        int endOfMessage = input.indexOf("/at")-1;
        int startOfAt = input.indexOf("/at") + 4;
        int endOfAt = input.length();
        if(endOfMessage <= startOfMessage) {
            throw new DukeEventException();
        }
        String message = input.substring(startOfMessage, endOfMessage);
        String at = input.substring(startOfAt,endOfAt);
        if(message.isEmpty() || at.isEmpty()){
            throw new DukeEventException();
        }
        Event temp = new Event(message, isDone,at);
        return temp;
    }

    private static void saveTask(List<Task> list) throws IOException{
        FileWriter fileWriter = new FileWriter(FILENAME);
        for(Task task : list){
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
