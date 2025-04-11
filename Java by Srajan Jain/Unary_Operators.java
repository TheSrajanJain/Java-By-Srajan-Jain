import java.util.Scanner;
public class Unary_Operators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.println("Enter second number: ");
        int num2 = scanner.nextInt();
        System.out.println("++"+num1+" = "+(++num1));
        System.out.println(num1+"++ = "+(num1++));
        System.out.println("++"+num2+" = "+(++num2));
        System.out.println(num2+"++ = "+(num2++));
    }
}