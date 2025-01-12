/*
 *Build #IC-243.21565.193, built on November 13, 2024
 *@author Predescu Theodor
 *clasa utilizata pentru conectarea unui utilizator ce are deja cont in baza de date
 */

package upb.awj.siteBileteAvion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import upb.awj.siteBileteAvion.models.Passengers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
@SessionAttributes({"Client"})
public class PassengersController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login-verification")
    public String loginVerification(
            @RequestParam("email_ver") String email_ver,
            @RequestParam("password") String password,
            Model model) {
        List<Passengers> passengersList;
        boolean validation_passed = false;
        try {
            // Execute the query
           String query =  "select PassengerID, FirstName, LastName, email, PassportNumber, nationality, Password,CNP  from passengers;";
           passengersList = jdbcTemplate.query(query, (rs, rowNum) -> new Passengers(
                           rs.getInt("PassengerID"),
                           rs.getString("FirstName"),
                           rs.getString("LastName"),
                           rs.getString("email"),
                           rs.getString("PassportNumber"),
                           rs.getString("nationality"),
                           rs.getString("Password"),
                           rs.getString("CNP")
           ));
            Passengers client = new Passengers();
            for (var passenger : passengersList) {
                if (passenger.getEmail().equals(email_ver)  && passenger.getPassword().equals(password)) {
                    validation_passed = true;
                    client = passenger;
                }
            }
            model.addAttribute("validation", validation_passed);
//            model.addAttribute("passengersList", passengersList);
            model.addAttribute("Client", client);

            if (validation_passed) return "redirect:/login/user";
            else return "login";
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
//            model.addAttribute("errorMessage", "An error occurred while fetching passengers. Please try again later.");
            model.addAttribute("validation", validation_passed);
            return "login";
        }
    }

}
