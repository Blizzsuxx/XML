package com.clerk.clerkb.model.potvrdaOVakcinaciji;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TVakcina", propOrder = {
        "pfizer",
        "sinopharm",
        "moderna",
        "sputnik",
        "astraZeneca"
})
public class TVakcina {

    @XmlElement(name = "Pfizer")
    protected String pfizer;
    @XmlElement(name = "Sinopharm")
    protected String sinopharm;
    @XmlElement(name = "Moderna")
    protected String moderna;
    @XmlElement(name = "Sputnik")
    protected String sputnik;
    @XmlElement(name = "AstraZeneca")
    protected String astraZeneca;

    /**
     * Gets the value of the pfizer property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPfizer() {
        return pfizer;
    }

    /**
     * Sets the value of the pfizer property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPfizer(String value) {
        this.pfizer = value;
    }

    /**
     * Gets the value of the sinopharm property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSinopharm() {
        return sinopharm;
    }

    /**
     * Sets the value of the sinopharm property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSinopharm(String value) {
        this.sinopharm = value;
    }

    /**
     * Gets the value of the moderna property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getModerna() {
        return moderna;
    }

    /**
     * Sets the value of the moderna property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setModerna(String value) {
        this.moderna = value;
    }

    /**
     * Gets the value of the sputnik property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSputnik() {
        return sputnik;
    }

    /**
     * Sets the value of the sputnik property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSputnik(String value) {
        this.sputnik = value;
    }

    /**
     * Gets the value of the astraZeneca property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAstraZeneca() {
        return astraZeneca;
    }

    /**
     * Sets the value of the astraZeneca property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAstraZeneca(String value) {
        this.astraZeneca = value;
    }


}
