package com.example.demo.dto;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.example.demo.model.korisnik.Korisnik;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "jwt",
        "user"
})
@XmlRootElement(name = "token", namespace = "http://www.ftn.uns.ac.rs/token")
public class UserTokenStateDTO {
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/token", required = true)
    public String jwt;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/token", required = true)
    public Korisnik user;
    public UserTokenStateDTO() {
    }

    public UserTokenStateDTO(String jwt, Korisnik korisnik) {
        this.jwt = jwt;
        this.user = korisnik;
    }



}