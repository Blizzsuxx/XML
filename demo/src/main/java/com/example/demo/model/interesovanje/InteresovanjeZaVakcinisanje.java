
package com.example.demo.model.interesovanje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="drzavljanstvo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="drzavljanstvo_republike_srbije" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="strani_sa_broravkom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="strani_bez_boravka" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="osoba" type="{http://ftn.uns.ac.rs/interesovanje}TOsoba"/>
 *         &lt;element name="lokacija" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vakcine">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="izabrane_vakcine">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://ftn.uns.ac.rs/interesovanje}TIzbor">
 *                           &lt;sequence>
 *                             &lt;element name="vakcina" type="{http://ftn.uns.ac.rs/interesovanje}TVakcina"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="bilo_sta" type="{http://ftn.uns.ac.rs/interesovanje}TIzbor"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="davalac_krvi" type="{http://ftn.uns.ac.rs/interesovanje}TIzbor"/>
 *         &lt;element name="dan" type="{http://www.w3.org/2001/XMLSchema}gMonthDay"/>
 *         &lt;element name="potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "drzavljanstvo",
    "osoba",
    "lokacija",
    "vakcine",
    "davalacKrvi",
    "dan",
    "potpis"
})
@XmlRootElement(name = "interesovanje_za_vakcinisanje", namespace = "http://ftn.uns.ac.rs/interesovanje")
public class InteresovanjeZaVakcinisanje {

