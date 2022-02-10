
package com.example.demo.model.zeleniSertifikat;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="QRCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4296"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Pacijent" type="{}TOsoba"/>
 *         &lt;element name="datumIzdavanja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="prvaDoza" type="{}TPrvaDoza"/>
 *         &lt;element name="drugaDoza" type="{}TDrugaDoza"/>
 *         &lt;element name="vreme" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minExclusive value="0"/>
 *             &lt;pattern value="[0-9]+"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "qrCode",
    "pacijent",
    "datumIzdavanja",
    "prvaDoza",
    "drugaDoza",
    "vreme"
})
@XmlRootElement(name = "digitalniSertifikat")
public class DigitalniSertifikat implements Serializable{

    @XmlElement(name = "QRCode", required = true)
    protected String qrCode;
    @XmlElement(name = "Pacijent", required = true)
    protected TOsoba pacijent;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumIzdavanja;
    @XmlElement(required = true)
    protected TPrvaDoza prvaDoza;
    @XmlElement(required = true)
    protected TDrugaDoza drugaDoza;
    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar vreme;
    @XmlAttribute(name = "ID")
    protected Integer id;

    /**
     * Gets the value of the qrCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQRCode() {
        return qrCode;
    }

    /**
     * Sets the value of the qrCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQRCode(String value) {
        this.qrCode = value;
    }

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
     * Gets the value of the datumIzdavanja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumIzdavanja() {
        return datumIzdavanja;
    }

    /**
     * Sets the value of the datumIzdavanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumIzdavanja(XMLGregorianCalendar value) {
        this.datumIzdavanja = value;
    }

    /**
     * Gets the value of the prvaDoza property.
     * 
     * @return
     *     possible object is
     *     {@link TPrvaDoza }
     *     
     */
    public TPrvaDoza getPrvaDoza() {
        return prvaDoza;
    }

    /**
     * Sets the value of the prvaDoza property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPrvaDoza }
     *     
     */
    public void setPrvaDoza(TPrvaDoza value) {
        this.prvaDoza = value;
    }

    /**
     * Gets the value of the drugaDoza property.
     * 
     * @return
     *     possible object is
     *     {@link TDrugaDoza }
     *     
     */
    public TDrugaDoza getDrugaDoza() {
        return drugaDoza;
    }

    /**
     * Sets the value of the drugaDoza property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDrugaDoza }
     *     
     */
    public void setDrugaDoza(TDrugaDoza value) {
        this.drugaDoza = value;
    }

    /**
     * Gets the value of the vreme property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVreme() {
        return vreme;
    }

    /**
     * Sets the value of the vreme property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVreme(XMLGregorianCalendar value) {
        this.vreme = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setID(Integer value) {
        this.id = value;
    }

}
