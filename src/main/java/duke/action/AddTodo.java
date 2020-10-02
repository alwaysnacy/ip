package duke.action;

import duke.task.Task;
import duke.task.ToDo;

/**
 * Adds a Todo task to the TaskManager.
 */
public class AddTodo extends AddAction {
    public static final String ACTION = "todo";
    public static final String HELP_MESSAGE = ACTION + ": Adds a Todo to the task list of DUKE.\n"
            + " Parameters: DESCRIPTION\n"
            + " Example: " + ACTION
            + " return books to the Library";
    public static Task task;

    public AddTodo(String description) {
        task = new ToDo(description, getTargetIndex());
    }

    @Override
    public ActionResult executeAction() {
        taskList.addTask(task);
        return new ActionResult(String.format(MESSAGE, task, taskList.getNumTasks()));

    }
}
