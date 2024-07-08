package be.umons_project.pgl_back_end.exeption;

public class CustomException extends RuntimeException{

    private String message;
    public CustomException(String message) {

        super(message);
        this.message = message;
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
