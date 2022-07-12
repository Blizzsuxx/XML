package com.clerk.clerkb.model.saglasnost;

import com.clerk.clerkb.model.potvrdaOVakcinaciji.TVakcina;
import com.clerk.clerkb.model.zahtevZaSertifikat.TOsoba;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "drzavljanstvo",
        "osoba",
        "radniStatus",
        "zanimanje",
        "korisnikUstanoveSocZastite",
        "izjava",
        "potpis",
        "datum"
})
@XmlRootElement(name = "saglasnost_za_sprovodjenje_imunizacije", namespace = "http://ftn.uns.ac.rs/saglasnost")
public class SaglasnostZaSprovodjenjeImunizacije {

    @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo drzavljanstvo;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected TOsoba osoba;
    @XmlElement(name = "radni_status", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected SaglasnostZaSprovodjenjeImunizacije.RadniStatus radniStatus;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected SaglasnostZaSprovodjenjeImunizacije.Zanimanje zanimanje;
    @XmlElement(name = "korisnik_ustanove_soc_zastite", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected TIzbor korisnikUstanoveSocZastite;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected SaglasnostZaSprovodjenjeImunizacije.Izjava izjava;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    protected String potpis;
    @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;

    public SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public TOsoba getOsoba() {
        return osoba;
    }

    public void setOsoba(TOsoba osoba) {
        this.osoba = osoba;
    }

    public SaglasnostZaSprovodjenjeImunizacije.RadniStatus getRadniStatus() {
        return radniStatus;
    }

    public void setRadniStatus(SaglasnostZaSprovodjenjeImunizacije.RadniStatus radniStatus) {
        this.radniStatus = radniStatus;
    }

    public SaglasnostZaSprovodjenjeImunizacije.Zanimanje getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(SaglasnostZaSprovodjenjeImunizacije.Zanimanje zanimanje) {
        this.zanimanje = zanimanje;
    }

    public TIzbor getKorisnikUstanoveSocZastite() {
        return korisnikUstanoveSocZastite;
    }

    public void setKorisnikUstanoveSocZastite(TIzbor korisnikUstanoveSocZastite) {
        this.korisnikUstanoveSocZastite = korisnikUstanoveSocZastite;
    }

    public SaglasnostZaSprovodjenjeImunizacije.Izjava getIzjava() {
        return izjava;
    }

    public void setIzjava(SaglasnostZaSprovodjenjeImunizacije.Izjava izjava) {
        this.izjava = izjava;
    }

    public String getPotpis() {
        return potpis;
    }

    public void setPotpis(String potpis) {
        this.potpis = potpis;
    }

    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    public void setDatum(XMLGregorianCalendar datum) {
        this.datum = datum;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "republikaSrbija",
            "stranac"
    })
    public static class Drzavljanstvo {

        @XmlElement(name = "republika_srbija", namespace = "http://ftn.uns.ac.rs/saglasnost")
        protected SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo.RepublikaSrbija republikaSrbija;
        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost")
        protected SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo.Stranac stranac;

        /**
         * Gets the value of the republikaSrbija property.
         *
         * @return
         *     possible object is
         *     {@link SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo.RepublikaSrbija }
         *
         */
        public SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo.RepublikaSrbija getRepublikaSrbija() {
            return republikaSrbija;
        }

        /**
         * Sets the value of the republikaSrbija property.
         *
         * @param value
         *     allowed object is
         *     {@link SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo.RepublikaSrbija }
         *
         */
        public void setRepublikaSrbija(SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo.RepublikaSrbija value) {
            this.republikaSrbija = value;
        }

        /**
         * Gets the value of the stranac property.
         *
         * @return
         *     possible object is
         *     {@link SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo.Stranac }
         *
         */
        public SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo.Stranac getStranac() {
            return stranac;
        }

        /**
         * Sets the value of the stranac property.
         *
         * @param value
         *     allowed object is
         *     {@link SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo.Stranac }
         *
         */
        public void setStranac(SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo.Stranac value) {
            this.stranac = value;
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
         *         &lt;element name="jmbg">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;pattern value="[0-9]{13,13}"/>
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
                "jmbg"
        })
        public static class RepublikaSrbija {

            @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
            protected String jmbg;

            /**
             * Gets the value of the jmbg property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getJmbg() {
                return jmbg;
            }

            /**
             * Sets the value of the jmbg property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setJmbg(String value) {
                this.jmbg = value;
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
         *         &lt;element name="naziv_stranog_drzavljanstva" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="br_pasosa_ili_ebs">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;pattern value="^[0-9]*$"/>
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
                "nazivStranogDrzavljanstva",
                "brPasosaIliEbs"
        })
        public static class Stranac {

            @XmlElement(name = "naziv_stranog_drzavljanstva", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
            protected String nazivStranogDrzavljanstva;
            @XmlElement(name = "br_pasosa_ili_ebs", namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
            protected String brPasosaIliEbs;

            /**
             * Gets the value of the nazivStranogDrzavljanstva property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getNazivStranogDrzavljanstva() {
                return nazivStranogDrzavljanstva;
            }

            /**
             * Sets the value of the nazivStranogDrzavljanstva property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setNazivStranogDrzavljanstva(String value) {
                this.nazivStranogDrzavljanstva = value;
            }

            /**
             * Gets the value of the brPasosaIliEbs property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getBrPasosaIliEbs() {
                return brPasosaIliEbs;
            }

            /**
             * Sets the value of the brPasosaIliEbs property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setBrPasosaIliEbs(String value) {
                this.brPasosaIliEbs = value;
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
     *         &lt;element name="saglasnost" type="{http://ftn.uns.ac.rs/saglasnost}TIzbor"/>
     *         &lt;element name="vakcina" type="{http://ftn.uns.ac.rs/saglasnost}TVakcina"/>
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
            "saglasnost",
            "vakcina"
    })
    public static class Izjava {

        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
        protected TIzbor saglasnost;
        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost", required = true)
        protected TVakcina vakcina;

        /**
         * Gets the value of the saglasnost property.
         *
         * @return
         *     possible object is
         *     {@link TIzbor }
         *
         */
        public TIzbor getSaglasnost() {
            return saglasnost;
        }

        /**
         * Sets the value of the saglasnost property.
         *
         * @param value
         *     allowed object is
         *     {@link TIzbor }
         *
         */
        public void setSaglasnost(TIzbor value) {
            this.saglasnost = value;
        }

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
     *         &lt;element name="zaposlen" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="nezaposlen" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="penzioner" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ucenik" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="student" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="dete" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "zaposlen",
            "nezaposlen",
            "penzioner",
            "ucenik",
            "student",
            "dete"
    })
    public static class RadniStatus {

        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost")
        protected String zaposlen;
        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost")
        protected String nezaposlen;
        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost")
        protected String penzioner;
        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost")
        protected String ucenik;
        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost")
        protected String student;
        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost")
        protected String dete;

