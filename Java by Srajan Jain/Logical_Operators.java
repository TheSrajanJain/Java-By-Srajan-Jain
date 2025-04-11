import java.util.Scanner;
public class Logical_Operators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first boolean value (true/false): ");
        boolean a = scanner.nextBoolean();
        System.out.print("Enter the second boolean value (true/false): ");
        boolean b = scanner.nextBoolean();
        System.out.println(a+" && "+b+" is "+(a && b));
        System.out.println(a+" || "+b+" is "+(a || b));
        System.out.println(a+" ! "+b+" is "+(a != b));
    }
}

