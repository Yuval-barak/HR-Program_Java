package workers;

public class AlgorithmicSoftwareDeveloper extends SoftwareDeveloper{
	    private double additionalBonus;
	    private EmployeeType employeeType = EmployeeType.ALGORITHMIC_SOFTWARE_DEVELOPER;
	    
	    public AlgorithmicSoftwareDeveloper(String id, String firstName, String lastName, String phoneNumber, String emailAddress,
	                                       	Gender gender, double basicMonthlySalary, double monthlyBonus, double additionalBonus) {
	        super(id, firstName, lastName, phoneNumber, emailAddress, gender, basicMonthlySalary,monthlyBonus);
	        this.additionalBonus = additionalBonus;
	        this.employeeType = EmployeeType.ALGORITHMIC_SOFTWARE_DEVELOPER;
	    }

	    public double getAdditionalBonus() {
	        return additionalBonus;
	    }

	    public void setAdditionalBonus(double additionalBonus) {
	    	if (additionalBonus > 0) {
	            this.additionalBonus = additionalBonus;
	        } else {
	            throw new IllegalArgumentException("Monthly additionalBonus cannot be negative.");
	        }
	    }

	    @Override
	    public double calculateMonthlyIncome() {
	        return super.calculateMonthlyIncome() + additionalBonus;
	    }

	    public String toString() {
	        return super.toString().replace("SOFTWARE_DEVELOPER", "ALGORITHMIC_SOFTWARE_DEVELOPER") + ", Additional Bonus: $" + additionalBonus;
	    }
	    
	    @Override
	    public boolean equals(Object other) {
 	       return (other instanceof AlgorithmicSoftwareDeveloper)
 	    		   && super.equals(other);
 	    }
 }

