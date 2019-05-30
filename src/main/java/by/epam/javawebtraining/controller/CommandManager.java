package by.epam.javawebtraining.controller;

import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.controller.Command.commandimplim.*;
import by.epam.javawebtraining.controller.Command.commandimplim.create.AddQuestionCommand;
import by.epam.javawebtraining.controller.Command.commandimplim.create.ConfirmAnswersCommand;
import by.epam.javawebtraining.controller.Command.commandimplim.create.CreateNewTestCommand;
import by.epam.javawebtraining.controller.Command.commandimplim.create.CreateQuestionCommand;
import by.epam.javawebtraining.controller.Command.commandimplim.edit.*;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    public enum CommandType {
        START_SIGN_IN, LOG_IN, LOG_OUT, SIGN_IN, CHOOSE_TEST_THEME,
        BACK_TO_TESTS, LOOK_THROUGH_TEST, CREATE_NEW_TEST,
        GO_TO_CREATE_TEST_PAGE, ADD_QUESTION, CREATE_QUESTION,
        SAVE_TEST, CREATE_ANSWERS, CONFIRM_ANSWERS, DELETE_TEST, EDIT_TEST,
        UPDATE_TEST, DELETE_QUESTION, EDIT_QUESTION, UPDATE_QUESTION,
        UPDATE_ANSWERS,
        DEFAULT_COMMAND;
    }

    private CommandManager() {
    }

    private static Map<CommandType, Command> commandMap;

    static {
        commandMap = new HashMap<>();
        commandMap.put(CommandType.START_SIGN_IN, new StartSignInCommand());
        commandMap.put(CommandType.LOG_IN, new LogInCommand());
        commandMap.put(CommandType.LOG_OUT, new LogOutCommand());
        commandMap.put(CommandType.SIGN_IN, new SignInCommand());
        commandMap.put(CommandType.CHOOSE_TEST_THEME, new ChooseTestThemeCommand());
        commandMap.put(CommandType.BACK_TO_TESTS, new BackToTestsCommand());
        commandMap.put(CommandType.LOOK_THROUGH_TEST, new LookThroughTestCommand());
        commandMap.put(CommandType.CREATE_NEW_TEST, new CreateNewTestCommand());
        commandMap.put(CommandType.GO_TO_CREATE_TEST_PAGE, new GoToCresteTestPage());
        commandMap.put(CommandType.ADD_QUESTION, new AddQuestionCommand());
        commandMap.put(CommandType.CREATE_QUESTION, new CreateQuestionCommand());
        commandMap.put(CommandType.CONFIRM_ANSWERS, new ConfirmAnswersCommand());
        commandMap.put(CommandType.DELETE_TEST, new DeleteTestCommand());
        commandMap.put(CommandType.EDIT_TEST, new EditTestCommand());
        commandMap.put(CommandType.UPDATE_TEST, new UpdateTestCommand());
        commandMap.put(CommandType.DELETE_QUESTION, new DeleteQuestionCommand());
        commandMap.put(CommandType.EDIT_QUESTION, new EditQuestionCommand());
        commandMap.put(CommandType.UPDATE_QUESTION, new UpdateQuestionCommand());
        commandMap.put(CommandType.UPDATE_ANSWERS, new UpdateAnswersCommand());

        commandMap.put(CommandType.DEFAULT_COMMAND, new DefaultCommand());
    }

    public static Command getCommand(String command) {
        CommandType commandType;
        try {
            commandType = CommandType.valueOf(command.toUpperCase());
        } catch (Exception e) {
            commandType = CommandType.DEFAULT_COMMAND;
        }
        return commandMap.get(commandType);
    }
}
