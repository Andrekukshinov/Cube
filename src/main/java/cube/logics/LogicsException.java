package cube.logics;

public class LogicsException extends Exception {
    public LogicsException(String message, Throwable cause) {
	   super(message, cause);
    }

    public LogicsException(String message) {
	   super(message);
    }
}
