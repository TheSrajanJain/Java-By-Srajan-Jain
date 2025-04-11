import java.util.Scanner;
import java.util.Random;
public class Hotel_Management_System_v1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int choice = 0;
        System.out.println("--------------- Dosa Idli Sambar Chutney Chutney Hotel ---------------\n");
        System.out.println("--------- Menu ---------");
        while(true) {
            System.out.println("1. Dosa ---> 60/-\n2. Idli ---> 35/-\n3. Pav Bhaji ---> 45/-");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
        }
    }
}
