# Employee Management System

A console-based **Employee Management System** developed using **Core Java**.
The project demonstrates important Java concepts such as **Object-Oriented Programming, Collections, Exception Handling, File Handling, Serialization, CRUD operations, and input validation**.

---

## 📌 Project Overview

The Employee Management System is a menu-driven Java application that allows users to manage employee records.

Users can:

- Add new employees
- View all employees
- Search employees by ID
- Update employee details
- Delete employees
- Search employees by department
- Search employees based on minimum salary
- Find the highest-paid employee
- View employee statistics
- Save employee data to a file
- Automatically load previously saved employee data

The application uses **Java Serialization** to store employee records locally so that the data remains available even after restarting the application.

---

## 🚀 Features

### 1. Add Employee

Add a new employee by providing:

- Employee ID
- Employee Name
- Department
- Salary

The application checks whether the employee ID already exists before adding the employee.

---

### 2. View All Employees

Displays all employee records in a structured format.

Example:

```text
ID: 101   | Name: Rahul               | Department: IT              | Salary: 35000.00
ID: 102   | Name: Priya               | Department: HR              | Salary: 30000.00
ID: 103   | Name: Kiran               | Department: Finance         | Salary: 40000.00

```

---

### 3. Search Employee

Search for an employee using their unique Employee ID.

---

### 4. Update Employee

Update existing employee information:

- Name
- Department
- Salary

The application first verifies that the employee exists.

---

### 5. Delete Employee

Delete an employee record using the Employee ID.

---

### 6. Search by Department

Display all employees belonging to a particular department.

Example:

```text
Enter Department: IT

```

The application displays all employees from the IT department.

---

### 7. Search by Minimum Salary

Find employees whose salary is greater than or equal to a specified amount.

Example:

```text
Enter Minimum Salary: 30000

```

---

### 8. Highest Paid Employee

Automatically identifies and displays the employee with the highest salary.

---

### 9. Employee Statistics

Displays:

- Total number of employees
- Total salary
- Average salary
- Highest salary
- Lowest salary

Example:

```text
Total Employees : 5
Total Salary    : 175000.0
Average Salary  : 35000.0
Highest Salary  : 50000.0
Lowest Salary   : 25000.0

```

---

### 10. Data Persistence

Employee records are stored in:

```text
employees.dat

```

Java Serialization is used to save and retrieve employee data.

This means employee information can be loaded automatically when the application starts again.

---

# 🛠️ Technologies Used

| Technology         | Purpose                         |
| ------------------ | ------------------------------- |
| Java               | Application development         |
| Core Java          | Main programming concepts       |
| OOP                | Object-oriented design          |
| ArrayList          | Store employee records          |
| Exception Handling | Handle invalid input and errors |
| File Handling      | Store employee data             |
| Serialization      | Persist employee objects        |
| Scanner            | Read user input                 |
| Git                | Version control                 |
| GitHub             | Source code hosting             |

---

# 🧠 Core Java Concepts Demonstrated

This project covers several important Core Java concepts.

## Object-Oriented Programming

### Encapsulation

Employee fields are declared as private and accessed using getters and setters.

```java
private int id;
private String name;
private String department;
private double salary;

```

---

### Classes and Objects

The `Employee` class represents an employee object.

```java
Employee employee =
        new Employee(id, name, department, salary);

```

---

### Constructor

The constructor initializes employee information.

```java
public Employee(int id, String name,
                String department, double salary) {

    this.id = id;
    this.name = name;
    this.department = department;
    this.salary = salary;
}

```

---

### Method Overriding

The `toString()` method is overridden to display employee information in a readable format.

```java
@Override
public String toString() {
    return String.format(
        "ID: %-5d | Name: %-20s | Department: %-15s | Salary: %.2f",
        id, name, department, salary
    );
}

```

---

## Collections Framework

The project uses `ArrayList` to store multiple employee objects.

```java
private static final ArrayList<Employee> employees =
        new ArrayList<>();

```

---

## Exception Handling

The application uses `try-catch` blocks to handle invalid user input.

Example:

```java
try {
    return Integer.parseInt(sc.nextLine().trim());
}
catch (NumberFormatException e) {
    System.out.println("Please enter a valid number.");
}

```

---

## File Handling

The application uses Java file streams to store employee data.

```java
FileOutputStream
FileInputStream
ObjectOutputStream
ObjectInputStream

```

---

## Serialization

The `Employee` class implements:

```java
Serializable

```

This allows employee objects to be stored and retrieved from a file.

---

# 📂 Project Structure

```text
employee-management-system/
│
├── EmployeeManagementSystem.java
│
├── .gitignore
│
└── README.md

```

### Generated at Runtime

```text
employees.dat

```

The `employees.dat` file is generated when the application saves employee data.

