import java.util.ArrayList;
import java.util.Scanner;

/*
 * ============================================================
 *             BANKING MANAGEMENT SYSTEM
 * ============================================================
 * Developed using Core Java
 *
 * Concepts Used:
 * - Classes and Objects
 * - Encapsulation
 * - Inheritance
 * - Polymorphism
 * - ArrayList
 * - Scanner
 * - Methods
 * - Exception Handling
 * - Loops and Conditional Statements
 * - String Handling
 * - Date and Time API
 * - Input Validation
 * - Transaction Management
 * ============================================================
 */

class Transaction {

    private String type;
    private double amount;
    private double balance;
    private String description;
    private String dateTime;

    public Transaction(String type, double amount,
                       double balance, String description,
                       String dateTime) {

        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        this.dateTime = dateTime;
    }

    public void displayTransaction() {

        System.out.println("-----------------------------------------------");
        System.out.println("Transaction Type : " + type);
        System.out.println("Amount           : ₹" + amount);
        System.out.println("Balance After    : ₹" + balance);
        System.out.println("Description      : " + description);
        System.out.println("Date & Time      : " + dateTime);
    }
}


// ============================================================
// ACCOUNT CLASS
// ============================================================

class Account {

    private String accountNumber;
    private String customerName;
    private String phoneNumber;
    private String email;
    private String address;
    private int pin;
    private double balance;

    private ArrayList<Transaction> transactions;

    public Account(String accountNumber,
                   String customerName,
                   String phoneNumber,
                   String email,
                   String address,
                   int pin,
                   double initialDeposit) {

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.pin = pin;
        this.balance = initialDeposit;

        transactions = new ArrayList<>();

        addTransaction(
                "ACCOUNT CREATED",
                initialDeposit,
                "Initial account deposit"
        );
    }

    // ========================================================
    // GETTERS
    // ========================================================

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }

    // ========================================================
    // PIN VALIDATION
    // ========================================================

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    // ========================================================
    // DEPOSIT
    // ========================================================

    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance += amount;

        addTransaction(
                "DEPOSIT",
                amount,
                "Cash deposited into account"
        );

        return true;
    }

    // ========================================================
    // WITHDRAW
    // ========================================================

    public boolean withdraw(double amount) {

        if (amount <= 0) {
            return false;
        }

        if (amount > balance) {
            return false;
        }

        balance -= amount;

        addTransaction(
                "WITHDRAWAL",
                amount,
                "Cash withdrawn from account"
        );

        return true;
    }

    // ========================================================
    // TRANSFER SUPPORT
    // ========================================================

    public boolean transferMoney(double amount, String receiver) {

        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;

        addTransaction(
                "TRANSFER",
                amount,
                "Money transferred to " + receiver
        );

        return true;
    }

    // ========================================================
    // TRANSACTION HISTORY
    // ========================================================

    private void addTransaction(String type,
                                double amount,
                                String description) {

        String dateTime =
                java.time.LocalDateTime.now()
                        .format(
                                java.time.format.DateTimeFormatter
                                        .ofPattern("dd-MM-yyyy HH:mm:ss")
                        );

        transactions.add(
                new Transaction(
                        type,
                        amount,
                        balance,
                        description,
                        dateTime
                )
        );
    }

    public void showTransactionHistory() {

        if (transactions.isEmpty()) {

            System.out.println("\nNo transactions available.");

            return;
        }

        System.out.println("\n================================================");
        System.out.println("              TRANSACTION HISTORY");
        System.out.println("================================================");

        for (Transaction transaction : transactions) {

            transaction.displayTransaction();
        }

        System.out.println("-----------------------------------------------");
    }

    // ========================================================
    // ACCOUNT DETAILS
    // ========================================================

    public void displayAccountDetails() {

        System.out.println("\n================================================");
        System.out.println("              ACCOUNT DETAILS");
        System.out.println("================================================");

        System.out.println("Account Number : " + accountNumber);
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Phone Number   : " + phoneNumber);
        System.out.println("Email          : " + email);
        System.out.println("Address        : " + address);
        System.out.println("Balance        : ₹" + balance);

        System.out.println("================================================");
    }

    // ========================================================
    // UPDATE CUSTOMER DETAILS
    // ========================================================

    public void updatePhone(String phone) {
        this.phoneNumber = phone;
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    public void updateAddress(String address) {
        this.address = address;
    }
}


