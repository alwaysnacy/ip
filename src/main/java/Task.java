import java.util.ArrayList;

public class Task {
    protected String description;
    protected Boolean isDone;
    protected int id;

    public Task(String description, int id) {
        this.description = description;
        this.isDone = false;
        this.id = id;
    }

    public String getTask() {
        return description;
    }

    public String getStatus() {
        return (isDone ? "[\u2713]" : "[\u2718]");
    }

    public void setAsDone ()  {
        isDone = true;
    }

    @Override
    public String toString() {
        return description;
    }
}
