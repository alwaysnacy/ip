package duke.action;

/**
 * Represents an invalid action. Upon execution, produces some feedback to the user.
 */
public class InvalidAction extends Action {
    public final String outputToScreen;
    public InvalidAction(String outputToScreen) {
        this.outputToScreen = outputToScreen;
    }

    public ActionResult executeAction() {
        return new ActionResult(outputToScreen);
    }
}
