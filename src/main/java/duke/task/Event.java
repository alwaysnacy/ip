package duke.task;

import duke.task.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDateTime at;

    public  Event(String description, int taskID, LocalDateTime at) {
        super(description, taskID);
        this.at = at;
    }

    @Override
    public String toFile() {
        return String.format("E | %s | %s | %s", getStatusAsNumber(), description,
                at.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }

    @Override
    public String toString() {
        return String.format("[E]%s %s (at: %s)",getStatus(), description,
                at.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm")));
    }

}
