package by.epam.javawebtraining.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputTextValidator {
    public static final String NAME_SURNAME_REGEX = ".+";
    public static final String E_MAIL = ".+";
    private static InputTextValidator instance = new InputTextValidator();

    private InputTextValidator() {
    }

    public static InputTextValidator getInstance() {
        return instance;
    }

    /**
     * Check if input String is not null and length > 0
     */
    public boolean isThereText(String inputText) {
        boolean result = false;
        if (inputText != null){
            inputText = inputText.trim();
            if (((inputText.length() > 0)
                    && (inputText.length() < 255))){
                result = true;
            }
        }
        return result;
    }

    /**
     * Check if name or surname matches to pattern
     *
     * @param nameSurname
     * @return true if matches and false otherwise
     */
    public boolean isValidNameSurname(String nameSurname) {
        return matchesRegex(nameSurname, NAME_SURNAME_REGEX);
    }

    public boolean isEmail(String email) {
        return matchesRegex(email, E_MAIL);
    }

    /**
     * Check if text matches to pattern
     * @param text
     * @param regex
     */
    public boolean matchesRegex(String text, String regex) {
        boolean result = false;
        if (isThereText(text)) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            if (matcher.matches()) {
                result = true;
            }
        }
        return result;
    }
}
