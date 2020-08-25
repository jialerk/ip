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
        ArrayList<Task> list = new ArrayList<>();
        while(true){
            int num = 1;
            //scan input
            String input = scan.nextLine();
            //check input and act based on different commands
            if(input.equals("bye")){
                break;
            }else if(input.contains("done ")){
                String[] message = input.split(" ");
                int number = Integer.valueOf(message[1]);
                list.get(number-1).markAsDone();
                System.out.println("____________________________________________________________\n" +
                        " Nice! I've marked this task as done:\n   " +
                        list.get(number-1)+"\n"+
                        "__________________________________________________________");
            }else if(input.equals("list")){
                System.out.println("____________________________________________________________");
                for(Task item : list){
                    System.out.println(num+"."+item);
                }
                System.out.println("____________________________________________________________");
            }else {
                Task temp = new Task(input);
                list.add(temp);
                System.out.println("____________________________________________________________\n" +
                        " added: " + input + "\n" +
                        "__________________________________________________________");
            }
        }
        System.out.println("____________________________________________________________\n" +
                " Bye. Hope to see you again soon!\n" +
                "__________________________________________________________");
    }
}
