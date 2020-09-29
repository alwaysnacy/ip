package duke.actions;

import duke.exceptions.InvalidTaskTypeException;
import duke.task.Event;
import duke.task.Task;

public class AddEvent extends AddAction {
    public static final String ACTION = "event";
    public static Task task;
    public static final String HELP_MESSAGE = ACTION + ": Adds an Event to the task list of DUKE.\n"
            + " Parameters: DESCRIPTION /at YYYY-MM-DD TIME\n"
            + " Example: " + ACTION
            + " return books to the Library";

    public AddEvent(String description, String atTime) {
        task = new Event(description, getTargetIndex(), atTime);
    }

    @Override
    public ActionResult executeAction() {

        taskList.addTask(task);
        return new ActionResult(String.format(MESSAGE, task, taskList.getNumTasks()));
    }

}
