package com.clerk.clerkb.dto;

import java.util.ArrayList;

public class EvidencijaDTO {

public String selectedJmbg;
public String institution;
public String name;
public String lastname;
public String punkt;
public String faksimil;
public String telephone;
public String privremeneKontradikcije;
public String privremeneKontradikcijeDatum;
public Boolean trajneKontradikcije;
public ArrayList<Kolona> tabela;
public EvidencijaDTO(String selectedJmbg, String institution, String name, String lastname, String punkt,
        String faksimil, String telephone, String privremeneKontradikcije, String privremeneKontradikcijeDatum,
        Boolean trajneKontradikcije, ArrayList<Kolona> tabela) {
    this.selectedJmbg = selectedJmbg;
    this.institution = institution;
    this.name = name;
    this.lastname = lastname;
    this.punkt = punkt;
    this.faksimil = faksimil;
    this.telephone = telephone;
    this.privremeneKontradikcije = privremeneKontradikcije;
    this.privremeneKontradikcijeDatum = privremeneKontradikcijeDatum;
    this.trajneKontradikcije = trajneKontradikcije;
    this.tabela = tabela;
}
public String getSelectedJmbg() {
    return selectedJmbg;
}
public void setSelectedJmbg(String selectedJmbg) {
    this.selectedJmbg = selectedJmbg;
}
public String getInstitution() {
    return institution;
}
public void setInstitution(String institution) {
    this.institution = institution;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getLastname() {
    return lastname;
}
public void setLastname(String lastname) {
    this.lastname = lastname;
}
public String getPunkt() {
    return punkt;
}
public void setPunkt(String punkt) {
    this.punkt = punkt;
}
public String getFaksimil() {
    return faksimil;
}
public void setFaksimil(String faksimil) {
    this.faksimil = faksimil;
}
public String getTelephone() {
    return telephone;
}
public void setTelephone(String telephone) {
    this.telephone = telephone;
}
public String getPrivremeneKontradikcije() {
    return privremeneKontradikcije;
}
public void setPrivremeneKontradikcije(String privremeneKontradikcije) {
    this.privremeneKontradikcije = privremeneKontradikcije;
}
public String getPrivremeneKontradikcijeDatum() {
    return privremeneKontradikcijeDatum;
}
public void setPrivremeneKontradikcijeDatum(String privremeneKontradikcijeDatum) {
    this.privremeneKontradikcijeDatum = privremeneKontradikcijeDatum;
}
public Boolean getTrajneKontradikcije() {
    return trajneKontradikcije;
}
public void setTrajneKontradikcije(Boolean trajneKontradikcije) {
    this.trajneKontradikcije = trajneKontradikcije;
}
public ArrayList<Kolona> getTabela() {
    return tabela;
}
public void setTabela(ArrayList<Kolona> tabela) {
    this.tabela = tabela;
}
    
}
