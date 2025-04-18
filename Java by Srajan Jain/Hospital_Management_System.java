import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Hospital_Management_System {
    static Scanner scanner = new Scanner(System.in);
    static String customerName = "";
    static String customerAddress = "Unknown";
    static long customerContact = 0;
    static int totalBill = 0;
    static String bill = "";
    static void Patient_Details() {
        Random random = new Random();
        int r = random.nextInt(100000)+10000;
        System.out.println("\n--------------- Patient Registration ---------------");
        System.out.print("Enter your Name: ");
        customerName = scanner.nextLine();
        System.out.print("Enter your Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your Gender (Male/Female/Other): ");
        String gender = scanner.nextLine();
        System.out.print("Enter your Contact No.: ");
        customerContact = scanner.nextLong();
        System.out.print("Enter your Emergency Contact No.: ");
        long contact2 = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter your Email Id: ");
        String email = scanner.nextLine();
        System.out.println("\nPatient Registered Successfully!");
        System.out.println("Name: " + customerName);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Contact: " + customerContact);
        System.out.println("Emergency Contact: " + contact2);
        System.out.println("Email: " + email);
        System.out.println("Your Id no. Generated: "+r);
    }
    static void Doctor_Details() {
        System.out.println("\n--------------- Doctor Registration ---------------");
        System.out.print("Enter Doctor's Name: ");
        String D_name = scanner.nextLine();
        System.out.print("Enter Doctor's Age: ");
        int D_age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Doctor's Gender (Male/Female/Other): ");
        String D_gender = scanner.nextLine();
        System.out.print("Enter Doctor's Private(Personal) No.: ");
        long D_contact = scanner.nextLong();
        System.out.print("Enter Doctor's Public Contact No.: ");
        long D_contact2 = scanner.nextLong();
        System.out.println("\nDoctor Registered Successfully!");
        System.out.println("Name: " + D_name);
        System.out.println("Age: " + D_age);
        System.out.println("Gender: " + D_gender);
        System.out.println("Personal Contact: " + D_contact);
        System.out.println("Public Contact: " + D_contact2);
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
        Random random = new Random();
        int choice, strips;
        bill = "";
        totalBill = 0;
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
            int serialNumber = bill.split("\n").length + 1;
            bill += String.format("%-5d %-15s %-8d %-8d %-8d %-8d\n", serialNumber, medicineName, hsn, rate, rate, itemTotal);
        }
        if (!bill.isEmpty()) {
            generateBill();
        } else {
            System.out.println("No medicines selected, returning to menu.");
        }
    }
    static void generateBill() {
        Random random = new Random();
        int billNumber = 100000 + random.nextInt(900000);
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
    static void Ward_Select() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int r = random.nextInt(1000)+1;
        int choice;
        int price = 0;
        String wardType = "";
        System.out.println("Available Wards:- ");
        System.out.println("1. General Ward - 200rs.");
        System.out.println("2. ICU Ward - 20000rs.");
        System.out.println("3. Private Ward - 2000rs.");
        System.out.println("4. Semi-Private Ward - 1000rs.");
        System.out.println("0. Cancel Ward Registration");
        System.out.print("Enter Your Choice: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                wardType = "General Ward";
                price = 200;
                break;
            case 2:
                wardType = "ICU Ward";
                price = 20000;
                break;
            case 3:
                wardType = "Private Ward";
                price = 2000;
                break;
            case 4:
                wardType = "Semi-Private Ward";
                price = 1000;
                break;
            case 0:
                System.out.println("Ward Registration Cancelled.");
                return;
            default:
                System.out.println("Invalid choice! Please try again.");
                return;
        }
        System.out.println("Ward Registered Successfully!");
        System.out.println("Ward Type: " + wardType);
        System.out.println("Your Ward No.: "+r);
        System.out.println("Charges: Rs." + price);
        totalBill += price;
        System.out.println("Total amount so far (excluding medicines): Rs." + totalBill);

    }
    static void Appointment_Service_Setter() {
        Scanner scanner = new Scanner(System.in);
        String[] doctorNames = {"Dr. Rajesh Sharma - Cardiologist", "Dr. Neha Verma - Dermatologist", "Dr. Arjun Singh - Orthopedic", "Dr. Anjali Gupta - Neurologist", "Dr. Aman Patel - General Physician"};
        System.out.println("--------------- Available Doctors ---------------");
        for (int i = 0; i < doctorNames.length; i++) {
            System.out.println((i + 1) + ". " + doctorNames[i]);
        }
        System.out.println("0. Cancel Appointment");
        System.out.print("Select Doctor Number for Appointment: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 0) {
            System.out.println("Appointment Process Cancelled.");
            return;
        } else if (choice < 1 || choice > doctorNames.length) {
            System.out.println("Invalid Choice! Try Again.");
            return;
        }
        String selectedDoctor = doctorNames[choice - 1];
        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter Appointment Date (DD-MM-YYYY): ");
        String date = scanner.nextLine();
        System.out.print("Enter Appointment Time (e.g., 10:30 AM): ");
        String time = scanner.nextLine();
        System.out.println("\nAppointment Confirmed!");
        System.out.println("Doctor: " + selectedDoctor);
        System.out.println("Patient: " + patientName);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
    }
    static void Service() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String serviceName = "";
        int serviceCost = 0;
        System.out.println("\n----------- Available Hospital Services -----------");
        System.out.println("1. Room Cleaning - Rs. 150");
        System.out.println("2. Bed Sheet Change - Rs. 100");
        System.out.println("3. Laundry Service - Rs. 200");
        System.out.println("4. Food Delivery - Rs. 300");
        System.out.println("0. Cancel Service Request");
        System.out.print("Enter the service number you want: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                serviceName = "Room Cleaning";
                serviceCost = 150;
                break;
            case 2:
                serviceName = "Bed Sheet Change";
                serviceCost = 100;
                break;
            case 3:
                serviceName = "Laundry Service";
                serviceCost = 200;
                break;
            case 4:
                serviceName = "Food Delivery";
                serviceCost = 300;
                break;
            case 0:
                System.out.println("Service Request Cancelled.");
                return;
            default:
                System.out.println("Invalid Choice! Try Again.");
                return;
        }
        System.out.print("Enter the Room Number where this service is needed: ");
        int roomNo = scanner.nextInt();
        System.out.println("\nService Request Confirmed!");
        System.out.println("Service: " + serviceName);
        System.out.println("Room Number: " + roomNo);
        System.out.println("Service Cost: Rs. " + serviceCost);
        totalBill += serviceCost;
        System.out.println("Total amount so far (excluding medicines): Rs." + totalBill);
        System.out.println("Thank you! Our staff will attend shortly.");
    }
    static void Registration_Methods() {
        int choice;
        do {
            System.out.println("\n------------ Registration Methods ------------");
            System.out.println("1. Patient Section");
            System.out.println("2. Doctor Section");
            System.out.println("3. Pharmacy Section");
            System.out.println("4. Ward Section");
            System.out.println("5. Appointment Section");
            System.out.println("6. Service Section");
            System.out.println("0. Exit the program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: Patient_Details(); break;
                case 2: Doctor_Details(); break;
                case 3: selectMedicines(); break;
                case 4: Ward_Select(); break;
                case 5: Appointment_Service_Setter(); break;
                case 0: System.out.println("Exiting Program... Thank you!"); break;
                default: System.out.println("Invalid choice! Please select again.");
            }
        } while (choice != 0);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("======= Welcome to Unity Hospital =======");
        while(true) {
            Registration_Methods();
            System.out.println("Do you want to leave the Hospital, if your or your close one's health is finished? (0/1)");
            choice = scanner.nextInt();
            if(choice == 0 || choice == 1){
                FinalHospitalBill();
                if(choice == 0){
                    System.out.println("Ok, sir but first take the Bill for this Session...");
                } else {
                    System.out.println("Ok, Thank You for visiting our Hospital, Bill generated!");
                }
                break;
            }
        }
    }
    static void FinalHospitalBill() {
        System.out.println("\n=========== Final Hospital Bill ===========");
        System.out.println("Patient Name: " + customerName);
        System.out.println("Total Services + Ward + Appointments: Rs. " + totalBill);
        System.out.println("Medicines are billed separately in 'Medical_Bill.txt'");
        System.out.println("============================================");
        System.out.println("Thank you for trusting Unity Hospital!\nWish you good health!");
    }
}
