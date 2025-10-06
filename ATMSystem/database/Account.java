package database;

public class Account {
    private String accountHolderName;
    private int pin;
    private double balance;
    private String phoneNumber;
    private int accountNumber;

    public Account(int accountNumber, String accountHolderName, int pin, double initialBalance, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        this.balance = initialBalance;
        this.phoneNumber = phoneNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(int amount) {
        if (amount > 0 && amount % 500 == 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " successfully!");
        } else {
            System.out.println("Invalid amount! Only multiples of $500 are allowed.");
        }
    }

    public boolean withdraw(int amount, int enteredPin) {
        if (enteredPin == pin) {
            if (amount > 0 && amount % 500 == 0) {
                if (amount <= balance) {
                    balance -= amount;
                    System.out.println("Withdrawn $" + amount + " successfully!");
                    return true;
                } else {
                    System.out.println("Insufficient balance!");
                }
            } else {
                System.out.println("Invalid amount! Only multiples of $500 are allowed.");
            }
        } else {
            System.out.println("Incorrect PIN. Withdrawal denied!");
        }
        return false;
    }
}
