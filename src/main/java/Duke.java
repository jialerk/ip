import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        printStart();
        Scanner scan = new Scanner(System.in);
        List<Task> list = new ArrayList<Task>();
        while(true){
            int num = 1;
            //scan input
            String input = scan.nextLine();
            //check input and act based on different commands
            if(input.equals("bye")){
                break;
            }else if(input.startsWith("done ")){
                Task task = makeDone(list,input);
                printDone(task);
            }else if(input.equals("list")){
                printList(list);
            }else if(input.startsWith("todo ")){
                Todo todo = createTodo(input);
                list.add(todo);
                todo.printTodo();
            }else if(input.startsWith("deadline ")) {
                Deadline deadline = createDeadline(input);
                list.add(deadline);
                deadline.printDeadline();
            }else if(input.startsWith("event ")) {
                Event event = createEvent(input);
                list.add(event);
                event.printEvent();
            }else{
                continue;
            }
        }
        printBye();
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

    private static void printDone(Task list){
        System.out.println("____________________________________________________________\n" +
                " Nice! I've marked this task as done:\n   " +
                list + "\n" +
                "__________________________________________________________");
    }

    private static void printBye(){
        System.out.println("____________________________________________________________\n" +
                " Bye. Hope to see you again soon!\n" +
                "__________________________________________________________");
    }

    private static Task makeDone(List<Task> list, String input){
        String[] message = input.split(" ");
        int number = Integer.valueOf(message[1]);
        list.get(number-1).markAsDone();
        return list.get(number-1);
    }

    private static Todo createTodo(String input){
        int startOfMessage = 5;
        int endOfMessage = input.length();
        String message = input.substring(startOfMessage,endOfMessage);
        Todo temp = new Todo(message);
        return temp;
    }

    private static Deadline createDeadline(String input){
        int startOfMessage = 9;
        int endOfMessage = input.indexOf("/by")-1;
        int startOfBy = input.indexOf("/by") + 4;
        int endOfBy = input.length();
        String message = input.substring(startOfMessage, endOfMessage);
        String by = input.substring(startOfBy,endOfBy);
        Deadline temp = new Deadline(message,by);
        return temp;
    }

    private static Event createEvent(String input){
        int startOfMessage = 6;
        int endOfMessage = input.indexOf("/at")-1;
        int startOfAt = input.indexOf("/at") + 4;
        int endOfAt = input.length();
        String message = input.substring(startOfMessage, endOfMessage);
        String At = input.substring(startOfAt,endOfAt);
        Event temp = new Event(message,At);
        return temp;
    }
}
