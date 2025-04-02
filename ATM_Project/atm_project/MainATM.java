
package atm_project;

import java.util.Scanner;

public class MainATM {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for account details
        System.out.print("Enter your Account Number: ");
        long accountNumber = scanner.nextLong();
        scanner.nextLine();

        //Ask user for their name
        System.out.print("Enter Your name: ");
        String accountHolder = scanner.nextLine().trim();
        
        // Ask user to set up PIN
        System.out.print("Set your 4 digit PIN: ");
        int userPin = scanner.nextInt();
        
        // Create a new user account with user-provided details
        UserAccount user = new UserAccount(accountNumber, accountHolder, userPin, 0.0); //Initial balance: $0.00

        int attempts = 3;
        boolean isAutheticated = false;

        // PIN Authentication - Allow 3 attempts
        while (attempts > 0) {
            System.out.println("\nEnter your PIN to login: ");
            int enteredPin = scanner.nextInt();

            if(user.validatePin(enteredPin)) {
                isAutheticated = true;
                System.out.println("Authentication successful!\n");
                break;
            } else {
                attempts--;
                System.out.println("Incorrect PIN👻.Attempts left: " + attempts);
            }
        }
         // If authentication fails after 3 attempts -- exit
        
         if(!isAutheticated) {
            System.out.println("Too many incorrect attempts. Exiting...");
            scanner.close();
            return;
         }

        //Creating ATM services instance
        ATMServices atm = new ATMServices(user);
        boolean running = true;

        while (running) {
            System.out.println("\n╔══════════════════════════════╗");
              System.out.println("║      Welcome to ATM          ║");
              System.out.println("╠══════════════════════════════╣");
              System.out.println("║ 1. Check Balance             ║");
              System.out.println("║ 2. Deposit                   ║");
              System.out.println("║ 3. Withdraw                  ║");
              System.out.println("║ 4. Mini Statement            ║");
              System.out.println("║ 5. Exit                      ║");
              System.out.println("╚══════════════════════════════╝");
              System.out.print("Select an option: ");
 

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                System.out.println("Your Balance is: $" + user.getBalance());
                break;
                case 2:
                System.out.println("Enter the deposit amount : ");
                double depositAmount = scanner.nextDouble();
                user.deposit(depositAmount);
                System.out.println("Deposit successful! New balance : $" + user.getBalance());
                break;
                case 3:
                System.out.println("Enter the withdrawal amount : ");
                double withdrawAmount = scanner.nextDouble();
                if (user.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful! New balance: $" + user.getBalance());
                } else {
                    System.out.println("Insufficient balance!");
                }
                break;
                case 4:
                user.getLastTransaction();
                break;
                
                case 5:
                System.out.println("Exiting ATM Services. Have a great day😊!!");
                running = false;
                break;
                
                default:
                System.out.println("Invalid choice! Please try again.");
            }
            
            }
            scanner.close();
        }
    }