        /**
         * Gets the value of the zaposlen property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getZaposlen() {
            return zaposlen;
        }

        /**
         * Sets the value of the zaposlen property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setZaposlen(String value) {
            this.zaposlen = value;
        }

        /**
         * Gets the value of the nezaposlen property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getNezaposlen() {
            return nezaposlen;
        }

        /**
         * Sets the value of the nezaposlen property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setNezaposlen(String value) {
            this.nezaposlen = value;
        }

        /**
         * Gets the value of the penzioner property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPenzioner() {
            return penzioner;
        }

        /**
         * Sets the value of the penzioner property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPenzioner(String value) {
            this.penzioner = value;
        }

        /**
         * Gets the value of the ucenik property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getUcenik() {
            return ucenik;
        }

        /**
         * Sets the value of the ucenik property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setUcenik(String value) {
            this.ucenik = value;
        }

        /**
         * Gets the value of the student property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getStudent() {
            return student;
        }

        /**
         * Sets the value of the student property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setStudent(String value) {
            this.student = value;
        }

        /**
         * Gets the value of the dete property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDete() {
            return dete;
        }

        /**
         * Sets the value of the dete property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDete(String value) {
            this.dete = value;
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
     *       &lt;choice>
     *         &lt;element name="zdravstvena_zastita" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="socijalna_zastita" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="prosveta" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="mup" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="vojska" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="drugo" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "zdravstvenaZastita",
            "socijalnaZastita",
            "prosveta",
            "mup",
            "vojska",
            "drugo"
    })
    public static class Zanimanje {

        @XmlElement(name = "zdravstvena_zastita", namespace = "http://ftn.uns.ac.rs/saglasnost")
        protected String zdravstvenaZastita;
        @XmlElement(name = "socijalna_zastita", namespace = "http://ftn.uns.ac.rs/saglasnost")
        protected String socijalnaZastita;
        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost")
        protected String prosveta;
        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost")
        protected String mup;
        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost")
        protected String vojska;
        @XmlElement(namespace = "http://ftn.uns.ac.rs/saglasnost")
        protected String drugo;

        /**
         * Gets the value of the zdravstvenaZastita property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getZdravstvenaZastita() {
            return zdravstvenaZastita;
        }

        /**
         * Sets the value of the zdravstvenaZastita property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setZdravstvenaZastita(String value) {
            this.zdravstvenaZastita = value;
        }

        /**
         * Gets the value of the socijalnaZastita property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getSocijalnaZastita() {
            return socijalnaZastita;
        }

        /**
         * Sets the value of the socijalnaZastita property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setSocijalnaZastita(String value) {
            this.socijalnaZastita = value;
        }

        /**
         * Gets the value of the prosveta property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getProsveta() {
            return prosveta;
        }

        /**
         * Sets the value of the prosveta property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setProsveta(String value) {
            this.prosveta = value;
        }

        /**
         * Gets the value of the mup property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getMup() {
            return mup;
        }

        /**
         * Sets the value of the mup property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setMup(String value) {
            this.mup = value;
        }

        /**
         * Gets the value of the vojska property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getVojska() {
            return vojska;
        }

        /**
         * Sets the value of the vojska property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setVojska(String value) {
            this.vojska = value;
        }

        /**
         * Gets the value of the drugo property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDrugo() {
            return drugo;
        }

        /**
         * Sets the value of the drugo property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDrugo(String value) {
            this.drugo = value;
        }

    }
}
