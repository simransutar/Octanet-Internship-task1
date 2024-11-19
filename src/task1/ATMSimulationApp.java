package task1;

//import packages
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ATMSimulationApp {

        // Fields for ATM simulation
        private double balance;
        private String pin;
        private List<String> transactionHistory;

        // Constructor initializes account with default PIN 1284
        public  ATMSimulationApp() {
            this.balance = 1000;
            this.pin = "1284"; // Default PIN
            this.transactionHistory = new ArrayList<>();
        }

        // Method for check the account balance
        public void checkBalance() {
            System.out.println("Current Balance: $" + balance);
            transactionHistory.add("Balance Inquiry: $" + balance);
        }

        // Method for withdrawing money from the account
        public void withdrawCash(double amount) {
            if (amount > 0 ) {
                balance -= amount;
                System.out.println("Successfully withdrew $" + amount);
                transactionHistory.add("Cash Withdrawal: $" + amount);
            } else if (amount > balance) {
                System.out.println("Insufficient balance.");
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        }

        // Method for depositing money into the account(amount=amt)
        public void depositCash(double amt) {
            if (amt > 0) {
                balance += amt;
                System.out.println("Successfully deposited $" + amt);
                transactionHistory.add("Cash Deposit: $" + amt);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        // Method for changing the PIN
        public void changePIN(String oldPIN, String newPIN) {
            if (oldPIN.equals(this.pin)) {
                this.pin = newPIN;
                System.out.println("PIN successfully changed.");
                transactionHistory.add("PIN Changed");
            } else {
                System.out.println("Incorrect old PIN.");
            }
        }

        // Method for displaying the transaction history
        public void displayTransactionHistory() {
            if (transactionHistory.isEmpty()) {
                System.out.println("No transactions available.");
            } else {
                System.out.println("Transaction History:");
                for (String transaction : transactionHistory) {
                    System.out.println(transaction);
                }
            }
        }

        // Main method with user interface for ATM operations
        public static void main(String[] args) {
            ATMSimulationApp atm = new ATMSimulationApp();
            Scanner sc = new Scanner(System.in);

            // User interaction loop for the ATM system
            while (true) {
                System.out.println("\n---- ATM Menu ----");
                System.out.println("1. Account Balance Inquiry");
                System.out.println("2. Withdraw Cash");
                System.out.println("3. Deposit Cash");
                System.out.println("4. Change PIN");
                System.out.println("5. Transaction History");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        atm.withdrawCash(withdrawAmount);
                        break;

                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        atm.depositCash(depositAmount);
                        break;

                    case 4:
                        System.out.print("Enter old PIN: ");
                        String oldPIN = sc.next();
                        System.out.print("Enter new PIN: ");
                        String newPIN = sc.next();
                        atm.changePIN(oldPIN, newPIN);
                        break;
                    case 5:
                        atm.displayTransactionHistory();
                        break;
                    case 6:
                        System.out.println("Thank you for using the ATM. Bye!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }}


