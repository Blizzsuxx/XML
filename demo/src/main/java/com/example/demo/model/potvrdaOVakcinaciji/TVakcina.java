
package com.example.demo.model.potvrdaOVakcinaciji;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TVakcina complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TVakcina">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Pfizer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Sinopharm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Moderna" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Sputnik" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AstraZeneca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
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
