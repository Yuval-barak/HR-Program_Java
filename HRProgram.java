package workersprogram;
import workers.*;
import staff.*;
import workers.EmployeeType;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class HRProgram  {
	private static HRDepartment hrDepartment = new HRDepartment();

    public static void main(String[] args) throws EmployeeNotFoundException {
    	String filePath = "workers.dat";
        try {
			hrDepartment.loadWorkerData(filePath);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
        hrDepartment.saveWorkerData("workers.dat");
        
        boolean exitProgram = false;
        Scanner scanner = new Scanner(System.in);
        MenuOption option = null;

        do {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character
 
            option = MenuOption.values()[choice - 1];

            switch (option) {
                case ADD_EMPLOYEE:
                    addEmployee();
                    break;
                case VIEW_EMPLOYEE:
                	viewEmployee();
                    break;
                case DELETE_EMPLOYEE:
                    deleteEmployee();
                    break;
                case VIEW_REPORT:
                    viewReport();
                    break;
                case EXIT:
                    System.out.println("Exiting the program...");
                    exitProgram = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (!exitProgram);
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        int counter = 1;
        for (MenuOption option : MenuOption.values()) {
            System.out.println(counter + ". " + option.getDisplayName());
            counter++;
        }
        System.out.print("Enter your choice: ");
    }

    private static void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        EmployeeType employeeType = getEmployeeType();

        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();
        
        try {
            hrDepartment.findEmployeeById(id);
            System.out.println("Employee with the same ID already exists.");
            return; // Exit the method if employee already exists
        } catch (EmployeeNotFoundException e) { // Continue with adding the employee        
        		}
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();
        System.out.print("Enter gender (Male/Female): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter basic monthly salary: ");
        double basicMonthlySalary = scanner.nextDouble();
        scanner.nextLine();  // Consume newline character

        switch (employeeType) {
            case ADMINISTRATIVE:
                System.out.print("Enter role: ");
                String role = scanner.nextLine();
                AdministrativeWorker administrativeWorker = new AdministrativeWorker(id, firstName, lastName, phoneNumber, emailAddress, gender, basicMonthlySalary, role);
                try {
                    hrDepartment.addEmployee(administrativeWorker);
                    System.out.println("Administrative worker added successfully.");
                } catch (EmployeeAlreadyExistsException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case SOFTWARE_DEVELOPER:
                System.out.print("Enter monthly bonus: ");
                double monthlyBonus = scanner.nextDouble();
                scanner.nextLine();  // Consume newline character
                SoftwareDeveloper softwareDeveloper = new SoftwareDeveloper(id, firstName, lastName, phoneNumber,
                        emailAddress, gender, basicMonthlySalary, monthlyBonus);
                try {
                    hrDepartment.addEmployee(softwareDeveloper);
                    System.out.println("Software developer added successfully.");
                } catch (EmployeeAlreadyExistsException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case ALGORITHMIC_SOFTWARE_DEVELOPER:
                System.out.print("Enter monthly bonus: ");
                monthlyBonus = scanner.nextDouble();
                System.out.print("Enter additional bonus: ");
                double additionalBonus = scanner.nextDouble();
                scanner.nextLine();  // Consume newline character
                AlgorithmicSoftwareDeveloper algorithmicSoftwareDeveloper = new AlgorithmicSoftwareDeveloper(id, firstName,
                        lastName, phoneNumber, emailAddress, gender, basicMonthlySalary, monthlyBonus, additionalBonus);
                try {
                    hrDepartment.addEmployee(algorithmicSoftwareDeveloper);
                    System.out.println("Algorithmic software developer added successfully.");
                } catch (EmployeeAlreadyExistsException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid employee type.");
                break;
        }
    }

    private static void viewEmployee() throws EmployeeNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();
        Employee employee = hrDepartment.findEmployeeById(id);
		System.out.println(employee.toString());
    }

    private static void deleteEmployee() throws EmployeeNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();     
        hrDepartment.deleteEmployee(id);
    }
    private static void viewReport() {
        List<Employee> sortedEmployees = hrDepartment.sortEmployees();

        if (sortedEmployees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee Report:");
            for (Employee employee : sortedEmployees) {
                System.out.println(employee.toString());
            }
        }
    }
    private static EmployeeType getEmployeeType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select employee type:");
        int counter = 1;
        for (EmployeeType type : EmployeeType.values()) {
            System.out.println(counter + ". " + type.name());
            counter++;
        }
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        return EmployeeType.values()[choice - 1];
    }
}
