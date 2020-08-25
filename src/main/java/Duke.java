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
        ArrayList<String> bye = new ArrayList<>();
        while(true){
            int num = 1;
            String hello = scan.nextLine();
            if(hello.equals("bye")){
                break;
            }else if(hello.equals("list")){
                System.out.println("____________________________________________________________");
                for(String item : bye){
                    System.out.println(num+". "+item);
                }
                System.out.println("____________________________________________________________");
            }else {
                bye.add(hello);
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
