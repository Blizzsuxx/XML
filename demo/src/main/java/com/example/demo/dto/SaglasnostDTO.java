package com.example.demo.dto;

public class SaglasnostDTO {
    public String drzavljanstvo;
    public String jmbg;
    public String ime;
    public String prezime;
    public String imeRoditelja;
    public String pol;
    public String datumRodjenja;
    public String mestoRodjenja;
    public String adresa;
    public String mesto;
    public String mobilni;
    public String fiksni;
    public String eadresa;
    public String radniStatus;
    public String zanimanje;
    public String socijalnaZastita;
    public String saglasnost;
    public String izabranaVakcina;
    public String opstinaSocijale;

    public SaglasnostDTO(){

    }

    public SaglasnostDTO(String drzavljanstvo, String jmbg, String ime, String prezime, String imeRoditelja, String pol,
            String datumRodjenja, String mestoRodjenja, String adresa, String mesto, String mobilni, String fiksni,
            String eadresa, String radniStatus, String zanimanje, String socijalnaZastita, String saglasnost,
            String izabranaVakcina, String opstinaSocijale) {
        this.drzavljanstvo = drzavljanstvo;
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.imeRoditelja = imeRoditelja;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
        this.mestoRodjenja = mestoRodjenja;
        this.adresa = adresa;
        this.mesto = mesto;
        this.mobilni = mobilni;
        this.fiksni = fiksni;
        this.eadresa = eadresa;
        this.radniStatus = radniStatus;
        this.zanimanje = zanimanje;
        this.socijalnaZastita = socijalnaZastita;
        this.saglasnost = saglasnost;
        this.izabranaVakcina = izabranaVakcina;
        this.opstinaSocijale = opstinaSocijale;
    }

    @Override
    public String toString() {
        return "SaglasnostDTO [adresa=" + adresa + ", datumRodjenja=" + datumRodjenja + ", drzavljanstvo="
                + drzavljanstvo + ", eadresa=" + eadresa + ", fiksni=" + fiksni + ", ime=" + ime + ", imeRoditelja="
                + imeRoditelja + ", izabranaVakcina=" + izabranaVakcina + ", jmbg=" + jmbg + ", mesto=" + mesto
                + ", mestoRodjenja=" + mestoRodjenja + ", mobilni=" + mobilni + ", opstinaSocijale=" + opstinaSocijale
                + ", pol=" + pol + ", prezime=" + prezime + ", radniStatus=" + radniStatus + ", saglasnost="
                + saglasnost + ", socijalnaZastita=" + socijalnaZastita + ", zanimanje=" + zanimanje + "]";
    }


    
}
