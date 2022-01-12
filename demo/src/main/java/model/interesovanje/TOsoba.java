
package model.interesovanje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TOsoba complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TOsoba">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="jmbg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[0-9]{13,13}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="e-adresa">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="/^[^\s@]+@[^\s@]+\.[^\s@]+$/"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="mobilni">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="06[0-9]{8,8}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fiksni">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="01[0-9]{7,7}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TOsoba", namespace = "http://ftn.uns.ac.rs/interesovanje", propOrder = {
    "jmbg",
    "ime",
    "prezime",
    "eAdresa",
    "mobilni",
    "fiksni"
})
public class TOsoba {

    @XmlElement(namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
    protected String jmbg;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
    protected String ime;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
    protected String prezime;
    @XmlElement(name = "e-adresa", namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
    protected String eAdresa;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
    protected String mobilni;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
    protected String fiksni;

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
     * Gets the value of the eAdresa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEAdresa() {
        return eAdresa;
    }

    /**
     * Sets the value of the eAdresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEAdresa(String value) {
        this.eAdresa = value;
    }

    /**
     * Gets the value of the mobilni property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobilni() {
        return mobilni;
    }

    /**
     * Sets the value of the mobilni property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobilni(String value) {
        this.mobilni = value;
    }

    /**
     * Gets the value of the fiksni property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiksni() {
        return fiksni;
    }

    /**
     * Sets the value of the fiksni property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiksni(String value) {
        this.fiksni = value;
    }

}
