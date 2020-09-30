package duke.actions;

public class FindAction extends Action {
    public static final String ACTION = "find";

    public static final String HELP_MESSAGE = ACTION + ": Finds all tasks whose descriptions contain any of "
            + "a keyword and displays them as a list with index numbers.\n"
            + " Parameters: KEYWORD\n"
            + " Example: " + ACTION + "book";

    public static final String MESSAGE = "Here are the matching tasks in your list:\n";

    public String keyword;

    public FindAction(String keyword) {
        this.keyword = keyword;
    }

    public String getStringOfMatchingTask() {
        String matchingTask = "";
        for (int i = 0; i <taskList.getNumTasks(); i++) {
            if (taskList.getStringOfTask(i).contains(keyword)) {
                matchingTask += (i+1) + ". " + taskList.getStringOfTask(i) + "\n";
            }
        }
        return matchingTask;
    }

    @Override
    public ActionResult executeAction() {
        return new ActionResult(MESSAGE + getStringOfMatchingTask());
    }
}
