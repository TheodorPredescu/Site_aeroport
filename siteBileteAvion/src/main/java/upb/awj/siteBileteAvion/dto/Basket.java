/*
 *Build #IC-243.21565.193, built on November 13, 2024
 *@author Predescu Theodor
 *clasa utilizata pentru stocarea informatiilor legate de biletele deja cumparate - utilizata doar pentru afisare
 */

package upb.awj.siteBileteAvion.dto;

public class Basket {

    private int passengerID;
    private int basketID;
    private int ticketID;
    private String seatNumber;
    private String bookingDate;
    private double price;
    private String departureTime;
    private String arrivalTime;
    private String origin;
    private String destination;


    public Basket(int passengerID, int basketID, int ticketID, String seatNumber, String bookingDate, double price, String departureTime, String arrivalTime, String origin, String destination) {
        this.passengerID = passengerID;
        this.basketID = basketID;
        this.ticketID = ticketID;
        this.seatNumber = seatNumber;
        this.bookingDate = bookingDate;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.origin = origin;
        this.destination = destination;
    }

    public Basket() {
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public int getBasketID() {
        return basketID;
    }

    public void setBasketID(int basketID) {
        this.basketID = basketID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
