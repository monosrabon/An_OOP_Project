ATM System Project

# Overview

This is a Java-based ATM system that simulates a real-world ATM machine. It demonstrates the use of Object-Oriented Programming (OOP) concepts such as encapsulation, inheritance, abstraction, and polymorphism.

# The system supports:

- Adding and managing multiple accounts
- Persistent account storage in a file (accounts.txt)
- Deposits and withdrawals (only multiples of $500 allowed)
- Phone number verification for withdrawals
- Personalized greetings when users log in

# Key Features
1. Account Management

- Accounts are represented using the Account class with private fields and getter/setter methods.
- Supports adding new accounts dynamically from the main menu.
- All accounts are saved in accounts.txt for persistent storage.

2. ATM Operations

- Login requires account number and PIN.
- Personalized greeting: "Hello <Name>, Have a good day!"
- Deposit money (multiples of $500 only, no verification).
- Withdraw money (multiples of $500 only, phone verification required).

3. OOP Concepts Used

- Encapsulation: Account details are private and accessed via methods.
- Abstraction: ATM is an abstract class with an abstract showMenu() method.
- Inheritance: BasicATM extends ATM and implements its functionality.
- Polymorphism: The ATM menu behavior can be changed by creating new subclasses of ATM.
- Modularity: Project is split into packages (atm and database) for better organization.

# Future Enhancements

- Automatic unique account number generation
- GUI interface for easier interaction
- Multi-currency support
- PIN encryption and secure data storage
