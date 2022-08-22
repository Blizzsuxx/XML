
package com.clerk.clerkb.model.saglasnost;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TIzbor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TIzbor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="izabran" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIzbor", namespace = "http://ftn.uns.ac.rs/saglasnost")
public class TIzbor {

    @XmlAttribute(name = "izabran", required = true)
    protected boolean izabran;

    /**
     * Gets the value of the izabran property.
     * 
     */
    public boolean isIzabran() {
        return izabran;
    }

    /**
     * Sets the value of the izabran property.
     * 
     */
    public void setIzabran(boolean value) {
        this.izabran = value;
    }

    public void setIzabran(String value) {
        if(value.equals("Da") || value.equals("da") || value.equals("true")){
            this.izabran = true;
        } else {
            this.izabran = false;
        }
    }

}
