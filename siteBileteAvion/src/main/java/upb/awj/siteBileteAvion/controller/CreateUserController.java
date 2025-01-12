/*
*Build #IC-243.21565.193, built on November 13, 2024
*@author Predescu Theodor
* clasa pentru inregistrare de utilizator nou:
*       este legat de create_user.html si preda informatii legate de client prin intermediul variabilei "Client" clasei
*           BascketController
*/
package upb.awj.siteBileteAvion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import upb.awj.siteBileteAvion.models.Passengers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@SessionAttributes({"Client"})
public class CreateUserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    // Regex pattern for validating email format
    private static final String EMAIL_REGEX ="^[[A-Za-z]A-Za-z0-9+_.-]*@[A-Za-z0-9.-]+$";
    private static final String NAME_REGEX = "^[a-zA-Z][a-zA-Z\s'-]*$";
    // Regex pattern for validating password
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[@&*%`~!]).+$";
    private static final String CNP_REGEX = "^[0-9]{13}$";

    public static boolean isValidName(String name) {
        name = name.trim();
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        if (name.length() > 2)
            return matcher.matches();
        return false;
    }

    public static boolean isValidEmail(String email) {
        email = email.trim();
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        password = password.trim();
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public static boolean isValidCNP(String cnp) {
        cnp = cnp.trim();
        Pattern pattern = Pattern.compile(CNP_REGEX);
        Matcher matcher = pattern.matcher(cnp);
        return matcher.matches();
    }

    @GetMapping("/create-user")
    public String showUserMenu(Model model) {
        model.addAttribute("showsubmit", true);
        return "create_user";
    }

    @PostMapping("/create-user")
    public String handleCreateUser(
            @ModelAttribute Passengers passenger,
            Model model
    ) {
        Boolean valid_email = false, valid_password = false, valid = false, valid_name = false, valid_password_duplicate = false, valid_cnp = false;
        if (isValidEmail(passenger.getEmail())) valid_email = true;
        if (isValidPassword(passenger.getPassword()) && passenger.getPassword().length() >= 5) valid_password = true;
        if (passenger.getPassword().equals(passenger.getConfirmPassword()))  valid_password_duplicate = true;
        if (isValidName(passenger.getFirstName()) && isValidName(passenger.getLastName())) valid_name = true;
        if (isValidCNP(passenger.getCNP())) valid_cnp = true;
        if (valid_email && valid_password && valid_name && valid_password_duplicate && valid_cnp) valid = true;

        model.addAttribute("valide", valid_email);
        model.addAttribute("validp", valid_password);
        model.addAttribute("validpd", valid_password_duplicate);
        model.addAttribute("validn", valid_name);
        model.addAttribute("validcnp", valid_cnp);
        model.addAttribute("valid", valid);
        model.addAttribute("showsubmit", true);

        model.addAttribute("firstName", passenger.getFirstName());
        model.addAttribute("lastName", passenger.getLastName());
        model.addAttribute("email", passenger.getEmail());
        model.addAttribute("CNP", passenger.getCNP());
        model.addAttribute("passportNumber", passenger.getPassportNumber());
        model.addAttribute("nationality", passenger.getNationality());
        if (valid) {
            try {
                String insertQuery = "INSERT INTO Passengers (CNP, FirstName, LastName, email, PassportNumber, nationality, Password) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
                jdbcTemplate.update(insertQuery, passenger.getCNP(), passenger.getFirstName(), passenger.getLastName(),
                                    passenger.getEmail(), passenger.getPassportNumber(), passenger.getNationality(), passenger.getPassword());
                model.addAttribute("succesMessage", "User created successfully!");
                model.addAttribute("valid_add", true);
                model.addAttribute("Client", passenger);
                model.addAttribute("showsubmit", false);
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("valid_add", false);
                model.addAttribute("errorMessage", "An error occurred while creating the user.");
                model.addAttribute("showsubmit", true);
            }
        }
        return "create_user";
    }
}
