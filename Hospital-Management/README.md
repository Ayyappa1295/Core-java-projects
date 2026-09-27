# 🏥 Hospital Management System

A console-based **Hospital Management System** developed using **Core Java**.

This project helps manage basic hospital operations such as adding patients, viewing patient records, assigning doctors, updating diseases, and discharging patients.

---

## 📌 Project Overview

The **Hospital Management System** is a Java console application designed to demonstrate practical implementation of Core Java concepts.

The application provides a simple menu-driven interface where users can manage patient information efficiently.

---

## 🚀 Features

* ➕ Add New Patient
* 👥 View All Patients
* 👨‍⚕️ Assign Doctor to Patient
* 📝 Update Patient Disease
* 🏥 Discharge Patient
* 🔍 Search Patient by Name
* ❌ Exit Hospital System

---

## 🛠️ Technologies Used

* **Java**
* **Core Java**
* **ArrayList**
* **Scanner**
* **Object-Oriented Programming (OOP)**
* **Conditional Statements**
* **Loops**
* **Methods**
* **Classes and Objects**

---

## 📚 Core Java Concepts Used

This project demonstrates the following concepts:

### 1. Classes and Objects

The `Patient` class is used to create patient objects.

### 2. Constructors

A constructor initializes patient details such as:

* Name
* Age
* Disease
* Doctor
* Admission status

### 3. Encapsulation of Behavior

Patient-related operations are implemented through methods such as:

* `assignDoctor()`
* `display()`

### 4. ArrayList

`ArrayList<Patient>` is used to store multiple patient records dynamically.

### 5. Scanner

The `Scanner` class is used to accept input from the user.

### 6. Methods

Different operations are separated into methods such as:

* `addPatient()`
* `viewPatients()`
* `findPatient()`
* `assignDoctor()`
* `updateDisease()`
* `dischargePatient()`

### 7. Loops and Switch

A `do-while` loop keeps the hospital menu running, while a `switch` statement handles user choices.

---

## 📂 Project Structure

```text
Hospital-Management-System/
│
├── HospitalSystem.java
└── README.md
```

---

## ▶️ How to Run

### Step 1: Install Java

Make sure Java JDK is installed on your system.

Check the Java version:

```bash
java -version
```

---

### Step 2: Save the Code

Save the Java source code as:

```text
HospitalSystem.java
```

---

### Step 3: Compile the Program

Open Terminal in the project folder and run:

```bash
javac HospitalSystem.java
```

---

### Step 4: Run the Program

```bash
java HospitalSystem
```

---

## 💻 Sample Menu

```text
===== HOSPITAL SYSTEM =====
1. Add Patient
2. View Patients
3. Assign Doctor
4. Update Disease
5. Discharge Patient
6. Exit

Enter choice:
```

---

## 🧪 Sample Output

### Add Patient

```text
Enter Name: Rahul
Enter Age: 25
Enter Disease: Fever

Patient Added Successfully 🏥
```

### Assign Doctor

```text
Enter Patient Name: Rahul
Enter Doctor Name: DrRavi

Doctor Assigned: DrRavi
```

### View Patients

```text
Name: Rahul | Age: 25 | Disease: Fever | Doctor: DrRavi | Admitted: true
```

### Discharge Patient

```text
Enter Patient Name: Rahul

Patient Discharged 🏥
```

---

## 🔄 Application Flow

```text
Start
  ↓
Display Hospital Menu
  ↓
Select Operation
  ↓
Add / View / Assign Doctor / Update / Discharge
  ↓
Perform Operation
  ↓
Return to Menu
  ↓
Exit
```

---

## 🎯 Learning Outcomes

By developing this project, the following practical skills are demonstrated:

* Understanding Core Java fundamentals
* Working with Classes and Objects
* Using Constructors
* Managing collections with ArrayList
* Implementing CRUD-like operations
* Searching objects in a collection
* Using loops and switch statements
* Creating modular Java methods
* Building a menu-driven console application

---

## 🔮 Future Enhancements

The project can be further improved by adding:

* MySQL database integration
* JDBC connectivity
* Patient ID generation
* Doctor management
* Appointment scheduling
* Billing system
* Room/bed management
* Login authentication
* GUI using Java Swing or JavaFX
* Spring Boot REST API
* Web-based hospital management system

---

## 👨‍💻 Author

**Ayyappa**

https://github.com/Ayyappa1295

---

## ⭐ Project Purpose

This project was created for **learning, practice, and demonstrating Core Java programming skills** through a real-world application.

If you find this project useful, consider giving it a ⭐ on GitHub.
