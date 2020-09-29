package duke.actions;

import duke.exceptions.InvalidTaskTypeException;
import duke.task.Task;

public abstract class AddAction extends Action {
    public static final String MESSAGE = "Got it. I've added this task:\n %1$s\n"
            + "Now you have %2$d tasks in the list.";

    public static Task toAdd;

    public abstract ActionResult executeAction();
}
