public class Reservation {
    public int peoplePerGroup;
    public int reservationTime;
    public int reservationMadeTime;
    public String name;

    //constructor


    public Reservation(String pName, int pPeoplePerGroup, int pReservationTime, int pReservationMadeTime) {
        name = pName;
        peoplePerGroup = pPeoplePerGroup;
        reservationTime = pReservationTime;
        reservationMadeTime = pReservationMadeTime;
    }

    public String toString() {
        return ("Reservation details: Reservation Name: " + name + ". People per group: " + peoplePerGroup + ". Reservation time: " + reservationTime + ". Reservation made at: " + reservationMadeTime + ".");
    }
}
