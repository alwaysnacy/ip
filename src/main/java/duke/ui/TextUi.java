package duke.ui;

import duke.action.ActionResult;

import java.util.Scanner;

import static duke.message.Messages.GOODBYE_MESSAGE;
import static duke.message.Messages.WELCOME_MESSAGE;
import static duke.message.Messages.LOGO_MESSAGE;

public class TextUi {

    public static final int INDEX_OFFSET = 1;

    private static final String REPLY_IDENTIFIER = ">> ";
    private static final String NEWLINE = System.lineSeparator();
    private static final String COMMAND_DIVIDER = "===================================================";

    public String getUserInput() {
        System.out.print(REPLY_IDENTIFIER + "Action: ");
        Scanner sc = new Scanner(System.in);
        String UserInput = sc.nextLine();
        return UserInput;
    }

    public void printWelcomeMessage() {
        printScreen(COMMAND_DIVIDER, COMMAND_DIVIDER, LOGO_MESSAGE, COMMAND_DIVIDER, WELCOME_MESSAGE);
    }

    public void printGoodbyeMessage() {
        printScreen(GOODBYE_MESSAGE, COMMAND_DIVIDER, COMMAND_DIVIDER);
    }

    public void printScreen(String... messages) {
        for (String message: messages) {
            if (message == LOGO_MESSAGE || message == COMMAND_DIVIDER) {
                System.out.println(message);
            } else {
                System.out.println(REPLY_IDENTIFIER + message.replace("\n", NEWLINE + REPLY_IDENTIFIER));
            }
        }
    }

    public void printActionResult(ActionResult result) {
        printScreen(result.outputToScreen, COMMAND_DIVIDER);
    }
}
