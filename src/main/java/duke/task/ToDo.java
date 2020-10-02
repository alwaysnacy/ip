package duke.task;

import duke.task.Task;

public class ToDo extends Task {
    public ToDo(String description, int taskID) {
        super(description, taskID);
    }

    @Override
    public String toFile() {
        return String.format("T | %s | %s", getStatusAsNumber(), description);
    }

    @Override
    public String toString() {
        return String.format("[T]%s %s", getStatus(), description);
    }
}
