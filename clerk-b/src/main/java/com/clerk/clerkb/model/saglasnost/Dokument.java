package com.clerk.clerkb.model.saglasnost;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "saglasnostZaSprovodjenjeImunizacije",
        "evidencijaOVakcinaciji"
})
@XmlRootElement(name = "dokument", namespace = "http://ftn.uns.ac.rs/saglasnost")
public class Dokument {
    @XmlElement(name = "saglasnost_za_sprovodjenje_imunizacije", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected SaglasnostZaSprovodjenjeImunizacije saglasnostZaSprovodjenjeImunizacije;
    @XmlElement(name = "evidencija_o_vakcinaciji", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected EvidencijaOVakcinaciji evidencijaOVakcinaciji;

    public SaglasnostZaSprovodjenjeImunizacije getSaglasnostZaSprovodjenjeImunizacije() {
        return saglasnostZaSprovodjenjeImunizacije;
    }

    public void setSaglasnostZaSprovodjenjeImunizacije(SaglasnostZaSprovodjenjeImunizacije saglasnostZaSprovodjenjeImunizacije) {
        this.saglasnostZaSprovodjenjeImunizacije = saglasnostZaSprovodjenjeImunizacije;
    }

    public EvidencijaOVakcinaciji getEvidencijaOVakcinaciji() {
        return evidencijaOVakcinaciji;
    }

    public void setEvidencijaOVakcinaciji(EvidencijaOVakcinaciji evidencijaOVakcinaciji) {
        this.evidencijaOVakcinaciji = evidencijaOVakcinaciji;
    }
}
