package com.example.demo.model.vakcina;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="vaccines")
public class Vaccines {

    private List<Vaccine> vaccine;

    public List<Vaccine> getVaccine() {
        return vaccine;
    }

    public void setVaccine(List<Vaccine> vaccine) {
        this.vaccine = vaccine;
    }
}
