//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.28 at 02:21:29 AM CEST 
//


package company.bean;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the company.bean package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: company.bean
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Presek }
     * 
     */
    public Presek createPresek() {
        return new Presek();
    }

    /**
     * Create an instance of {@link Presek.Zaglavlje }
     * 
     */
    public Presek.Zaglavlje createPresekZaglavlje() {
        return new Presek.Zaglavlje();
    }

    /**
     * Create an instance of {@link Presek.Stavka }
     * 
     */
    public Presek.Stavka createPresekStavka() {
        return new Presek.Stavka();
    }
    
    public NalogZaPrenos createNalogZaPrenos(){
    	return new NalogZaPrenos();
    }
    
    public NalogZaPrenos.PodaciOUplati createPodaciOUplati(){
    	return new NalogZaPrenos.PodaciOUplati();
    }
    
    public ZahtevZaIzvod createZahtevZaIzvod(){
    	return new ZahtevZaIzvod();
    }

    /**
     * Create an instance of {@link TRacun }
     * 
     */
    public TRacun createTRacun() {
        return new TRacun();
    }

}