// ============================================================
// BANK CLASS
// ============================================================

class Bank {

    private String bankName;

    private ArrayList<Account> accounts;

    public Bank(String bankName) {

        this.bankName = bankName;

        accounts = new ArrayList<>();
    }

    // ========================================================
    // CREATE ACCOUNT
    // ========================================================

    public Account createAccount(String name,
                                 String phone,
                                 String email,
                                 String address,
                                 int pin,
                                 double initialDeposit) {

        String accountNumber =
                generateAccountNumber();

        Account account =
                new Account(
                        accountNumber,
                        name,
                        phone,
                        email,
                        address,
                        pin,
                        initialDeposit
                );

        accounts.add(account);

        return account;
    }

    // ========================================================
    // GENERATE ACCOUNT NUMBER
    // ========================================================

    private String generateAccountNumber() {

        return "ACC" +
                String.format(
                        "%06d",
                        accounts.size() + 100001
                );
    }

    // ========================================================
    // FIND ACCOUNT
    // ========================================================

    public Account findAccount(String accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber()
                    .equalsIgnoreCase(accountNumber)) {

                return account;
            }
        }

        return null;
    }

    // ========================================================
    // DELETE ACCOUNT
    // ========================================================

    public boolean deleteAccount(String accountNumber) {

        Account account =
                findAccount(accountNumber);

        if (account == null) {
            return false;
        }

        accounts.remove(account);

        return true;
    }

    // ========================================================
    // SHOW ALL ACCOUNTS
    // ========================================================

    public void displayAllAccounts() {

        if (accounts.isEmpty()) {

            System.out.println(
                    "\nNo accounts available."
            );

            return;
        }

        System.out.println("\n================================================");
        System.out.println("                 ALL ACCOUNTS");
        System.out.println("================================================");

        for (Account account : accounts) {

            System.out.println(
                    "Account Number : "
                            + account.getAccountNumber()
            );

            System.out.println(
                    "Customer Name  : "
                            + account.getCustomerName()
            );

            System.out.println(
                    "Phone          : "
                            + account.getPhoneNumber()
            );

            System.out.println(
                    "Balance        : ₹"
                            + account.getBalance()
            );

            System.out.println("-----------------------------------------------");
        }
    }

    public int getTotalAccounts() {

        return accounts.size();
    }

    public String getBankName() {

        return bankName;
    }
}


// ============================================================
// MAIN CLASS
// ============================================================

public class BankingManagementSystem {

    static Scanner scanner =
            new Scanner(System.in);

    static Bank bank =
            new Bank("ABC National Bank");

    // ========================================================
    // MAIN METHOD
    // ========================================================

