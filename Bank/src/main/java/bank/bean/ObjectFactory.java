//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 06:53:14 PM CEST 
//


package bank.bean;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bank.bean package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bank.bean
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ZahtevZaIzvod }
     * 
     */
    public ZahtevZaIzvod createZahtevZaIzvod() {
        return new ZahtevZaIzvod();
    }

    /**
     * Create an instance of {@link TRacun }
     * 
     */
    public TRacun createTRacun() {
        return new TRacun();
    }
    
    public NalogZaPrenos createNalogZaPrenos(){
    	return new NalogZaPrenos();
    }
    
    public NalogZaPrenos.PodaciOUplati createPodaciOUplati(){
    	return new NalogZaPrenos.PodaciOUplati();
    }

}
