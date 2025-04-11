import java.util.Scanner;
public class Area_Of_Circle {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the radius: ");
        float radius = s1.nextFloat();
        float pie = 22 / 7f;
        System.out.println("The Area of Circle i.e, " + pie + " * " + radius + " * " + radius + " = " + (pie * radius * radius) + " units.");
    }
}