import java.util.Scanner;
public class Calculator_v1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();
        System.out.println("Enter your choice(+, -, *, /, %): ");
        String choice = scanner.next();
        switch (choice){
            case "+":
                System.out.println(a+" + "+b+" = "+(a+b));
                break;
            case "-":
                System.out.println(a+" - "+b+" = "+(a-b));
                break;
            case "*":
                System.out.println(a+" * "+b+" = "+(a*b));
                break;
            case "/":
                System.out.println(a+" / "+b+" = "+(a/b));
                break;
            case "%":
                System.out.println(a+" % "+b+" = "+(a%b));
                break;
        }
    }
}
