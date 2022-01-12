
package saglasnost;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ftn.uns.ac.rs/saglasnost}saglasnost_za_sprovodjenje_imunizacije"/>
 *         &lt;element ref="{http://ftn.uns.ac.rs/saglasnost}evidencija_o_vakcinaciji"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "saglasnostZaSprovodjenjeImunizacije",
    "evidencijaOVakcinaciji"
})
@XmlRootElement(name = "dokument", namespace = "http://ftn.uns.ac.rs/saglasnost")
public class Dokument {

    @XmlElement(name = "saglasnost_za_sprovodjenje_imunizacije", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected SaglasnostZaSprovodjenjeImunizacije saglasnostZaSprovodjenjeImunizacije;
    @XmlElement(name = "evidencija_o_vakcinaciji", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected EvidencijaOVakcinaciji evidencijaOVakcinaciji;
    /**
     * Gets the value of the saglasnostZaSprovodjenjeImunizacije property.
     * 
     * @return
     *     possible object is
     *     {@link SaglasnostZaSprovodjenjeImunizacije }
     *     
     */
    public SaglasnostZaSprovodjenjeImunizacije getSaglasnostZaSprovodjenjeImunizacije() {
        return saglasnostZaSprovodjenjeImunizacije;
    }

    /**
     * Sets the value of the saglasnostZaSprovodjenjeImunizacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaglasnostZaSprovodjenjeImunizacije }
     *     
     */
    public void setSaglasnostZaSprovodjenjeImunizacije(SaglasnostZaSprovodjenjeImunizacije value) {
        this.saglasnostZaSprovodjenjeImunizacije = value;
    }

    /**
     * Gets the value of the evidencijaOVakcinaciji property.
     * 
     * @return
     *     possible object is
     *     {@link EvidencijaOVakcinaciji }
     *     
     */
    public EvidencijaOVakcinaciji getEvidencijaOVakcinaciji() {
        return evidencijaOVakcinaciji;
    }

    /**
     * Sets the value of the evidencijaOVakcinaciji property.
     * 
     * @param value
     *     allowed object is
     *     {@link EvidencijaOVakcinaciji }
     *     
     */
    public void setEvidencijaOVakcinaciji(EvidencijaOVakcinaciji value) {
        this.evidencijaOVakcinaciji = value;
    }

}
