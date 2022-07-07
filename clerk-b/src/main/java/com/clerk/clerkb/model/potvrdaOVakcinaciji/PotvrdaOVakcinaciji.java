package com.clerk.clerkb.model.potvrdaOVakcinaciji;

import com.clerk.clerkb.model.zahtevZaSertifikat.TOsoba;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "pacijent",
        "datumPrva",
        "serija",
        "datumDruga",
        "ustanova",
        "vakcina",
        "datumPotvrde",
        "qrCode"
})
@XmlRootElement(name = "potvrdaOVakcinaciji")
public class PotvrdaOVakcinaciji {

    @XmlElement(name = "Pacijent", required = true)
    protected TOsoba pacijent;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPrva;
    @XmlElement(required = true)
    protected String serija;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumDruga;
    @XmlElement(required = true)
    protected TZdravstvenaUstanova ustanova;
    @XmlElement(required = true)
    protected TVakcina vakcina;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPotvrde;
    @XmlElement(name = "QRCode", required = true)
    protected String qrCode;

    /**
     * Gets the value of the pacijent property.
     *
     * @return
     *     possible object is
     *     {@link TOsoba }
     *
     */
    public TOsoba getPacijent() {
        return pacijent;
    }

    /**
     * Sets the value of the pacijent property.
     *
     * @param value
     *     allowed object is
     *     {@link TOsoba }
     *
     */
    public void setPacijent(TOsoba value) {
        this.pacijent = value;
    }

    /**
     * Gets the value of the datumPrva property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDatumPrva() {
        return datumPrva;
    }

    /**
     * Sets the value of the datumPrva property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDatumPrva(XMLGregorianCalendar value) {
        this.datumPrva = value;
    }

    /**
     * Gets the value of the serija property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSerija() {
        return serija;
    }

    /**
     * Sets the value of the serija property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSerija(String value) {
        this.serija = value;
    }

    /**
     * Gets the value of the datumDruga property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDatumDruga() {
        return datumDruga;
    }

    /**
     * Sets the value of the datumDruga property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDatumDruga(XMLGregorianCalendar value) {
        this.datumDruga = value;
    }

    /**
     * Gets the value of the ustanova property.
     *
     * @return
     *     possible object is
     *     {@link TZdravstvenaUstanova }
     *
     */
    public TZdravstvenaUstanova getUstanova() {
        return ustanova;
    }

    /**
     * Sets the value of the ustanova property.
     *
     * @param value
     *     allowed object is
     *     {@link TZdravstvenaUstanova }
     *
     */
    public void setUstanova(TZdravstvenaUstanova value) {
        this.ustanova = value;
    }

    /**
     * Gets the value of the vakcina property.
     *
     * @return
     *     possible object is
     *     {@link TVakcina }
     *
     */
    public TVakcina getVakcina() {
        return vakcina;
    }

    /**
     * Sets the value of the vakcina property.
     *
     * @param value
     *     allowed object is
     *     {@link TVakcina }
     *
     */
    public void setVakcina(TVakcina value) {
        this.vakcina = value;
    }

    /**
     * Gets the value of the datumPotvrde property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDatumPotvrde() {
        return datumPotvrde;
    }

    /**
     * Sets the value of the datumPotvrde property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDatumPotvrde(XMLGregorianCalendar value) {
        this.datumPotvrde = value;
    }

    /**
     * Gets the value of the qrCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getQRCode() {
        return qrCode;
    }

    /**
     * Sets the value of the qrCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setQRCode(String value) {
        this.qrCode = value;
    }

}
