import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Medical_Bill_Using_File_Handling {
    static String customerName, customerAddress;
    static long customerContact;
    static int totalBill = 0;
    static String bill = "";
    static int billNumber;
    static void getCustomerDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------- Registration --------------");
        System.out.print("Enter your Name: ");
        customerName = scanner.nextLine();
        System.out.print("Enter your Address: ");
        customerAddress = scanner.nextLine();
        System.out.print("Enter your Contact Number: ");
        customerContact = scanner.nextLong();
    }
    static void showMedicineStock() {
        System.out.println("Available Medicines:");
        System.out.println("1. Paracetamol - Rs.50 per strip");
        System.out.println("2. Amoxicillin - Rs.120 per strip");
        System.out.println("3. Cetirizine - Rs.30 per strip");
        System.out.println("4. Metformin - Rs.100 per strip");
        System.out.println("5. Ibuprofen - Rs.80 per strip");
        System.out.println("0. Exit");
    }
    static void selectMedicines() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int choice, strips;
        while (true) {
            showMedicineStock();
            System.out.print("Choose medicine number (0 to finish): ");
            choice = scanner.nextInt();
            if (choice == 0) break;
            System.out.print("Enter number of strips: ");
            strips = scanner.nextInt();
            int hsn = 1000 + random.nextInt(9000);
            int rate = 0;
            String medicineName = "";
            switch (choice) {
                case 1: medicineName = "Paracetamol"; rate = 50; break;
                case 2: medicineName = "Amoxicillin"; rate = 120; break;
                case 3: medicineName = "Cetirizine"; rate = 30; break;
                case 4: medicineName = "Metformin"; rate = 100; break;
                case 5: medicineName = "Ibuprofen"; rate = 80; break;
                default: System.out.println("Invalid choice, try again!"); continue;
            }
            int itemTotal = rate * strips;
            totalBill += itemTotal;
            bill += String.format("%-5d %-15s %-8d %-8d %-8d %-8d\n", (bill.split("\n").length + 1), medicineName, hsn, rate, rate, itemTotal);
        }
    }
    static void generateBill() {
        Random random = new Random();
        billNumber = 100000 + random.nextInt(900000);
        try {
            FileWriter writer = new FileWriter("Medical_Bill.txt");
            writer.write("-----------------------------------------------------------\n");
            writer.write("                          TAX INVOICE\n");
            writer.write("-----------------------------------------------------------\n");
            writer.write("MEDICAL INVOICE                          Bill No: " + billNumber + "\n");
            writer.write("Address: Church Street, Bengaluru\n");
            writer.write("Phone No: +91-1075314648, +91-8029924749\n");
            writer.write("-----------------------------------------------------------\n");
            writer.write("Party's Name\n");
            writer.write("Name    : " + customerName + "\n");
            writer.write("Address : " + customerAddress + "\n");
            writer.write("Contact : " + customerContact + "\n");
            writer.write("-----------------------------------------------------------\n");
            writer.write(String.format("%-5s %-15s %-8s %-8s %-8s %-8s\n", "S.No", "Items", "HSN", "RATE", "MRP", "Amount"));
            writer.write("-----------------------------------------------------------\n");
            writer.write(bill);
            writer.write("-----------------------------------------------------------\n");
            writer.write(String.format("%50s %d\n", "Sub Total:", totalBill));
            writer.write("-----------------------------------------------------------\n");
            writer.write("Thank you for your purchase!\n");
            writer.close();
            System.out.println("Bill generated successfully! Check 'Medical_Bill.txt'");
        } catch (IOException e) {
            System.out.println("Error while generating bill.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Om Shanti Medical Store!\n");
        getCustomerDetails();
        selectMedicines();
        generateBill();
    }
}
