package by.epam.javawebtraining.controller;

import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.controller.Command.commandimplim.*;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    public enum CommandType {
        START_SIGN_IN, LOG_IN, SIGN_IN, CHOOSE_TEST_THEME, DEFAULT_COMMAND;
    }

    private CommandManager() {
    }

    private static Map<CommandType, Command> commandMap;

    static {
        commandMap = new HashMap<>();
        commandMap.put(CommandType.START_SIGN_IN, new StartSignInCommand());
        commandMap.put(CommandType.LOG_IN, new LogInCommand());
        commandMap.put(CommandType.SIGN_IN, new SignInCommand());
        commandMap.put(CommandType.CHOOSE_TEST_THEME, new ChooseTestThemeCommand());
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
