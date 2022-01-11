
package model.zeleniSertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TDrugaDoza complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TDrugaDoza">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serijaDruga">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[0-9]{8,8}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="datumDruge" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="zdravstvenaUstanova" type="{}TZdravstvenaUstanova"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDrugaDoza", propOrder = {
    "serijaDruga",
    "datumDruge",
    "zdravstvenaUstanova"
})
public class TDrugaDoza {

    @XmlElement(required = true)
    protected String serijaDruga;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumDruge;
    @XmlElement(required = true)
    protected TZdravstvenaUstanova zdravstvenaUstanova;

    /**
     * Gets the value of the serijaDruga property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerijaDruga() {
        return serijaDruga;
    }

    /**
     * Sets the value of the serijaDruga property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerijaDruga(String value) {
        this.serijaDruga = value;
    }

    /**
     * Gets the value of the datumDruge property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumDruge() {
        return datumDruge;
    }

    /**
     * Sets the value of the datumDruge property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumDruge(XMLGregorianCalendar value) {
        this.datumDruge = value;
    }

    /**
     * Gets the value of the zdravstvenaUstanova property.
     * 
     * @return
     *     possible object is
     *     {@link TZdravstvenaUstanova }
     *     
     */
    public TZdravstvenaUstanova getZdravstvenaUstanova() {
        return zdravstvenaUstanova;
    }

    /**
     * Sets the value of the zdravstvenaUstanova property.
     * 
     * @param value
     *     allowed object is
     *     {@link TZdravstvenaUstanova }
     *     
     */
    public void setZdravstvenaUstanova(TZdravstvenaUstanova value) {
        this.zdravstvenaUstanova = value;
    }

}
