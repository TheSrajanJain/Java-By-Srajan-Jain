import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
public class Stock_Market_v1 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static LocalDate today = LocalDate.now();
    static void BitCoin(int shares, String assets){
        int r = random.nextInt(2);
        System.out.println("Purchased "+shares+" of "+assets);
        System.out.println("Date of Purchased the shares: "+today);
    }
    static void Sensex(int shares, String assets){
        int r = random.nextInt(2);
        System.out.println("Purchased "+shares+" of "+assets);
        System.out.println("Date of Purchased the shares: "+today);
    }
    static void Nifty50(int shares, String assets){
        int r = random.nextInt(2);
        System.out.println("Purchased "+shares+" of "+assets);
        System.out.println("Date of Purchased the shares: "+today);
    }
    static void S_P500(int shares, String assets){
        int r = random.nextInt(2);
        System.out.println("Purchased "+shares+" of "+assets);
        System.out.println("Date of Purchased the shares: "+today);
    }
    static void DJIA(int shares, String assets){
        int r = random.nextInt(2);
        System.out.println("Purchased "+shares+" of "+assets);
        System.out.println("Date of Purchased the shares: "+today);
    }
    static void Options(int option){
        System.out.println("Welcome To Stock Market: ");
        System.out.println("1. Register");
    }
    static void Assets_Option(int choice){
        System.out.println("==================== Stock Market ====================");
        System.out.println("1. BitCoin");
        System.out.println("2. Sensex");
        System.out.println("3. Nifty 50");
        System.out.println("4. S&P 500");
        System.out.println("5. Dow Jones Industrial Average (DJIA)");
        System.out.println("Enter your Choice(1, 2, 3, 4, 5): ");
        choice = scanner.nextInt();
    }
    public static void main(String[] args) {
        int choice = 0;
        String assets = "";
        int shares = 0;
        int share_price = 0;
        System.out.print("Enter the amount of shares you want to purchase ");
        switch(choice){
            case 1:
                assets = "BitCoin";
                share_price = 5000;
                System.out.println("(5000rs. Per Share): ");
                shares = scanner.nextInt();
                BitCoin(shares, assets);
                break;
            case 2:
                assets = "Sensex";
                share_price = 1000;
                System.out.println("(1000rs. Per Share): ");
                shares = scanner.nextInt();
                Sensex(shares, assets);
                break;
            case 3:
                assets = "Nifty 50";
                share_price = 2000;
                System.out.println("(2000rs. Per Share): ");
                shares = scanner.nextInt();
                Nifty50(shares, assets);
                break;
            case 4:
                assets = "S&P 500";
                share_price = 4500;
                System.out.println("(4500rs. Per Share): ");
                shares = scanner.nextInt();
                S_P500(shares, assets);
                break;
            case 5:
                assets = "DJIA";
                share_price = 1250;
                System.out.println("(1250rs. Per Share): ");
                shares = scanner.nextInt();
                DJIA(shares, assets);
                break;
            default:
                System.out.println("Sorry! Invalid Option, Try again!");
                break;
        }
    }
}
