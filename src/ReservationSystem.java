import java.util.Arrays;
import java.util.Scanner;


public class ReservationSystem {

    static Reservation [] reservations = new Reservation[10];
    static int count = 0;

    //add reservation
    public static void addReservation(int num, int time, int timeMade) {
        if (count < 10) {
            reservations[count] = new Reservation(num, time, timeMade);
            count++;
            System.out.println(count);
        } else {
            System.out.println("The restaurant is full.");
        }
    }

//    public static void deleteReservation (int reservationNum) {
//
//        reservationNum = 1;
//        if (reservationNum < 0 || reservationNum > reservations.length) {
//            System.out.println("Invalid reservation number. Not found");
//        }
//        else {
//            for (int i = reservationNum; i < reservations.length - 1; i++) {
//                reservations[i] = reservations[i + 1];
//            }
//            reservations[reservations.length - 1] = new Reservation(0, 0, 0);
//            System.out.println("Reservation " + reservationNum + " deleted.");
//        }
//        displayReservation();
//    }

        public static void deleteReservation(int reservationNum) {
            if (reservationNum >= 0 && reservationNum < count) {
                for (int i = reservationNum; i < count - 1; i++) {
                    reservations[i] = reservations[i + 1];
                }
                reservations[count - 1] = null;
                count--;
                System.out.println("Reservation " + reservationNum + " deleted.");
            } else {
                System.out.println("Invalid reservation number. Not found");
            }
            displayReservation();
        }

    public static void displayReservation() {
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
        addReservation(10, 8, 16);
        addReservation(5, 7, 20);
        displayReservation();
        bubbleSortReservations();
        deleteReservation(1);
    }


}
