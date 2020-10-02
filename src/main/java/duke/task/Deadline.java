package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDateTime by;

    public Deadline (String description, int taskID, LocalDateTime by) {
        super(description, taskID);
        this.by = by;
    }

    @Override
    public String toFile() {
        return String.format("D | %s | %s | %s", getStatusAsNumber(), description,
                by.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }

    @Override
    public String toString() {
        return String.format("[D]%s %s (by: %s)",getStatus(), description,
                by.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm")));
    }

}
