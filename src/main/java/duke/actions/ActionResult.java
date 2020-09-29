package duke.actions;

import duke.task.Task;

import java.util.ArrayList;
import java.util.List;

public class ActionResult {

    public final String outputToScreen;

    private final ArrayList<Task> tasks;

    public ActionResult(String outputToScreen) {
        this.outputToScreen = outputToScreen;
        tasks = null;
    }
    public ActionResult(String outputToScreen, ArrayList<Task> tasks) {
        this.outputToScreen = outputToScreen;
        this.tasks = tasks;
    }

    public ArrayList<Task> getAddedTasks() {
        return tasks;
    }
}
