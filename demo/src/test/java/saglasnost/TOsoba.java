
package saglasnost;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ime_roditelja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pol" type="{http://ftn.uns.ac.rs/saglasnost}TPol"/>
 *         &lt;element name="datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="mesto_rodjenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="adresa">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="^[a-zA-Z]+[a-zA-Z0-9]*$"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *         &lt;element name="e-adresa">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="/^[^\s@]+@[^\s@]+\.[^\s@]+$/"/>
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
@XmlType(name = "TOsoba", namespace = "http://ftn.uns.ac.rs/saglasnost", propOrder = {
    "ime",
    "prezime",
    "imeRoditelja",
    "pol",
    "datumRodjenja",
    "mestoRodjenja",
    "adresa",
    "mesto",
    "mobilni",
    "fiksni",
    "eAdresa"
})
public class TOsoba {

    @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected String ime;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected String prezime;
    @XmlElement(name = "ime_roditelja", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected String imeRoditelja;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected TPol pol;
    @XmlElement(name = "datum_rodjenja", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumRodjenja;
    @XmlElement(name = "mesto_rodjenja", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected String mestoRodjenja;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected String adresa;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected String mesto;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected String mobilni;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected String fiksni;
    @XmlElement(name = "e-adresa", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected String eAdresa;

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
     * Gets the value of the imeRoditelja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImeRoditelja() {
        return imeRoditelja;
    }

    /**
     * Sets the value of the imeRoditelja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImeRoditelja(String value) {
        this.imeRoditelja = value;
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
     * Gets the value of the datumRodjenja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumRodjenja() {
        return datumRodjenja;
    }

    /**
     * Sets the value of the datumRodjenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumRodjenja(XMLGregorianCalendar value) {
        this.datumRodjenja = value;
    }

    /**
     * Gets the value of the mestoRodjenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMestoRodjenja() {
        return mestoRodjenja;
    }

    /**
     * Sets the value of the mestoRodjenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMestoRodjenja(String value) {
        this.mestoRodjenja = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresa(String value) {
        this.adresa = value;
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

}
