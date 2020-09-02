public class Event extends Task {
    protected String at;

    public  Event (String description, int id, String at) {
        super(description, id);
        this.at = at;
    }

    public String toString() {
        return String.format("[E]%s %s (by: %s)",getStatus(), description, at);
    }
}
