package duke.actions;

public class HelpAction extends Action{
    public static final String ACTION = "help";

    public static final String HELP_MESSAGE = ACTION + ": Shows what you can do in DUKE.\n"
            + " Example: " + ACTION;

    @Override
    public ActionResult executeAction() {
        return new ActionResult(
                AddTodo.HELP_MESSAGE
                        + "\n" + AddEvent.HELP_MESSAGE
                        + "\n" + AddDeadline.HELP_MESSAGE
                        + "\n" + DeleteAction.HELP_MESSAGE
                        + "\n" + ListAction.HELP_MESSAGE
                        + "\n" + HelpAction.HELP_MESSAGE
                        + "\n" + ExitAction.HELP_MESSAGE
        );
    }
}
