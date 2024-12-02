package workers;

public class SoftwareDeveloper extends Employee {
    private double monthlyBonus;
    private EmployeeType employeeType = EmployeeType.SOFTWARE_DEVELOPER;
    
    public SoftwareDeveloper(String id, String firstName, String lastName, String phoneNumber, String emailAddress,
    				Gender gender, double basicMonthlySalary, double monthlyBonus) {
        super(id, firstName, lastName, phoneNumber, emailAddress, gender, basicMonthlySalary);
        setMonthlyBonus(monthlyBonus);
        this.employeeType = EmployeeType.SOFTWARE_DEVELOPER;       
    }
    
    public double getMonthlyBonus() {
        return monthlyBonus;
    }

    public void setMonthlyBonus(double monthlyBonus) {
        if (monthlyBonus > 0) {
            this.monthlyBonus = monthlyBonus;
        } else {
            throw new IllegalArgumentException("Monthly bonus cannot be negative.");
        }
    }
   
    @Override
    public double calculateMonthlyIncome() {
    	return getBasicMonthlySalary() + monthlyBonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", Employee Type: " + employeeType + ", Monthly Bonus: $" + monthlyBonus;
    }
    @Override
    public boolean equals(Object other) {
    	       return (other instanceof SoftwareDeveloper)
    	    		   && super.equals(other);
    	    }
	}
    
