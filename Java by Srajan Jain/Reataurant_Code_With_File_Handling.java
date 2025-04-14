{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name, city;
        int age, total = 0, amount = 0;
        System.out.println("=============== Sky Deck ===============");
        System.out.println("------------- Registration -------------");
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        System.out.print("Enter your age: ");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your city: ");
        city = scanner.nextLine();
        System.out.println("=============== Sky Deck ===============");
        Menu();
        System.out.print("Do you want to order something? (0=No / 1=Yes): ");
        int choice = scanner.nextInt();
        if (choice == 0) {
            System.out.println("Have a nice day!\nExiting...");
            return;
        }
        System.out.print("Enter an option number (1-6): ");
        int option = scanner.nextInt();
        String size = "";
        int price = 0;
        switch (option) {
            case 1:
                System.out.print("Small or Large Burger? (S/L): ");
                size = scanner.next();
                price = size.equalsIgnoreCase("S") ? 50 : 100;
                break;
            case 2:
                System.out.print("Small or Large Pizza? (S/L): ");
                size = scanner.next();
                price = size.equalsIgnoreCase("S") ? 99 : 199;
                break;
            case 3:
                System.out.print("With Extra Chole? (Y/N): ");
                size = scanner.next();
                price = size.equalsIgnoreCase("Y") ? 75 : 50;
                break;
            case 4:
                System.out.print("Half or Full Plate Noodles? (H/F): ");
                size = scanner.next();
                price = size.equalsIgnoreCase("H") ? 50 : 100;
                break;
            case 5:
                System.out.print("With Butter Paranthe? (Y/N): ");
                size = scanner.next();
                price = size.equalsIgnoreCase("Y") ? 60 : 50;
                break;
            case 6:
                String[] flavours = {"Chocolate", "Vanilla", "Pineapple", "Red Velvet"};
                int[] prices = {50, 40, 45, 60};
                System.out.println("Available Dessert Flavours:");
                for (int i = 0; i < flavours.length; i++) {
                    System.out.println(i + ". " + flavours[i] + " --> ₹" + prices[i] + "/-");
                }
                System.out.print("Enter your choice: ");
                int flavour = scanner.nextInt();
                price = prices[flavour];
                break;
            default:
                System.out.println("Invalid option! Exiting...");
                return;
        }
        System.out.print("Enter Quantity: ");
        amount = scanner.nextInt();
        total = price * amount;
        System.out.println("Your Total Bill is: ₹" + total);
        try {
            FileWriter writer = new FileWriter("Bill.txt", true);
            writer.write("Customer: " + name + ", Age: " + age + ", City: " + city + "\n");
            writer.write("Ordered Item Option: " + option + ", Size/Choice: " + size + ", Quantity: " + amount + "\n");
            writer.write("Total Amount: ₹" + total + "\n");
            writer.write("----------------------------------------\n");
            writer.close();
            System.out.println("Order saved successfully to file!");
        } catch (IOException e) {
            System.out.println("Error saving order to file.");
            e.printStackTrace();
        }
    }
    static void Menu() {
        System.out.println("--------- Menu ---------");
        System.out.println("1. Burger --> ₹50/₹100");
        System.out.println("2. Pizza --> ₹99/₹199");
        System.out.println("3. Amritsari Kulcha --> ₹50/₹75");
        System.out.println("4. Noodles --> ₹50/₹100");
        System.out.println("5. Aloo De Paranthe --> ₹50/₹60");
        System.out.println("6. Desserts --> Flavours Vary");
        System.out.println("-------------------------");
    }
}
