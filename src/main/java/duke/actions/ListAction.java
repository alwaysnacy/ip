package duke.actions;

public class ListAction extends Action {
    public static final String ACTION = "list";

    public static final String HELP_MESSAGE = ACTION
            + ": Displays all tasks in DUKE as a list with index numbers.\n"
            + " Example: " + ACTION;
    public static final String MESSAGE= "Here are the tasks in your list:\n";
    @Override
    public ActionResult executeAction() {
        return new ActionResult(MESSAGE + taskList.getStringOfAllTasks());
    }
}
