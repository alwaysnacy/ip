package duke.action;

import static duke.ui.TextUi.INDEX_OFFSET;


/**
 * Marks as done a task identified using it's last displayed index from the TaskManager.
 */
public class FinishAction extends Action {
    public static final String ACTION = "done";
    public static final String HELP_MESSAGE = ACTION + ": Set the task identified by index number as done. "
            + " Parameters: INDEX\n"
            + " Example: " + ACTION +"1";
    public static final String MESSAGE = "Nice! I've marked this task as done:\n %1$s";

    public static int taskID;

    public FinishAction(int taskID) {
        this.taskID = taskID;
    }

    @Override
    public ActionResult executeAction() {
        taskList.setTaskAsDone(this.taskID - INDEX_OFFSET);
        return new ActionResult(String.format(MESSAGE, taskList.getStringOfTask(taskID-INDEX_OFFSET)));

    }
}
