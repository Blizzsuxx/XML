package com.clerk.clerkb.model.zahtevZaSertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPol", propOrder = {
        "musko",
        "zensko"
})
public class TPol {

    @XmlElement(name = "Musko")
    protected String musko;
    @XmlElement(name = "Zensko")
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
