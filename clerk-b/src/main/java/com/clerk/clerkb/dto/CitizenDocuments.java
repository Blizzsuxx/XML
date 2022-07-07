package com.clerk.clerkb.dto;

import com.clerk.clerkb.model.zahtevZaSertifikat.ZahtevZaSertifikat;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "certificateRequest"
})
@XmlRootElement(name = "citizenDocuments")
public class CitizenDocuments {

    private ZahtevZaSertifikat certificateRequest;

    public ZahtevZaSertifikat getCertificateRequest() {
        return certificateRequest;
    }

    public void setCertificateRequest(ZahtevZaSertifikat certificateRequest) {
        this.certificateRequest = certificateRequest;
    }
}
