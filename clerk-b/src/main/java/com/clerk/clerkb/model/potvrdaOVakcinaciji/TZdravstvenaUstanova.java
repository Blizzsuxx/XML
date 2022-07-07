package com.clerk.clerkb.model.potvrdaOVakcinaciji;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TZdravstvenaUstanova", propOrder = {
        "naziv",
        "ulica",
        "broj",
        "grad"
})
public class TZdravstvenaUstanova {

    @XmlElement(required = true)
    protected String naziv;
    @XmlElement(required = true)
    protected String ulica;
    @XmlElement(required = true)
    protected String broj;
    @XmlElement(required = true)
    protected String grad;

    /**
     * Gets the value of the naziv property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the ulica property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * Sets the value of the ulica property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUlica(String value) {
        this.ulica = value;
    }

    /**
     * Gets the value of the broj property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBroj(String value) {
        this.broj = value;
    }

    /**
     * Gets the value of the grad property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGrad() {
        return grad;
    }

    /**
     * Sets the value of the grad property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGrad(String value) {
        this.grad = value;
    }

}
