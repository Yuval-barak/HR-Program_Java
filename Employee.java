package workers;
import java.io.Serializable;
import java.util.List;

public abstract class Employee extends Exception implements Comparable<Employee> ,Serializable{

	private static final long serialVersionUID = 123456L; // Added for serialization

    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private Gender gender;
    private double basicMonthlySalary;

    public Employee(String id, String firstName, String lastName, String phoneNumber, String emailAddress, Gender gender, double basicMonthlySalary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;             
        this.gender = gender; 
        try {
        setBasicMonthlySalary(basicMonthlySalary);
        setPhoneNumber(phoneNumber);
        setEmailAddress(emailAddress);
        } catch (IllegalSalary | IllegalPhoneNumber | IllegalEmail e) {
			this.basicMonthlySalary =5000.0;
			this.phoneNumber = null;
			this.emailAddress = null;			
}
    }
    public Employee() { // Default constructor with default values 
        this.id = "";
        this.firstName = "";
        this.lastName = "";
        this.phoneNumber = "";
        this.emailAddress = "";
        this.gender = Gender.MALE; //Default Gender
        this.basicMonthlySalary = 5000.0; } //Minimum salary
  
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws IllegalPhoneNumber {
        if (phoneNumber.matches("\\d{10}")) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalPhoneNumber("Invalid phone number. Phone number should be a 10-digit number.");  }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) throws IllegalEmail {
        // Check if the email address contains '@', and ends with '.com'
        if (emailAddress.contains("@") && (emailAddress.endsWith(".com")||emailAddress.endsWith(".co.il"))) {
            this.emailAddress = emailAddress;
        } else {
            throw new IllegalEmail("Invalid email address format.");
        }
    }

    public Gender getGender() {
        return gender;
    }
    
    public void setGender(Gender gender) { //We used an enum to check the correctness
        this.gender = gender;
    }
    
    public double getBasicMonthlySalary() {
        return basicMonthlySalary;
    }

    public void setBasicMonthlySalary(double basicMonthlySalary) throws IllegalSalary {
        if (basicMonthlySalary <= 0) {
       throw new IllegalArgumentException("Invalid basic monthly salary. Salary should be a positive value.");
        }
        this.basicMonthlySalary = basicMonthlySalary;
    }

    public abstract double calculateMonthlyIncome();

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + firstName + " " + lastName +
                ", Phone Number: " + phoneNumber +
                ", Email Address: " + emailAddress +
                ", Gender: " + gender +
//              " ,Basic Monthly Salary: $" + basicMonthlySalary +
                ", Total monthly income: $" + calculateMonthlyIncome();
    }

    @Override
    public boolean equals(Object other) {
       return (other instanceof Employee)
    		   && (this.id == ((Employee)other).getId());
    }

    @Override
    public int compareTo(Employee other) {
    		if (this.lastName.equals(other.lastName)) 
    				return this.firstName.compareTo(other.firstName);
    		else {
    			return this.lastName.compareTo(other.lastName);
    		}		
    			}
}
