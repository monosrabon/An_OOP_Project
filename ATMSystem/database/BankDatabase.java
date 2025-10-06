package database;

import java.io.*;
import java.util.*;

public class BankDatabase {
    private Map<Integer, Account> accounts;
    private final String filePath = "accounts.txt";

    public BankDatabase() {
        accounts = new HashMap<>();
        loadAccounts();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
        saveAccounts();
        System.out.println("Account added successfully: " + account.getAccountNumber());
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean accountExists(int accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    // Load accounts from file
    private void loadAccounts() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Format: accountNumber;name;pin;balance;phone
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    int accNum = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int pin = Integer.parseInt(parts[2]);
                    double balance = Double.parseDouble(parts[3]);
                    String phone = parts[4];
                    Account acc = new Account(accNum, name, pin, balance, phone);
                    accounts.put(accNum, acc);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Database file not found. A new one will be created.");
        } catch (IOException e) {
            System.out.println("Error reading the database file.");
        }
    }

    // Save accounts to file
    private void saveAccounts() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Account acc : accounts.values()) {
                bw.write(acc.getAccountNumber() + ";" + acc.getAccountHolderName() + ";" +
                         acc.getPin() + ";" + acc.getBalance() + ";" + acc.getPhoneNumber());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts to file.");
        }
    }
}
