package com.clerk.clerkb.model.zeleniSertifikat;

import com.clerk.clerkb.model.zahtevZaSertifikat.TOsoba;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "qrCode",
        "pacijent",
        "datumIzdavanja",
        "vakcinacija", //edit
        "vreme"
})
@XmlRootElement(name = "digitalniSertifikat")
public class DigitalniSertifikat {

    @XmlElement(name = "QRCode", required = true)
    protected String qrCode;
    @XmlElement(name = "Pacijent", required = true)
    protected TOsoba pacijent;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumIzdavanja;

    @XmlElement(required = true)
    protected TVakcinacija vakcinacija; //edit

    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar vreme;
    @XmlAttribute(name = "ID")
    protected Integer id;

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public TOsoba getPacijent() {
        return pacijent;
    }

    public void setPacijent(TOsoba pacijent) {
        this.pacijent = pacijent;
    }

    public XMLGregorianCalendar getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(XMLGregorianCalendar datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public TVakcinacija getVakcinacija() {
        return vakcinacija;
    }

    public void setVakcinacija(TVakcinacija vakcinacija) {
        this.vakcinacija = vakcinacija;
    }

    public XMLGregorianCalendar getVreme() {
        return vreme;
    }

    public void setVreme(XMLGregorianCalendar vreme) {
        this.vreme = vreme;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
