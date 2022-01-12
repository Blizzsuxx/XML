
package com.example.demo.model.zeleniSertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TPrvaDoza complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPrvaDoza">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serija">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[0-9]{8,8}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="datumPrve" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
@XmlType(name = "TPrvaDoza", propOrder = {
    "serija",
    "datumPrve",
    "zdravstvenaUstanova"
})
public class TPrvaDoza {

    @XmlElement(required = true)
    protected String serija;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPrve;
    @XmlElement(required = true)
    protected TZdravstvenaUstanova zdravstvenaUstanova;

    /**
     * Gets the value of the serija property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerija() {
        return serija;
    }

    /**
     * Sets the value of the serija property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerija(String value) {
        this.serija = value;
    }

    /**
     * Gets the value of the datumPrve property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPrve() {
        return datumPrve;
    }

    /**
     * Sets the value of the datumPrve property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPrve(XMLGregorianCalendar value) {
        this.datumPrve = value;
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
