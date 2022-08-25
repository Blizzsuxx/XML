
package com.clerk.clerkb.model.izvestajOImunizaciji;

import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element name="izvestaj_se_odnosi_na">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="datum_od" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="datum_do" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="podaci">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="imunizacija">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="podneto" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="zeleni_sertifikat">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="podneto" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                             &lt;element name="primljeno" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="dato_je_vakcina" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="primljene_doze">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="doza" type="{http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji}TDoza" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="proizvodjaci">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="proizvodjac" type="{http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji}TProizvodjac" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="datum_izdavanja" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
    "izvestajSeOdnosiNa",
    "podaci",
    "datoJeVakcina",
    "primljeneDoze",
    "proizvodjaci",
    "datumIzdavanja",
    "potpis"
})
@XmlRootElement(name = "izvestaj_o_imunizaciji", namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji")
public class IzvestajOImunizaciji {

    @XmlElement(name = "izvestaj_se_odnosi_na", namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
    protected IzvestajOImunizaciji.IzvestajSeOdnosiNa izvestajSeOdnosiNa;
    @XmlElement(namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
    protected IzvestajOImunizaciji.Podaci podaci;
    @XmlElement(name = "dato_je_vakcina", namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji")
    protected long datoJeVakcina;
    @XmlElement(name = "primljene_doze", namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
    protected IzvestajOImunizaciji.PrimljeneDoze primljeneDoze;
    @XmlElement(namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
    protected IzvestajOImunizaciji.Proizvodjaci proizvodjaci;
    @XmlElement(name = "datum_izdavanja", namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumIzdavanja;
    @XmlElement(namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
    protected String potpis;

    /**
     * Gets the value of the izvestajSeOdnosiNa property.
     * 
     * @return
     *     possible object is
     *     {@link IzvestajOImunizaciji.IzvestajSeOdnosiNa }
     *     
     */
    public IzvestajOImunizaciji.IzvestajSeOdnosiNa getIzvestajSeOdnosiNa() {
        return izvestajSeOdnosiNa;
    }

    /**
     * Sets the value of the izvestajSeOdnosiNa property.
     * 
     * @param value
     *     allowed object is
     *     {@link IzvestajOImunizaciji.IzvestajSeOdnosiNa }
     *     
     */
    public void setIzvestajSeOdnosiNa(IzvestajOImunizaciji.IzvestajSeOdnosiNa value) {
        this.izvestajSeOdnosiNa = value;
    }

    /**
     * Gets the value of the podaci property.
     * 
     * @return
     *     possible object is
     *     {@link IzvestajOImunizaciji.Podaci }
     *     
     */
    public IzvestajOImunizaciji.Podaci getPodaci() {
        return podaci;
    }

    /**
     * Sets the value of the podaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link IzvestajOImunizaciji.Podaci }
     *     
     */
    public void setPodaci(IzvestajOImunizaciji.Podaci value) {
        this.podaci = value;
    }

    /**
     * Gets the value of the datoJeVakcina property.
     * 
     */
    public long getDatoJeVakcina() {
        return datoJeVakcina;
    }

    /**
     * Sets the value of the datoJeVakcina property.
     * 
     */
    public void setDatoJeVakcina(long value) {
        this.datoJeVakcina = value;
    }

    /**
     * Gets the value of the primljeneDoze property.
     * 
     * @return
     *     possible object is
     *     {@link IzvestajOImunizaciji.PrimljeneDoze }
     *     
     */
    public IzvestajOImunizaciji.PrimljeneDoze getPrimljeneDoze() {
        return primljeneDoze;
    }

    /**
     * Sets the value of the primljeneDoze property.
     * 
     * @param value
     *     allowed object is
     *     {@link IzvestajOImunizaciji.PrimljeneDoze }
     *     
     */
    public void setPrimljeneDoze(IzvestajOImunizaciji.PrimljeneDoze value) {
        this.primljeneDoze = value;
    }

    /**
     * Gets the value of the proizvodjaci property.
     * 
     * @return
     *     possible object is
     *     {@link IzvestajOImunizaciji.Proizvodjaci }
     *     
     */
    public IzvestajOImunizaciji.Proizvodjaci getProizvodjaci() {
        return proizvodjaci;
    }

    /**
     * Sets the value of the proizvodjaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link IzvestajOImunizaciji.Proizvodjaci }
     *     
     */
    public void setProizvodjaci(IzvestajOImunizaciji.Proizvodjaci value) {
        this.proizvodjaci = value;
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
     *       &lt;sequence>
     *         &lt;element name="datum_od" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="datum_do" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
        "datumOd",
        "datumDo"
    })
    public static class IzvestajSeOdnosiNa {

        @XmlElement(name = "datum_od", namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datumOd;
        @XmlElement(name = "datum_do", namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datumDo;

        /**
         * Gets the value of the datumOd property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatumOd() {
            return datumOd;
        }

        /**
         * Sets the value of the datumOd property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumOd(XMLGregorianCalendar value) {
            this.datumOd = value;
        }

        /**
         * Gets the value of the datumDo property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatumDo() {
            return datumDo;
        }

        /**
         * Sets the value of the datumDo property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumDo(XMLGregorianCalendar value) {
            this.datumDo = value;
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
     *         &lt;element name="imunizacija">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="podneto" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="zeleni_sertifikat">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="podneto" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                   &lt;element name="primljeno" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
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
    @XmlType(name = "", propOrder = {
        "imunizacija",
        "zeleniSertifikat"
    })
    public static class Podaci {

        @XmlElement(namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
        protected IzvestajOImunizaciji.Podaci.Imunizacija imunizacija;
        @XmlElement(name = "zeleni_sertifikat", namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
        protected IzvestajOImunizaciji.Podaci.ZeleniSertifikat zeleniSertifikat;

        /**
         * Gets the value of the imunizacija property.
         * 
         * @return
         *     possible object is
         *     {@link IzvestajOImunizaciji.Podaci.Imunizacija }
         *     
         */
        public IzvestajOImunizaciji.Podaci.Imunizacija getImunizacija() {
            return imunizacija;
        }

        /**
         * Sets the value of the imunizacija property.
         * 
         * @param value
         *     allowed object is
         *     {@link IzvestajOImunizaciji.Podaci.Imunizacija }
         *     
         */
        public void setImunizacija(IzvestajOImunizaciji.Podaci.Imunizacija value) {
            this.imunizacija = value;
        }

        /**
         * Gets the value of the zeleniSertifikat property.
         * 
         * @return
         *     possible object is
         *     {@link IzvestajOImunizaciji.Podaci.ZeleniSertifikat }
         *     
         */
        public IzvestajOImunizaciji.Podaci.ZeleniSertifikat getZeleniSertifikat() {
            return zeleniSertifikat;
        }

        /**
         * Sets the value of the zeleniSertifikat property.
         * 
         * @param value
         *     allowed object is
         *     {@link IzvestajOImunizaciji.Podaci.ZeleniSertifikat }
         *     
         */
        public void setZeleniSertifikat(IzvestajOImunizaciji.Podaci.ZeleniSertifikat value) {
            this.zeleniSertifikat = value;
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
         *         &lt;element name="podneto" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
            "podneto"
        })
        public static class Imunizacija {

            @XmlElement(namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji")
            protected long podneto;

            /**
             * Gets the value of the podneto property.
             * 
             */
            public long getPodneto() {
                return podneto;
            }

            /**
             * Sets the value of the podneto property.
             * 
             */
            public void setPodneto(long value) {
                this.podneto = value;
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
         *         &lt;element name="podneto" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *         &lt;element name="primljeno" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
            "podneto",
            "primljeno"
        })
        public static class ZeleniSertifikat {

            @XmlElement(namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji")
            protected long podneto;
            @XmlElement(namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji")
            protected long primljeno;

            /**
             * Gets the value of the podneto property.
             * 
             */
            public long getPodneto() {
                return podneto;
            }

            /**
             * Sets the value of the podneto property.
             * 
             */
            public void setPodneto(long value) {
                this.podneto = value;
            }

            /**
             * Gets the value of the primljeno property.
             * 
             */
            public long getPrimljeno() {
                return primljeno;
            }

            /**
             * Sets the value of the primljeno property.
             * 
             */
            public void setPrimljeno(long value) {
                this.primljeno = value;
            }

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
     *         &lt;element name="doza" type="{http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji}TDoza" maxOccurs="unbounded"/>
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
        "doza"
    })
    public static class PrimljeneDoze {

        @XmlElement(namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
        protected List<TDoza> doza;

        /**
         * Gets the value of the doza property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the doza property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDoza().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TDoza }
         * 
         * 
         */
        public List<TDoza> getDoza() {
            if (doza == null) {
                doza = new ArrayList<TDoza>();
            }
            return this.doza;
        }

        public void setDoza(List<TDoza> doza) {
            this.doza = doza;
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
     *         &lt;element name="proizvodjac" type="{http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji}TProizvodjac" maxOccurs="unbounded"/>
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
        "proizvodjac"
    })
    public static class Proizvodjaci {

        @XmlElement(namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
        protected List<TProizvodjac> proizvodjac;



        /**
         * Gets the value of the proizvodjac property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the proizvodjac property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProizvodjac().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TProizvodjac }
         * 
         * 
         */
        public List<TProizvodjac> getProizvodjac() {
            if (proizvodjac == null) {
                proizvodjac = new ArrayList<TProizvodjac>();
            }
            return this.proizvodjac;
        }


        public void setProizvodjac(List<TProizvodjac> proizvodjac) {
            this.proizvodjac = proizvodjac;
        }
    }

}
