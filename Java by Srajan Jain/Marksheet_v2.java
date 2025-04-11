import java.util.Scanner;
public class Marksheet_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int phy = 0;
        int chem = 0;
        int bio = 0;
        int maths = 0;
        int sst = 0;
        int eng = 0;
        int accountancy = 0;
        int business_studies = 0;
        int economics = 0;
        int history = 0;
        int total;
        double percent;
        System.out.println("------------Indian Institute Of Technology------------");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your branch: ");
        String branch = scanner.nextLine();
        System.out.print("Enter your Roll no.: ");
        int rollno = scanner.nextInt();
        System.out.println("Select your stream:");
        System.out.println("1. PCM (Physics, Chemistry, Mathematics)");
        System.out.println("2. PCB (Physics, Chemistry, Biology)");
        System.out.println("3. Arts (Social Studies, English, History)");
        System.out.println("4. Commerce (Accountancy, Business Studies, Economics)");
        System.out.print("Enter your choice (1-4): ");
        int stream = scanner.nextInt();
        int subjects = 3;
        switch (stream) {
            case 1:
                System.out.println("Enter you marks in Physics(out of 100): ");
                phy = scanner.nextInt();
                if(phy < 0 || phy > 100){
                    System.out.println("Invalid marks!");
                    return;
                }
                System.out.println("Enter your marks in Chemistry(out of 100): ");
                chem = scanner.nextInt();
                if(chem < 0 || chem > 100){
                    System.out.println("Invalid marks!");
                    return;
                }
                System.out.println("Enter your marks in Mathematics(out of 100): ");
                maths = scanner.nextInt();
                if(maths < 0 || maths > 100){
                    System.out.println("Invalid marks!");
                    return;
                }
                total = phy + chem + maths;
                percent = (float) total / 300 * 100;
                System.out.println("\n------------Marksheet------------");
                System.out.println("| Name: " + name);
                System.out.println("| Branch: " + branch);
                System.out.println("| Roll No.: " + rollno);
                System.out.println("| Total Marks: " + total + " out of " + (subjects * 100));
                System.out.println("| Your Percentage: " + percent + "%");
                System.out.println("--------Thank You--------");
                break;
            case 2:
                System.out.println("Enter you marks in Physics(out of 100): ");
                phy = scanner.nextInt();
                if(phy < 0 || phy > 100){
                    System.out.println("Invalid marks!");
                    return;
                }
                System.out.println("Enter your marks in Chemistry(out of 100): ");
                chem = scanner.nextInt();
                if(chem < 0 || chem > 100){
                    System.out.println("Invalid marks!");
                    return;
                }
                System.out.println("Enter your marks in Biology(out of 100): ");
                bio = scanner.nextInt();
                if(bio < 0 || bio > 100){
                    System.out.println("Invalid marks!");
                    return;
                }
                total = phy + chem + bio;
                percent = (float) total / 300 * 100;
                System.out.println("\n------------Marksheet------------");
                System.out.println("| Name: " + name);
                System.out.println("| Branch: " + branch);
                System.out.println("| Roll No.: " + rollno);
                System.out.println("| Total Marks: " + total + " out of " + (subjects * 100));
                System.out.println("| Your Percentage: " + percent + "%");
                System.out.println("--------Thank You--------");
                break;
            case 3:
                System.out.println("Enter you marks in Social Studies(out of 100): ");
                sst = scanner.nextInt();
                if(sst < 0 || sst > 100){
                    System.out.println("Invalid marks!");
                    return;
                }
                System.out.println("Enter your marks in English(out of 100): ");
                eng = scanner.nextInt();
                if(eng < 0 || eng > 100){
                    System.out.println("Invalid marks!");
                    return;
                }
                System.out.println("Enter your marks in History(out of 100): ");
                history = scanner.nextInt();
                if(history < 0 || history > 100){
                    System.out.println("Invalid marks!");
                    return;
                }
                total = sst + eng + history;
                percent = (float) total / 300 * 100;
                System.out.println("\n------------Marksheet------------");
                System.out.println("| Name: " + name);
                System.out.println("| Branch: " + branch);
                System.out.println("| Roll No.: " + rollno);
                System.out.println("| Total Marks: " + total + " out of " + (subjects * 100));
                System.out.println("| Your Percentage: " + percent + "%");
                System.out.println("--------Thank You--------");
                break;
            case 4:
                System.out.println("Enter you marks in Accountancy(out of 100): ");
                accountancy = scanner.nextInt();
                if(accountancy < 0 || accountancy > 100){
                    System.out.println("Invalid marks!");
                    return;
                }
                System.out.println("Enter your marks in Business Studies(out of 100): ");
                business_studies = scanner.nextInt();
                if(business_studies < 0 || business_studies > 100){
                    System.out.println("Invalid marks!");
                    return;
                }
                System.out.println("Enter your marks in Economics(out of 100): ");
                economics = scanner.nextInt();
                if(economics < 0 || economics > 100){
                    System.out.println("Invalid marks!");
                    return;
                }
                total = accountancy + business_studies + economics;
                percent = (float) total / 300 * 100;
                System.out.println("\n------------Marksheet------------");
                System.out.println("| Name: " + name);
                System.out.println("| Branch: " + branch);
                System.out.println("| Roll No.: " + rollno);
                System.out.println("| Total Marks: " + total + " out of " + (subjects * 100));
                System.out.println("| Your Percentage: " + percent + "%");
                System.out.println("--------Thank You--------");
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }
    }
}