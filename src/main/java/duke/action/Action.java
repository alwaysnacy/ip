package duke.action;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskManager;
import java.nio.file.Paths;

public class Action {
    protected TaskManager taskList;
    private int taskID = -1;

    protected Action() {
    }

    /**
     * Executes the action and returns the result.
     */
    public ActionResult executeAction() {
        throw new UnsupportedOperationException("To be implemented by child classes");
    }

    /**
     * Supplies the data the action will be executed on.
     */
    public void setData(TaskManager taskList) {
        this.taskList = taskList;
    }

    /**
     * Extracts the task with target taskID in the last shown list
     */
    public int getTargetIndex() {
        return taskID;
    }

    /**
     * modifies the default Storage file (duke.txt) whenever an action is executed
     */
    public void modifyFile() {
        try {
            Storage.saveToStorage(taskList, Paths.get(Storage.DEFAULT_STORAGE_FILEPATH));
        } catch (DukeException e) {
            e.printStackTrace();
        }
    }
}
