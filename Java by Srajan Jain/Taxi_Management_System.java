import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
class BankAccount {
    String name;
    String accountNumber;
    String ifscCode;
    double balance;
    public BankAccount(String name, String accountNumber, String ifscCode, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.balance = balance;
    }
    public void saveToFile() {
        try {
            String fileName = "BankDetails_" + accountNumber + ".txt";
            FileWriter writer = new FileWriter(fileName);
            writer.write("===== Bank Account Details =====\n");
            writer.write("Name: " + name + "\n");
            writer.write("Account Number: " + accountNumber + "\n");
            writer.write("IFSC Code: " + ifscCode + "\n");
            writer.write("Balance: ₹" + balance + "\n");
            writer.close();
            System.out.println("Details saved successfully to: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving details.");
            e.printStackTrace();
        }
    }
    public void updateBalance(double paymentAmount) {
        if (paymentAmount <= balance) {
            balance -= paymentAmount;
            System.out.println("Payment of ₹" + paymentAmount + " was successful. New Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    public static BankAccount readFromFile(String accountNumber) {
        String fileName = "BankDetails_" + accountNumber + ".txt";
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Account not found!");
            return null;
        }
        try (Scanner fileReader = new Scanner(file)) {
            String name = "", accountNum = "", ifsc = "";
            double balance = 0.0;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (line.startsWith("Name:")) {
                    name = line.split(":")[1].trim();
                }
                if (line.startsWith("Account Number:")) {
                    accountNum = line.split(":")[1].trim();
                }
                if (line.startsWith("IFSC Code:")) {
                    ifsc = line.split(":")[1].trim();
                }
                if (line.startsWith("Balance:")) {
                    balance = Double.parseDouble(line.split(":")[1].trim().replace("₹", ""));
                }
            }
            return new BankAccount(name, accountNum, ifsc, balance);
        } catch (FileNotFoundException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
            return null;
        }
    }
}
public class Taxi_Management_System {
    static void Client_Details(String name, String father_name, long contact, long aadhar) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        System.out.print("Enter your Father's Name: ");
        father_name = scanner.nextLine();
        System.out.print("Enter your contact: ");
        contact = scanner.nextLong();
        System.out.print("Enter your Aadhar no.: ");
        aadhar = scanner.nextLong();
    }
    static void Menu() {
        System.out.println("========== Taxi Menu ==========\n1. Book Taxi\n2. Cancel Taxi\n3. Exit");
    }
    static void Menu_choice(int choice, String location) {
        String taxis[] = {"Swift Cab 101", "Speedster Taxi", "Urban Go Cab"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Enter your choice(1, 2, 3): ");
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Available Taxis: ");
                for (int i = 0; i < taxis.length; i++) {
                    System.out.println(i + " --> " + taxis[i]);
                }
                System.out.println("Enter the location you want to go: ");
                location = scanner.nextLine();
                System.out.print("Based on your location, your payment: ₹");
                int payment = random.nextInt(10000) + 1000;  // Random payment between ₹1000 and ₹11000
                System.out.println(payment);
                System.out.println("Do you want to pay?(0 - Cancel, 1 - Yes): ");
                int choice1 = scanner.nextInt();
                if (choice1 == 0) {
                    System.out.println("Cancelling...");
                    return;
                } else if (choice1 == 1) {
                    System.out.println("Enter your Account Number to deduct payment: ");
                    scanner.nextLine();
                    String accountNumber = scanner.nextLine();
                    BankAccount userAccount = BankAccount.readFromFile(accountNumber);
                    if (userAccount != null) {
                        userAccount.updateBalance(payment);
                        userAccount.saveToFile();
                    }
                }
                break;
            case 2:
                System.out.println("Taxi booking cancelled.");
                break;
            case 3:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Enter Bank Account Details =====");
        System.out.print("Enter Account Holder's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter IFSC Code: ");
        String ifscCode = scanner.nextLine();
        System.out.print("Enter Initial Balance: ₹");
        double balance = scanner.nextDouble();
        BankAccount newAccount = new BankAccount(name, accountNumber, ifscCode, balance);
        newAccount.saveToFile();
        String location = "";
        int choice = 0;
        Menu();
        Menu_choice(choice, location);
    }
}
