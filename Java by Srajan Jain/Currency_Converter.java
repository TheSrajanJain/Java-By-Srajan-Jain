import java.util.Scanner;
public class Currency_Converter {
    static void INRToUSD(double amount) {
        System.out.println("The amount in USD is: " + (amount / 85.14));
    }
    static void USDToINR(double amount) {
        System.out.println("The amount in INR is: " + (amount * 85.14));
    }
    static void EURToGBP(double amount) {
        System.out.println("The amount in GBP is: " + (amount * 0.86));
    }
    static void GBPToEUR(double amount) {
        System.out.println("The amount in EUR is: " + (amount * 1.14));
    }
    static void JPYToINR(double amount) {
        System.out.println("The amount in INR is: " + (amount * 0.69));
    }
    static void INRToJPY(double amount) {
        System.out.println("The amount in JPY is: " + (amount / 0.69));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;
        while (true) {
            System.out.println("\nCurrency Converter!");
            System.out.println("1. INR to USD");
            System.out.println("2. USD to INR");
            System.out.println("3. EUR to GBP");
            System.out.println("4. GBP to EUR");
            System.out.println("5. JPY to INR");
            System.out.println("6. INR to JPY");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount in INR: ");
                    amount = scanner.nextDouble();
                    INRToUSD(amount);
                    break;
                case 2:
                    System.out.print("Enter amount in USD: ");
                    amount = scanner.nextDouble();
                    USDToINR(amount);
                    break;
                case 3:
                    System.out.print("Enter amount in EUR: ");
                    amount = scanner.nextDouble();
                    EURToGBP(amount);
                    break;
                case 4:
                    System.out.print("Enter amount in GBP: ");
                    amount = scanner.nextDouble();
                    GBPToEUR(amount);
                    break;
                case 5:
                    System.out.print("Enter amount in JPY: ");
                    amount = scanner.nextDouble();
                    JPYToINR(amount);
                    break;
                case 6:
                    System.out.print("Enter amount in INR: ");
                    amount = scanner.nextDouble();
                    INRToJPY(amount);
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
