public class Deadline extends Task {
    protected String by;

    public Deadline (String description, int id, String by) {
        super(description, id);
        this.by = by;
    }

    public String toString() {
        return String.format("[D]%s %s (by: %s)",getStatus(), description, by);
    }
}
