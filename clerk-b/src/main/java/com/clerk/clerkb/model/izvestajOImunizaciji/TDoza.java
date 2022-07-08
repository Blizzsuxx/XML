package com.clerk.clerkb.model.izvestajOImunizaciji;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDoza", namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", propOrder = {
        "redniBrojDoze",
        "primljenaKolicina"
})
public class TDoza {

    @XmlElement(name = "redni_broj_doze", namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji")
    protected long redniBrojDoze;
    @XmlElement(name = "primljena_kolicina", namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji")
    protected long primljenaKolicina;

    /**
     * Gets the value of the redniBrojDoze property.
     *
     */
    public long getRedniBrojDoze() {
        return redniBrojDoze;
    }

    /**
     * Sets the value of the redniBrojDoze property.
     *
     */
    public void setRedniBrojDoze(long value) {
        this.redniBrojDoze = value;
    }

    /**
     * Gets the value of the primljenaKolicina property.
     *
     */
    public long getPrimljenaKolicina() {
        return primljenaKolicina;
    }

    /**
     * Sets the value of the primljenaKolicina property.
     *
     */
    public void setPrimljenaKolicina(long value) {
        this.primljenaKolicina = value;
    }

}
