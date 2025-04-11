import java.util.Scanner;
public class Banking_System_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalUsers = 3;
        int amount = 0;
        int pin2 = 0;
        String[] userNames = {"Oswald", "Doraemon", "Bobthebuilder"};
        int[] accountNumbers = {101, 102, 103};
        System.out.println("------------Bank OF Unity:)------------");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your Father name: ");
        String father = scanner.nextLine();
        System.out.print("Enter your Account no.: ");
        int account = scanner.nextInt();
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();
        System.out.println("Enter the minimum amount of money you want to deposit to start this account(minimum 100): ");
        int balance = scanner.nextInt();
        if (balance < 99) {
            System.out.println("Sorry! you have to deposit 100 or more... but fine:)");
        }
        System.out.println(" ");
        System.out.println("Submitting informaion...");
        System.out.println(" ");
        System.out.println("_________Login_________");
        for(int j = 1; j <= 3; j++){
            System.out.print("Enter your PIN: ");
            pin2 = scanner.nextInt();
            if(pin2 != pin && j == 1){
                System.out.println("You wasted your first attempt!");
            }
            if(pin2 != pin && j == 2){
                System.out.println("You wasted your second attempt, now last attempt!");
            }
            if(pin2 == pin){
                break;
            }
            else{
                System.out.println("Try again!");
                if(j == 3){
                    System.out.println("Unsuccessful attempts! Exiting...");
                    return;
                }
            }
        }
            System.out.println("Welcome, " + name + "!");
            System.out.println("Son of " + father);
            System.out.println("Account no.: " + account);
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Transfer Money");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int option = scanner.nextInt();
                if (option == 1) {
                    System.out.println("Your Balance: ₹" + balance);
                } else if (option == 2) {
                    System.out.print("Enter deposit amount: ₹");
                    int depositAmount = scanner.nextInt();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.println("₹" + depositAmount + " deposited successfully to your balance!");
                    } else {
                        System.out.println("Sorry! The amount of money you entered is out of range.");
                    }
                } else if (option == 3) {
                    System.out.print("Enter withdrawal amount: ₹");
                    int withdrawalAmount = scanner.nextInt();
                    if (withdrawalAmount > 0 && withdrawalAmount <= balance) {
                        balance -= withdrawalAmount;
                        System.out.println("₹" + withdrawalAmount + " withdrawn successfully from your balance!");
                    } else {
                        System.out.println("Invalid withdrawal amount or insufficient balance!");
                    }
                } else if (option == 4) {
                    System.out.println("Available accounts: ");
                    System.out.println(" ");
                    System.out.println("User's Name ---> Account no.");
                    System.out.println("1. " + userNames[0] + " ---> " + accountNumbers[0]);
                    System.out.println("2. " + userNames[1] + " ---> " + accountNumbers[1]);
                    System.out.println("3. " + userNames[2] + " ---> " + accountNumbers[2]);
                    System.out.println(" ");
                    System.out.print("Enter recipient's account number: ");
                    int account1 = scanner.nextInt();
                        if (account1 == accountNumbers[0]) {
                            System.out.println("Enter the amount you want to transfer: ");
                            amount = scanner.nextInt();
                            if (amount < 0 || amount > balance) {
                                System.out.println("Sorry! The Amount you entered is either invalid, it is not available in your account balance or it is lower than the transferable amount!");
                                break;
                            } else {
                                System.out.println(amount+"rs. is Successfully transferred!");
                                balance -= amount;
                            }
                        } else if (account1 == accountNumbers[1]) {
                            System.out.println("Enter the amount you want to transfer: ");
                            amount = scanner.nextInt();
                            if (amount < 0 || amount > balance) {
                                System.out.println("Sorry! Invalid Amount");
                                break;
                            } else {
                                System.out.println("Successfully transferred!");
                                balance -= amount;
                            }
                        } else if (account1 == accountNumbers[2]) {
                            System.out.println("Enter the amount you want to transfer: ");
                            amount = scanner.nextInt();
                            if (amount < 0 || amount > balance) {
                                System.out.println("Sorry! Invalid Amount");
                                break;
                            } else {
                                System.out.println("Successfully transferred!");
                                balance -= amount;
                            }
                        } else {
                            System.out.println("Sorry! the amount is invalid or non-available.");
                            break;}
                }
                else{
                    System.out.println("Have a nice day!\n Exiting...");
                    return;
                }
            }
        }
    }
