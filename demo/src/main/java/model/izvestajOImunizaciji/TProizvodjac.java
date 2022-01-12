
package model.izvestajOImunizaciji;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TProizvodjac complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TProizvodjac">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ime" type="{http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji}TVakcina"/>
 *         &lt;element name="broj_doza" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TProizvodjac", namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", propOrder = {
    "ime",
    "brojDoza"
})
public class TProizvodjac {

    @XmlElement(name = "Ime", namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
    protected TVakcina ime;
    @XmlElement(name = "broj_doza", namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji")
    protected long brojDoza;

    /**
     * Gets the value of the ime property.
     * 
     * @return
     *     possible object is
     *     {@link TVakcina }
     *     
     */
    public TVakcina getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TVakcina }
     *     
     */
    public void setIme(TVakcina value) {
        this.ime = value;
    }

    /**
     * Gets the value of the brojDoza property.
     * 
     */
    public long getBrojDoza() {
        return brojDoza;
    }

    /**
     * Sets the value of the brojDoza property.
     * 
     */
    public void setBrojDoza(long value) {
        this.brojDoza = value;
    }

}
