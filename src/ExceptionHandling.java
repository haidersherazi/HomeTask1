
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class ExceptionHandling {

	
	// a. Handling Multiple Exceptions
	
    public static void multipleExceptionHandling() {
        
    	
    	try {
   
    		int[] array = new int[5];
            System.out.println(array[10]); // ArrayIndexOutOfBoundsException
            
            String str = null;
            int length = str.length(); // This line will throw NullPointerException
            System.out.println("Length: " + length); // This line won't be reached
            
            int a = 7;
            int b = 0;
            
            System.out.println( a / b ); // Arithmetic Exception
            
        } catch (ArithmeticException e) {
        	
        	System.err.println("Caught ArithmeticException: " + e.getMessage()); 
            
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
        	
        	System.err.println("Caught multiple exceptions: " + e.getMessage());
            
        }  finally {
        
        	// it can be used to close open connections and it must run after the try or catch blocks
        }
    }
 
    // b. Re-throwing Exceptions
    
    public static void rethrowingExceptionHandling() throws RethrowCustomizeException {
    
    	try {
        
    		// code here that may throw an exception
    			
    		int result = divideByZero();
            
    		System.out.println("Result: " + result);
            
        
    	} catch (ArithmeticException e) {
        
    		System.err.println("ArithmeticException caught: " + e.getMessage());
    		
    		// Wrapping the caught exception in a new CustomException and re-throwing it
            throw new RethrowCustomizeException("CustomException occurred", e);
        
    	}
    
    }
    
    
    // c. Resource Management using try-with-resources
    
    public static void resourceManagementHandling() {
    	
        // Using try-with-resources to automatically close the resource (in this case, a BufferedReader)
 
    	try (BufferedReader buffReader = new BufferedReader(new FileReader("nonexistent_file.txt"))) {
    		
    		String line;
            
            while ((line = buffReader.readLine()) != null) {
            
            	System.out.println(line);
            }
        
    	} catch (FileNotFoundException e) {
        
    		System.err.println("File not found: " + e.getMessage());
        
    	} catch (IOException e) {
        
    		System.err.println("Error reading file: " + e.getMessage());
        
    	}
    }

    
    // d. Chaining Exceptions
    public static void chainExceptionHandling() {
        
    	try {
            
        	divideByZero();
            
        } catch (ArithmeticException e) {
        	
            // Wrapping the caught exception in a new exception and chaining them
        	
            throw new RuntimeException("Error during division", e);
        }
    }

    
    private static int divideByZero() {
        return 8 / 0; // Arithmetic Exception will be thrown here
    }
    
}
