import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
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
        Scanner scan = new Scanner(System.in);
        ArrayList<Task> bye = new ArrayList<>();
        while(true){
            int num = 1;
            String hello = scan.nextLine();
            if(hello.equals("bye")){
                break;
            }else if(hello.contains("done ")){
                String[] split = hello.split(" ");
                int number = Integer.valueOf(split[1]);
                bye.get(number-1).markAsDone();
                System.out.println("____________________________________________________________\n" +
                        " Nice! I've marked this task as done:\n   " +
                        bye.get(number-1)+"\n"+
                        "__________________________________________________________");
            }else if(hello.equals("list")){
                System.out.println("____________________________________________________________");
                for(Task item : bye){
                    System.out.println(num+"."+item);
                }
                System.out.println("____________________________________________________________");
            }else {
                Task t = new Task(hello);
                bye.add(t);
                System.out.println("____________________________________________________________\n" +
                        " added: " + hello + "\n" +
                        "__________________________________________________________");
            }
        }
        System.out.println("____________________________________________________________\n" +
                " Bye. Hope to see you again soon!\n" +
                "__________________________________________________________");
    }
}
