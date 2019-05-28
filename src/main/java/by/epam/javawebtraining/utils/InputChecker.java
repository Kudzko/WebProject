package by.epam.javawebtraining.utils;

import by.epam.javawebtraining.service.validation.InputTextValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {
    public static final String NUMBER_REGEX = "\\d";

    private static InputChecker instance = new InputChecker();

    private InputChecker() {
    }

    public static InputChecker getInstance() {
        return instance;
    }

    /**
     * Check if input data is digits > 0
     */
    public boolean isNumber(String inputData) {
        boolean result = false;
        if (inputData != null) {
            inputData = inputData.trim();
            if (inputData.length() > 0) {
                Pattern pattern = Pattern.compile(NUMBER_REGEX);
                Matcher matcher = pattern.matcher(inputData);
                if (matcher.matches()) {
                    result = true;
                }

            }
        }
        return result;
    }

}
