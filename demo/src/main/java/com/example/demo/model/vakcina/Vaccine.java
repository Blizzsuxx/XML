package com.example.demo.model.vakcina;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="vaccine")
public class Vaccine {

    private long id;
    private String manufacturer;
    private int quantity;
    private HashMap<String, Long> termini;

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

    public HashMap<String, Long> getTermini() {
        if(termini == null) {
            termini = new HashMap<>();
        }
        return termini;
    }

    public void setTermini(HashMap<String, Long> termini) {
        this.termini = termini;
    }


    
}
