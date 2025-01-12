/*
 *Build #IC-243.21565.193, built on November 13, 2024
 *@author Predescu Theodor
 *clasa utilizata pentru stocarea informatiilor legate de biletele disponibile (fara locurile disponibile - apare variabila, dar nu este utilizata)
 */

package upb.awj.siteBileteAvion.dto;

import java.util.List;

public class FlightsAvailable {
    private int ticketID;
    private String seatNumber;
    private List<String> seatNumbers;
    private double price;
    private int flightID;
    private String flightNumber;
    private String departureTime;
    private String arrivalTime;
    private String origin;
    private String destination;

    public FlightsAvailable() {
    }

    public FlightsAvailable(int ticketID, String seatNumber,  double price, int flightID, String flightNumber, String departureTime, String arrivalTime, String origin, String destination) {
        this.ticketID = ticketID;
        this.seatNumber = seatNumber;
        this.price = price;
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.origin = origin;
        this.destination = destination;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
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
