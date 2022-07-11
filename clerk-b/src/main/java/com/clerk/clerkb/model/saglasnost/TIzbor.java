package com.clerk.clerkb.model.saglasnost;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIzbor", namespace = "http://ftn.uns.ac.rs/saglasnost")
public class TIzbor {

    @XmlAttribute(name = "izabran", required = true)
    protected boolean izabran;

    public boolean isIzabran() {
        return izabran;
    }

    public void setIzabran(boolean izabran) {
        this.izabran = izabran;
    }
}
