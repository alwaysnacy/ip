package duke.action;

public abstract class AddAction extends Action {
    public static final String MESSAGE = "Got it. I've added this task:\n %1$s\n"
            + "Now you have %2$d tasks in the list.";

    public abstract ActionResult executeAction();

}
