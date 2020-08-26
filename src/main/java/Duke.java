import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        TaskManager todayList = new TaskManager();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        for (int i = 0; i < 20; i++) {
            System.out.print("-");
        }
        System.out.println();
        
        System.out.println("Hello! I'm Duke\n" + "What do you want to do today?");
        for (int i = 0; i < 20; i++) {
            System.out.print("-");
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        while (!text.equals("bye")) {
            for (int i = 0; i < 20; i++) {
                System.out.print("-");
            }

            System.out.println();
            if (text.equals("list")) {
                todayList.printTasks();
            } else if (text.contains("done")) {
                String[] commandSplit = text.split(" ");
                int taskID = Integer.parseInt(commandSplit[1]) - 1;
                if (taskID < todayList.getNumTasks()) {
                    todayList.setTaskAsDone(taskID);
                    todayList.printTaskDone(taskID);
                } else {
                    System.out.println("Invalid Task!");
                }
            } else {
                System.out.println("added: " + text);
                todayList.addTask(text);
            }

            for (int i = 0; i < 20; i++) {
                System.out.print("-");
            }
            System.out.println();
            text = sc.nextLine();
        }

        for (int i = 0; i < 20; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("Bye. See you tomorrow!");
        for (int i = 0; i < 20; i++) {
            System.out.print("-");
        }
        System.out.println();

    }
}
