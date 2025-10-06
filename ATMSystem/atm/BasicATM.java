package atm;

import database.Account;
import java.util.Scanner;

public class BasicATM extends ATM {

    public BasicATM(Account account) {
        super(account);
    }

    private boolean verifyPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Calling the registered phone number: " + account.getPhoneNumber() + "...");
        System.out.println("Enter your PIN to verify the withdrawal:");
        int enteredPin = scanner.nextInt();
        return enteredPin == account.getPin();
    }

    @Override
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your PIN:");
        int enteredPin = scanner.nextInt();

        if (enteredPin == account.getPin()) {
            System.out.println("Hello " + account.getAccountHolderName() + ", Have a good day!");

            boolean exit = false;
            while (!exit) {
                System.out.println("\n===== ATM Menu =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Your current balance is: $" + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit (multiples of $500 only): ");
                        int depositAmount = scanner.nextInt();
                        account.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw (multiples of $500 only): ");
                        int withdrawAmount = scanner.nextInt();
                        if (withdrawAmount % 500 != 0) {
                            System.out.println("Invalid amount! Only multiples of $500 are allowed.");
                        } else if (verifyPhoneNumber()) {
                            account.withdraw(withdrawAmount, enteredPin);
                        } else {
                            System.out.println("Phone verification failed. Withdrawal denied!");
                        }
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid PIN. Access Denied!");
        }
    }
}
