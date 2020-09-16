package duke.task;

import duke.task.Task;

public class ToDo extends Task {
    public ToDo(String description, int id) {
        super(description, id);
    }

    @Override
    public String toString() {
        return String.format("[T]%s %s", getStatus(), description);
    }
}
