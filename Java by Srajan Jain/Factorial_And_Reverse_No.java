import java.util.Scanner;
public class Factorial_And_Reverse_No {
    static void Reverse_no(int number){
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        System.out.println("Reversed number of "+number+" is: " + reversed);
    }
    static void Factorial_no(int number){
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        System.out.println("1. Reverse no.\n2. Factorial no.\n3. Exit");
        int choice = 0;
        int num = 0;
        while(true) {
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            System.out.println("Enter a number: ");
            num = scanner.nextInt();
            switch (choice) {
                case (1):
                    Reverse_no(num);
                    break;
                case (2):
                    Factorial_no(num);
                    break;
                case (3):
                    System.out.println("Have a nice day! \nExiting");
                    return;
                default:
                    System.out.println("Sorry incorrect choice! Try again\n\n");
            }
            System.out.println("-----------------------");
        }

    }
}
