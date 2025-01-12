/*
 *Build #IC-243.21565.193, built on November 13, 2024
 *@author Predescu Theodor
 *clasa utilizata pentru stocarea informatiilor legate de biletele ce urmeaza sa fie cumparate, dar au fost selectate
 */

package upb.awj.siteBileteAvion.dto;

public class BasketTickets {


    private int basketTicketID;     //    it has autoincrement, we will not use it
    private int basketID;
    private int ticketID;
    private String bookingDate;
    private String seatNumber;
    private int flightID;

//    info to be shown (only extras)
    private String origin, destination, departure, arrival;
    private double price;



    public BasketTickets(int ticketID, String bookingDate, String seatNumber, String origin, String destination, String departure, String arrival, double price, int flightID) {
        this.ticketID = ticketID;
        this.bookingDate = bookingDate;
        this.seatNumber = seatNumber;
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.flightID = flightID;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
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

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBasketID() {
        return basketID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setBasketID(int basketID) {
        this.basketID = basketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
