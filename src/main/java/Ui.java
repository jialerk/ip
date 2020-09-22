import java.util.List;
import java.util.Scanner;

public class Ui {
    private static Scanner scan = new Scanner(System.in);

    public static String readCommand(){
        return scan.nextLine();
    }

    public static void printStart(){
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

    public static void printList(List<Task> list){
        int num = 1;
        System.out.println("____________________________________________________________\n" +
                "Here are the tasks in your list:");
        for(Task item : list){
            System.out.println(num+"."+item);
            num++;
        }
        System.out.println("____________________________________________________________");
    }

    public static void printDone(Task task){
        System.out.println("____________________________________________________________\n" +
                " Nice! I've marked this task as done:\n   " +
                task + "\n" +
                "__________________________________________________________");
    }

    public static void printDelete(Task task, int total){
        System.out.println("____________________________________________________________\n" +
                " Noted. I've removed this task:\n   " +
                task + "\n" +
                " Now you have " + total + (total == 1 ? " task in the list.\n" : " tasks in the list.\n") +
                "__________________________________________________________");
    }

    public static void printBye(){
        System.out.println("____________________________________________________________\n" +
                " Bye. Hope to see you again soon!\n" +
                "__________________________________________________________");
    }

    public static void printError(){
        System.out.println("____________________________________________________________\n" +
                " ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" +
                "__________________________________________________________");
    }

    public static void printTodoError(){
        System.out.println("____________________________________________________________\n" +
                " ☹ OOPS!!! The description of a todo cannot be empty.\n" +
                "__________________________________________________________");
    }

    public static void printDeadlineError(){
        System.out.println("____________________________________________________________\n" +
                " ☹ OOPS!!! The description of a deadline cannot be empty.\n" +
                "__________________________________________________________");
    }

    public static void printEventError(){
        System.out.println("____________________________________________________________\n" +
                " ☹ OOPS!!! The description of a event cannot be empty.\n" +
                "__________________________________________________________");
    }

    public static void fileNotFoundError(){
        System.out.println("File not found. Creating file...");
    }

    public static void createFileError(){
        System.out.println("Creating file failed.");
    }

    public static void printWritingError(){
        System.out.println("Writing to file failed.");
    }
}
