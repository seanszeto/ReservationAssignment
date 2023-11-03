public class Reservation {
    public int peoplePerGroup;
    public int reservationTime;
    public int reservationMadeTime;

    //constructor


    public Reservation(int pPeoplePerGroup, int pReservationTime, int pReservationMadeTime) {
        peoplePerGroup = pPeoplePerGroup;
        reservationTime = pReservationTime;
        reservationMadeTime = pReservationMadeTime;
    }

    public String toString() {
        return ("Reservation details: People per group: " + peoplePerGroup + ". Reservation time: " + reservationTime + ". Reservation made at: " + reservationMadeTime + ".");
    }

    //print Method
}
