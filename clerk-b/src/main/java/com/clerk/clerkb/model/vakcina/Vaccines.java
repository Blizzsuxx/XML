package com.clerk.clerkb.model.vakcina;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

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
