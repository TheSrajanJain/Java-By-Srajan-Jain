import java.util.Scanner;
public class Assignment_Operators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.println("Enter second number: ");
        double num2 = scanner.nextDouble();
        System.out.println(num1+" += "+num2+" = "+(num1+=num2));
        System.out.println(num1+" -= "+num2+" = "+(num1-=num2));
        System.out.println(num1+" *= "+num2+" = "+(num1*=num2));
        System.out.println(num1+" /= "+num2+" = "+(num1/=num2));
    }
}
