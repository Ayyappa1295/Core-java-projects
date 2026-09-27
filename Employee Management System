import java.io.*;
import java.util.*;

class Employee implements Serializable {

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %-5d | Name: %-20s | Department: %-15s | Salary: %.2f",
            id, name, department, salary
        );
    }
}

public class EmployeeManagementSystem {

    private static final Scanner sc = new Scanner(System.in);

    private static final ArrayList<Employee> employees = new ArrayList<>();

    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {

        loadEmployees();

        while (true) {

            System.out.println("\n==============================================");
            System.out.println("       EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("==============================================");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Search by Department");
            System.out.println("7. Search by Minimum Salary");
            System.out.println("8. Show Highest Paid Employee");
            System.out.println("9. Show Employee Statistics");
            System.out.println("10. Exit");
            System.out.println("==============================================");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    searchByDepartment();
                    break;

                case 7:
                    searchBySalary();
                    break;

                case 8:
                    highestPaidEmployee();
                    break;

                case 9:
                    statistics();
                    break;

                case 10:
                    saveEmployees();
                    System.out.println("\nThank you for using Employee Management System!");
                    System.exit(0);

                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
        }
    }

    // ADD EMPLOYEE
    private static void addEmployee() {

        System.out.println("\n========== ADD EMPLOYEE ==========");

        int id = readInt("Enter Employee ID: ");

        if (findEmployee(id) != null) {
            System.out.println("Employee ID already exists!");
            return;
        }

        String name = readString("Enter Employee Name: ");
        String department = readString("Enter Department: ");
        double salary = readDouble("Enter Salary: ");

        if (salary < 0) {
            System.out.println("Salary cannot be negative!");
            return;
        }

        Employee employee =
                new Employee(id, name, department, salary);

        employees.add(employee);

        saveEmployees();

        System.out.println("\nEmployee added successfully!");
    }

    // VIEW EMPLOYEES
    private static void viewEmployees() {

        System.out.println("\n========== ALL EMPLOYEES ==========");

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("----------------------------------------------");
        System.out.println("Total Employees: " + employees.size());
    }

    // SEARCH EMPLOYEE
    private static void searchEmployee() {

        System.out.println("\n========== SEARCH EMPLOYEE ==========");

        int id = readInt("Enter Employee ID: ");

        Employee employee = findEmployee(id);

        if (employee != null) {
            System.out.println("\nEmployee Found:");
            System.out.println(employee);
        } else {
            System.out.println("Employee not found!");
        }
    }

    // UPDATE EMPLOYEE
    private static void updateEmployee() {

        System.out.println("\n========== UPDATE EMPLOYEE ==========");

        int id = readInt("Enter Employee ID: ");

        Employee employee = findEmployee(id);

        if (employee == null) {
            System.out.println("Employee not found!");
            return;
        }

        System.out.println("\nCurrent Details:");
        System.out.println(employee);

        String name = readString("Enter New Name: ");
        String department = readString("Enter New Department: ");
        double salary = readDouble("Enter New Salary: ");

        if (salary < 0) {
            System.out.println("Salary cannot be negative!");
            return;
        }

        employee.setName(name);
        employee.setDepartment(department);
        employee.setSalary(salary);

        saveEmployees();

        System.out.println("\nEmployee updated successfully!");
    }

    // DELETE EMPLOYEE
    private static void deleteEmployee() {

        System.out.println("\n========== DELETE EMPLOYEE ==========");

        int id = readInt("Enter Employee ID: ");

        Employee employee = findEmployee(id);

        if (employee == null) {
            System.out.println("Employee not found!");
            return;
        }

        employees.remove(employee);

        saveEmployees();

        System.out.println("\nEmployee deleted successfully!");
    }

    // SEARCH BY DEPARTMENT
    private static void searchByDepartment() {

        System.out.println("\n========== SEARCH BY DEPARTMENT ==========");

        String department =
                readString("Enter Department: ");

        boolean found = false;

        for (Employee employee : employees) {

            if (employee.getDepartment()
                    .equalsIgnoreCase(department)) {

                System.out.println(employee);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found in this department.");
        }
    }

    // SEARCH BY SALARY
    private static void searchBySalary() {

        System.out.println("\n========== SEARCH BY SALARY ==========");

        double salary =
                readDouble("Enter Minimum Salary: ");

        boolean found = false;

        for (Employee employee : employees) {

            if (employee.getSalary() >= salary) {

                System.out.println(employee);
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                "No employees found with this salary range."
            );
        }
    }

    // HIGHEST PAID EMPLOYEE
    private static void highestPaidEmployee() {

        System.out.println("\n========== HIGHEST PAID EMPLOYEE ==========");

        if (employees.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }

        Employee highest = employees.get(0);

        for (Employee employee : employees) {

            if (employee.getSalary() > highest.getSalary()) {
                highest = employee;
            }
        }

        System.out.println("\nHighest Paid Employee:");
        System.out.println(highest);
    }

    // STATISTICS
    private static void statistics() {

        System.out.println("\n========== EMPLOYEE STATISTICS ==========");

        if (employees.isEmpty()) {
            System.out.println("No employee data available.");
            return;
        }

        double totalSalary = 0;
        double highestSalary = employees.get(0).getSalary();
        double lowestSalary = employees.get(0).getSalary();

        for (Employee employee : employees) {

            double salary = employee.getSalary();

            totalSalary += salary;

            if (salary > highestSalary) {
                highestSalary = salary;
            }

            if (salary < lowestSalary) {
                lowestSalary = salary;
            }
        }

        double averageSalary =
                totalSalary / employees.size();

        System.out.println("Total Employees : " + employees.size());
        System.out.println("Total Salary    : " + totalSalary);
        System.out.println("Average Salary  : " + averageSalary);
        System.out.println("Highest Salary  : " + highestSalary);
        System.out.println("Lowest Salary   : " + lowestSalary);
    }

    // FIND EMPLOYEE
    private static Employee findEmployee(int id) {

        for (Employee employee : employees) {

            if (employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }

    // SAVE DATA
    private static void saveEmployees() {

        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                         new FileOutputStream(FILE_NAME))) {

            output.writeObject(employees);

        } catch (IOException e) {

            System.out.println(
                "Error while saving employee data."
            );
        }
    }

    // LOAD DATA
    @SuppressWarnings("unchecked")
    private static void loadEmployees() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream input =
                     new ObjectInputStream(
                         new FileInputStream(FILE_NAME))) {

            ArrayList<Employee> savedEmployees =
                    (ArrayList<Employee>) input.readObject();

            employees.addAll(savedEmployees);

        } catch (IOException | ClassNotFoundException e) {

            System.out.println(
                "Unable to load previous employee data."
            );
        }
    }

    // INTEGER INPUT
    private static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        sc.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                    "Please enter a valid number."
                );
            }
        }
    }

    // DOUBLE INPUT
    private static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        sc.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                    "Please enter a valid salary."
                );
            }
        }
    }

    // STRING INPUT
    private static String readString(String message) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                "Input cannot be empty."
            );
        }
    }
}
