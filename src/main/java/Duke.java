import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String separatingLine = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        TaskManager todayList = new TaskManager();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println(separatingLine);
        
        System.out.println("Hello! I'm Duke\n" + "What do you want to do today?");
        System.out.println(separatingLine);

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        while (!text.equals("bye")) {
            System.out.println(separatingLine);

            //list command
            if (text.equals("list")) {
                todayList.printTasks();
            //done command
            } else if (text.contains("done")) {
                String[] commandSplit = text.split(" ");
                int taskID = Integer.parseInt(commandSplit[1]) - 1;
                if (taskID < todayList.getNumTasks()) {
                    todayList.setTaskAsDone(taskID);
                    todayList.printOneTask(taskID);
                } else {
                    System.out.println("Invalid Task!");
                }
            //add command
            } else {
                System.out.println("Got it. I've added this task: ");
                todayList.addTask(text);
                todayList.printOneTask(todayList.getNumTasks() - 1);
                System.out.println("Now you have " + todayList.getNumTasks() + " tasks in the list.");
            }

            System.out.println(separatingLine);
            text = sc.nextLine();
        }

        System.out.println(separatingLine);
        System.out.println("Bye. See you tomorrow!");
        System.out.println(separatingLine);

    }
}
