import java.util.Scanner;
public class computer_parts_shopping_system_v1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int price1 = 6999;
        int price2 = 6499;
        int price3 = 2999;
        int price4 = 999;
        int cpu = 0;
        int monitor = 0;
        int keyboard = 0;
        int mouse = 0;
                System.out.println("-------------Computer Parts Shop-------------");
        System.out.println(" ");
        System.out.println("(Arranged by descending order of their price)");
        System.out.println("Product Name ---------- Price(per piece)");
        System.out.println("1. CPU      ------------ 6999/-");
        System.out.println("2. Monitor  ------------ 6499/-");
        System.out.println("3. Keyboard ------------ 2999/-");
        System.out.println("4. Mouse    ------------  999/-");
        System.out.println(" ");
        System.out.println("Enter your choice(1, 2, 3, 4): ");
        int choice = scanner.nextInt();
        if(choice == 1){
            System.out.println("Enter the amount of piece you want to purchase: ");
            cpu = scanner.nextInt();
        }
        else if(choice == 2){
            System.out.println("Enter the amount of piece you want to purchase: ");
            monitor = scanner.nextInt();
        }
        else if(choice == 3){
            System.out.println("Enter the amount of piece you want to purchase: ");
            keyboard = scanner.nextInt();
        }
        else{
            System.out.println("Enter the amount of piece you want to purchase: ");
            mouse = scanner.nextInt();
        }
        for(int i = 1; i <= 4; i++) {
            System.out.println(" ");
            System.out.println("Do you want to buy another items?(0/1):");
            int choice1 = scanner.nextInt();
            if (choice1 == 0) {
                System.out.println("-----Thank you-----");
                if (choice == 1) {
                    System.out.println("Product purchased: CPU");
                    System.out.println("Amount of piece purchased: " + cpu);
                    System.out.println("Total = " + price1 + " * " + cpu + " = " + (price1 * cpu));
                    System.out.println("--------------------------------");
                } else if (choice == 2) {
                    System.out.println("Product purchased: Monitor");
                    System.out.println("Amount of piece purchased: " + cpu);
                    System.out.println("Total = " + price2 + " * " + monitor + " = " + (price2 * monitor));
                    System.out.println("--------------------------------");
                } else if (choice == 3) {
                    System.out.println("Product purchased: Keyboard");
                    System.out.println("Amount of piece purchased: " + keyboard);
                    System.out.println("Total = " + price3 + " * " + keyboard + " = " + (price3 * keyboard));
                    System.out.println("--------------------------------");
                } else {
                    System.out.println("Product purchased: Mouse");
                    System.out.println("Amount of piece purchased: " + mouse);
                    System.out.println("Total = " + price4 + " * " + mouse + " = " + (price4 * mouse));
                    System.out.println("--------------------------------");
                }
                break;
            }
            else if (choice1 == 1) {
                System.out.println("Enter your choice(1, 2, 3, 4): ");
                choice = scanner.nextInt();
                if(choice == 1){
                    System.out.println("Enter the amount of piece you want to purchase: ");
                    cpu = scanner.nextInt();
                }
                else if(choice == 2){
                    System.out.println("Enter the amount of piece you want to purchase: ");
                    monitor = scanner.nextInt();
                }
                else if(choice == 3){
                    System.out.println("Enter the amount of piece you want to purchase: ");
                    keyboard = scanner.nextInt();
                }
                else{
                    System.out.println("Enter the amount of piece you want to purchase: ");
                    mouse = scanner.nextInt();
                }
            }
        }
    }
}
