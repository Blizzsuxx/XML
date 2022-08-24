package com.clerk.clerkb.dto;

public class Kolona {
    

    public String datumVakcine;
    public String ekstremitet;
    public String serija;
    public String proizvodjac;
    public String nezeljenaReakcija;
    public String potpisLekara;
    public String nazivVakcine;
    public Kolona(String datumVakcine, String ekstremitet, String serija, String proizvodjac, String nezeljenaReakcija,
            String potpisLekara, String nazivVakcine) {
        this.datumVakcine = datumVakcine;
        this.ekstremitet = ekstremitet;
        this.serija = serija;
        this.proizvodjac = proizvodjac;
        this.nezeljenaReakcija = nezeljenaReakcija;
        this.potpisLekara = potpisLekara;
        this.nazivVakcine = nazivVakcine;
    }
    public String getDatumVakcine() {
        return datumVakcine;
    }
    public void setDatumVakcine(String datumVakcine) {
        this.datumVakcine = datumVakcine;
    }
    public String getEkstremitet() {
        return ekstremitet;
    }
    public void setEkstremitet(String ekstremitet) {
        this.ekstremitet = ekstremitet;
    }
    public String getSerija() {
        return serija;
    }
    public void setSerija(String serija) {
        this.serija = serija;
    }
    public String getProizvodjac() {
        return proizvodjac;
    }
    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }
    public String getNezeljenaReakcija() {
        return nezeljenaReakcija;
    }
    public void setNezeljenaReakcija(String nezeljenaReakcija) {
        this.nezeljenaReakcija = nezeljenaReakcija;
    }
    public String getPotpisLekara() {
        return potpisLekara;
    }
    public void setPotpisLekara(String potpisLekara) {
        this.potpisLekara = potpisLekara;
    }
    public String getNazivVakcine() {
        return nazivVakcine;
    }
    public void setNazivVakcine(String nazivVakcine) {
        this.nazivVakcine = nazivVakcine;
    }
    
        


}
