package duke.actions;

import duke.exceptions.InvalidTaskTypeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;

public class AddDeadline extends AddAction{
    public static final String ACTION = "deadline";
    public static final String HELP_MESSAGE = ACTION + ": Adds a Deadline to the task list of DUKE.\n"
            + " Parameters: DESCRIPTION /by YYYY-MM-DD TIME\n"
            + " Example: " + ACTION
            + " submit the third Math homework /by 2020-10-03 2359";
    public static Task task;

    public AddDeadline(String description, String byTime) {
        task = new Deadline(description, getTargetIndex(), byTime);
    }

    @Override
    public ActionResult executeAction() {
        taskList.addTask(task);

        return new ActionResult(String.format(MESSAGE, task, taskList.getNumTasks()));

    }
}