    public static void main(String[] args) {

        showWelcomeScreen();

        while (true) {

            showMainMenu();

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    createNewAccount();
                    break;

                case 2:
                    loginToAccount();
                    break;

                case 3:
                    searchAccount();
                    break;

                case 4:
                    bank.displayAllAccounts();
                    break;

                case 5:
                    deleteAccount();
                    break;

                case 6:
                    showBankStatistics();
                    break;

                case 7:

                    System.out.println(
                            "\nThank you for using "
                                    + bank.getBankName()
                                    + "!"
                    );

                    System.out.println(
                            "Have a great day!"
                    );

                    scanner.close();

                    System.exit(0);

                    break;

                default:

                    System.out.println(
                            "\nInvalid choice! "
                                    + "Please try again."
                    );
            }
        }
    }

    // ========================================================
    // WELCOME SCREEN
    // ========================================================

    public static void showWelcomeScreen() {

        System.out.println(
                "\n************************************************"
        );

        System.out.println(
                "*                                              *"
        );

        System.out.println(
                "*          ABC NATIONAL BANK                  *"
        );

        System.out.println(
                "*       BANKING MANAGEMENT SYSTEM             *"
        );

        System.out.println(
                "*                                              *"
        );

        System.out.println(
                "************************************************"
        );
    }

    // ========================================================
    // MAIN MENU
    // ========================================================

    public static void showMainMenu() {

        System.out.println(
                "\n================================================"
        );

        System.out.println(
                "              MAIN BANKING MENU"
        );

        System.out.println(
                "================================================"
        );

        System.out.println(
                "1. Create New Account"
        );

        System.out.println(
                "2. Login to Account"
        );

        System.out.println(
                "3. Search Account"
        );

        System.out.println(
                "4. Display All Accounts"
        );

        System.out.println(
                "5. Delete Account"
        );

        System.out.println(
                "6. Bank Statistics"
        );

        System.out.println(
                "7. Exit"
        );

        System.out.println(
                "================================================"
        );
    }

    // ========================================================
    // CREATE ACCOUNT
    // ========================================================

    public static void createNewAccount() {

        System.out.println(
                "\n================================================"
        );

        System.out.println(
                "              CREATE NEW ACCOUNT"
        );

        System.out.println(
                "================================================"
        );

        scanner.nextLine();

        System.out.print(
                "Enter customer name: "
        );

        String name =
                scanner.nextLine();

        System.out.print(
                "Enter phone number: "
        );

        String phone =
                scanner.nextLine();

        System.out.print(
                "Enter email: "
        );

        String email =
                scanner.nextLine();

        System.out.print(
                "Enter address: "
        );

        String address =
                scanner.nextLine();

        int pin;

        while (true) {

            pin =
                    readInt(
                            "Create 4-digit PIN: "
                    );

            if (pin >= 1000 && pin <= 9999) {
                break;
            }

            System.out.println(
                    "PIN must contain exactly 4 digits."
            );
        }

        double initialDeposit;

        while (true) {

            initialDeposit =
                    readDouble(
                            "Enter initial deposit: ₹"
                    );

            if (initialDeposit >= 500) {
                break;
            }

            System.out.println(
                    "Minimum initial deposit is ₹500."
            );
        }

        Account account =
                bank.createAccount(
                        name,
                        phone,
                        email,
                        address,
                        pin,
                        initialDeposit
                );

        System.out.println(
                "\n************************************************"
        );

        System.out.println(
                "       ACCOUNT CREATED SUCCESSFULLY!"
        );

        System.out.println(
                "************************************************"
        );

        System.out.println(
                "Account Number : "
                        + account.getAccountNumber()
        );

        System.out.println(
                "Customer Name  : "
                        + account.getCustomerName()
        );

        System.out.println(
                "Initial Balance: ₹"
                        + account.getBalance()
        );

        System.out.println(
                "************************************************"
        );
    }

    // ========================================================
    // LOGIN
    // ========================================================

    public static void loginToAccount() {

        System.out.println(
                "\n================================================"
        );

        System.out.println(
                "                 ACCOUNT LOGIN"
        );

        System.out.println(
                "================================================"
        );

        scanner.nextLine();

        System.out.print(
                "Enter account number: "
        );

        String accountNumber =
                scanner.nextLine();

        Account account =
                bank.findAccount(accountNumber);

        if (account == null) {

            System.out.println(
                    "\nAccount not found!"
            );

            return;
        }

        int pin =
                readInt("Enter 4-digit PIN: ");

        if (!account.verifyPin(pin)) {

            System.out.println(
                    "\nIncorrect PIN!"
            );

            return;
        }

        System.out.println(
                "\nLogin successful!"
        );

        customerMenu(account);
    }

    // ========================================================
    // CUSTOMER MENU
    // ========================================================

    public static void customerMenu(Account account) {

        while (true) {

            System.out.println(
                    "\n================================================"
            );

            System.out.println(
                    "             CUSTOMER DASHBOARD"
            );

            System.out.println(
                    "================================================"
            );

            System.out.println(
                    "Welcome, "
                            + account.getCustomerName()
            );

            System.out.println(
                    "Account: "
                            + account.getAccountNumber()
            );

            System.out.println(
                    "------------------------------------------------"
            );

            System.out.println(
                    "1. Account Details"
            );

            System.out.println(
                    "2. Check Balance"
            );

            System.out.println(
                    "3. Deposit Money"
            );

            System.out.println(
                    "4. Withdraw Money"
            );

            System.out.println(
                    "5. Transfer Money"
            );

            System.out.println(
                    "6. Transaction History"
            );

            System.out.println(
                    "7. Update Profile"
            );

            System.out.println(
                    "8. Logout"
            );

            System.out.println(
                    "================================================"
            );

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:

                    account.displayAccountDetails();

                    break;

                case 2:

                    checkBalance(account);

                    break;

                case 3:

                    depositMoney(account);

                    break;

                case 4:

                    withdrawMoney(account);

                    break;

                case 5:

                    transferMoney(account);

                    break;

                case 6:

                    account.showTransactionHistory();

                    break;

                case 7:

                    updateProfile(account);

                    break;

                case 8:

                    System.out.println(
                            "\nLogged out successfully."
                    );

                    return;

                default:

                    System.out.println(
                            "\nInvalid choice!"
                    );
            }
        }
    }

    // ========================================================
    // CHECK BALANCE
    // ========================================================

    public static void checkBalance(Account account) {

        System.out.println(
                "\n-----------------------------------------------"
        );

        System.out.println(
                "             BALANCE ENQUIRY"
        );

        System.out.println(
                "-----------------------------------------------"
        );

        System.out.println(
                "Account Number : "
                        + account.getAccountNumber()
        );

        System.out.println(
                "Available Balance : ₹"
                        + account.getBalance()
        );

        System.out.println(
                "-----------------------------------------------"
        );
    }

    // ========================================================
    // DEPOSIT
    // ========================================================

    public static void depositMoney(Account account) {

        double amount =
                readDouble(
                        "\nEnter amount to deposit: ₹"
                );

        if (account.deposit(amount)) {

            System.out.println(
                    "\nDeposit successful!"
            );

            System.out.println(
                    "Deposited Amount : ₹"
                            + amount
            );

            System.out.println(
                    "New Balance      : ₹"
                            + account.getBalance()
            );

        } else {

            System.out.println(
                    "\nInvalid deposit amount!"
            );
        }
    }

    // ========================================================
    // WITHDRAW
    // ========================================================

    public static void withdrawMoney(Account account) {

        double amount =
                readDouble(
                        "\nEnter amount to withdraw: ₹"
                );

        if (amount > account.getBalance()) {

            System.out.println(
                    "\nInsufficient balance!"
            );

            System.out.println(
                    "Available Balance: ₹"
                            + account.getBalance()
            );

            return;
        }

        if (account.withdraw(amount)) {

            System.out.println(
                    "\nWithdrawal successful!"
            );

            System.out.println(
                    "Withdrawn Amount : ₹"
                            + amount
            );

            System.out.println(
                    "Remaining Balance: ₹"
                            + account.getBalance()
            );

        } else {

            System.out.println(
                    "\nInvalid withdrawal amount!"
            );
        }
    }

    // ========================================================
    // TRANSFER MONEY
    // ========================================================

    public static void transferMoney(Account sender) {

        scanner.nextLine();

        System.out.println(
                "\n================================================"
        );

        System.out.println(
                "                MONEY TRANSFER"
        );

        System.out.println(
                "================================================"
        );

        System.out.print(
                "Enter receiver account number: "
        );

        String receiverNumber =
                scanner.nextLine();

        Account receiver =
                bank.findAccount(receiverNumber);

        if (receiver == null) {

            System.out.println(
                    "\nReceiver account not found!"
            );

            return;
        }

        if (receiver.getAccountNumber()
                .equalsIgnoreCase(
                        sender.getAccountNumber()
                )) {

            System.out.println(
                    "\nYou cannot transfer money "
                            + "to your own account."
            );

            return;
        }

        System.out.println(
                "Receiver Name: "
                        + receiver.getCustomerName()
        );

        double amount =
                readDouble(
                        "Enter transfer amount: ₹"
                );

        if (amount <= 0) {

            System.out.println(
                    "\nInvalid amount!"
            );

            return;
        }

        if (amount > sender.getBalance()) {

            System.out.println(
                    "\nInsufficient balance!"
            );

            return;
        }

        boolean success =
                sender.transferMoney(
                        amount,
                        receiver.getAccountNumber()
                );

        if (success) {

            receiver.deposit(amount);

            System.out.println(
                    "\n************************************************"
            );

            System.out.println(
                    "          TRANSFER SUCCESSFUL!"
            );

            System.out.println(
                    "************************************************"
            );

            System.out.println(
                    "From Account : "
                            + sender.getAccountNumber()
            );

            System.out.println(
                    "To Account   : "
                            + receiver.getAccountNumber()
            );

            System.out.println(
                    "Amount       : ₹"
                            + amount
            );

            System.out.println(
                    "New Balance  : ₹"
                            + sender.getBalance()
            );

            System.out.println(
                    "************************************************"
            );
        }
    }

    // ========================================================
    // SEARCH ACCOUNT
    // ========================================================

    public static void searchAccount() {

        scanner.nextLine();

        System.out.println(
                "\n================================================"
        );

        System.out.println(
                "                 SEARCH ACCOUNT"
        );

        System.out.println(
                "================================================"
        );

        System.out.print(
                "Enter account number: "
        );

        String accountNumber =
                scanner.nextLine();

        Account account =
                bank.findAccount(accountNumber);

        if (account == null) {

            System.out.println(
                    "\nAccount not found!"
            );

        } else {

            account.displayAccountDetails();
        }
    }

    // ========================================================
    // DELETE ACCOUNT
    // ========================================================

    public static void deleteAccount() {

        scanner.nextLine();

        System.out.println(
                "\n================================================"
        );

        System.out.println(
                "                 DELETE ACCOUNT"
        );

        System.out.println(
                "================================================"
        );

        System.out.print(
                "Enter account number: "
        );

        String accountNumber =
                scanner.nextLine();

        Account account =
                bank.findAccount(accountNumber);

        if (account == null) {

            System.out.println(
                    "\nAccount not found!"
            );

            return;
        }

        System.out.println(
                "Customer Name: "
                        + account.getCustomerName()
        );

        System.out.println(
                "Current Balance: ₹"
                        + account.getBalance()
        );

        System.out.print(
                "Are you sure? (yes/no): "
        );

        String confirmation =
                scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {

            boolean deleted =
                    bank.deleteAccount(
                            accountNumber
                    );

            if (deleted) {

                System.out.println(
                        "\nAccount deleted successfully."
                );
            }

        } else {

            System.out.println(
                    "\nAccount deletion cancelled."
            );
        }
    }

    // ========================================================
    // UPDATE PROFILE
    // ========================================================

    public static void updateProfile(Account account) {

        while (true) {

            System.out.println(
                    "\n================================================"
            );

            System.out.println(
                    "                 UPDATE PROFILE"
            );

            System.out.println(
                    "================================================"
            );

            System.out.println(
                    "1. Update Phone Number"
            );

            System.out.println(
                    "2. Update Email"
            );

            System.out.println(
                    "3. Update Address"
            );

            System.out.println(
                    "4. Back"
            );

            int choice =
                    readInt("Enter choice: ");

            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter new phone number: "
                    );

                    String phone =
                            scanner.nextLine();

                    account.updatePhone(phone);

                    System.out.println(
                            "Phone number updated successfully."
                    );

                    break;

                case 2:

                    System.out.print(
                            "Enter new email: "
                    );

                    String email =
                            scanner.nextLine();

                    account.updateEmail(email);

                    System.out.println(
                            "Email updated successfully."
                    );

                    break;

                case 3:

                    System.out.print(
                            "Enter new address: "
                    );

                    String address =
                            scanner.nextLine();

                    account.updateAddress(address);

                    System.out.println(
                            "Address updated successfully."
                    );

                    break;

                case 4:

                    return;

                default:

                    System.out.println(
                            "Invalid choice!"
                    );
            }
        }
    }

    // ========================================================
    // BANK STATISTICS
    // ========================================================

    public static void showBankStatistics() {

        System.out.println(
                "\n================================================"
        );

        System.out.println(
                "                BANK STATISTICS"
        );

        System.out.println(
                "================================================"
        );

        System.out.println(
                "Bank Name       : "
                        + bank.getBankName()
        );

        System.out.println(
                "Total Accounts  : "
                        + bank.getTotalAccounts()
        );

        System.out.println(
                "System Status   : ACTIVE"
        );

        System.out.println(
                "Technology      : Core Java"
        );

        System.out.println(
                "================================================"
        );
    }

    // ========================================================
    // INTEGER INPUT
    // ========================================================

    public static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return scanner.nextInt();

            } catch (Exception e) {

                System.out.println(
                        "Please enter a valid number."
                );

                scanner.nextLine();
            }
        }
    }

    // ========================================================
    // DOUBLE INPUT
    // ========================================================

    public static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return scanner.nextDouble();

            } catch (Exception e) {

                System.out.println(
                        "Please enter a valid amount."
                );

                scanner.nextLine();
            }
        }
    }
}
