package duke.task;

import duke.task.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDate at;

    public  Event(String description, int id, String at) {
        super(description, id);
        this.at = LocalDate.parse(at);
    }

    @Override
    public String toFile() {
        return String.format("E | %s | %s | %s", getStatusAsNumber(), description, at);
    }

    @Override
    public String toString() {
        return String.format("[E]%s %s (at: %s)",getStatus(), description,
                at.format(DateTimeFormatter.ofPattern("MMM d yyyy")));
    }
}