    @XmlElement(namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
    protected InteresovanjeZaVakcinisanje.Drzavljanstvo drzavljanstvo;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
    protected TOsoba osoba;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
    protected String lokacija;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
    protected InteresovanjeZaVakcinisanje.Vakcine vakcine;
    @XmlElement(name = "davalac_krvi", namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
    protected TIzbor davalacKrvi;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
    @XmlSchemaType(name = "gMonthDay")
    protected XMLGregorianCalendar dan;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
    protected String potpis;

    /**
     * Gets the value of the drzavljanstvo property.
     * 
     * @return
     *     possible object is
     *     {@link InteresovanjeZaVakcinisanje.Drzavljanstvo }
     *     
     */
    public InteresovanjeZaVakcinisanje.Drzavljanstvo getDrzavljanstvo() {
        return drzavljanstvo;
    }

    /**
     * Sets the value of the drzavljanstvo property.
     * 
     * @param value
     *     allowed object is
     *     {@link InteresovanjeZaVakcinisanje.Drzavljanstvo }
     *     
     */
    public void setDrzavljanstvo(InteresovanjeZaVakcinisanje.Drzavljanstvo value) {
        this.drzavljanstvo = value;
    }

    /**
     * Gets the value of the osoba property.
     * 
     * @return
     *     possible object is
     *     {@link TOsoba }
     *     
     */
    public TOsoba getOsoba() {
        return osoba;
    }

    /**
     * Sets the value of the osoba property.
     * 
     * @param value
     *     allowed object is
     *     {@link TOsoba }
     *     
     */
    public void setOsoba(TOsoba value) {
        this.osoba = value;
    }

    /**
     * Gets the value of the lokacija property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLokacija() {
        return lokacija;
    }

    /**
     * Sets the value of the lokacija property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLokacija(String value) {
        this.lokacija = value;
    }

    /**
     * Gets the value of the vakcine property.
     * 
     * @return
     *     possible object is
     *     {@link InteresovanjeZaVakcinisanje.Vakcine }
     *     
     */
    public InteresovanjeZaVakcinisanje.Vakcine getVakcine() {
        return vakcine;
    }

    /**
     * Sets the value of the vakcine property.
     * 
     * @param value
     *     allowed object is
     *     {@link InteresovanjeZaVakcinisanje.Vakcine }
     *     
     */
    public void setVakcine(InteresovanjeZaVakcinisanje.Vakcine value) {
        this.vakcine = value;
    }

    /**
     * Gets the value of the davalacKrvi property.
     * 
     * @return
     *     possible object is
     *     {@link TIzbor }
     *     
     */
    public TIzbor getDavalacKrvi() {
        return davalacKrvi;
    }

    /**
     * Sets the value of the davalacKrvi property.
     * 
     * @param value
     *     allowed object is
     *     {@link TIzbor }
     *     
     */
    public void setDavalacKrvi(TIzbor value) {
        this.davalacKrvi = value;
    }

    /**
     * Gets the value of the dan property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDan() {
        return dan;
    }

    /**
     * Sets the value of the dan property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDan(XMLGregorianCalendar value) {
        this.dan = value;
    }

    /**
     * Gets the value of the potpis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPotpis() {
        return potpis;
    }

    /**
     * Sets the value of the potpis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPotpis(String value) {
        this.potpis = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="drzavljanstvo_republike_srbije" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="strani_sa_broravkom" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="strani_bez_boravka" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "drzavljanstvoRepublikeSrbije",
        "straniSaBroravkom",
        "straniBezBoravka"
    })
    public static class Drzavljanstvo {

        @XmlElement(name = "drzavljanstvo_republike_srbije", namespace = "http://ftn.uns.ac.rs/interesovanje")
        protected String drzavljanstvoRepublikeSrbije;
        @XmlElement(name = "strani_sa_broravkom", namespace = "http://ftn.uns.ac.rs/interesovanje")
        protected String straniSaBroravkom;
        @XmlElement(name = "strani_bez_boravka", namespace = "http://ftn.uns.ac.rs/interesovanje")
        protected String straniBezBoravka;

        /**
         * Gets the value of the drzavljanstvoRepublikeSrbije property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDrzavljanstvoRepublikeSrbije() {
            return drzavljanstvoRepublikeSrbije;
        }

        /**
         * Sets the value of the drzavljanstvoRepublikeSrbije property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDrzavljanstvoRepublikeSrbije(String value) {
            this.drzavljanstvoRepublikeSrbije = value;
        }

        /**
         * Gets the value of the straniSaBroravkom property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStraniSaBroravkom() {
            return straniSaBroravkom;
        }

        /**
         * Sets the value of the straniSaBroravkom property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStraniSaBroravkom(String value) {
            this.straniSaBroravkom = value;
        }

        /**
         * Gets the value of the straniBezBoravka property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStraniBezBoravka() {
            return straniBezBoravka;
        }

        /**
         * Sets the value of the straniBezBoravka property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStraniBezBoravka(String value) {
            this.straniBezBoravka = value;
        }

    }


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
     *         &lt;element name="izabrane_vakcine">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://ftn.uns.ac.rs/interesovanje}TIzbor">
     *                 &lt;sequence>
     *                   &lt;element name="vakcina" type="{http://ftn.uns.ac.rs/interesovanje}TVakcina"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="bilo_sta" type="{http://ftn.uns.ac.rs/interesovanje}TIzbor"/>
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
        "izabraneVakcine",
        "biloSta"
    })
    public static class Vakcine {

        @XmlElement(name = "izabrane_vakcine", namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
        protected InteresovanjeZaVakcinisanje.Vakcine.IzabraneVakcine izabraneVakcine;
        @XmlElement(name = "bilo_sta", namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
        protected TIzbor biloSta;

        /**
         * Gets the value of the izabraneVakcine property.
         * 
         * @return
         *     possible object is
         *     {@link InteresovanjeZaVakcinisanje.Vakcine.IzabraneVakcine }
         *     
         */
        public InteresovanjeZaVakcinisanje.Vakcine.IzabraneVakcine getIzabraneVakcine() {
            return izabraneVakcine;
        }

        /**
         * Sets the value of the izabraneVakcine property.
         * 
         * @param value
         *     allowed object is
         *     {@link InteresovanjeZaVakcinisanje.Vakcine.IzabraneVakcine }
         *     
         */
        public void setIzabraneVakcine(InteresovanjeZaVakcinisanje.Vakcine.IzabraneVakcine value) {
            this.izabraneVakcine = value;
        }

        /**
         * Gets the value of the biloSta property.
         * 
         * @return
         *     possible object is
         *     {@link TIzbor }
         *     
         */
        public TIzbor getBiloSta() {
            return biloSta;
        }

        /**
         * Sets the value of the biloSta property.
         * 
         * @param value
         *     allowed object is
         *     {@link TIzbor }
         *     
         */
        public void setBiloSta(TIzbor value) {
            this.biloSta = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://ftn.uns.ac.rs/interesovanje}TIzbor">
         *       &lt;sequence>
         *         &lt;element name="vakcina" type="{http://ftn.uns.ac.rs/interesovanje}TVakcina"/>
         *       &lt;/sequence>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "vakcina"
        })
        public static class IzabraneVakcine
            extends TIzbor
        {

            @XmlElement(namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
            protected TVakcina vakcina;

            /**
             * Gets the value of the vakcina property.
             * 
             * @return
             *     possible object is
             *     {@link TVakcina }
             *     
             */
            public TVakcina getVakcina() {
                return vakcina;
            }

            /**
             * Sets the value of the vakcina property.
             * 
             * @param value
             *     allowed object is
             *     {@link TVakcina }
             *     
             */
            public void setVakcina(TVakcina value) {
                this.vakcina = value;
            }

        }

    }

}
