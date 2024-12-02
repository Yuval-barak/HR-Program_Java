package workers;


public enum EmployeeType {
	ADMINISTRATIVE,
    SOFTWARE_DEVELOPER,
    ALGORITHMIC_SOFTWARE_DEVELOPER
    
    {
    String employeeType;
    
    public String getEmployeeType() {
		return employeeType;

} 
    }
}
