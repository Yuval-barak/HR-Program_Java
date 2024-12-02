package staff;


public class EmployeeNotFoundException extends Exception {
	
	public EmployeeNotFoundException() {
		super();
	}
     public EmployeeNotFoundException(String message) {
          super(message);
        }
    }
