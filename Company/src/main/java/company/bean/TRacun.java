//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 12:54:46 PM CEST 
//


package company.bean;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TRacun complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TRacun">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="broj_racuna" type="{http://www.ftn.uns.ac.rs/xml}TBrojRacuna"/>
 *         &lt;element name="broj_modela" type="{http://www.ftn.uns.ac.rs/xml}TModel"/>
 *         &lt;element name="poziv_na_broj" type="{http://www.ftn.uns.ac.rs/xml}TPozivNaBroj"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRacun", namespace = "http://www.ftn.uns.ac.rs/xml", propOrder = {
    "brojRacuna",
    "brojModela",
    "pozivNaBroj"
})
public class TRacun {

    @XmlElement(name = "broj_racuna", required = true)
    protected String brojRacuna;
    @XmlElement(name = "broj_modela", required = true)
    protected BigInteger brojModela;
    @XmlElement(name = "poziv_na_broj", required = true)
    protected String pozivNaBroj;

    /**
     * Gets the value of the brojRacuna property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojRacuna() {
        return brojRacuna;
    }

    /**
     * Sets the value of the brojRacuna property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojRacuna(String value) {
        this.brojRacuna = value;
    }

    /**
     * Gets the value of the brojModela property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojModela() {
        return brojModela;
    }

    /**
     * Sets the value of the brojModela property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojModela(BigInteger value) {
        this.brojModela = value;
    }

    /**
     * Gets the value of the pozivNaBroj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPozivNaBroj() {
        return pozivNaBroj;
    }

    /**
     * Sets the value of the pozivNaBroj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPozivNaBroj(String value) {
        this.pozivNaBroj = value;
    }

}
