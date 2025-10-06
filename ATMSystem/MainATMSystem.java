import atm.ATM;
import atm.BasicATM;
import database.BankDatabase;
import database.Account;
import java.util.Scanner;

public class MainATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankDatabase bankDatabase = new BankDatabase();

        // Add some default accounts
        bankDatabase.addAccount(new Account(123456, "Srabon", 1234, 50000.0, "123-456-7890"));
        bankDatabase.addAccount(new Account(789012, "Arif", 5678, 30000.0, "987-654-3210"));

        System.out.println("===== Welcome to ATM System =====");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Insert ATM Card (Access Account)");
            System.out.println("2. Add New Account to Database");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    System.out.print("ATM card detected. Enter account number: ");
                    int detectedAccountNumber = scanner.nextInt();

                    if (bankDatabase.accountExists(detectedAccountNumber)) {
                        Account account = bankDatabase.getAccount(detectedAccountNumber);
                        ATM atm = new BasicATM(account);
                        atm.showMenu();
                    } else {
                        System.out.println("Invalid account number. Please contact the bank.");
                    }
                    break;

                case 2:
                    System.out.println("Add New Account:");
                    System.out.print("Enter new account number: ");
                    int newAccNum = scanner.nextInt();
                    if (bankDatabase.accountExists(newAccNum)) {
                        System.out.println("Account number already exists!");
                        break;
                    }
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter PIN: ");
                    int pin = scanner.nextInt();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();

                    Account newAccount = new Account(newAccNum, name, pin, balance, phone);
                    bankDatabase.addAccount(newAccount);
                    System.out.println("New account added successfully!");
                    break;

                case 3:
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
