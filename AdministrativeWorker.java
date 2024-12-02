package workers;

	public class AdministrativeWorker extends Employee {
	    private String role;
	    
	    private EmployeeType employeeType = EmployeeType.ADMINISTRATIVE;
	    
	    public AdministrativeWorker(String id, String firstName, String lastName, String phoneNumber, String emailAddress,
	                                Gender gender, double basicMonthlySalary, String role) {
	        super(id, firstName, lastName, phoneNumber, emailAddress, gender, basicMonthlySalary);
	        this.role = role;
	        this.employeeType = EmployeeType.ADMINISTRATIVE;
	    }

	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }

	    @Override
	    public double calculateMonthlyIncome() {
	        return getBasicMonthlySalary();
	    }

	    @Override
	    public String toString() {
	        return super.toString() +", Employee Type: " + employeeType + ", Role: " + role;
	    }

	    @Override
	    public boolean equals(Object other) {
	    	       return (other instanceof AdministrativeWorker)
	    	    		   && super.equals(other);
	    }
	}


