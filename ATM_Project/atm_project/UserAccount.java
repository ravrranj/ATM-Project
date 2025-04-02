package atm_project;

import java.util.ArrayList;

// creating the useraccount class (Encapsulation)
public class UserAccount {
    private long accountNumber; // cannot be accessed directly from outside
    private String accountHolder;
    private int pin;             // Keeps user PIN secure
    private double balance;      // Prevents direct modification of balance
    private ArrayList<String> miniStatement; 

    public UserAccount(long accountNumber,String accountHolder, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;  // to set user name
        this.pin = pin;
        this.balance = 0.0;
        this.miniStatement = new ArrayList<>();
    }

    public long getAccountNumber() {
        return this.accountNumber;
    }

    //getter function to retrieve user's name
    public String getAccountHolder() {
        return accountHolder;
    }

    //Validate PIN
    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    // deposite amount
    public void deposit(double amount) {
        if (amount > 0) {
        balance += amount;
        addTransaction("Deposited: $" + amount);
        System.out.println("Deposit successful! Your new balance is: $" + balance);
    } else {
        System.out.println("Inavlid deposite amount!");
    }
}

    // Withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            addTransaction("Withdrawn: $" + amount);
            System.out.println("Withdrawn: $" + amount);
            return true;
        } else {
            System.out.println("Insufficcient funds or invalid amount!");
            return false;
        }
    }

    // Add transaction history ((only recent 5))

    public void addTransaction(String transaction) {
         if (miniStatement.size() == 5) {
            miniStatement.remove(0);  // remove the older transaction 
         }
            miniStatement.add(transaction);
    }


    // Get balance
    public double getBalance() {
        return balance;
    }

    //print last 5 transactions

public void getLastTransaction() {
    System.out.println("\n╔════════════════════════════════════╗");
  System.out.printf("║   Mini Statement for %-12s         ║\n", this.getAccountHolder());
      System.out.println("╠════════════════════════════════════╣");

    if (miniStatement == null || miniStatement.isEmpty()) {
      System.out.println("║     No recent transactions         ║");
    } else {
        for (String transaction : miniStatement) {
            System.out.printf("║ %s ║\n ", transaction);
        }
    }

      System.out.println("╠════════════════════════════════════╣"  );
  System.out.printf("║  Current Balance: $%,.2f           ║\n", this.getBalance());
      System.out.println("╚════════════════════════════════════╝\n");
}

    @Override
    public String toString() {
        return "Account Holder : " + accountHolder + "Account Number: " + accountNumber + ", Balance: $" + balance;
    }
}
    