package duke.task;

import duke.task.Task;

public class Event extends Task {
    protected String at;

    public  Event(String description, int id, String at) {
        super(description, id);
        this.at = at;
    }

    @Override
    public String toString() {
        return String.format("[E]%s %s (at: %s)",getStatus(), description, at);
    }
}
