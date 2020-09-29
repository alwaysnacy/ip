package duke.parser;

import duke.actions.*;

import static duke.message.Messages.INVALID_ACTION_MESSAGE;

public class Parser {
    public Action parseInput(String userInput) {
        String[] words = userInput.trim().split(" ", 2);  // split the input into command and arguments
        if (words.length == 0) {
            return new InvalidAction(String.format(INVALID_ACTION_MESSAGE, HelpAction.HELP_MESSAGE));
        }

        final String commandWord = words[0];
        final String arguments = userInput.replaceFirst(commandWord, "").trim();

        switch (commandWord) {

        case AddTodo.ACTION:
            return prepareAddTodo(arguments);
        case AddEvent.ACTION:
            return prepareAddEvent(arguments);
        case AddDeadline.ACTION:
            return prepareAddDeadline(arguments);

        case DeleteAction.ACTION:
            return prepareDeleteAction(arguments);

        case FinishAction.ACTION:
            return prepareFinishAction(arguments);

        case ListAction.ACTION:
            return new ListAction();

        case ExitAction.ACTION:
            return new ExitAction();

        case HelpAction.ACTION:
            return new HelpAction();
        default:
            return new InvalidAction(String.format(INVALID_ACTION_MESSAGE, HelpAction.HELP_MESSAGE));
        }
    }

    private Action prepareAddTodo(String args) {
        return new AddTodo(args);
    }

    private Action prepareAddDeadline(String args) {
        String[] parts = args.split("/by");
        // Validate arg string format
        if (parts.length != 2) {
            return new InvalidAction(String.format(INVALID_ACTION_MESSAGE, AddDeadline.HELP_MESSAGE));
        }
        return new AddDeadline(parts[0].trim(), parts[1].trim());
    }

    private Action prepareAddEvent(String args) {
        String[] parts = args.split("/at");
        // Validate arg string format
        if (parts.length != 2) {
            return new InvalidAction(String.format(INVALID_ACTION_MESSAGE, AddEvent.HELP_MESSAGE));
        }
        return new AddDeadline(parts[0].trim(), parts[1].trim());
    }

    private Action prepareDeleteAction(String args) {
        final int targetIndex = Integer.parseInt(args);
        return new DeleteAction(targetIndex);
    }

    private Action prepareFinishAction(String args) {
        final int targetIndex = Integer.parseInt(args);
        return new FinishAction(targetIndex);
    }

}
