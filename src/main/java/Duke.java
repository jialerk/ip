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
            try {
                if (input.equals("bye")) {
                    break;
                } else if (input.startsWith("done ")) {
                    Task task = makeDone(list, input);
                    printDone(task);
                } else if (input.equals("list")) {
                    printList(list);
                } else if (input.startsWith("todo")) {
                    Todo todo = createTodo(input);
                    list.add(todo);
                    todo.printTodo();
                } else if (input.startsWith("deadline")) {
                    Deadline deadline = createDeadline(input);
                    list.add(deadline);
                    deadline.printDeadline();
                } else if (input.startsWith("event")) {
                    Event event = createEvent(input);
                    list.add(event);
                    event.printEvent();
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

    private static Todo createTodo(String input) throws DukeTodoException{
        int startOfMessage = 5;
        int endOfMessage = input.length();
        if(endOfMessage <= startOfMessage){
            throw new DukeTodoException();
        }
        String message = input.substring(startOfMessage,endOfMessage);
        if(message.isEmpty()){
            throw new DukeTodoException();
        }else {
            Todo temp = new Todo(message);
            return temp;
        }
    }

    private static Deadline createDeadline(String input) throws DukeDeadlineException{
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
            Deadline temp = new Deadline(message, by);
            return temp;
        }
    }

    private static Event createEvent(String input) throws DukeEventException{
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
        Event temp = new Event(message, at);
        return temp;
    }
}
