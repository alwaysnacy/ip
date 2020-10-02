package duke.action;

/**
 * Lists all tasks in the TaskManager of Duke
 */
public class ListAction extends Action {
    public static final String ACTION = "list";

    public static final String HELP_MESSAGE = ACTION
            + ": Displays all tasks in DUKE as a list with index numbers.\n"
            + " Example: " + ACTION;
    public static final String MESSAGE= "Here are the tasks in your list:\n%1$s"
            + "You have %2$d tasks in the list";
    public static final String NO_TASK_MESSAGE = "You are having no task!";

    @Override
    public ActionResult executeAction() {
        if (taskList.getNumTasks() == 0) {
            return new ActionResult(NO_TASK_MESSAGE);
        }
        return new ActionResult(String.format(MESSAGE, taskList.getStringOfAllTasks(), taskList.getNumTasks()));
    }
}
