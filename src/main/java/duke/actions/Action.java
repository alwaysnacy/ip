package duke.actions;

import duke.task.Task;
import duke.task.TaskManager;

import static duke.ui.TextUi.INDEX_OFFSET;

public class Action {
    protected TaskManager taskList;
    private int taskID = -1;

    public Action(int targetIndex) {
        this.setTaskID(taskID);
    }

    protected Action() {
    }

    public ActionResult executeAction() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }

    public void setData(TaskManager taskList) {
        this.taskList = taskList;
    }

    protected String getOneTask() throws IndexOutOfBoundsException {
        return taskList.getStringOfTask(getTargetIndex() - INDEX_OFFSET);
    }

    public int getTargetIndex() {
        return taskID;
    }

    public void setTaskID(int ID) {
        this.taskID = ID;
    }
}
