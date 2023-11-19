
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// a. Handling Multiple Exceptions
		ExceptionHandling.multipleExceptionHandling();
		
		// b. Re-throwing Exceptions
        try {
        	ExceptionHandling.rethrowingExceptionHandling();
        } catch (RethrowCustomizeException e) {
            System.err.println("Caught re-thrown exception: " + e.getMessage());
        }

        // c. Resource Management
        ExceptionHandling.resourceManagementHandling();
        
     
        // d. Chaining Exceptions
        
        try {
        	ExceptionHandling.chainExceptionHandling();
        } catch (RuntimeException e) {
        	System.err.println("Caught chained exception: " + e.getMessage());
        	System.err.println("Original cause: " + e.getCause().getMessage());
        }
	}

}