It is excluded from GitHub using `.gitignore`.

---

# ⚙️ Requirements

Before running the project, make sure you have:

- Java JDK 8 or later
- Terminal / Command Prompt
- Git (optional for running the project)
- GitHub account (for source code hosting)

You can check your Java version using:

```bash
java -version

```

Check the Java compiler:

```bash
javac -version

```

---

# ▶️ How to Run

## Step 1: Clone the Repository

```bash
git clone https://github.com/YOUR-USERNAME/employee-management-system.git

```

Replace:

```text
YOUR-USERNAME

```

with your GitHub username.

---

## Step 2: Navigate to the Project

```bash
cd employee-management-system

```

---

## Step 3: Compile the Program

```bash
javac EmployeeManagementSystem.java

```

---

## Step 4: Run the Application

```bash
java EmployeeManagementSystem

```

---

# 🖥️ Application Menu

When the application starts, the following menu appears:

```text
==============================================
       EMPLOYEE MANAGEMENT SYSTEM
==============================================
1. Add Employee
2. View All Employees
3. Search Employee
4. Update Employee
5. Delete Employee
6. Search by Department
7. Search by Minimum Salary
8. Show Highest Paid Employee
9. Show Employee Statistics
10. Exit
==============================================
Enter your choice:

```

---

# 💻 Sample Usage

## Add Employee

```text
========== ADD EMPLOYEE ==========

Enter Employee ID: 101
Enter Employee Name: Rahul
Enter Department: IT
Enter Salary: 35000

Employee added successfully!

```

---

## View Employees

```text
========== ALL EMPLOYEES ==========

ID: 101   | Name: Rahul              | Department: IT              | Salary: 35000.00
ID: 102   | Name: Priya              | Department: HR              | Salary: 30000.00

----------------------------------------------
Total Employees: 2

```

---

## Search Employee

```text
========== SEARCH EMPLOYEE ==========

Enter Employee ID: 101

Employee Found:
ID: 101   | Name: Rahul              | Department: IT              | Salary: 35000.00

```

---

## Update Employee

```text
========== UPDATE EMPLOYEE ==========

Enter Employee ID: 101

Current Details:
ID: 101   | Name: Rahul              | Department: IT              | Salary: 35000.00

Enter New Name: Rahul Kumar
Enter New Department: Development
Enter New Salary: 45000

Employee updated successfully!

```

---

## Delete Employee

```text
========== DELETE EMPLOYEE ==========

Enter Employee ID: 102

Employee deleted successfully!

```

---

# 🔐 Input Validation

The application includes validation for:

- Duplicate employee IDs
- Empty names
- Empty departments
- Invalid numeric input
- Negative salaries
- Non-existing employee IDs

Example:

```text
Please enter a valid number.

```

---

# 📊 Application Flow

```text
             START
               │
               ▼
       Load Employee Data
               │
               ▼
        Display Main Menu
               │
       ┌───────┴────────┐
       │                │
       ▼                ▼
   User Choice       Exit
       │                │
       ▼                ▼
 Perform Operation   Save Data
       │                │
       └───────┐        ▼
               │       END
               ▼
         Display Menu
               │
               └─── Repeat

```

---

# 🎯 Learning Objectives

By developing this project, the following skills are practiced:

- Java syntax and programming fundamentals
- Object-Oriented Programming
- Classes and objects
- Constructors
- Encapsulation
- Method overriding
- Collections Framework
- ArrayList
- Loops and conditional statements
- Methods
- Exception Handling
- File Handling
- Serialization
- Input validation
- CRUD operations
- Basic application design

---

# 🔮 Future Enhancements

The project can be extended with:

- MySQL database integration
- JDBC
- Login and authentication
- Role-based access
- Java Swing GUI
- JavaFX interface
- REST API using Spring Boot
- HTML/CSS/JavaScript frontend
- Employee attendance management
- Employee leave management
- Payroll management
- Search and sorting functionality
- Export employee data to Excel/PDF

---

# 📌 Resume Description

**Employee Management System | Core Java**

Developed a console-based Employee Management System using Core Java. Implemented CRUD operations, Object-Oriented Programming, ArrayList, Exception Handling, File Handling, Serialization, input validation, employee search, department filtering, salary analysis, and employee statistics with persistent local data storage.

---

# 💼 Skills Demonstrated

```text
Core Java
OOP
Collections Framework
ArrayList
Exception Handling
File Handling
Serialization
CRUD Operations
Input Validation
Git
GitHub

```

---

# 👨‍💻 Author

**Kaveri Ayyappa**

GitHub:
`https://github.com/Ayyappa1295

---

# ⭐ Support

If you find this project useful, consider giving the repository a ⭐ on GitHub. next give me for commit
