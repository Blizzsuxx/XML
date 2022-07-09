package com.clerk.clerkb.model.vakcina;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="vaccine")
public class Vaccine {

    private long id;
    private String manufacturer;
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
