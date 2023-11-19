

// Re-throw exception class for re-throwing example

public class RethrowCustomizeException extends Exception {
    
	public RethrowCustomizeException(String message, Throwable cause) {
        super(message, cause);
    }
}

