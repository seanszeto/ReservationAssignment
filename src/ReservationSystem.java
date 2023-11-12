import java.rmi.server.RemoteServer;
import java.util.Arrays;
import java.util.Scanner;


public class ReservationSystem {

    static Reservation[] reservations = new Reservation[10];

// create new array for the Wait list
    ReservationSystem[] waitlist = new ReservationSystem[100];
    static int count = 0;

    //add reservation
    public static void addReservation(String name, int num, int time, int timeMade) {
        if (count < 10) {
            reservations[count] = new Reservation(name, num, time, timeMade);
            count++;
            System.out.println(count);
        } else {
            System.out.println("The restaurant is full.");
        }
        displayReservation();
    }

    public static void deleteReservation(String reservationName) {

        for(int i = 0; i < reservations.length; i++){

            if(reservations[i] != null && reservations[i].name.equals(reservationName) ){
                for (int j = i; j < count - 1; i++) {
                    reservations[j] = reservations[j + 1];
                }
                reservations[count - 1] = null;
                count--;
                System.out.println("Reservation " + reservationName + " deleted.");
            }
        }
        displayReservation();
    }

    public static void changeReservation(String reservationName, int newGroupSize, int newReservationTime, int newTimeMade) {
//        if (reservationNum >=  0 && reservationNum < count) {

        for (int i = 0; i < reservations.length; i++) {

            if (reservations[i] != null && reservations[i].name.equals(reservationName)) {
                reservations[i] = new Reservation(reservationName, newGroupSize, newReservationTime, newTimeMade);
                System.out.println("Reservation by " + reservationName + " updated. Reservation changed to group of " + newGroupSize + " at " + newReservationTime + ".");
            } else {
                System.out.println("Reservation not found.");
            }
        }
    }

    public static void displayReservation() {
        bubbleSortReservations();

        for(int i=0; i < reservations.length; i++){
            System.out.println(reservations[i]);
        }
    }

    //sort reservation (public void ...)
    public static void bubbleSortReservations() {

        int n = reservations.length;
        boolean swapped;
        for (int j = 0; j < n - 1; j++) {
            swapped = false;
            for (j = 0; j < n - 1; j++) {
                if ( reservations[j] != null && reservations[j+1] != null
                  && reservations[j].reservationTime > reservations[j + 1].reservationTime) {

                    // Swap arr[j] and arr[j+1]
                    Reservation temp = reservations[j];
                    reservations[j] = reservations[j + 1];
                    reservations[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false) {
                break;
            }
        }
    }



    // Function to print an array
    static void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Input a number:");
            System.out.println("1. Add Reservation");
            System.out.println("2. Delete Reservation");
            System.out.println("3. Display Reservations");
            System.out.println("4. Change Reservation");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter name:");
                    String name = scanner.next();
                    System.out.println("Enter group size:");
                    int groupSize = scanner.nextInt();
                    System.out.println("Enter reservation time:");
                    int reservationTime = scanner.nextInt();
                    System.out.println("Enter time made:");
                    int timeMade = scanner.nextInt();
                    ReservationSystem.addReservation(name, groupSize, reservationTime, timeMade);
                    break;
                case 2:
                    System.out.println("Enter the name the reservation was made under:");
                    String reservationToDelete = scanner.next();
                    ReservationSystem.deleteReservation(reservationToDelete);
                    break;
                case 3:
                    ReservationSystem.displayReservation();
                    break;
                case 4:
                    System.out.println("Enter reservation name:");
                    String rName = scanner.next();
//                    System.out.println("Enter reservation number to be changed.");
//                    int reservationToBeChanged = scanner.nextInt();
                    System.out.println("Enter new group size:");
                    int newGroup = scanner.nextInt();
                    System.out.println("Enter new reservation time:");
                    int newTime = scanner.nextInt();
                    System.out.println("Enter new time when reservation was made:");
                    int newMade = scanner.nextInt();
                    ReservationSystem.changeReservation(rName, newGroup, newTime, newMade);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}



