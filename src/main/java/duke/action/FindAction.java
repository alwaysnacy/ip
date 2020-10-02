package duke.action;

/**
 * Finds tasks containing a given keyword (not empty)
 */
public class FindAction extends Action {
    public static final String ACTION = "find";

    public static final String HELP_MESSAGE = ACTION + ": Finds all tasks whose descriptions contain any of "
            + "a keyword and displays them as a list with index numbers.\n"
            + " Parameters: KEYWORD\n"
            + " Example: " + ACTION + "book";

    public static final String MESSAGE = "Here are the matching tasks in your list:\n%1$s"
            + "%2$d matching tasks listed!";
    public static final String NO_TASk_FOUND_MESSAGE = "No matching tasks found!";
    public int numberOfMactchingTasks;

    public String keyword;

    public FindAction(String keyword) {
        this.keyword = keyword;
        this.numberOfMactchingTasks = 0;
    }

    public String getStringOfMatchingTask() {
        String matchingTask = "";
        for (int i = 0; i <taskList.getNumTasks(); i++) {
            if (taskList.getStringOfTask(i).contains(keyword)) {
                matchingTask += (i+1) + ". " + taskList.getStringOfTask(i) + "\n";
                numberOfMactchingTasks++;
            }
        }
        return matchingTask;
    }

    @Override
    public ActionResult executeAction() {
        String stringOfMatchingTasks = getStringOfMatchingTask();
        if (stringOfMatchingTasks.isEmpty()) {
            return new ActionResult(NO_TASk_FOUND_MESSAGE);
        }
        return new ActionResult(String.format(MESSAGE, stringOfMatchingTasks, numberOfMactchingTasks));
    }
}
