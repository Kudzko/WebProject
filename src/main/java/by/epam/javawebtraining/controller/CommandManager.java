package by.epam.javawebtraining.controller;

import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.controller.Command.commandimplim.DefaultCommand;
import by.epam.javawebtraining.controller.Command.commandimplim.LogInCommand;
import by.epam.javawebtraining.controller.Command.commandimplim.SignInCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    public enum CommandType {
        SIGN_IN, LOG_IN, DEFAULT_COMMAND;
    }

    private CommandManager() {
    }

    private static Map<CommandType, Command> commandMap;

    static {
        commandMap = new HashMap<>();
        commandMap.put(CommandType.SIGN_IN, new SignInCommand());
        commandMap.put(CommandType.LOG_IN, new LogInCommand());
        commandMap.put(CommandType.DEFAULT_COMMAND, new DefaultCommand());
    }

    public static Command getCommand(String command) {
        CommandType commandType;
try{
    commandType = CommandType.valueOf(command.toUpperCase());
}catch (Exception e){
    commandType = CommandType.DEFAULT_COMMAND;
}


        return commandMap.get(commandType);
    }
}
