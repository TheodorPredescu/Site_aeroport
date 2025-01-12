/*
*   NEUTILIZAT
 */

package upb.awj.siteBileteAvion.models;

import io.swagger.models.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "Airplanes")
public class Airplanes {

    @Id
    @GeneratedValue
    private int airplaneID;
    @Column(name = "Model")
    private String model;
    @Column(name = "Capacity")
    private int capacity;

    public Airplanes(String model, int capacity, int manufacturer) {
        this.model = model;
        this.capacity = capacity;
        this.manufacturer = manufacturer;
    }

    public int getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(int manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    @Column(name = "Manufacturer")
    private int manufacturer;
}
