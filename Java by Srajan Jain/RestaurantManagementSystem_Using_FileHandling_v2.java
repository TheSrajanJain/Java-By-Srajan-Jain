import java.io.*;
import java.time.LocalDate;
import java.util.*;
public class RestaurantManagementSystem_Using_FileHandling_v2 {
    static final String FILE_NAME = "orders.txt";
    static class Order {
        String orderId;
        String customerId;
        String name;
        String date;
        String items;
        double total;
        public Order(String orderId, String customerId, String name, String date, String items, double total) {
            this.orderId = orderId;
            this.customerId = customerId;
            this.name = name;
            this.date = date;
            this.items = items;
            this.total = total;
        }
        public String toString() {
            return "OrderID: " + orderId + "\n"
                    + "CustomerID: " + customerId + "\n"
                    + "Name: " + name + "\n"
                    + "Date: " + date + "\n"
                    + "Items: " + items + "\n"
                    + "Total: " + total + "\n"
                    + "-----";
        }
    }
    public static void addOrder(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(order.toString());
            writer.newLine();
            System.out.println("Order added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
    public static void searchByDate(String searchDate) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            List<String> orderBlock = new ArrayList<>();
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.equals("-----")) {
                    for (String l : orderBlock) {
                        if (l.startsWith("Date:") && l.contains(searchDate)) {
                            System.out.println(String.join("\n", orderBlock));
                            System.out.println("-----");
                            found = true;
                        }
                    }
                    orderBlock.clear();
                } else {
                    orderBlock.add(line);
                }
            }
            if (!found) {
                System.out.println("No orders found on that date.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }
    public static void searchByCustomerId(String customerId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            List<String> orderBlock = new ArrayList<>();
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.equals("-----")) {
                    for (String l : orderBlock) {
                        if (l.startsWith("CustomerID:") && l.contains(customerId)) {
                            System.out.println(String.join("\n", orderBlock));
                            System.out.println("-----");
                            found = true;
                        }
                    }
                    orderBlock.clear();
                } else {
                    orderBlock.add(line);
                }
            }
            if (!found) {
                System.out.println("No orders found for that customer ID.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nRestaurant Management System");
            System.out.println("1. Add Order");
            System.out.println("2. Search Orders by Date");
            System.out.println("3. Search Orders by Customer ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Order ID: ");
                    String orderId = sc.nextLine();
                    System.out.print("Customer ID: ");
                    String customerId = sc.nextLine();
                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();
                    String date = LocalDate.now().toString();
                    System.out.print("Items (comma separated): ");
                    String items = sc.nextLine();
                    System.out.print("Total amount: ");
                    double total = sc.nextDouble();
                    sc.nextLine();
                    Order order = new Order(orderId, customerId, name, date, items, total);
                    addOrder(order);
                    break;
                case 2:
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String searchDate = sc.nextLine();
                    searchByDate(searchDate);
                    break;
                case 3:
                    System.out.print("Enter Customer ID: ");
                    String searchId = sc.nextLine();
                    searchByCustomerId(searchId);
                    break;
                case 0:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        sc.close();
    }
}
