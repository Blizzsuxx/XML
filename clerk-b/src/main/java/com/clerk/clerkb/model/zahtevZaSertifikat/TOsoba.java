package com.clerk.clerkb.model.zahtevZaSertifikat;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TOsoba", propOrder = {
        "ime",
        "prezime",
        "datum",
        "pol",
        "jmbg",
        "pasos"
})
public class TOsoba {

    @XmlElement(required = true)
    protected String ime;
    @XmlElement(required = true)
    protected String prezime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(required = true)
    protected TPol pol;
    @XmlElement(required = true)
    protected String jmbg;
    @XmlElement(required = true)
    protected String pasos;

    /**
     * Gets the value of the ime property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the prezime property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Sets the value of the prezime property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPrezime(String value) {
        this.prezime = value;
    }

    /**
     * Gets the value of the datum property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the pol property.
     *
     * @return
     *     possible object is
     *     {@link TPol }
     *
     */
    public TPol getPol() {
        return pol;
    }

    /**
     * Sets the value of the pol property.
     *
     * @param value
     *     allowed object is
     *     {@link TPol }
     *
     */
    public void setPol(TPol value) {
        this.pol = value;
    }

    /**
     * Gets the value of the jmbg property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getJmbg() {
        return jmbg;
    }

    /**
     * Sets the value of the jmbg property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setJmbg(String value) {
        this.jmbg = value;
    }

    /**
     * Gets the value of the pasos property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPasos() {
        return pasos;
    }

    /**
     * Sets the value of the pasos property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPasos(String value) {
        this.pasos = value;
    }
}
