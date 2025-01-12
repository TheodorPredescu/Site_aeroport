/*
 *Build #IC-243.21565.193, built on November 13, 2024
 *@author Predescu Theodor
 *clasa utilizata pentru stocarea informatiilor legate de utilizatorul curent
 */
package upb.awj.siteBileteAvion.models;


import jakarta.persistence.*;

//@Entity
//@Table(name = "passengers")
public class Passengers {


    //    Var
//    @Id
//    @GeneratedValue
    private int PassengerID;

    //@Column(name = "FirstName")
    private String firstName;

    //@Column(name = "LastName")
    private String lastName;
    //@Column(name = "Email")
    private String email;
    //@Column(name = "PassportNumber")
    private String passportNumber;
    //@Column(name = "Nationality")
    private String nationality;

    private String CNP;
    private String password;
    private String confirmPassword;

    //    getter
    public String getPassword() {
        return password;
    }
    public String getCNP() {
        return CNP;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public int getPassengerID() {
        return PassengerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getNationality() {
        return nationality;
    }
    //  setter

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassengerID(int passengerID) {
        PassengerID = passengerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    //Constructor
    public Passengers(int passengerID, String firstName, String lastName, String email, String passportNumber, String nationality, String password, String CNP) {
        this.PassengerID = passengerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.CNP = CNP;
        this.password = password;
    }
    public Passengers() {

    }
}
