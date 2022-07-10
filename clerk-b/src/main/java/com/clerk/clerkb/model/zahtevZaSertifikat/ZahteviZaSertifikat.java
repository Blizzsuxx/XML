package com.clerk.clerkb.model.zahtevZaSertifikat;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="zahtevi")
public class ZahteviZaSertifikat {

    private List<ZahtevZaSertifikat> zahtev;

    public List<ZahtevZaSertifikat> getZahtev() {
        return zahtev;
    }

    public void setZahtev(List<ZahtevZaSertifikat> zahtev) {
        this.zahtev = zahtev;
    }
}
