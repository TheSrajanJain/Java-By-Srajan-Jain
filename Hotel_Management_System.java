import java.util.Scanner;
import java.util.Random;
public class Hospital_Management_System {
    static void Patient_Details(String name, int age, String gender, long contact, long contact2, String email){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------- Registration ---------------");
        System.out.print("Enter your Name: ");
        name = scanner.nextLine();
        System.out.print("Enter your Age: ");
        age = scanner.nextInt();
        System.out.print("Enter your Gender(Male/Female/Other): ");
        gender = scanner.next();
        System.out.print("Enter your Contact No.: ");
        contact = scanner.nextLong();
        System.out.print("Enter your Emergency Contact No.: ");
        contact2 = scanner.nextLong();
        System.out.print("Enter your Email Id: ");
        email = scanner.nextLine();
    }
    static void Doctor_Details(String D_name, int D_age, String D_gender, long D_contact, long D_contact2){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Doctor Name: ");
        D_name = scanner.nextLine();
        System.out.println("Enter Doctor Age: ");
    }
    static void Registration_Methods(int choice, String section){
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------ Registration Methods ------------");
        System.out.println("1. Patient Section");
        System.out.println("2. Doctor Section");
        System.out.println("3. Pharmacy Section");
        System.out.println("4. Ward Section");
        System.out.println("5. Appointment Section");
        System.out.println("6. Service Section");
        System.out.println("Enter your choice: ");
        choice = scanner.nextInt();
        switch(choice) {
            case (1):
            System.out.println("1. Register Patient");
            System.out.println("2. View Patient Details");
            System.out.println("3. Update Patient Information");
            System.out.println("4. Exit/Cancel the Program");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            break;
            case(2):
                System.out.println("1. Register Doctor");
                System.out.println("2. View Doctors Details");
                System.out.println("3. Update Doctors Information");
                System.out.println("4. Exit/Cancel the Program");
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                break;
        }
    }
}
