/*
 *   NEUTILIZAT
 */
package upb.awj.siteBileteAvion.models;

import upb.awj.siteBileteAvion.dto.FlightsAvailable;

//@Entity
//@Table(name = "Tickets")
public class Tickets {


//    @Id
//    @GeneratedValue
//    private int TicketID;
//
//    @ManyToOne(targetEntity = FlightsAvailable.class)
//    @PrimaryKeyJoinColumn(name = "flightID")
    private FlightsAvailable flight;

//    @Column(name = "SeatNumber")
    private String seatNumber;

//    @Column(name = "BookingDate")
    private String bookingDate;

//    @Column(name = "Price")
    private float price;

//    public int getTicketID() {
//        return TicketID;
//    }

    public FlightsAvailable getFlight() {
        return flight;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public float getPrice() {
        return price;
    }

    public Tickets(FlightsAvailable flight, String seatNumber, String bookingDate, float price) {
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.bookingDate = bookingDate;
        this.price = price;
    }
}
