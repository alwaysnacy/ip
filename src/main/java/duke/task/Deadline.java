package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDate by;

    public Deadline (String description, int id, String by) {
        super(description, id);
        this.by = LocalDate.parse(by);
    }

    @Override
    public String toFile() {
        return String.format("D | %s | %s | %s", getStatusAsNumber(), description, by);
    }

    @Override
    public String toString() {
        return String.format("[D]%s %s (by: %s)",getStatus(), description,
                by.format(DateTimeFormatter.ofPattern("MMM d yyyy")));
    }
}
