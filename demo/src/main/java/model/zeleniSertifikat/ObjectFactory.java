
package model.zeleniSertifikat;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the zeleniSertifikat package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: zeleniSertifikat
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DigitalniSertifikat }
     * 
     */
    public DigitalniSertifikat createDigitalniSertifikat() {
        return new DigitalniSertifikat();
    }

    /**
     * Create an instance of {@link TOsoba }
     * 
     */
    public TOsoba createTOsoba() {
        return new TOsoba();
    }

    /**
     * Create an instance of {@link TPrvaDoza }
     * 
     */
    public TPrvaDoza createTPrvaDoza() {
        return new TPrvaDoza();
    }

    /**
     * Create an instance of {@link TDrugaDoza }
     * 
     */
    public TDrugaDoza createTDrugaDoza() {
        return new TDrugaDoza();
    }

    /**
     * Create an instance of {@link TZdravstvenaUstanova }
     * 
     */
    public TZdravstvenaUstanova createTZdravstvenaUstanova() {
        return new TZdravstvenaUstanova();
    }

    /**
     * Create an instance of {@link TPol }
     * 
     */
    public TPol createTPol() {
        return new TPol();
    }

}
