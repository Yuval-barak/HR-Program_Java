package staff;
import workers.*;
import java.io.*;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HRDepartment extends Exception  {
    public List<Employee> employees;

    public HRDepartment() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) throws EmployeeAlreadyExistsException {
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyExistsException("Employee already exists in the HR department.");
        }
        employees.add(employee);
    }

    public Employee findEmployeeById(String id) throws EmployeeNotFoundException {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }            
        }
        throw new EmployeeNotFoundException("Employee not found in the HR department.");
        
    }
    public void deleteEmployee(String id) throws EmployeeNotFoundException {
        Employee employeeToRemove = findEmployeeById(id);
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            System.out.println("Employee deleted successfully.");
        } else {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
    }

    public List<Employee> sortEmployees() {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        Collections.sort(sortedEmployees);
        return sortedEmployees;
    }
    public void loadWorkerData(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            employees = (List<Employee>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading worker data from file: " + e.getMessage());
        }
    }

    public void saveWorkerData(String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Error saving worker data to file: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        sortEmployees();
        String employeesString = ""; //empty string
        for (Employee employee : employees) {
            employeesString += employee.toString() + "\n"; } // adds employee details to the string directly 
        return employeesString;
    }
}
	