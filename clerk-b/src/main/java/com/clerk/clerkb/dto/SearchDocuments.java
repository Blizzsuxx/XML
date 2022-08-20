package com.clerk.clerkb.dto;


import com.clerk.clerkb.model.potvrdaOVakcinaciji.PotvrdaOVakcinaciji;
import com.clerk.clerkb.model.saglasnost.Dokument;
import com.clerk.clerkb.model.zeleniSertifikat.DigitalniSertifikat;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "documents")
public class SearchDocuments {

    private List<Dokument> saglasnost;

    private List<PotvrdaOVakcinaciji> potvrda;

    private List<DigitalniSertifikat> sertifikat;

    public List<Dokument> getSaglasnost() {
        return saglasnost;
    }

    public void setSaglasnost(List<Dokument> saglasnost) {
        this.saglasnost = saglasnost;
    }

    public List<PotvrdaOVakcinaciji> getPotvrda() {
        return potvrda;
    }

    public void setPotvrda(List<PotvrdaOVakcinaciji> potvrda) {
        this.potvrda = potvrda;
    }

    public List<DigitalniSertifikat> getSertifikat() {
        return sertifikat;
    }

    public void setSertifikat(List<DigitalniSertifikat> sertifikat) {
        this.sertifikat = sertifikat;
    }
}
