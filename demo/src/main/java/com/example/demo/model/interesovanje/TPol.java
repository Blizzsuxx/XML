
package com.example.demo.model.interesovanje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TPol complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPol">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Musko" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Zensko" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPol", namespace = "http://ftn.uns.ac.rs/interesovanje", propOrder = {
    "musko",
    "zensko"
})
public class TPol {

    @XmlElement(name = "Musko", namespace = "http://ftn.uns.ac.rs/interesovanje")
    protected String musko;
    @XmlElement(name = "Zensko", namespace = "http://ftn.uns.ac.rs/interesovanje")
    protected String zensko;

    /**
     * Gets the value of the musko property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMusko() {
        return musko;
    }

    /**
     * Sets the value of the musko property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMusko(String value) {
        this.musko = value;
    }

    /**
     * Gets the value of the zensko property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZensko() {
        return zensko;
    }

    /**
     * Sets the value of the zensko property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZensko(String value) {
        this.zensko = value;
    }

}
