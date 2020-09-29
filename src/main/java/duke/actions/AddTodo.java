package duke.actions;

import duke.exceptions.InvalidTaskTypeException;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

public class AddTodo extends AddAction {
    public static final String ACTION = "todo";
    public static final String HELP_MESSAGE = ACTION + ": Adds a Todo to the task list of DUKE.\n"
            + " Parameters: DESCRIPTION\n"
            + " Example: " + ACTION
            + " meet with the CS2113 team /at 2020-10-12 1600";
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
