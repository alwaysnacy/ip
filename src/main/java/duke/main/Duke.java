package duke.main;

import duke.actions.Action;
import duke.actions.ActionResult;
import duke.actions.ExitAction;
import duke.exceptions.DukeException;
import duke.exceptions.InvalidTaskTypeException;
import duke.parser.Parser;
import duke.task.TaskManager;
import duke.task.Task;
import duke.ui.TextUi;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.IOException;


import java.util.Scanner;
import java.util.ArrayList;

import static java.lang.System.lineSeparator;

public class Duke {

    private TaskManager todayList = new TaskManager();
    private TextUi ui;

    public static void main(String[] args) {
        new Duke().run();
    }

    /**
     * Runs the program until termination.
     */
    public void run() {
        start();
        runCommandLoopUntilExitCommand();
        exit();
    }

    private void start() {
        this.ui = new TextUi();
        ui.printWelcomeMessage();
    }

    private void exit() {
        ui.printGoodbyeMessage();
        System.exit(0);
    }

    private void runCommandLoopUntilExitCommand() {
        Action action;
        do {
            String userInput = ui.getUserInput();
            action = new Parser().parseInput(userInput);
            ActionResult result = executeCommand(action);
            //taskList.setLastShownList(result.getRelevantPersons());
            ui.printActionResult(result);

        } while (!ExitAction.isExit(action));
    }

    private ActionResult executeCommand(Action action) {
        try {
            action.setData(todayList);
            ActionResult result = action.executeAction();
            return result;
        } catch (Exception e) {
            ui.printScreen(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
//    private static String separatingLine = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
//
//    public static void printGreetings(String greeting) {
//
//        if (greeting.equals("hello")) {
//            String logo = " ____        _        \n"
//                    + "|  _ \\ _   _| | _____ \n"
//                    + "| | | | | | | |/ / _ \\\n"
//                    + "| |_| | |_| |   <  __/\n"
//                    + "|____/ \\__,_|_|\\_\\___|\n";
//            System.out.println("Hello from\n" + logo);
//
//            System.out.println(separatingLine);
//
//            System.out.println("Hello! I'm duke.main.Duke\n" + "What do you want to do today?");
//            System.out.println(separatingLine);
//        } else if (greeting.equals("bye")) {
//            System.out.println(separatingLine);
//            System.out.println("Bye. See you tomorrow!");
//            System.out.println(separatingLine);
//        }
//    }
//
//    public static void main(String[] args) throws DukeException, IOException {



//        printGreetings("hello");
//        String file2 = "data/duke.txt";
//        System.out.println("full path: " + f.getAbsolutePath());
//        Path filePath = null;
//        FileWriter fw = new FileWriter(String.valueOf("data/duke.txt"));
//
//          Scanner sc = new Scanner(f);
//        filePath = Paths.get(fileName);

//        Scanner sc = new Scanner(System.in);
//        String text = sc.nextLine();
//
//        while (!text.equals("bye")) {
//            System.out.println(separatingLine);
//
//            //list command
//            try {
//                if (text.equals("list")) {
//                    todayList.printTasks();
//                    //done command
//                } else if (text.contains("done")) {
//                    setTaskDone(text, todayList);
//                    //add command
//                } else if (text.contains("delete")){
//                    String[] commandSplit = text.split(" ");
//                    int taskID = Integer.parseInt(commandSplit[1]) - 1;
//                    System.out.println("Noted down. I've deleted this task: ");
//                    todayList.printOneTask(taskID);
//                    todayList.deleteTask(taskID);
//                    System.out.println("Now you have " + todayList.getNumTasks() + " tasks in the list.");
//                } else{
//                    todayList.addTask(text);
//                    System.out.println("Got it. I've added this task: ");
//                    todayList.printOneTask(todayList.getNumTasks() - 1);
//                    System.out.println("Now you have " + todayList.getNumTasks() + " tasks in the list.");
//                    try {
//                        writeToFile(file2, todayList.getTask(todayList.getNumTasks()-1) + lineSeparator());
//                    } catch (IOException e) {
//                        System.out.println("Something went wrong: " + e.getMessage());
//                    }
//                }
//            } catch (DukeException e) {
//                System.out.println("OOPS!!! There is no such task!");
//            } catch (NullPointerException e) {
//                System.out.println("OOPS!!! No task ID like this!");
//            } catch (InvalidTaskTypeException e) {
//                System.out.println("OOPS!!! I'm sorry, but I don't know what that means.");
//            }
//
//            System.out.println(separatingLine);
//            text = sc.nextLine();
//        }
////        for (int i=0; i< todayList.getNumTasks(); i++) {
////            fw.write(todayList[i].toString() + System.lineSeparator());
////        }
//
//        printGreetings("bye");
//
//    }
//
//    public static void setTaskDone(String text, TaskManager todayList) throws DukeException{
//        String[] commandSplit = text.split(" ");
//        int taskID = Integer.parseInt(commandSplit[1]) - 1;
//        if (taskID < todayList.getNumTasks()) {
//            todayList.setTaskAsDone(taskID);
//            System.out.println("Nice! I've marked this task as done:");
//            todayList.printOneTask(taskID);
//        } else {
//            throw new DukeException();
//        }
//    }
//
//    private static void writeToFile(String filePath, String textToAdd) throws IOException {
//        FileWriter fw = new FileWriter(filePath, true);
//        fw.write(textToAdd);
//        fw.close();
//    }


//}
