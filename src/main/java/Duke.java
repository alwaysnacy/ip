import java.io.*;
import java.util.Scanner;

public class Duke {
    private static String separatingLine = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

    public static void printGreetings(String greeting) {

        if (greeting.equals("hello")) {
            String logo = " ____        _        \n"
                    + "|  _ \\ _   _| | _____ \n"
                    + "| | | | | | | |/ / _ \\\n"
                    + "| |_| | |_| |   <  __/\n"
                    + "|____/ \\__,_|_|\\_\\___|\n";
            System.out.println("Hello from\n" + logo);

            System.out.println(separatingLine);

            System.out.println("Hello! I'm Duke\n" + "What do you want to do today?");
            System.out.println(separatingLine);
        } else if (greeting.equals("bye")) {
            System.out.println(separatingLine);
            System.out.println("Bye. See you tomorrow!");
            System.out.println(separatingLine);
        }
    }

    public static void main(String[] args) throws DukeException {
        TaskManager todayList = new TaskManager();

        printGreetings("hello");

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        while (!text.equals("bye")) {
            System.out.println(separatingLine);

            //list command
            try {
                if (text.equals("list")) {
                    todayList.printTasks();
                    //done command
                } else if (text.contains("done")) {
                    setTaskDone(text, todayList);
                    //add command
                } else {
                    todayList.addTask(text);
                    System.out.println("Got it. I've added this task: ");
                    todayList.printOneTask(todayList.getNumTasks() - 1);
                    System.out.println("Now you have " + todayList.getNumTasks() + " tasks in the list.");
                }
            } catch (DukeException e) {
                System.out.println("OOPS!!! There is no such task!");
            } catch (NullPointerException e) {
                System.out.println("OOPS!!! No task ID like this!");
            } catch (InvalidTaskTypeException e) {
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means.");
            }

            System.out.println(separatingLine);
            text = sc.nextLine();
        }

        printGreetings("bye");

    }

    public static void setTaskDone(String text, TaskManager todayList) throws DukeException{
        String[] commandSplit = text.split(" ");
        int taskID = Integer.parseInt(commandSplit[1]) - 1;
        if (taskID < todayList.getNumTasks()) {
            todayList.setTaskAsDone(taskID);
            System.out.println("Nice! I've marked this task as done:");
            todayList.printOneTask(taskID);
        } else {
            throw new DukeException();
        }
    }
}
