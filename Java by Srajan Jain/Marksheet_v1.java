import java.util.Scanner;
public class Marksheet_v1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------Indian Institute Of Technology------------");
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter your branch: ");
        String branch = scanner.next();
        System.out.print("Enter your Roll no.: ");
        int rollno = scanner.nextInt();
        System.out.print("Enter your stream(1.PCM, 2.PCB, 3.Arts, 4.Commerce): ");
        int stream = scanner.nextInt();
        System.out.print("Enter your marks in Physics(Out of 100): ");
        int phy = scanner.nextInt();
        System.out.print("Enter your marks in Chemistry(Out of 100): ");
        int chem = scanner.nextInt();
        System.out.print("Enter your marks in Biology(Out of 100): ");
        int bio = scanner.nextInt();
        System.out.print("Enter your marks in Mathematics(Out of 100): ");
        int maths = scanner.nextInt();
        System.out.print("Enter your marks in Social Studies(Out of 100): ");
        int sst = scanner.nextInt();
        int total = phy + chem + bio + maths + sst;
        float percent = total/5f;
        System.out.println(phy+" + "+chem+" + "+bio+" + "+maths+" + "+sst+" = "+total+" out of 500");
        System.out.println("Your percentage is: "+percent+"%");
    }
}
