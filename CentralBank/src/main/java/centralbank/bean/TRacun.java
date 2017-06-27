//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.24 at 08:58:12 PM CEST 
//

package centralbank.bean;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for TRacun complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="TRacun"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="broj_racuna"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.ftn.uns.ac.rs/xml}TBrojRacuna"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="broj_modela"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;totalDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="poziv_na_broj"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRacun", namespace = "http://www.ftn.uns.ac.rs/xml", propOrder = { "brojRacuna", "brojModela",
		"pozivNaBroj" })
@Entity
@Table(name = "racun")
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
	 * @return possible object is {@link String }
	 * 
	 */

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlTransient
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	/**
	 * Sets the value of the brojRacuna property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBrojRacuna(String value) {
		this.brojRacuna = value;
	}

	/**
	 * Gets the value of the brojModela property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getBrojModela() {
		return brojModela;
	}

	/**
	 * Sets the value of the brojModela property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setBrojModela(BigInteger value) {
		this.brojModela = value;
	}

	/**
	 * Gets the value of the pozivNaBroj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPozivNaBroj() {
		return pozivNaBroj;
	}

	/**
	 * Sets the value of the pozivNaBroj property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPozivNaBroj(String value) {
		this.pozivNaBroj = value;
	}

}
