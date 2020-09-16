package duke.main;

import duke.exceptions.DukeException;
import duke.exceptions.InvalidTaskTypeException;
import duke.task.TaskManager;
import duke.task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

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

            System.out.println("Hello! I'm duke.main.Duke\n" + "What do you want to do today?");
            System.out.println(separatingLine);
        } else if (greeting.equals("bye")) {
            System.out.println(separatingLine);
            System.out.println("Bye. See you tomorrow!");
            System.out.println(separatingLine);
        }
    }

    public static void main(String[] args) throws DukeException, IOException {
        TaskManager todayList = new TaskManager();

        printGreetings("hello");

        String fileName = "duke.txt";
        Path filePath = null;
        FileWriter fw = new FileWriter(String.valueOf(filePath));

        Scanner sc = new Scanner(filePath);
        filePath = Paths.get(fileName);

//        Scanner sc = new Scanner(System.in);
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
                } else if (text.contains("delete")){
                    String[] commandSplit = text.split(" ");
                    int taskID = Integer.parseInt(commandSplit[1]) - 1;
                    todayList.deleteTask(taskID);
                    System.out.println("Now you have " + todayList.getNumTasks() + " tasks in the list.");
                } else{
                    todayList.addTask(text);
                    updateFile(filePath);
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
        for (int i=0; i< todayList.getNumTasks(); i++) {
            fw.write(todayList[i].toString() + System.lineSeparator());
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

    private static void updateFile(Path filePath) throws IOException {
        FileWriter fw = new FileWriter(String.valueOf(filePath));
        for (Task t : todayList) {
            fw.write(t.toString() + System.lineSeparator());
        }
        fw.write("There are a total of " + arrayOfTasks.size() + " tasks in the list.");
        fw.close();
    }
}
