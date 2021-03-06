package com.clerk.clerkb.dto;

import com.clerk.clerkb.model.potvrdaOVakcinaciji.PotvrdaOVakcinaciji;
import com.clerk.clerkb.model.saglasnost.Dokument;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahtevZaSertifikat;

import javax.xml.bind.annotation.*;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "certificateRequest",
        "potvrde",
        "saglasnost"
})
@XmlRootElement(name = "citizenDocuments")
public class CitizenDocuments {

    private ZahtevZaSertifikat certificateRequest;

    private List<PotvrdaOVakcinaciji> potvrde;

    private List<Dokument> saglasnost;

    public ZahtevZaSertifikat getCertificateRequest() {
        return certificateRequest;
    }

    public void setCertificateRequest(ZahtevZaSertifikat certificateRequest) {
        this.certificateRequest = certificateRequest;
    }

    public List<PotvrdaOVakcinaciji> getPotvrde() {
        return potvrde;
    }

    public void setPotvrde(List<PotvrdaOVakcinaciji> potvrde) {
        this.potvrde = potvrde;
    }

    public List<Dokument> getSaglasnost() {
        return saglasnost;
    }

    public void setSaglasnost(List<Dokument> saglasnost) {
        this.saglasnost = saglasnost;
    }
}
