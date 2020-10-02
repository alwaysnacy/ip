package duke.task;

import java.util.ArrayList;

public class Task {
    protected String description;
    protected Boolean isDone;
    protected int taskID;

    public Task(String description, int taskID) {
        this.description = description;
        this.isDone = false;
        this.taskID = taskID;
    }

    public String getStatus() {
        return (isDone ? "[\u2713]" : "[\u2718]");
    }

    public String getStatusAsNumber() {
        return (isDone ? "1" : "0");
    }

    public void setAsDone ()  {
        isDone = true;
    }

    public String toFile() { return description; }

    @Override
    public String toString() {
        return description;
    }
}
