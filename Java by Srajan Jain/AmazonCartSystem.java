import java.util.Scanner;
import java.util.ArrayList;
public class AmazonCartSystem {
    static String[] products = {"Laptop", "Smart Phone", "Head Phone", "Mouse", "JoyStick", "KeyBoard"};
    static int[] prices = {55000, 45000, 5500, 3400, 4600, 2500};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cart = new ArrayList<>();
        long balance;

        System.out.println("Welcome to the Amazon Cart System!");

        // User account setup
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit (minimum ₹100): ");
        balance = scanner.nextLong();
        if (balance < 100) {
            System.out.println("Minimum deposit should be ₹100. Restart the program to try again.");
            return;
        }

        System.out.println("Hello, " + name + "! Your account has been created with ₹" + balance + " balance.\n");

        // Main menu loop
        while (true) {
            System.out.println("-------- Amazon Cart Menu --------");
            System.out.println("1. View Product Catalog");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Display products
                    System.out.println("\n---- Product Catalog ----");
                    for (int i = 0; i < products.length; i++) {
                        System.out.println((i + 1) + ". " + products[i] + " - ₹" + prices[i]);
                    }
                    System.out.println();
                    break;

                case 2:
                    // Add product to cart
                    System.out.print("Enter the product number to add to cart: ");
                    int productIndex = scanner.nextInt() - 1;
                    if (productIndex >= 0 && productIndex < products.length) {
                        cart.add(products[productIndex]);
                        System.out.println(products[productIndex] + " added to your cart.\n");
                    } else {
                        System.out.println("Invalid product number!\n");
                    }
                    break;

                case 3:
                    // View cart
                    System.out.println("\n---- Your Cart ----");
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty.\n");
                    } else {
                        for (String item : cart) {
                            System.out.println("--> " + item);
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    // Checkout
                    System.out.println("\n---- Checkout ----");
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty. Add something first!\n");
                    } else {
                        int total = 0;
                        for (String item : cart) {
                            int index = java.util.Arrays.asList(products).indexOf(item);
                            total += prices[index];
                        }
                        System.out.println("Total amount: ₹" + total);
                        if (total <= balance) {
                            balance -= total;
                            System.out.println("Purchase successful! Remaining balance: ₹" + balance + "\n");
                            cart.clear();
                        } else {
                            System.out.println("Insufficient balance. Please add funds or remove items from the cart.\n");
                        }
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting... Thank you for shopping with us!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.\n");
            }
        }
    }
}