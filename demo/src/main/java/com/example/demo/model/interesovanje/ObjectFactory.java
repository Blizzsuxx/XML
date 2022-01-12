
package com.example.demo.model.interesovanje;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the interesovanje package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: interesovanje
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InteresovanjeZaVakcinisanje }
     * 
     */
    public InteresovanjeZaVakcinisanje createInteresovanjeZaVakcinisanje() {
        return new InteresovanjeZaVakcinisanje();
    }

    /**
     * Create an instance of {@link InteresovanjeZaVakcinisanje.Vakcine }
     * 
     */
    public InteresovanjeZaVakcinisanje.Vakcine createInteresovanjeZaVakcinisanjeVakcine() {
        return new InteresovanjeZaVakcinisanje.Vakcine();
    }

    /**
     * Create an instance of {@link InteresovanjeZaVakcinisanje.Drzavljanstvo }
     * 
     */
    public InteresovanjeZaVakcinisanje.Drzavljanstvo createInteresovanjeZaVakcinisanjeDrzavljanstvo() {
        return new InteresovanjeZaVakcinisanje.Drzavljanstvo();
    }

    /**
     * Create an instance of {@link TOsoba }
     * 
     */
    public TOsoba createTOsoba() {
        return new TOsoba();
    }

    /**
     * Create an instance of {@link TIzbor }
     * 
     */
    public TIzbor createTIzbor() {
        return new TIzbor();
    }

    /**
     * Create an instance of {@link TZdravstvenaUstanova }
     * 
     */
    public TZdravstvenaUstanova createTZdravstvenaUstanova() {
        return new TZdravstvenaUstanova();
    }

    /**
     * Create an instance of {@link TVakcina }
     * 
     */
    public TVakcina createTVakcina() {
        return new TVakcina();
    }

    /**
     * Create an instance of {@link TPol }
     * 
     */
    public TPol createTPol() {
        return new TPol();
    }

    /**
     * Create an instance of {@link InteresovanjeZaVakcinisanje.Vakcine.IzabraneVakcine }
     * 
     */
    public InteresovanjeZaVakcinisanje.Vakcine.IzabraneVakcine createInteresovanjeZaVakcinisanjeVakcineIzabraneVakcine() {
        return new InteresovanjeZaVakcinisanje.Vakcine.IzabraneVakcine();
    }

}
