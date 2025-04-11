import java.util.Scanner;
import java.util.Random;
public class Railway_Ticket_System {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] bookedSeats = {"A1", "A2", "B3", "C4", "D5"};
        String[] waitingList = new String[5];
        String[] reservations = {"John", "Alice", "Bob", "Eve"};
        String trains[] = {"Rajdhani Express", "Sajani Express", "Prashant Bhai Ki Express(PBKE)", "Sorry Sir! Express"};
        int seats = 12;
        String name = "";
        String father = "";
        int account = 0;
        int pin = 0;
        int choice = 0;
        int tickets = 0;
        int ticketID = 0;
        int count = 0;
        int r = 0;
        while(true){
            System.out.println("-------------Registration Form-------------");
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
            System.out.print("Enter your Father name: ");
            father = scanner.nextLine();
            System.out.print("Enter your Account no.: ");
            account = scanner.nextInt();
            System.out.print("Enter your Account PIN: ");
            pin = scanner.nextInt();
            System.out.println("Do you want to register your info? (0/1): ");
            choice = scanner.nextInt();
            if(choice == 0){
                System.out.println("Means, you want to make changes...\nRefill the form!\n");
                continue;
            }
            else if(choice == 1){
                System.out.println("Registring Information!");
                for(int i = 300000000; i >= 0; i--){
                    if(i == 300000000){
                        System.out.print("3...");
                    }
                    else if(i == 200000000){
                        System.out.print("2...");
                    }
                    else if(i == 100000000){
                        System.out.print("1...");
                    }
                    else if(i == 0){
                        System.out.println("0...");
                    }
                }
                r = random.nextInt(1000000);
                System.out.println("Your Railway Account: "+r);
            break;
            }
        }
        System.out.println("-----------------------\n1. Books Tickets\n2. View Your Booked Seats\n3. Manage waiting lists\n4. Cancel reservations\n5. Exit");
        while(true) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case (1):
                    System.out.println("Available trains ---> Route(Place to Place)\n1. "+trains[0]+" ---> Delhi to Mumbai\n2. "+trains[1]+" ---> Aligarh to London\n3. "+trains[2]+" ---> Delhi to New York\n4. "+trains[3]+" ---> Aligarh to All of the world!");
                    System.out.println("Enter your choice: ");
                    choice = scanner.nextInt();
                    if(choice == 1){
                        System.out.print("Enter number of tickets to book: ");
                        tickets = scanner.nextInt();
                        ticketID = 1000 + random.nextInt(9000);
                        System.out.println("\nBooking Confirmed!");
                        System.out.println("Passenger Name: " + name);
                        System.out.println("Number of Tickets: " + tickets);
                        System.out.println("Ticket ID: " + ticketID);
                        System.out.println("\nThank you for using the Railway Ticket Booking System!");
                    }
                    else if (choice == 2) {
                        System.out.print("Enter number of tickets to book: ");
                        tickets = scanner.nextInt();
                        ticketID = 1000 + random.nextInt(9000);
                        System.out.println("\nBooking Confirmed!");
                        System.out.println("Passenger Name: " + name);
                        System.out.println("Number of Tickets: " + tickets);
                        System.out.println("Ticket ID: " + ticketID);
                        System.out.println("\nThank you for using the Railway Ticket Booking System!");
                    }
                    else if (choice == 3) {
                        System.out.print("Enter number of tickets to book: ");
                        tickets = scanner.nextInt();
                        ticketID = 1000 + random.nextInt(9000);
                        System.out.println("\nBooking Confirmed!");
                        System.out.println("Passenger Name: " + name);
                        System.out.println("Number of Tickets: " + tickets);
                        System.out.println("Ticket ID: " + ticketID);
                        System.out.println("\nThank you for using the Railway Ticket Booking System!");
                    }
                    else if (choice == 4) {
                        System.out.print("Enter number of tickets to book: ");
                        tickets = scanner.nextInt();
                        ticketID = 1000 + random.nextInt(9000);
                        System.out.println("\nBooking Confirmed!");
                        System.out.println("Passenger Name: " + name);
                        System.out.println("Number of Tickets: " + tickets);
                        System.out.println("Ticket ID: " + ticketID);
                        System.out.println("\nThank you for using the Railway Ticket Booking System!");
                    }
                    else{
                        System.out.println("Sorry! The train no. you enter is not available!");
                        return;
                    }
                    break;
                case (2):
                    System.out.println("Here are your booked seats:");
                    for (int i = 0; i < bookedSeats.length; i++) {
                        System.out.println("Seat " + (i + 1) + ": " + bookedSeats[i]);
                    }
                    break;
                case (3):
                    while (true) {
                        System.out.println("\n--- Railway Waiting List ---");
                        System.out.println("1. Add Passenger");
                        System.out.println("2. View Waiting List");
                        System.out.println("3. Exit");
                        System.out.print("Enter your choice: ");
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        if (choice == 1) {
                            if (count < waitingList.length) {
                                System.out.print("Enter passenger name: ");
                                name = scanner.nextLine();
                                waitingList[count] = name;
                                count++;
                                System.out.println("Passenger added!");
                            }
                            else {
                                System.out.println("Waiting list is full!");
                            }
                        }
                        else if (choice == 2) {
                            System.out.println("\nCurrent Waiting List:");
                            if (count == 0) {
                                System.out.println("No passengers in the waiting list.");
                            }
                            else {
                                for (int i = 0; i < count; i++) {
                                    System.out.println((i + 1) + ". " + waitingList[i]);
                                }
                            }
                        }
                        else if (choice == 3) {
                            System.out.println("Exiting the system. Thank you!");
                            break;
                        }
                        else {
                            System.out.println("Invalid choice! Please try again.");
                        }
                    }
                    break;
                case (4):
                    count = reservations.length;
                    while (true) {
                        System.out.println("\n--- Railway Reservation Cancellation ---");
                        System.out.println("1. View Reservations");
                        System.out.println("2. Cancel Reservation");
                        System.out.println("3. Exit");
                        System.out.print("Enter your choice: ");
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        if (choice == 1) {
                            System.out.println("\nCurrent Reservations:");
                            for (int i = 0; i < count; i++) {
                                if (reservations[i] != null) {
                                    System.out.println((i + 1) + ". " + reservations[i]);
                                }
                            }
                        }
                        else if (choice == 2) {
                            System.out.print("Enter the reservation number to cancel: ");
                            int cancelIndex = scanner.nextInt();
                            if (cancelIndex > 0 && cancelIndex <= count && reservations[cancelIndex - 1] != null) {
                                reservations[cancelIndex - 1] = null;
                                System.out.println("Reservation canceled!");
                            }
                            else {
                                System.out.println("Invalid reservation number!");
                            }
                        }
                        else if (choice == 3) {
                            System.out.println("Exiting the system. Thank you!");
                            break;
                        }
                        else {
                            System.out.println("Invalid choice! Please try again.");
                        }
                    }
                    break;
                case (5):
                    System.out.println("Have a nice day!\nExiting...");
                    return;
            }
        }
    }
}