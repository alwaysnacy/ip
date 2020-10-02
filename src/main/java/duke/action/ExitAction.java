package duke.action;

/**
 * Exits the Duke
 */
public class ExitAction extends Action{
    public static final String ACTION = "bye";

    public static final String HELP_MESSAGE = ACTION + ": Exits the program.\n"
            + " Example: " + ACTION;
    public static final String EXIT_MESSAGE = "I am closing today's task list ...";

    public ActionResult executeAction() {
        return new ActionResult(EXIT_MESSAGE);
    }

    public static boolean isExit(Action action) {
        return action instanceof ExitAction; // instanceof returns false if it is null
    }
}
