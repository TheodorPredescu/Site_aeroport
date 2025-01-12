/*
 *Build #IC-243.21565.193, built on November 13, 2024
 *@author Predescu Theodor
 *clasa utilizata pentru stocarea informatiilor legate de locurile disponibile in fiecare avion
 */
package upb.awj.siteBileteAvion.models;

public class AvailableSeats {

    private int seatID;
    private int flightID;
    private String seatNumber;
    private boolean isAvailable;

    public AvailableSeats(int seatID, int flightID, String seatNumber, boolean isAvailable) {
        this.seatID = seatID;
        this.flightID = flightID;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
    }

    public AvailableSeats() {
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }
}
