package duke;

import duke.action.Action;
import duke.action.ActionResult;
import duke.action.ExitAction;
import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskManager;
import duke.ui.TextUi;

public class Duke {

    private TaskManager todayList;
    private TextUi ui;
    private String filePath = "duke.txt";
    private Storage storage;

    public static void main(String[] args) {
        new Duke().run();
    }

    /**
     * Runs the program until termination.
     */
    public void run() {
        loadData();
        start();
        runCommandLoopUntilExitCommand();
        exit();
    }

    private void loadData() {
        storage = new Storage(filePath);
        try {
            todayList = storage.loadFromStorage();
        } catch (DukeException e) {
            todayList = new TaskManager();
        }
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
            action.modifyFile();
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

