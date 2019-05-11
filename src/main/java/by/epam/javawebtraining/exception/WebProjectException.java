package by.epam.javawebtraining.exception;

public class WebProjectException extends Exception {
    public WebProjectException() {
    }

    public WebProjectException(String message) {
        super(message);
    }

    public WebProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebProjectException(Throwable cause) {
        super(cause);
    }

    public WebProjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
