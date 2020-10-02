package duke.action;

import duke.task.Event;
import duke.task.Task;

import java.time.LocalDateTime;

/**
 * Adds an Event task to the TaskManager.
 */
public class AddEvent extends AddAction {
    public static final String ACTION = "event";
    public static Task task;
    public static final String HELP_MESSAGE = ACTION + ": Adds an Event to the task list of DUKE.\n"
            + " Parameters: DESCRIPTION /at YYYY-MM-DD HH:MM\n"
            + " Example: " + ACTION
            + " meet with the CS2113 team /at 2020-10-12 16:00";

    public AddEvent(String description, LocalDateTime atTime) {
        task = new Event(description, getTargetIndex(), atTime);
    }

    @Override
    public ActionResult executeAction() {
        taskList.addTask(task);
        return new ActionResult(String.format(MESSAGE, task, taskList.getNumTasks()));
    }

}
