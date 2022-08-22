package com.clerk.clerkb.model.zahtevZaSertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "pacijent",
        "razlog",
        "mesto",
        "dan",
        "mesec",
        "godina",
        "potpis"
})
@XmlRootElement(name="zahtevZaSertifikat")
public class ZahtevZaSertifikat {

    @XmlElement(name = "Pacijent", required = true)
    protected TOsoba pacijent;
    @XmlElement(required = true)
    protected String razlog;
    @XmlElement(required = true)
    protected String mesto;
    @XmlElement(required = true)
    protected XMLGregorianCalendar dan;
    @XmlElement(required = true)
    @XmlSchemaType(name = "gMonth")
    protected XMLGregorianCalendar mesec;
    protected int godina;
    @XmlElement(required = true)
    protected String potpis;

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
     * Gets the value of the razlog property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRazlog() {
        return razlog;
    }

    /**
     * Sets the value of the razlog property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRazlog(String value) {
        this.razlog = value;
    }

    /**
     * Gets the value of the mesto property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMesto(String value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the dan property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDan() {
        return dan;
    }

    /**
     * Sets the value of the dan property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDan(XMLGregorianCalendar value) {
        this.dan = value;
    }

    /**
     * Gets the value of the mesec property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getMesec() {
        return mesec;
    }

    /**
     * Sets the value of the mesec property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setMesec(XMLGregorianCalendar value) {
        this.mesec = value;
    }

    /**
     * Gets the value of the godina property.
     *
     */
    public int getGodina() {
        return godina;
    }

    /**
     * Sets the value of the godina property.
     *
     */
    public void setGodina(int value) {
        this.godina = value;
    }

    /**
     * Gets the value of the potpis property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPotpis() {
        return potpis;
    }

    /**
     * Sets the value of the potpis property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPotpis(String value) {
        this.potpis = value;
    }


}
