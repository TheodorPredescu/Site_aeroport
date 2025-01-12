/*
 *   NEUTILIZAT
 */

package upb.awj.siteBileteAvion.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ClientBasckets")
public class ClientBasckets {


    @Id
    @GeneratedValue
    private int bascketID;

    @Column(name = "PassengerID")
    private int passengerID;

    public ClientBasckets(int passengerID) {
        this.passengerID = passengerID;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public int getBascketID() {
        return bascketID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }
}
