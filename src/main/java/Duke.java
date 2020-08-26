import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String[] tasks = new String[100];

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
                for (int i=0; i<j; i++) {
                    System.out.println(i+1 + ". " + tasks[i]);
                }
            } else {
                System.out.println("added: " + line);
                tasks[j] = line;
                j++;
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
