package duke.actions;

public class InvalidAction extends Action {
    public final String outputToScreen;
    public InvalidAction(String outputToScreen) {
        this.outputToScreen = outputToScreen;
    }

    public ActionResult executeAction() {
        return new ActionResult(outputToScreen);
    }
}
