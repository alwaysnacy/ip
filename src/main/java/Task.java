import java.util.ArrayList;

public class Task {
    private String task;
    private Boolean isDone;
    private int id;

    public Task(String task, int id) {
        this.task = task;
        this.isDone = false;
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public String getStatus() {
        return (isDone ? "[\u2713]" : "[\u2718]");
    }

    public void setAsDone ()  {
        isDone = true;
    }
}
