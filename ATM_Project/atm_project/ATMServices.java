package atm_project;

import java.util.Scanner;



public class ATMServices {
    private UserAccount user;
    private Scanner scanner;

    public ATMServices(UserAccount user) {
        this.user = user;  // Assigns user account 
        this.scanner = new Scanner(System.in);  // Initializes scanner for input  
        
        System.out.println("\n====================================");
        System.out.printf("  ATM Service Initialized for: %s\n", user.getAccountHolder());
        System.out.println("------------------------------------");
        System.out.printf("  Account Number : %s\n", user.getAccountNumber());
        System.out.printf("  Account Holder : %s\n", user.getAccountHolder());
        System.out.printf("  Balance        : $%,.2f\n", user.getBalance());
        System.out.println("====================================\n");
 
    }

    //Autheticate user by PIN
    public boolean authenticateUser() {
        System.out.print("enter your PIN: ");
        int enteredPin = scanner.nextInt();
        return user.validatePin(enteredPin);
    }

    //Withdraw money
    public void  withdrawCash() {
        System.out.println("Enter the amount to withdraw : ");
        double amount = scanner.nextDouble();

        if (amount > user.getBalance()) {
            System.out.println("Insufficient balance!");
        } else {
            user.withdraw(amount);
            user.addTransaction("Withdrawn: $" + amount);
            System.out.println("\n✔ Transaction Successful!");
            System.out.printf("   New Balance: $%,.2f%n", user.getBalance());
            System.out.println("------------------------------------\n");
  
        }
    }

    // Deposit money
    public void depositeCash() {
        System.out.println("Enter amount to deposit : ");
        double amount = scanner.nextDouble();

        user.deposit(amount);
        user.addTransaction("Deposited: $" + amount);
        System.out.println("\n✔ Transaction Successful!");
        System.out.printf("   New Balance: $%,.2f%n", user.getBalance());
        System.out.println("------------------------------------\n");

    }

    // check balance
    public void checkBalance() {
        System.out.println("\n====================================");
        System.out.printf("  Your Current Balance: $%,.2f\n", user.getBalance());
        System.out.println("====================================\n");
    }
    

    //print last 5 transactions (Mini statement)
    public void printMiniStatement() {
        user.getLastTransaction();
    }
}