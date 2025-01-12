
/*
 *Build #IC-243.21565.193, built on November 13, 2024
 *@author Predescu Theodor
 * clasa utilizata pentru a vizualiza istoricul biletelor cumparate, a vizualiza biletele posibile de cumparare,
 *      de a adauga in cosul curent si de a cumpara bilete
 */

package upb.awj.siteBileteAvion.controller;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import upb.awj.siteBileteAvion.models.AvailableSeats;
import upb.awj.siteBileteAvion.dto.Basket;
import upb.awj.siteBileteAvion.dto.FlightsAvailable;
import upb.awj.siteBileteAvion.dto.BasketTickets;
import upb.awj.siteBileteAvion.models.Passengers;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@SessionAttributes({"Client"})
public class BascketController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Passengers old_client;
    private List<BasketTickets> currentBasketList = new ArrayList<BasketTickets>();

    @GetMapping("/login/user")
        public String loggedIn(
//                @RequestParam("validation") boolean checked,
                @ModelAttribute("Client") Passengers client,
                Model model
                ) {
        check_client(client);
        try{
            Map<Integer, List<AvailableSeats>> seatsByFlight = getAvailableSeats();
            List<FlightsAvailable> flightsAvailable = getFlightsAvailable();
            List<Basket> baskets = getUserBaskets(client.getPassengerID());

            boolean has;
            model.addAttribute("seatsByFlight", seatsByFlight);
            model.addAttribute("currentBasketIsNotEmpty", !currentBasketList.isEmpty());
            model.addAttribute("currentBasketList", currentBasketList);
            model.addAttribute("flightsAvailable", flightsAvailable);
            if (!baskets.isEmpty()) {
                has = true;
                model.addAttribute("has", has);
                model.addAttribute("baskets", baskets); // Add the entire list to the model

                for (Basket basket : baskets) {
                    System.out.println(
                            has + " - " + basket.getSeatNumber() + " " +
                                    basket.getOrigin() + " -> " + basket.getDestination()
                    );
                }
            } else {
                has = false;
                model.addAttribute("has", has);
                System.out.println(has);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("username", client.getFirstName());
        return "menu";
    }


//    -------------------------------------------------------------------------------------------------------------------------------
    @PostMapping("/login/user")
    public String linkSeatToUser(@ModelAttribute("Client") Passengers client,
                                 Model model,
                                 @RequestParam(value = "seatID", required = false) Integer seatID,
                                 @RequestParam(value = "delete_ticketID", required = false) Integer delete_ticketID,
                                 @RequestParam(value = "delete_seatNumber", required = false) String delete_seatNumber,
                                 @RequestParam(value = "submit_basket", required = false) Boolean submit_basket
                                 ) {

        if (seatID != null)
            addSeatToUserInBasket(seatID);
        if (delete_ticketID != null && delete_seatNumber != null)
            deleteTicket(delete_ticketID, delete_seatNumber);
        if (submit_basket != null && submit_basket)
            finalizeBasket(client);


        for (var b: currentBasketList) {
            System.out.println("ticketID: " + b.getTicketID() + "\tbook time: " + b.getBookingDate() + "\tseat: " + b.getSeatNumber());
        }

        return "redirect:/login/user";
    }

//    -------------------------------------------------------------------------------------------------------------------------------

    public void deleteTicket(Integer ticketID, String seat) {
        currentBasketList.removeIf(ticket -> ticket.getTicketID() == ticketID && ticket.getSeatNumber().equals(seat));
    }
    // Add the seat by ID to the current User
    public void addSeatToUserInBasket(Integer seatID) {
//        System.out.println(seatID);

        String query = "select t.TicketID, a.seatNumber, t.price, f.origin, f.destination, f.DepartureTime, f.ArrivalTime, t.FlightID " +
                "from availableseats a inner join tickets t on t.FlightID = a.FlightID " +
                "inner join flights f on f.FlightID = t.FlightID " +
                "where a.SeatID = ?;";

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String bookingDate = currentDateTime.format(formatter);

        BasketTickets bucketItem = jdbcTemplate.queryForObject(query, new Object[]{seatID},(rs, rowNum) ->
                new BasketTickets(
                        rs.getInt("TicketID"),
                        bookingDate,
                        rs.getString("seatNumber"),
                        rs.getString("origin"),
                        rs.getString("destination"),
                        rs.getString("DepartureTime"),
                        rs.getString("ArrivalTime"),
                        rs.getDouble("price"),
                        rs.getInt("FlightID")
                )
                );
        currentBasketList.add(bucketItem);
        removeDuplicates();
    }

//    Add the items from my basket to my client in DB
    public void finalizeBasket(Passengers client){
        try {
            String add_baskettickets_query = "insert into baskettickets (BasketID, TicketID, BookingDate, seatNumber) values (?, ?, ?, ?)";
            String add_clientbaskets_query = "insert into clientbaskets (PassengerID) values (?);";
            String getLastInsertIdQuery = "SELECT LAST_INSERT_ID();";

            jdbcTemplate.update(add_clientbaskets_query, client.getPassengerID());
            int basketID = jdbcTemplate.queryForObject(getLastInsertIdQuery, Integer.class);
            System.out.println("Inserted BasketID: " + basketID);

            for (var basketItem :currentBasketList) {

                jdbcTemplate.update(add_baskettickets_query, basketID, basketItem.getTicketID(),
                        basketItem.getBookingDate(), basketItem.getSeatNumber());
                alter_seat_checker(false, basketItem.getFlightID(), basketItem.getSeatNumber());
            }
            currentBasketList.clear();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void alter_seat_checker(boolean state, int flightID, String seatNumber) {

        String alter_seat_checker = "update availableseats set IsAvailable = 0 where FlightID = ? and SeatNumber = ?;";
        jdbcTemplate.update(alter_seat_checker, flightID, seatNumber);
    }

    public void removeDuplicates() {
        for (int i = 0; i < currentBasketList.size(); i++) {
            BasketTickets ticket = currentBasketList.get(i);
            for (int j = i + 1; j < currentBasketList.size(); j++) {
                BasketTickets otherTicket = currentBasketList.get(j);
                // Check if ticketID and seatNumber match
                if (ticket.getTicketID() == otherTicket.getTicketID() &&
                        ticket.getSeatNumber().equals(otherTicket.getSeatNumber())) {
                    currentBasketList.remove(j); // Remove duplicate
                    j--; // Decrement j to account for the shifted indices
                }
            }
        }
    }

    public List<Basket> getUserBaskets(Integer passengerID) {
        String query = "select cb.PassengerID, cb.BasketID, t.TicketID, bt.seatNumber, bt.BookingDate, t.price," +
                "f.DepartureTime, f.ArrivalTime, f.origin, f.destination " +
                "from clientbaskets cb inner join baskettickets bt on cb.BasketID = bt.BasketID " +
                "inner join tickets t on bt.TicketID = t.TicketID " +
                "inner join flights f on t.FlightID = f.FlightID " +
                "where cb.PassengerID = ?;";

        List<Basket> baskets = jdbcTemplate.query(query, new Object[]{passengerID}, (rs, rowNum) ->
                new Basket(
                        rs.getInt("PassengerID"),
                        rs.getInt("BasketID"),
                        rs.getInt("TicketID"),
                        rs.getString("SeatNumber"),
                        rs.getString("BookingDate"),
                        rs.getDouble("price"),
                        rs.getString("DepartureTime"),
                        rs.getString("ArrivalTime"),
                        rs.getString("origin"),
                        rs.getString("destination")
                )
        );

        return baskets;
    }

    public Map<Integer, List<AvailableSeats>>  getAvailableSeats() {
        String available_seats_query = "select SeatID, FlightID, SeatNumber, IsAvailable from availableseats;";
        List<AvailableSeats> availableSeats = jdbcTemplate.query(available_seats_query, (rs, rowNum) -> new AvailableSeats(
                rs.getInt("SeatID"),
                rs.getInt("FlightID"),
                rs.getString("SeatNumber"),
                rs.getBoolean("IsAvailable")
        ));
        Map<Integer, List<AvailableSeats>> seatsByFlight = availableSeats.stream()
                .filter(AvailableSeats::getIsAvailable)
                .collect(Collectors.groupingBy(AvailableSeats::getFlightID));

        return  seatsByFlight;
    }

    public List<FlightsAvailable> getFlightsAvailable() {

        String flights_available_query = "SELECT t.TicketID, t.SeatNumber, t.price, t.FlightID, f.FlightNumber, " +
                "f.DepartureTime, f.ArrivalTime, f.origin, f.destination " +
                "FROM tickets t inner join flights f on t.FlightID = f.FlightID;";

        List<FlightsAvailable> flightsAvailable = jdbcTemplate.query(flights_available_query, (rs, rowNum)
                -> new FlightsAvailable(
                rs.getInt("TicketID"),
                rs.getString("SeatNumber"),
                rs.getDouble("price"),
                rs.getInt("FlightID"),
                rs.getString("FlightNumber"),
                rs.getString("DepartureTime"),
                rs.getString("ArrivalTime"),
                rs.getString("origin"),
                rs.getString("destination")
        ));
        return flightsAvailable;
    }

    public void check_client (Passengers client) {
        if (old_client != null && client != old_client) {
            currentBasketList.clear();
            old_client = client;
        }
        if (old_client == null) old_client = client;
    }
}
