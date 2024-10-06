// Customer class to store customer details (Encapsulation)
class Customer {
    private String name; // private field (Encapsulation)
    private String customerId; // private field (Encapsulation)

    public Customer(String name, String customerId) { // Constructor
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() { // Encapsulation (using getter)
        return name;
    }

    public String getCustomerId() { // Encapsulation (using getter)
        return customerId;
    }
}

// Base class: Account (Abstraction)
abstract class Account { // Abstract class (Abstraction)
    private String accountNumber; // private field (Encapsulation)
    private Customer customer;
    private double balance; // private field (Encapsulation)

    // Constructor (used in Inheritance)
    public Account(String accountNumber, Customer customer, double initialBalance) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = initialBalance;
    }

    // Deposit method (Encapsulation)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // Encapsulating balance change
            System.out.println("Deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method (Encapsulation)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; // Encapsulating balance change
            System.out.println("Withdrew " + amount + ". Remaining balance: " + balance);
        } else {
            System.out.println("Invalid or insufficient balance.");
        }
    }

    // Get balance method (Encapsulation)
    public double getBalance() {
        return balance; // Encapsulation (protecting direct access to balance)
    }

    // Account info method (Encapsulation)
    public void accountInfo() {
        System.out.println("Account Number: " + accountNumber + ", Customer: " + customer.getName() + ", Balance: " + balance);
    }
}

// SavingsAccount class inheriting from Account (Inheritance)
class SavingsAccount extends Account { // Inheritance
    private double interestRate; // Encapsulation

    public SavingsAccount(String accountNumber, Customer customer, double initialBalance, double interestRate) {
        super(accountNumber, customer, initialBalance); // Calling parent constructor (Inheritance)
        this.interestRate = interestRate;
    }

    // Calculate interest method (Encapsulation)
    public void calculateInterest() {
        double interest = getBalance() * interestRate; // Using inherited method (Polymorphism)
        System.out.println("Interest on the balance is: " + interest);
    }
}

// CheckingAccount class inheriting from Account (Inheritance)
class CheckingAccount extends Account { // Inheritance
    private double overdraftLimit; // Encapsulation

    public CheckingAccount(String accountNumber, Customer customer, double initialBalance, double overdraftLimit) {
        super(accountNumber, customer, initialBalance); // Calling parent constructor (Inheritance)
        this.overdraftLimit = overdraftLimit;
    }

    // Override withdraw method to include overdraft (Polymorphism: Method Overriding)
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance() + overdraftLimit) { // Overdraft logic (Overriding)
            double newBalance = getBalance() - amount;
            System.out.println("Withdrew " + amount + ". Remaining balance: " + newBalance + " (including overdraft limit).");
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }
}


// Main class to run the simulation
public class Main {
    public static void main(String[] args) {
        // Create a bank (Object creation)
        Bank myBank = new Bank("My Simple Bank"); // Encapsulation (creating a bank object)

        // Create customers (Object creation)
        Customer customer1 = new Customer("Alice", "C001"); // Creating customer1 object
        Customer customer2 = new Customer("Bob", "C002"); // Creating customer2 object

        // Add customers to the bank (Method invocation)
        myBank.addCustomer(customer1); // Encapsulation (adding customer1 to the bank)
        myBank.addCustomer(customer2); // Encapsulation (adding customer2 to the bank)

        // Create accounts for customers (Object creation)
        SavingsAccount savingsAcc1 = new SavingsAccount("A001", customer1, 500, 0.02); // Creating a savings account for customer1
        CheckingAccount checkingAcc2 = new CheckingAccount("A002", customer2, 300, 100); // Creating a checking account for customer2

        // Add accounts to the bank (Polymorphism: Bank class works with base Account type)
        myBank.addAccount(savingsAcc1); // Adding savings account to the bank
        myBank.addAccount(checkingAcc2); // Adding checking account to the bank

        // Perform deposit and withdrawal operations (Method invocation)
        savingsAcc1.deposit(200); // Deposit operation on savings account
        savingsAcc1.withdraw(100); // Withdraw operation on savings account
        savingsAcc1.calculateInterest(); // Calculate interest on savings account

        checkingAcc2.deposit(500); // Deposit operation on checking account
        checkingAcc2.withdraw(700); // Withdraw operation on checking account (testing overdraft)

        // Display account information (Method invocation)
        savingsAcc1.accountInfo(); // Display account information for savings account
        checkingAcc2.accountInfo(); // Display account information for checking account
    }
}
