import java.util.Scanner;

    public class UserInput {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Input a number:");
                System.out.println("1. Add Reservation");
                System.out.println("2. Delete Reservation");
                System.out.println("3. Display Reservations");
                System.out.println("4. Exit");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter group size:");
                        int groupSize = scanner.nextInt();
                        System.out.println("Enter reservation time:");
                        int reservationTime = scanner.nextInt();
                        System.out.println("Enter time made:");
                        int timeMade = scanner.nextInt();
                        ReservationSystem.addReservation(groupSize, reservationTime, timeMade);
                        break;
                    case 2:
                        System.out.println("Enter reservation number to be cancelled:");
                        int reservationToDelete = scanner.nextInt();
                        ReservationSystem.deleteReservation(reservationToDelete);
                        break;
                    case 3:
                        ReservationSystem.displayReservation();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        }
    }


