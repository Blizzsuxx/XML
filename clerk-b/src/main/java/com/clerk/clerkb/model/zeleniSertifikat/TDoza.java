package com.clerk.clerkb.model.zeleniSertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tip",
        "proizvodjac",
        "datum",
        "serija",
        "institucija"
})
public class TDoza {

    @XmlElement(required = true)
    protected String tip;

    @XmlElement(required = true)
    protected String proizvodjac;

    @XmlElement(required = true)
    protected String datum;

    @XmlElement(required = true)
    protected String serija;

    @XmlElement(required = true)
    protected String institucija;

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getSerija() {
        return serija;
    }

    public void setSerija(String serija) {
        this.serija = serija;
    }

    public String getInstitucija() {
        return institucija;
    }

    public void setInstitucija(String institucija) {
        this.institucija = institucija;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return Objects.equals(tip, o) && Objects.equals(proizvodjac, o) && Objects.equals(datum, o) && Objects.equals(serija, o) && Objects.equals(institucija, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tip, proizvodjac, datum, serija, institucija);
    }
}
