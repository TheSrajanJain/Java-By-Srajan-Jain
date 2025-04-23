import java.util.*;
import java.io.*;
import java.time.LocalDate;
public class Stock_Market_v1 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static LocalDate today = LocalDate.now();
    static String name = "", city = "", email = "", assets = "";
    static int age = 0, Id = 0, choice = 0, shares = 0, share_price = 0, option = 0;
    static long phone = 0;
    static double balance = 0.0;
    static void BitCoin(int shares, String assets) {
        System.out.println("Purchased " + shares + " of " + assets);
        System.out.println("Date of Purchase: " + today);
    }
    static void Sensex(int shares, String assets) {
        System.out.println("Purchased " + shares + " of " + assets);
        System.out.println("Date of Purchase: " + today);
    }
    static void Nifty50(int shares, String assets) {
        System.out.println("Purchased " + shares + " of " + assets);
        System.out.println("Date of Purchase: " + today);
    }
    static void S_P500(int shares, String assets) {
        System.out.println("Purchased " + shares + " of " + assets);
        System.out.println("Date of Purchase: " + today);
    }
    static void DJIA(int shares, String assets) {
        System.out.println("Purchased " + shares + " of " + assets);
        System.out.println("Date of Purchase: " + today);
    }
    static void Options() {
        System.out.println("\n--- Welcome To Stock Market ---");
        System.out.println("1. Register");
        System.out.println("2. Invest");
        System.out.println("3. Check My Shares");
        System.out.println("4. Withdraw Money from Assets");
        System.out.println("5. Deposit Money into Assets");
        System.out.println("Enter your desirable Option (1, 2, 3, 4, 5, '0' to Exit): ");
        option = scanner.nextInt();
        switch (option) {
            case 1: Registration(); break;
            case 2: Assets_Option(); break;
            case 3: CheckShares(); break;
            case 4: WithdrawMoney(); break;
            case 5: DepositMoney(); break;
            case 0:
                System.out.println("Thank you for visiting!");
                System.exit(0);
            default:
                System.out.println("Invalid option, please try again.");
                Options();
        }
    }
    static void Registration() {
        Id = random.nextInt(1000000);
        scanner.nextLine();
        System.out.println("=============== Registration ===============");
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        System.out.print("Enter your age: ");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your city: ");
        city = scanner.nextLine();
        System.out.print("Enter your email: ");
        email = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        phone = scanner.nextLong();
        System.out.print("Enter the amount to deposit into your account: ");
        balance = scanner.nextDouble();
        System.out.println("Registration Successful! Your ID is: " + Id);
        try (FileWriter writer = new FileWriter("Registration.txt", true)) {
            writer.write("ID: " + Id + ", Name: " + name + ", Age: " + age + ", City: " + city + ", Email: " + email
                    + ", Phone: " + phone + ", Balance: " + balance + ", Shares: 0, Assets: None, Date: " + today + "\n");
        }
        catch (IOException e) {
            System.out.println("Error saving registration.");
        }

        Options();
    }
    static void Assets_Option() {
        System.out.println("==================== Stock Market ====================");
        System.out.print("Enter your Registration ID: ");
        int inputId = scanner.nextInt();
        if (!loadUser(inputId)) {
            System.out.println("ID not found. Please register first.");
            Options();
            return;
        }
        System.out.println("1. BitCoin (Rs. 5000 per share)");
        System.out.println("2. Sensex (Rs. 1000 per share)");
        System.out.println("3. Nifty 50 (Rs. 2000 per share)");
        System.out.println("4. S&P 500 (Rs. 4500 per share)");
        System.out.println("5. DJIA (Rs. 1250 per share)");
        System.out.print("Enter your Choice (1-5): ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1: assets = "BitCoin"; share_price = 5000; break;
            case 2: assets = "Sensex"; share_price = 1000; break;
            case 3: assets = "Nifty 50"; share_price = 2000; break;
            case 4: assets = "S&P 500"; share_price = 4500; break;
            case 5: assets = "DJIA"; share_price = 1250; break;
            default:
                System.out.println("Invalid option. Try again.");
                Assets_Option();
                return;
        }
        System.out.print("Enter number of shares: ");
        shares = scanner.nextInt();
        double totalCost = shares * share_price;
        if (balance >= totalCost) {
            balance -= totalCost;
            System.out.println("Purchase successful! Rs. " + totalCost + " deducted. Remaining balance: Rs. " + balance);
            updateUser(inputId, balance, shares, assets);
            try (FileWriter investmentWriter = new FileWriter("Investments.txt", true)) {
                investmentWriter.write("ID: " + inputId + ", Date: " + today + ", Asset: " + assets + ", Shares: " + shares + ", Price: " + share_price + "\n");
            }
            catch (IOException e) {
                System.out.println("Failed to save investment data.");
            }

        }
        else {
            System.out.println("Insufficient balance!");
        }
        Options();
    }
    static boolean loadUser(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Registration.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID: " + id + ",")) {
                    String[] parts = line.split(",");
                    for (String part : parts) {
                        if (part.contains("Balance: ")) {
                            balance = Double.parseDouble(part.split(":")[1].trim());
                        }
                    }
                    return true;
                }
            }
        }
        catch (IOException e) {
            System.out.println("Could not read file.");
        }
        return false;
    }
    static void updateUser(int id, double updatedBalance, int newShares, String newAsset) {
        File inputFile = new File("Registration.txt");
        File tempFile = new File("temp.txt");
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                FileWriter writer = new FileWriter(tempFile)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID: " + id + ",")) {
                    String updatedLine = line.replaceAll("Balance: \\d+(\\.\\d+)?", "Balance: " + updatedBalance);
                    updatedLine = updatedLine.replaceAll("Shares: \\d+", "Shares: " + newShares);
                    updatedLine = updatedLine.replaceAll("Assets: \\w+", "Assets: " + newAsset);
                    writer.write(updatedLine + "\n");
                }
                else {
                    writer.write(line + "\n");
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error updating file.");
        }
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }
    static void CheckShares() {
        System.out.print("Enter your Registration ID: ");
        int id = scanner.nextInt();
        File file = new File("Investments.txt");
        if (!file.exists()) {
            System.out.println("No investment records found.");
            Options();
            return;
        }
        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n--- Your Investment Summary ---");
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID: " + id + ",")) {
                    found = true;
                    String[] parts = line.split(",");
                    String asset = parts[2].split(":")[1].trim();
                    int sharesOwned = Integer.parseInt(parts[3].split(":")[1].trim());
                    int originalPrice = Integer.parseInt(parts[4].split(":")[1].trim());
                    double percentageChange = (random.nextDouble() * 20) - 10; // -10% to +10%
                    int newPrice = (int) (originalPrice * (1 + percentageChange / 100));
                    int profitOrLoss = (newPrice - originalPrice) * sharesOwned;
                    System.out.println("Asset: " + asset);
                    System.out.println("Shares Owned: " + sharesOwned);
                    System.out.println("Original Price: Rs. " + originalPrice);
                    System.out.println("Current Price: Rs. " + newPrice);
                    System.out.println("Profit/Loss: Rs. " + profitOrLoss);
                    System.out.println("--------------------------------------------------");
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error reading investment file.");
        }
        if (!found) {
            System.out.println("No investments found for the given ID.");
        }
        Options();
    }
    static void WithdrawMoney() {
        System.out.print("Enter your Registration ID: ");
        int id = scanner.nextInt();
        if (loadUser(id)) {
            System.out.println("Your Current Balance is: Rs. " + balance);
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            if (amount <= balance) {
                balance -= amount;
                updateUser(id, balance, shares, assets);
                System.out.println("Withdrawal successful. Remaining Balance: Rs. " + balance);
            }
            else {
                System.out.println("Insufficient funds!");
            }
        }
        else {
            System.out.println("ID not found.");
        }
        Options();
    }
    static void DepositMoney() {
        System.out.print("Enter your Registration ID: ");
        int id = scanner.nextInt();
        if (loadUser(id)) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            balance += amount;
            updateUser(id, balance, shares, assets);
            System.out.println("Deposit successful. New Balance: Rs. " + balance);
        }
        else {
            System.out.println("ID not found.");
        }
        Options();
    }
    public static void main(String[] args) {
        Options();
    }
}
