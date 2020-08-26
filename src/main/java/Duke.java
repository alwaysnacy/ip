import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        TaskManager list1 = new TaskManager();

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

        int j =0;
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (!line.equals("bye")) {
            for (int i = 0; i < 20; i++) {
                System.out.print("-");
            }

            System.out.println();
            if (line.equals("list")) {
                list1.printTasks();
            } else if (line.contains("done")) {
                String[] commandSplit = line.split(" ");
                int taskID = Integer.parseInt(commandSplit[1]);
                if (taskID <= list1.getNumTasks()) {
                    list1.setTaskAsDone(taskID-1);
                    list1.printTaskDone(taskID-1);
                } else {
                    System.out.println("Invalid Task!");
                }
            } else {
                System.out.println("added: " + line);
                list1.addTask(line);
            }

            for (int i = 0; i < 20; i++) {
                System.out.print("-");
            }
            System.out.println();
            line = sc.nextLine();
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
