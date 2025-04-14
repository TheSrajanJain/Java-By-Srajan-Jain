import java.util.Scanner;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Children_Helpful_Code {

    static void Squares_Of_Ranging_no(int a) {
        for (int i = 1; i <= a; i++) {
            System.out.println(i + "^2 = " + (i * i));
        }
    }

    static void Addition_And_Subtraction(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.println(a + " - " + b + " = " + (a - b));
    }

    static void Multiplication(int a, int b) {
        System.out.println(a + " * " + b + " = " + (a * b));
    }

    static void Division(double a, double b) {
        if (b == 0) {
            System.out.println("Division by zero is not allowed!");
        } else {
            System.out.println(a + " / " + b + " = " + (a / b));
        }
    }

    static void Remainder(double a, double b) {
        if (b == 0) {
            System.out.println("Division by zero is not allowed!");
        } else {
            System.out.println(a + " % " + b + " = " + (a % b));
        }
    }

    static void Simplification_Solver(String expression) {
        try {
            Expression e = new ExpressionBuilder(expression).build();
            double result = e.evaluate();
            System.out.println("The result of the expression is: " + result);
        } catch (Exception ex) {
            System.out.println("Error evaluating expression: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int a, b;

        while (true) {
            System.out.println("\nChildren's Maths Tools!");
            System.out.println("1. Squares Of Ranging no.");
            System.out.println("2. Addition And Subtraction Of Large no.");
            System.out.println("3. Multiplication Of Large no.");
            System.out.println("4. Division Of no.");
            System.out.println("5. Remainder Of No.");
            System.out.println("6. Simplification Solver");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a no.: ");
                    a = scanner.nextInt();
                    Squares_Of_Ranging_no(a);
                    break;
                case 2:
                    System.out.print("Enter two no.: ");
                    a = scanner.nextInt();
                    b = scanner.nextInt();
                    Addition_And_Subtraction(a, b);
                    break;
                case 3:
                    System.out.print("Enter two no.: ");
                    a = scanner.nextInt();
                    b = scanner.nextInt();
                    Multiplication(a, b);
                    break;
                case 4:
                    System.out.print("Enter two no.: ");
                    a = scanner.nextInt();
                    b = scanner.nextInt();
                    Division(a, b);
                    break;
                case 5:
                    System.out.print("Enter two no.: ");
                    a = scanner.nextInt();
                    b = scanner.nextInt();
                    Remainder(a, b);
                    break;
                case 6:
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter a mathematical expression: ");
                    String expression = scanner.nextLine();
                    Simplification_Solver(expression);
                    break;
                case 7:
                    System.out.println("Have a nice Day!\nExiting...");
                    return;
                default:
                    System.out.println("Sorry! Invalid choice! Try Again...");
            }
        }
    }
}
