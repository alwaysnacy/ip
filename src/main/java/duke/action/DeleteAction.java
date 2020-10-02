package duke.action;

import duke.task.Task;

/**
 * Deletes a task identified using it's last displayed index from the TaskManager.
 */
public class DeleteAction extends  Action {
    public static final String ACTION = "delete";
    public static final String HELP_MESSAGE = ACTION
            + ": Deletes the task identified by the index number.\n"
            + " Parameters: INDEX\n"
            + " Example: " + ACTION + " 1";
    private int taskID;

    public static final String MESSAGE = "Noted down. I've deleted this task:\n %1$s\n"
            + "Now you have %2$d tasks in the list.";;

    public DeleteAction(int taskID) {
        this.taskID = taskID;
    }

    @Override
    public ActionResult executeAction() {
        final Task deletedTask = taskList.getTask(taskID);
        taskList.deleteTask(this.taskID);
        return new ActionResult(String.format(MESSAGE, deletedTask, taskList.getNumTasks()));
    }
}
