package com.example.demo.dto;

public class ZahtevZaSertifikatDTO {


    public String jmbg;
    public String ime;
    public String prezime;
    public String pol;
    public String datumRodjenja;
    public String mesto;
    public String razlog;
    public String brojPasossa;
    @Override
    public String toString() {
        return "ZahtevZaSertifikatDTO [brojPasossa=" + brojPasossa + ", datumRodjenja=" + datumRodjenja + ", ime=" + ime
                + ", jmbg=" + jmbg + ", mesto=" + mesto + ", pol=" + pol + ", prezime=" + prezime + ", razlog=" + razlog
                + "]";
    }
    
}
