import java.util.*;
import java.io.*;
public class E_Commerce_Platform {
    static Map<String, List<String>> cart = new HashMap<>();
    static String userFile = "users.txt";
    static String orderFile = "orders.txt";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("\n===== E-Commerce Platform =====");
            System.out.println("1. Register");
            System.out.println("2. Browse Catalog");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. View Orders");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    browseCatalog();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    checkout();
                    break;
                case 5:
                    viewOrders();
                    break;
                case 0:
                    System.out.println("Thank you for using the E-Commerce Platform.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    static void registerUser() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int accountNo = random.nextInt(1000000) + 10000;
        System.out.print("Enter your Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter a numeric Password: ");
        int password = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your Contact Number: ");
        long contact = scanner.nextLong();
        try (FileWriter fw = new FileWriter(userFile, true)) {
            fw.write(accountNo + "," + name + "," + age + "," + email + "," + password + "," + contact + "\n");
            System.out.println("Registration successful! Your account number: " + accountNo);
        } catch (IOException e) {
            System.out.println("Error saving user data.");
        }
    }
    static void browseCatalog() {
        Scanner scanner = new Scanner(System.in);
        int category, subcategory;
        while (true) {
            System.out.println("\nCategories:");
            System.out.println("1. Electronics");
            System.out.println("2. Grocery");
            System.out.println("3. HealthCare");
            System.out.println("4. Books");
            System.out.println("0. Back to main menu");
            System.out.print("Choose category: ");
            category = scanner.nextInt();
            if (category == 0) break;
            switch (category) {
                case 1:
                    addToCart("Electronics", Arrays.asList("Smartphone", "Laptop", "Headphones", "Smartwatch"));
                    break;
                case 2:
                    addToCart("Grocery", Arrays.asList("Rice", "Vegetables", "Cooking Oil", "Milk"));
                    break;
                case 3:
                    addToCart("HealthCare", Arrays.asList("Face Mask", "Sanitizer", "Vitamins", "First Aid Kit"));
                    break;
                case 4:
                    System.out.println("\nBook Categories:");
                    System.out.println("1. Fiction");
                    System.out.println("2. Science");
                    System.out.println("3. History");
                    System.out.println("4. Educational");
                    System.out.print("Choose book category: ");
                    subcategory = scanner.nextInt();
                    switch (subcategory) {
                        case 1:
                            addToCart("Fiction", Arrays.asList("The Great Gatsby", "To Kill a Mockingbird", "1984", "Catcher in the Rye", "LOTR"));
                            break;
                        case 2:
                            addToCart("Science", Arrays.asList("Brief History of Time", "Cosmos", "The Gene", "The Selfish Gene", "The Elegant Universe"));
                            break;
                        case 3:
                            addToCart("History", Arrays.asList("Sapiens", "Guns, Germs & Steel", "Silk Roads", "Anne Frank", "US History"));
                            break;
                        case 4:
                            addToCart("Educational", Arrays.asList("Algorithms", "Economics", "Biology", "Physics", "Linear Algebra"));
                            break;
                        default:
                            System.out.println("Invalid book category.");
                    }
                    break;
                default:
                    System.out.println("Invalid category.");
            }
        }
    }
    static void addToCart(String category, List<String> items) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAvailable in " + category + ":");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        System.out.print("Choose item number to add to cart (0 to cancel): ");
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= items.size()) {
            cart.computeIfAbsent(category, k -> new ArrayList<>()).add(items.get(choice - 1));
            System.out.println("Added to cart.");
        }
        else if (choice != 0) {
            System.out.println("Invalid item choice.");
        }
    }
    static void viewCart() {
        System.out.println("\n=== Your Shopping Cart ===");
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        cart.forEach((category, items) -> {
            System.out.println("[" + category + "]");
            for (String item : items) {
                System.out.println("- " + item);
            }
        });
    }
    static void checkout() {
        Scanner scanner = new Scanner(System.in);
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Add items before checkout.");
            return;
        }
        System.out.print("Enter your Account Number to proceed: ");
        String accNo = scanner.nextLine();
        boolean userFound = false;
        try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(accNo + ",")) {
                    userFound = true;
                    break;
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error reading user file.");
        }
        if (!userFound) {
            System.out.println("Account not found. Please register first.");
            return;
        }
        System.out.println("Processing payment...");
        try (FileWriter fw = new FileWriter(orderFile, true)) {
            fw.write("Order for Account: " + accNo + "\n");
            cart.forEach((cat, items) -> {
                try {
                    fw.write(cat + ": " + String.join(", ", items) + "\n");
                } catch (IOException e) {
                    System.out.println("Error writing order.");
                }
            });
            fw.write("----\n");
            cart.clear();
            System.out.println("Order placed successfully!");
        }
        catch (IOException e) {
            System.out.println("Error saving order.");
        }
    }
    static void viewOrders() {
        System.out.println("\n=== Order History ===");
        try (BufferedReader br = new BufferedReader(new FileReader(orderFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("No orders found.");
        }
    }
}
