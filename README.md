# ATM-Project
using the concept of OOPS and basic java wrote a code to show the working of ATM , wil implement more feature as I learn 


Features:
✅ User Authentication (PIN-based login)
✅ Account Balance Check
✅ Cash Withdrawal (Limit-based)
✅ Cash Deposit
✅ Mini Statement (Last 5 transactions)

OOP Concepts Used:
✔ Encapsulation → Private fields for balance, PIN, transactions
✔ Inheritance → UserAccount as base class, ATMService as derived class
✔ Polymorphism → Different transaction types (deposit, withdraw)
✔ Abstraction → Abstract class for TransactionService


Design the ATM System
We will break it into three main parts:

User Account → Holds balance, PIN, and transaction history.
ATM Services → Handles authentication, withdrawals, deposits, and balance check.
Transaction Log → Stores the last 5 transactions (mini-statement)


 Java Classes & OOP Implementation
🔹 1. UserAccount (Encapsulation)
Fields: accountNumber, pin, balance, ArrayList<String> transactions

Methods: validatePin(), updateBalance(), getLastTransactions()

🔹 2. ATMService (Inheritance & Polymorphism)
Methods: authenticateUser(), withdrawCash(), depositCash(), checkBalance(), printMiniStatement()

🔹 3. TransactionService (Abstraction)
Abstract class for deposit & withdrawal transactions


Steps involved : 

Step 1: Creating the UserAccount Class (Encapsulation)
First, we need a class to store user details (like PIN, balance, and transaction history). This will also have methods to validate the PIN, update balance, and store transactions.

🔹 What We'll Do in UserAccount
✅ Encapsulate user data (account number, PIN, balance)
✅ Store last 5 transactions using an ArrayList<String>
✅ Methods:

validatePin(int enteredPin) → boolean

updateBalance(double amount) → void

addTransaction(String transaction) → void

getLastTransactions() → void



Step 2: Creating ATMService Class
This class will handle:
✅ User Authentication (PIN verification)
✅ Withdraw Money (Ensure sufficient balance)
✅ Deposit Money (Increase balance)
✅ Check Balance (Show available balance)
✅ Mini Statement (Show last 5 transactions)



Step 3: 
Where we code the ATM system and run to test the program.
