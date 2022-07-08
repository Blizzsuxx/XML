package com.clerk.clerkb.model.izvestajOImunizaciji;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

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

    public IzvestajSeOdnosiNa getIzvestajSeOdnosiNa() {
        return izvestajSeOdnosiNa;
    }

    public void setIzvestajSeOdnosiNa(IzvestajSeOdnosiNa izvestajSeOdnosiNa) {
        this.izvestajSeOdnosiNa = izvestajSeOdnosiNa;
    }

    public IzvestajOImunizaciji.Podaci getPodaci() {
        return podaci;
    }

    public void setPodaci(IzvestajOImunizaciji.Podaci podaci) {
        this.podaci = podaci;
    }

    public long getDatoJeVakcina() {
        return datoJeVakcina;
    }

    public void setDatoJeVakcina(long datoJeVakcina) {
        this.datoJeVakcina = datoJeVakcina;
    }

    public IzvestajOImunizaciji.PrimljeneDoze getPrimljeneDoze() {
        return primljeneDoze;
    }

    public void setPrimljeneDoze(IzvestajOImunizaciji.PrimljeneDoze primljeneDoze) {
        this.primljeneDoze = primljeneDoze;
    }

    public IzvestajOImunizaciji.Proizvodjaci getProizvodjaci() {
        return proizvodjaci;
    }

    public void setProizvodjaci(IzvestajOImunizaciji.Proizvodjaci proizvodjaci) {
        this.proizvodjaci = proizvodjaci;
    }

    public XMLGregorianCalendar getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(XMLGregorianCalendar datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public String getPotpis() {
        return potpis;
    }

    public void setPotpis(String potpis) {
        this.potpis = potpis;
    }

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

        public XMLGregorianCalendar getDatumOd() {
            return datumOd;
        }

        public void setDatumOd(XMLGregorianCalendar datumOd) {
            this.datumOd = datumOd;
        }

        public XMLGregorianCalendar getDatumDo() {
            return datumDo;
        }

        public void setDatumDo(XMLGregorianCalendar datumDo) {
            this.datumDo = datumDo;
        }
    }

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

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "podneto"
        })
        public static class Imunizacija {

            @XmlElement(namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji")
            protected long podneto;

            public long getPodneto() {
                return podneto;
            }

            public void setPodneto(long value) {
                this.podneto = value;
            }

        }

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

            public long getPodneto() {
                return podneto;
            }

            public void setPodneto(long podneto) {
                this.podneto = podneto;
            }

            public long getPrimljeno() {
                return primljeno;
            }

            public void setPrimljeno(long primljeno) {
                this.primljeno = primljeno;
            }
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "doza"
    })
    public static class PrimljeneDoze {

        @XmlElement(namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
        protected List<TDoza> doza;

        public List<TDoza> getDoza() {
            return doza;
        }

        public void setDoza(List<TDoza> doza) {
            this.doza = doza;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "proizvodjac"
    })
    public static class Proizvodjaci {

        @XmlElement(namespace = "http:/www.ftn.uns.ac.rs/izvestaj_o_imunizaciji", required = true)
        protected List<TProizvodjac> proizvodjac;

        public List<TProizvodjac> getProizvodjac() {
            return proizvodjac;
        }

        public void setProizvodjac(List<TProizvodjac> proizvodjac) {
            this.proizvodjac = proizvodjac;
        }
    }

}

