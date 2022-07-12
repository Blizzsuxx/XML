package com.clerk.clerkb.model.saglasnost;

import com.clerk.clerkb.model.potvrdaOVakcinaciji.TVakcina;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "zdravstvenaUstanova",
        "vakcinacijskiPunkt",
        "imePrezimeFaksimilBrtel",
        "tabela"
})
public class EvidencijaOVakcinaciji {

    @XmlElement(name = "zdravstvena_ustanova", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected String zdravstvenaUstanova;
    @XmlElement(name = "vakcinacijski_punkt", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected String vakcinacijskiPunkt;
    @XmlElement(name = "ime_prezime_faksimil_brtel", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected EvidencijaOVakcinaciji.ImePrezimeFaksimilBrtel imePrezimeFaksimilBrtel;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected EvidencijaOVakcinaciji.Tabela tabela;

    /**
     * Gets the value of the zdravstvenaUstanova property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getZdravstvenaUstanova() {
        return zdravstvenaUstanova;
    }

    /**
     * Sets the value of the zdravstvenaUstanova property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setZdravstvenaUstanova(String value) {
        this.zdravstvenaUstanova = value;
    }

    /**
     * Gets the value of the vakcinacijskiPunkt property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVakcinacijskiPunkt() {
        return vakcinacijskiPunkt;
    }

    /**
     * Sets the value of the vakcinacijskiPunkt property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVakcinacijskiPunkt(String value) {
        this.vakcinacijskiPunkt = value;
    }

    /**
     * Gets the value of the imePrezimeFaksimilBrtel property.
     *
     * @return
     *     possible object is
     *     {@link EvidencijaOVakcinaciji.ImePrezimeFaksimilBrtel }
     *
     */
    public EvidencijaOVakcinaciji.ImePrezimeFaksimilBrtel getImePrezimeFaksimilBrtel() {
        return imePrezimeFaksimilBrtel;
    }

    /**
     * Sets the value of the imePrezimeFaksimilBrtel property.
     *
     * @param value
     *     allowed object is
     *     {@link EvidencijaOVakcinaciji.ImePrezimeFaksimilBrtel }
     *
     */
    public void setImePrezimeFaksimilBrtel(EvidencijaOVakcinaciji.ImePrezimeFaksimilBrtel value) {
        this.imePrezimeFaksimilBrtel = value;
    }

    /**
     * Gets the value of the tabela property.
     *
     * @return
     *     possible object is
     *     {@link EvidencijaOVakcinaciji.Tabela }
     *
     */
    public EvidencijaOVakcinaciji.Tabela getTabela() {
        return tabela;
    }

    /**
     * Sets the value of the tabela property.
     *
     * @param value
     *     allowed object is
     *     {@link EvidencijaOVakcinaciji.Tabela }
     *
     */
    public void setTabela(EvidencijaOVakcinaciji.Tabela value) {
        this.tabela = value;
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
     *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="faksimil">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="[0-9]+"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="brtel">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="[0-9]{10,10}"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
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
            "ime",
            "prezime",
            "faksimil",
            "brtel"
    })
    public static class ImePrezimeFaksimilBrtel {

        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
        protected String ime;
        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
        protected String prezime;
        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
        protected String faksimil;
        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
        protected String brtel;

        /**
         * Gets the value of the ime property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getIme() {
            return ime;
        }

        /**
         * Sets the value of the ime property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setIme(String value) {
            this.ime = value;
        }

        /**
         * Gets the value of the prezime property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPrezime() {
            return prezime;
        }

        /**
         * Sets the value of the prezime property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPrezime(String value) {
            this.prezime = value;
        }

        /**
         * Gets the value of the faksimil property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getFaksimil() {
            return faksimil;
        }

        /**
         * Sets the value of the faksimil property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setFaksimil(String value) {
            this.faksimil = value;
        }

        /**
         * Gets the value of the brtel property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getBrtel() {
            return brtel;
        }

        /**
         * Sets the value of the brtel property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setBrtel(String value) {
            this.brtel = value;
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
     *         &lt;element name="element" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="vakcina" type="{http://ftn.uns.ac.rs/saglasnost}TVakcina"/>
     *                   &lt;element name="datum_davanja" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="nacin_davanja" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ekstremitet">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;choice>
     *                             &lt;element name="dr" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="lv" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/choice>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="serija" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                   &lt;element name="proizvodjac" type="{http://ftn.uns.ac.rs/saglasnost}TVakcina"/>
     *                   &lt;element name="nezeljena_reakcija" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;element name="potpis_lekara" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="privremene_kontradikcije">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="dijagnoza" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="trajne_kontradikcije" type="{http://ftn.uns.ac.rs/saglasnost}TIzbor"/>
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
            "element",
            "privremeneKontradikcije",
            "trajneKontradikcije"
    })
    public static class Tabela {

        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
        protected List<EvidencijaOVakcinaciji.Tabela.Element> element;
        @XmlElement(name = "privremene_kontradikcije", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
        protected EvidencijaOVakcinaciji.Tabela.PrivremeneKontradikcije privremeneKontradikcije;
        @XmlElement(name = "trajne_kontradikcije", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
        protected TIzbor trajneKontradikcije;

        /**
         * Gets the value of the element property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the element property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getElement().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EvidencijaOVakcinaciji.Tabela.Element }
         *
         *
         */
        public List<EvidencijaOVakcinaciji.Tabela.Element> getElement() {
            if (element == null) {
                element = new ArrayList<Element>();
            }
            return this.element;
        }

        /**
         * Gets the value of the privremeneKontradikcije property.
         *
         * @return
         *     possible object is
         *     {@link EvidencijaOVakcinaciji.Tabela.PrivremeneKontradikcije }
         *
         */
        public EvidencijaOVakcinaciji.Tabela.PrivremeneKontradikcije getPrivremeneKontradikcije() {
            return privremeneKontradikcije;
        }

        /**
         * Sets the value of the privremeneKontradikcije property.
         *
         * @param value
         *     allowed object is
         *     {@link EvidencijaOVakcinaciji.Tabela.PrivremeneKontradikcije }
         *
         */
        public void setPrivremeneKontradikcije(EvidencijaOVakcinaciji.Tabela.PrivremeneKontradikcije value) {
            this.privremeneKontradikcije = value;
        }

        /**
         * Gets the value of the trajneKontradikcije property.
         *
         * @return
         *     possible object is
         *     {@link TIzbor }
         *
         */
        public TIzbor getTrajneKontradikcije() {
            return trajneKontradikcije;
        }

        /**
         * Sets the value of the trajneKontradikcije property.
         *
         * @param value
         *     allowed object is
         *     {@link TIzbor }
         *
         */
        public void setTrajneKontradikcije(TIzbor value) {
            this.trajneKontradikcije = value;
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
         *         &lt;element name="vakcina" type="{http://ftn.uns.ac.rs/saglasnost}TVakcina"/>
         *         &lt;element name="datum_davanja" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="nacin_davanja" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ekstremitet">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;choice>
         *                   &lt;element name="dr" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="lv" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/choice>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="serija" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *         &lt;element name="proizvodjac" type="{http://ftn.uns.ac.rs/saglasnost}TVakcina"/>
         *         &lt;element name="nezeljena_reakcija" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *         &lt;element name="potpis_lekara" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
                "vakcina",
                "datumDavanja",
                "nacinDavanja",
                "ekstremitet",
                "serija",
                "proizvodjac",
                "nezeljenaReakcija",
                "potpisLekara"
        })
        public static class Element {

            @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
            protected TVakcina vakcina;
            @XmlElement(name = "datum_davanja", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar datumDavanja;
            @XmlElement(name = "nacin_davanja", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
            protected String nacinDavanja;
            @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
            protected EvidencijaOVakcinaciji.Tabela.Element.Ekstremitet ekstremitet;
            @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost")
            protected long serija;
            @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
            protected TVakcina proizvodjac;
            @XmlElement(name = "nezeljena_reakcija", namespace = "http://ftn.uns.ac.rs/saglasnost")
            protected boolean nezeljenaReakcija;
            @XmlElement(name = "potpis_lekara", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
            protected String potpisLekara;

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

            /**
             * Gets the value of the datumDavanja property.
             *
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public XMLGregorianCalendar getDatumDavanja() {
                return datumDavanja;
            }

            /**
             * Sets the value of the datumDavanja property.
             *
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public void setDatumDavanja(XMLGregorianCalendar value) {
                this.datumDavanja = value;
            }

            /**
             * Gets the value of the nacinDavanja property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getNacinDavanja() {
                return nacinDavanja;
            }

            /**
             * Sets the value of the nacinDavanja property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setNacinDavanja(String value) {
                this.nacinDavanja = value;
            }

            /**
             * Gets the value of the ekstremitet property.
             *
             * @return
             *     possible object is
             *     {@link EvidencijaOVakcinaciji.Tabela.Element.Ekstremitet }
             *
             */
            public EvidencijaOVakcinaciji.Tabela.Element.Ekstremitet getEkstremitet() {
                return ekstremitet;
            }

            /**
             * Sets the value of the ekstremitet property.
             *
             * @param value
             *     allowed object is
             *     {@link EvidencijaOVakcinaciji.Tabela.Element.Ekstremitet }
             *
             */
            public void setEkstremitet(EvidencijaOVakcinaciji.Tabela.Element.Ekstremitet value) {
                this.ekstremitet = value;
            }

            /**
             * Gets the value of the serija property.
             *
             */
            public long getSerija() {
                return serija;
            }

            /**
             * Sets the value of the serija property.
             *
             */
            public void setSerija(long value) {
                this.serija = value;
            }

            /**
             * Gets the value of the proizvodjac property.
             *
             * @return
             *     possible object is
             *     {@link TVakcina }
             *
             */
            public TVakcina getProizvodjac() {
                return proizvodjac;
            }

            /**
             * Sets the value of the proizvodjac property.
             *
             * @param value
             *     allowed object is
             *     {@link TVakcina }
             *
             */
            public void setProizvodjac(TVakcina value) {
                this.proizvodjac = value;
            }

            /**
             * Gets the value of the nezeljenaReakcija property.
             *
             */
            public boolean isNezeljenaReakcija() {
                return nezeljenaReakcija;
            }

            /**
             * Sets the value of the nezeljenaReakcija property.
             *
             */
            public void setNezeljenaReakcija(boolean value) {
                this.nezeljenaReakcija = value;
            }

            /**
             * Gets the value of the potpisLekara property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getPotpisLekara() {
                return potpisLekara;
            }

            /**
             * Sets the value of the potpisLekara property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setPotpisLekara(String value) {
                this.potpisLekara = value;
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
             *         &lt;element name="dr" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="lv" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
                    "dr",
                    "lv"
            })
            public static class Ekstremitet {

                @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost")
                protected String dr;
                @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost")
                protected String lv;

                /**
                 * Gets the value of the dr property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getDr() {
                    return dr;
                }

                /**
                 * Sets the value of the dr property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setDr(String value) {
                    this.dr = value;
                }

                /**
                 * Gets the value of the lv property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getLv() {
                    return lv;
                }

                /**
                 * Sets the value of the lv property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setLv(String value) {
                    this.lv = value;
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
         *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="dijagnoza" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
                "datum",
                "dijagnoza"
        })
        public static class PrivremeneKontradikcije {

            @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar datum;
            @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
            protected String dijagnoza;

            /**
             * Gets the value of the datum property.
             *
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public XMLGregorianCalendar getDatum() {
                return datum;
            }

            /**
             * Sets the value of the datum property.
             *
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public void setDatum(XMLGregorianCalendar value) {
                this.datum = value;
            }

            /**
             * Gets the value of the dijagnoza property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getDijagnoza() {
                return dijagnoza;
            }

            /**
             * Sets the value of the dijagnoza property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setDijagnoza(String value) {
                this.dijagnoza = value;
            }

        }

    }
}
