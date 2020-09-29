package duke.actions;

import duke.task.Task;

import static duke.ui.TextUi.INDEX_OFFSET;

public class DeleteAction extends  Action {
    public static final String ACTION = "delete";
    public static final String HELP_MESSAGE = ACTION
            + ": Deletes the task identified by the index number.\n"
            + " Parameters: INDEX\n"
            + " Example: " + ACTION + " 1";
    private int taskID;

    public static final String MESSAGE = "Noted down. I've deleted this task:\n %1$s";

    public DeleteAction(int taskID) {
        this.taskID = taskID;
    }

    @Override
    public ActionResult executeAction() {
        final Task deletedTask = taskList.getTask(taskID-INDEX_OFFSET);
        taskList.deleteTask(this.taskID - INDEX_OFFSET);
        return new ActionResult(String.format(MESSAGE, deletedTask));

    }
}
