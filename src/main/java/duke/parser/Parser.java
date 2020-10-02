package duke.parser;

import duke.action.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static duke.message.Messages.*;

/**
 * Parses user input.
 */
public class Parser {

    /**
     * Parses user input into respective action for execution.
     *
     * @param userInput a full user input in type of String
     * @return the action the user has input
     */
    public Action parseInput(String userInput) {
        String[] inputs = userInput.trim().split(" ", 2);
        if (inputs.length == 0) {
            return new InvalidAction(String.format(INVALID_ACTION_MESSAGE, HelpAction.HELP_MESSAGE));
        }

        final String actionWord = inputs[0];
        final String arguments = userInput.replaceFirst(actionWord, "").trim();

        switch (actionWord) {

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

        case FindAction.ACTION:
            return prepareFindAction(arguments);

        default:
            return new InvalidAction(String.format(WRONG_FORMAT_MESSAGE, HelpAction.HELP_MESSAGE));
        }
    }


    /**
     * Parses arguments to prepare parameters for AddTodo action
     *
     * @param args full argument String, extracted after the action word
     * @return the prepared addTodo object
     */
    private Action prepareAddTodo(String args) {
        return new AddTodo(args);
    }

    /**
     * Parses arguments to prepare parameters for AddEvent action
     *
     * @param args full argument String, extracted after the action word
     * @return the prepared addEvent object
     */
    private Action prepareAddEvent(String args) {
        String[] descriptionAndTime = args.split("/at");
        // Validate arg string format
        if (descriptionAndTime.length != 2) {
            return new InvalidAction(String.format(WRONG_FORMAT_MESSAGE, AddEvent.HELP_MESSAGE));
        }

        try {
            LocalDateTime at = convertDateTimeFormat(descriptionAndTime[1].trim());
            return new AddEvent(descriptionAndTime[0].trim(), at);
        } catch (DateTimeParseException e) {
            return new InvalidAction(String.format(WRONG_DATETIME_FORMAT_MESSAGE, AddEvent.HELP_MESSAGE));
        }
    }


    /**
     * Parses arguments to prepare parameters for AddDeadline action
     *
     * @param args full argument String, extracted after the action word
     * @return the prepared addDeadline object
     */
    private Action prepareAddDeadline(String args) {
        String[] descriptionAndTime = args.split("/by");
        if (descriptionAndTime.length != 2) {
            return new InvalidAction(String.format(WRONG_FORMAT_MESSAGE, AddDeadline.HELP_MESSAGE));
        }

        try {
            LocalDateTime by = convertDateTimeFormat(descriptionAndTime[1].trim());
            return new AddDeadline(descriptionAndTime[0].trim(), by);
        } catch (DateTimeParseException e) {
            return new InvalidAction(String.format(WRONG_DATETIME_FORMAT_MESSAGE, AddDeadline.HELP_MESSAGE));

        }

    }


    /**
     * converts String parameter to LocalDateTime object
     *
     * @param dateAndTime full argument String, extracted after the action word
     * @return the LocalDateTime object
     */
    private LocalDateTime convertDateTimeFormat(String dateAndTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateAndTime, formatter);
        return dateTime;
    }


    /**
     * Parses arguments to prepare parameters to initialize DeleteAction
     *
     * @param args full argument String, extracted after the action word
     * @return the prepared DeleteAction object
     */
    private Action prepareDeleteAction(String args) {
        try {
            final int targetIndex = Integer.parseInt(args);
            return new DeleteAction(targetIndex);
        } catch (NumberFormatException e) {
            return new InvalidAction(String.format(INVALID_TASK_ID_MESSAGE, FinishAction.HELP_MESSAGE));
        }

    }

    /**
     * Parses arguments to prepare parameters to initialize FinishAction
     *
     * @param args full argument String, extracted after the action word
     * @return the prepared FinishAction object
     */
    private Action prepareFinishAction(String args) {
        try {
            final int targetIndex = Integer.parseInt(args);
            return new FinishAction(targetIndex);
        } catch (NumberFormatException e) {
            return new InvalidAction(String.format(INVALID_TASK_ID_MESSAGE, FinishAction.HELP_MESSAGE));
        }

    }

    /**
     * Parses arguments to prepare parameters to initialize FindAction action
     * ensures no empty keyword provided to the FindAction object
     *
     * @param args full argument String, extracted after the action word
     * @return the prepared FindAction object
     */
    private Action prepareFindAction(String args) {
        if (args.trim().isEmpty()) {
            return new InvalidAction(NO_KEYWORD_FOUND_MESSAGE);
        }
        return new FindAction(args.trim());
    }

}
