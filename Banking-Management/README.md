🏦 Banking Management System

A console-based Banking Management System developed using Core Java.

This project simulates basic banking operations such as account creation, customer login, deposit, withdrawal, money transfer, transaction history, profile management, account search, and account deletion.

The project is designed to demonstrate practical Core Java and Object-Oriented Programming (OOP) concepts through a real-world banking application.

---

📌 Project Overview

The Banking Management System provides a simple and interactive banking environment through a console application.

Customers can create their bank accounts, securely log in using a PIN, manage their account, perform financial transactions, view transaction history, and update their personal information.

The application also provides basic bank-level features such as viewing all accounts, searching accounts, deleting accounts, and displaying bank statistics.

---

🚀 Features

👤 Account Management

- Create a new bank account
- Automatic account number generation
- Store customer information
- Set a 4-digit PIN
- Initial deposit validation
- Search account
- Display all accounts
- Delete account

🔐 Customer Login

- Account number authentication
- 4-digit PIN verification
- Secure customer dashboard
- Logout functionality

💰 Banking Operations

- Check account balance
- Deposit money
- Withdraw money
- Transfer money between accounts
- Insufficient balance validation

📜 Transaction Management

- Transaction history
- Deposit records
- Withdrawal records
- Transfer records
- Account creation record
- Transaction date and time
- Balance after each transaction

👨‍💼 Profile Management

Customers can update:

- Phone number
- Email address
- Address

🏦 Bank Management

- Display all accounts
- Search accounts
- Delete accounts
- View total number of accounts
- Display bank statistics

---

🛠️ Technologies Used

Technology| Usage
Java| Application development
Core Java| Main programming concepts
ArrayList| Data storage
Scanner| User input
OOP| Application architecture
Java Time API| Transaction date & time
Exception Handling| Input validation

---

📚 Core Java Concepts Used

This project demonstrates several important Core Java concepts:

- Classes and Objects
- Encapsulation
- Constructors
- Methods
- Access Modifiers
- Inheritance
- Polymorphism
- ArrayList
- Loops
- Conditional Statements
- Switch Statements
- String Handling
- Exception Handling
- Input Validation
- Date and Time API
- Object-Oriented Programming

---

📂 Project Structure

Banking-Management-System/
│
├── BankingManagementSystem.java
│
└── README.md

The main Java file contains multiple classes:

BankingManagementSystem
        │
        ├── Bank
        │
        ├── Account
        │
        └── Transaction

"BankingManagementSystem"

Contains the "main()" method and handles the main application menu and customer interaction.

"Bank"

Manages bank-level operations such as:

- Creating accounts
- Finding accounts
- Deleting accounts
- Displaying all accounts
- Generating account numbers

"Account"

Stores customer and account information such as:

- Account number
- Customer name
- Phone number
- Email
- Address
- PIN
- Balance
- Transaction history

"Transaction"

Stores individual transaction information such as:

- Transaction type
- Amount
- Balance
- Description
- Date and time

---

⚙️ How to Run the Project

1. Clone the Repository

git clone https://github.com/YOUR-USERNAME/Banking-Management-System.git

2. Open the Project Folder

cd Banking-Management-System

3. Compile the Java Program

javac BankingManagementSystem.java

4. Run the Application

java BankingManagementSystem

---

🖥️ Main Menu

================================================
              MAIN BANKING MENU
================================================
1. Create New Account
2. Login to Account
3. Search Account
4. Display All Accounts
5. Delete Account
6. Bank Statistics
7. Exit
================================================

---

👤 Customer Dashboard

After successful login, customers can access:

================================================
             CUSTOMER DASHBOARD
================================================

1. Account Details
2. Check Balance
3. Deposit Money
4. Withdraw Money
5. Transfer Money
6. Transaction History
7. Update Profile
8. Logout

================================================

---

💳 Example Operations

Create Account

The customer provides:

Customer Name
Phone Number
Email
Address
4-Digit PIN
Initial Deposit

The system automatically generates an account number.

Example:

Account Number : ACC100001
Customer Name  : Rahul
Initial Balance: ₹5000.0

---

💰 Deposit

Enter amount to deposit: ₹2000

Deposit successful!

Deposited Amount : ₹2000.0
New Balance      : ₹7000.0

---

💸 Withdrawal

Enter amount to withdraw: ₹1000

Withdrawal successful!

Withdrawn Amount : ₹1000.0
Remaining Balance: ₹6000.0

---

🔄 Money Transfer

Enter receiver account number: ACC100002

Receiver Name: Priya

Enter transfer amount: ₹1500

************************************************
          TRANSFER SUCCESSFUL!
************************************************

From Account : ACC100001
To Account   : ACC100002
Amount       : ₹1500.0
New Balance  : ₹4500.0
************************************************

---

📜 Transaction History

The system maintains transaction records including:

Transaction Type
Amount
Balance After Transaction
Description
Date & Time

Example:

-----------------------------------------------
Transaction Type : DEPOSIT
Amount           : ₹2000.0
Balance After    : ₹7000.0
Description      : Cash deposited into account
Date & Time      : 28-09-2026 10:30:25
-----------------------------------------------

---

🔐 Validation

The application includes validation for:

- Invalid menu choices
- Invalid numeric input
- Invalid PIN
- Invalid deposit amount
- Invalid withdrawal amount
- Insufficient account balance
- Invalid receiver account
- Self-transfer prevention
- Minimum initial deposit
- 4-digit PIN requirement

---

🎯 Learning Objectives

This project helps demonstrate how Core Java can be used to build a real-world console application.

Through this project, you can practice:

- Designing classes
- Creating objects
- Applying encapsulation
- Working with collections
- Handling user input
- Implementing business logic
- Managing multiple objects
- Maintaining transaction records
- Handling invalid input
- Structuring a larger Java application

---

🔮 Future Enhancements

The project can be extended with:

- MySQL database integration
- JDBC connectivity
- Admin login
- Customer registration
- Password/PIN change
- Account types
- Savings account
- Current account
- Interest calculation
- Loan management
- ATM simulation
- Fund transfer receipts
- Email notifications
- Java Swing GUI
- JavaFX GUI
- Spring Boot REST API
- Web-based banking application
- Authentication and authorization

---

⚠️ Disclaimer

This project is created for educational and demonstration purposes only.

It is a console-based simulation and is not intended for real banking or financial transactions.

The current version stores data in memory using Java collections. Data will be lost when the application is terminated.

---

👨‍💻 Author

Ayyappa

GitHub

https://github.com/Ayyappa1295

---

⭐ Project Highlights

✔ Core Java
✔ Object-Oriented Programming
✔ Banking Operations
✔ Account Management
✔ Transaction Management
✔ ArrayList
✔ Exception Handling
✔ Input Validation
✔ Date & Time API
✔ Console-Based Application

---

⭐ If you found this project useful

Give the repository a ⭐ on GitHub!
