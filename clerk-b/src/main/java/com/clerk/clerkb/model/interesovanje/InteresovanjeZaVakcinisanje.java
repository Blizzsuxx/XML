package com.clerk.clerkb.model.interesovanje;

import com.clerk.clerkb.model.potvrdaOVakcinaciji.TVakcina;
import com.clerk.clerkb.model.saglasnost.TIzbor;
import com.clerk.clerkb.model.zahtevZaSertifikat.TOsoba;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "drzavljanstvo",
        "osoba",
        "lokacija",
        "vakcine",
        "davalacKrvi",
        "dan",
        "godina",
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
    @XmlElement(namespace = "http://ftn.uns.ac.rs/interesovanje", required = true)
    protected String godina;

    public InteresovanjeZaVakcinisanje.Drzavljanstvo getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(InteresovanjeZaVakcinisanje.Drzavljanstvo drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public TOsoba getOsoba() {
        return osoba;
    }

    public void setOsoba(TOsoba osoba) {
        this.osoba = osoba;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public InteresovanjeZaVakcinisanje.Vakcine getVakcine() {
        return vakcine;
    }

    public void setVakcine(InteresovanjeZaVakcinisanje.Vakcine vakcine) {
        this.vakcine = vakcine;
    }

    public TIzbor getDavalacKrvi() {
        return davalacKrvi;
    }

    public void setDavalacKrvi(TIzbor davalacKrvi) {
        this.davalacKrvi = davalacKrvi;
    }

    public XMLGregorianCalendar getDan() {
        return dan;
    }

    public void setDan(XMLGregorianCalendar dan) {
        this.dan = dan;
    }

    public String getPotpis() {
        return potpis;
    }

    public void setPotpis(String potpis) {
        this.potpis = potpis;
    }

    public String getGodina() {
        return godina;
    }

    public void setGodina(String godina) {
        this.godina = godina;
    }

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

        public String getDrzavljanstvoRepublikeSrbije() {
            return drzavljanstvoRepublikeSrbije;
        }

        public void setDrzavljanstvoRepublikeSrbije(String drzavljanstvoRepublikeSrbije) {
            this.drzavljanstvoRepublikeSrbije = drzavljanstvoRepublikeSrbije;
        }

        public String getStraniSaBroravkom() {
            return straniSaBroravkom;
        }

        public void setStraniSaBroravkom(String straniSaBroravkom) {
            this.straniSaBroravkom = straniSaBroravkom;
        }

        public String getStraniBezBoravka() {
            return straniBezBoravka;
        }

        public void setStraniBezBoravka(String straniBezBoravka) {
            this.straniBezBoravka = straniBezBoravka;
        }
    }

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

        public Vakcine.IzabraneVakcine getIzabraneVakcine() {
            return izabraneVakcine;
        }

        public void setIzabraneVakcine(Vakcine.IzabraneVakcine izabraneVakcine) {
            this.izabraneVakcine = izabraneVakcine;
        }

        public TIzbor getBiloSta() {
            return biloSta;
        }

        public void setBiloSta(TIzbor biloSta) {
            this.biloSta = biloSta;
        }

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
