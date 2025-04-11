import java.util.Scanner;
public class Bank_system_v1
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------Bank OF Unity:)------------");
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter your Father name: ");
        String father = scanner.next();
        System.out.print("Enter your Account no.: ");
        int account = scanner.nextInt();
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();
        System.out.println("Enter the minimum amount of money you want to deposit to start this account(minimum 100): ");
        int balance = scanner.nextInt();
        if(balance < 99){
            System.out.println("Sorry! you have to deposit 100 or more... but fine:)");
        }
        System.out.println(" ");
        System.out.println("Submitting test...");
        System.out.println(" ");
            System.out.println("_________Login_________");
            System.out.println("Enter your PIN: ");
            int pin2 = scanner.nextInt();
            if(pin2 != pin)
            {
                System.out.println("Sorry! Invalid PIN.");
            }
            else{
                System.out.println("________Welcome________");
                System.out.println("|Name: "+name);
                System.out.println("|S/O: Mr."+father);
                System.out.println("|A/c no.: "+account);
                System.out.println("|Your balance: "+balance+"rs.");
                System.out.println("|----------------------");
                System.out.println(" ");
                System.out.print(" Do you want to withdraw or deposit money? (0 for withdraw, 1 for deposit and 2 for exit): ");
                int choice = scanner.nextInt();
                if(choice == 0){
                    System.out.println("Enter the amount of money you want to withdraw: ");
                    int withdraw = scanner.nextInt();
                    if(withdraw > 0 && withdraw < balance){
                        System.out.println("Successfully withdraw!");
                        int deductedbalance = balance - withdraw;
                        System.out.println(withdraw+" has been deducted from your account balance.");
                        System.out.println("Your current balance: "+deductedbalance+"rs.");
                    }
                    else{
                        System.out.println("Sorry! The amount of money you have entered is either not withdraw able or it is not in your account balance!");
                    }
                }
                else if(choice == 1){
                    System.out.println("Enter the amount of money you want to deposit: ");
                    int deposit = scanner.nextInt();
                    System.out.println("Successfully deposit!");
                    int addedbalance = balance + deposit;
                    System.out.println("Your current balance: "+addedbalance+"rs.");
                }
                else if(choice == 2){
                    System.out.println("Good luck!");
                }
        }
    }
}
