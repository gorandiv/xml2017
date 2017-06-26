//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.24 at 08:58:12 PM CEST 
//

package centralbank.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="zaglavlje_fakture"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="id_poruke" type="{http://www.ftn.uns.ac.rs/xml}TIDPoruke"/&gt;
 *                   &lt;element name="broj_racuna" type="{http://www.ftn.uns.ac.rs/xml}TBrojRacuna"/&gt;
 *                   &lt;element name="naziv_dobavljaca" type="{http://www.ftn.uns.ac.rs/xml}TNaziv"/&gt;
 *                   &lt;element name="adresa_dobavljaca" type="{http://www.ftn.uns.ac.rs/xml}TAdresa"/&gt;
 *                   &lt;element name="pib_dobavljaca" type="{http://www.ftn.uns.ac.rs/xml}TPIB"/&gt;
 *                   &lt;element name="naziv_kupca" type="{http://www.ftn.uns.ac.rs/xml}TNaziv"/&gt;
 *                   &lt;element name="adresa_kupca" type="{http://www.ftn.uns.ac.rs/xml}TAdresa"/&gt;
 *                   &lt;element name="pib_kupca" type="{http://www.ftn.uns.ac.rs/xml}TPIB"/&gt;
 *                   &lt;element name="datum_racuna" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="vrednost_robe" type="{http://www.ftn.uns.ac.rs/xml}TIznos"/&gt;
 *                   &lt;element name="vrednost_usluga" type="{http://www.ftn.uns.ac.rs/xml}TIznos"/&gt;
 *                   &lt;element name="ukupno_roba_i_usluge" type="{http://www.ftn.uns.ac.rs/xml}TIznos"/&gt;
 *                   &lt;element name="ukupan_rabat" type="{http://www.ftn.uns.ac.rs/xml}TIznos"/&gt;
 *                   &lt;element name="ukupan_porez" type="{http://www.ftn.uns.ac.rs/xml}TIznos"/&gt;
 *                   &lt;element name="oznaka_valute" type="{http://www.ftn.uns.ac.rs/xml}TOznaka_valute"/&gt;
 *                   &lt;element name="iznos_za_uplatu" type="{http://www.ftn.uns.ac.rs/xml}TIznos"/&gt;
 *                   &lt;element name="uplata_na_racun" type="{http://www.ftn.uns.ac.rs/xml}TBrojRacuna"/&gt;
 *                   &lt;element name="datum_valute" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="stavka_fakture" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="redni_broj"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                         &lt;totalDigits value="3"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="naziv_robe_ili_usluge"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="120"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="kolicina"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="10"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="jedinica_mere"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="6"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="jedinicna_cena"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="10"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="vrednost"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="12"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="procenat_rabata"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="5"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="iznos_rabata"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="12"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="umanjeno_za_rabat"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="12"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="ukupan_porez"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="12"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
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
@XmlType(name = "", propOrder = { "zaglavljeFakture", "stavkaFakture" })
@XmlRootElement(name = "faktura")
@Entity
@Table(name = "faktura")
public class Faktura {

	@XmlElement(name = "zaglavlje_fakture", required = true)
	@ManyToOne(cascade = CascadeType.ALL)
	protected Faktura.ZaglavljeFakture zaglavljeFakture;
	@XmlElement(name = "stavka_fakture", required = true)
	@OneToMany(cascade = CascadeType.ALL)
	protected List<Faktura.StavkaFakture> stavkaFakture;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "poslata", nullable = false)
	private Boolean poslata;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setStavkaFakture(List<Faktura.StavkaFakture> stavkaFakture) {
		this.stavkaFakture = stavkaFakture;
	}

	/**
	 * Gets the value of the zaglavljeFakture property.
	 * 
	 * @return possible object is {@link Faktura.ZaglavljeFakture }
	 * 
	 */
	public Faktura.ZaglavljeFakture getZaglavljeFakture() {
		return zaglavljeFakture;
	}

	/**
	 * Sets the value of the zaglavljeFakture property.
	 * 
	 * @param value
	 *            allowed object is {@link Faktura.ZaglavljeFakture }
	 * 
	 */
	public void setZaglavljeFakture(Faktura.ZaglavljeFakture value) {
		this.zaglavljeFakture = value;
	}

	/**
	 * Gets the value of the stavkaFakture property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the stavkaFakture property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getStavkaFakture().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Faktura.StavkaFakture }
	 * 
	 * 
	 */
	public List<Faktura.StavkaFakture> getStavkaFakture() {
		if (stavkaFakture == null) {
			stavkaFakture = new ArrayList<Faktura.StavkaFakture>();
		}
		return this.stavkaFakture;
	}

	public Boolean getPoslata() {
		return poslata;
	}

	public void setPoslata(Boolean poslata) {
		this.poslata = poslata;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType&gt;
	 *   &lt;complexContent&gt;
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
	 *       &lt;sequence&gt;
	 *         &lt;element name="redni_broj"&gt;
	 *           &lt;simpleType&gt;
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
	 *               &lt;totalDigits value="3"/&gt;
	 *             &lt;/restriction&gt;
	 *           &lt;/simpleType&gt;
	 *         &lt;/element&gt;
	 *         &lt;element name="naziv_robe_ili_usluge"&gt;
	 *           &lt;simpleType&gt;
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
	 *               &lt;maxLength value="120"/&gt;
	 *             &lt;/restriction&gt;
	 *           &lt;/simpleType&gt;
	 *         &lt;/element&gt;
	 *         &lt;element name="kolicina"&gt;
	 *           &lt;simpleType&gt;
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
	 *               &lt;totalDigits value="10"/&gt;
	 *               &lt;fractionDigits value="2"/&gt;
	 *             &lt;/restriction&gt;
	 *           &lt;/simpleType&gt;
	 *         &lt;/element&gt;
	 *         &lt;element name="jedinica_mere"&gt;
	 *           &lt;simpleType&gt;
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
	 *               &lt;maxLength value="6"/&gt;
	 *             &lt;/restriction&gt;
	 *           &lt;/simpleType&gt;
	 *         &lt;/element&gt;
	 *         &lt;element name="jedinicna_cena"&gt;
	 *           &lt;simpleType&gt;
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
	 *               &lt;totalDigits value="10"/&gt;
	 *               &lt;fractionDigits value="2"/&gt;
	 *             &lt;/restriction&gt;
	 *           &lt;/simpleType&gt;
	 *         &lt;/element&gt;
	 *         &lt;element name="vrednost"&gt;
	 *           &lt;simpleType&gt;
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
	 *               &lt;totalDigits value="12"/&gt;
	 *               &lt;fractionDigits value="2"/&gt;
	 *             &lt;/restriction&gt;
	 *           &lt;/simpleType&gt;
	 *         &lt;/element&gt;
	 *         &lt;element name="procenat_rabata"&gt;
	 *           &lt;simpleType&gt;
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
	 *               &lt;totalDigits value="5"/&gt;
	 *               &lt;fractionDigits value="2"/&gt;
	 *             &lt;/restriction&gt;
	 *           &lt;/simpleType&gt;
	 *         &lt;/element&gt;
	 *         &lt;element name="iznos_rabata"&gt;
	 *           &lt;simpleType&gt;
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
	 *               &lt;totalDigits value="12"/&gt;
	 *               &lt;fractionDigits value="2"/&gt;
	 *             &lt;/restriction&gt;
	 *           &lt;/simpleType&gt;
	 *         &lt;/element&gt;
	 *         &lt;element name="umanjeno_za_rabat"&gt;
	 *           &lt;simpleType&gt;
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
	 *               &lt;totalDigits value="12"/&gt;
	 *               &lt;fractionDigits value="2"/&gt;
	 *             &lt;/restriction&gt;
	 *           &lt;/simpleType&gt;
	 *         &lt;/element&gt;
	 *         &lt;element name="ukupan_porez"&gt;
	 *           &lt;simpleType&gt;
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
	 *               &lt;totalDigits value="12"/&gt;
	 *               &lt;fractionDigits value="2"/&gt;
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
	@XmlType(name = "", propOrder = { "redniBroj", "nazivRobeIliUsluge", "kolicina", "jedinicaMere", "jedinicnaCena",
			"vrednost", "procenatRabata", "iznosRabata", "umanjenoZaRabat", "ukupanPorez" })
	@Entity
	@Table(name = "stavka_fakture")
	public static class StavkaFakture {

		@XmlElement(name = "redni_broj", required = true)
		protected BigInteger redniBroj;
		@XmlElement(name = "naziv_robe_ili_usluge", required = true)
		protected String nazivRobeIliUsluge;
		@XmlElement(required = true)
		protected BigDecimal kolicina;
		@XmlElement(name = "jedinica_mere", required = true)
		protected String jedinicaMere;
		@XmlElement(name = "jedinicna_cena", required = true)
		protected BigDecimal jedinicnaCena;
		@XmlElement(required = true)
		protected BigDecimal vrednost;
		@XmlElement(name = "procenat_rabata", required = true)
		protected BigDecimal procenatRabata;
		@XmlElement(name = "iznos_rabata", required = true)
		protected BigDecimal iznosRabata;
		@XmlElement(name = "umanjeno_za_rabat", required = true)
		protected BigDecimal umanjenoZaRabat;
		@XmlElement(name = "ukupan_porez", required = true)
		protected BigDecimal ukupanPorez;

		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		/**
		 * Gets the value of the redniBroj property.
		 * 
		 * @return possible object is {@link BigInteger }
		 * 
		 */
		public BigInteger getRedniBroj() {
			return redniBroj;
		}

		/**
		 * Sets the value of the redniBroj property.
		 * 
		 * @param value
		 *            allowed object is {@link BigInteger }
		 * 
		 */
		public void setRedniBroj(BigInteger value) {
			this.redniBroj = value;
		}

		/**
		 * Gets the value of the nazivRobeIliUsluge property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getNazivRobeIliUsluge() {
			return nazivRobeIliUsluge;
		}

		/**
		 * Sets the value of the nazivRobeIliUsluge property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setNazivRobeIliUsluge(String value) {
			this.nazivRobeIliUsluge = value;
		}

		/**
		 * Gets the value of the kolicina property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getKolicina() {
			return kolicina;
		}

		/**
		 * Sets the value of the kolicina property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setKolicina(BigDecimal value) {
			this.kolicina = value;
		}

		/**
		 * Gets the value of the jedinicaMere property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getJedinicaMere() {
			return jedinicaMere;
		}

		/**
		 * Sets the value of the jedinicaMere property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setJedinicaMere(String value) {
			this.jedinicaMere = value;
		}

		/**
		 * Gets the value of the jedinicnaCena property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getJedinicnaCena() {
			return jedinicnaCena;
		}

		/**
		 * Sets the value of the jedinicnaCena property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setJedinicnaCena(BigDecimal value) {
			this.jedinicnaCena = value;
		}

		/**
		 * Gets the value of the vrednost property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getVrednost() {
			return vrednost;
		}

		/**
		 * Sets the value of the vrednost property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setVrednost(BigDecimal value) {
			this.vrednost = value;
		}

		/**
		 * Gets the value of the procenatRabata property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getProcenatRabata() {
			return procenatRabata;
		}

		/**
		 * Sets the value of the procenatRabata property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setProcenatRabata(BigDecimal value) {
			this.procenatRabata = value;
		}

		/**
		 * Gets the value of the iznosRabata property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getIznosRabata() {
			return iznosRabata;
		}

		/**
		 * Sets the value of the iznosRabata property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setIznosRabata(BigDecimal value) {
			this.iznosRabata = value;
		}

		/**
		 * Gets the value of the umanjenoZaRabat property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getUmanjenoZaRabat() {
			return umanjenoZaRabat;
		}

		/**
		 * Sets the value of the umanjenoZaRabat property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setUmanjenoZaRabat(BigDecimal value) {
			this.umanjenoZaRabat = value;
		}

		/**
		 * Gets the value of the ukupanPorez property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getUkupanPorez() {
			return ukupanPorez;
		}

		/**
		 * Sets the value of the ukupanPorez property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setUkupanPorez(BigDecimal value) {
			this.ukupanPorez = value;
		}

	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType&gt;
	 *   &lt;complexContent&gt;
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
	 *       &lt;sequence&gt;
	 *         &lt;element name="id_poruke" type="{http://www.ftn.uns.ac.rs/xml}TIDPoruke"/&gt;
	 *         &lt;element name="broj_racuna" type="{http://www.ftn.uns.ac.rs/xml}TBrojRacuna"/&gt;
	 *         &lt;element name="naziv_dobavljaca" type="{http://www.ftn.uns.ac.rs/xml}TNaziv"/&gt;
	 *         &lt;element name="adresa_dobavljaca" type="{http://www.ftn.uns.ac.rs/xml}TAdresa"/&gt;
	 *         &lt;element name="pib_dobavljaca" type="{http://www.ftn.uns.ac.rs/xml}TPIB"/&gt;
	 *         &lt;element name="naziv_kupca" type="{http://www.ftn.uns.ac.rs/xml}TNaziv"/&gt;
	 *         &lt;element name="adresa_kupca" type="{http://www.ftn.uns.ac.rs/xml}TAdresa"/&gt;
	 *         &lt;element name="pib_kupca" type="{http://www.ftn.uns.ac.rs/xml}TPIB"/&gt;
	 *         &lt;element name="datum_racuna" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
	 *         &lt;element name="vrednost_robe" type="{http://www.ftn.uns.ac.rs/xml}TIznos"/&gt;
	 *         &lt;element name="vrednost_usluga" type="{http://www.ftn.uns.ac.rs/xml}TIznos"/&gt;
	 *         &lt;element name="ukupno_roba_i_usluge" type="{http://www.ftn.uns.ac.rs/xml}TIznos"/&gt;
	 *         &lt;element name="ukupan_rabat" type="{http://www.ftn.uns.ac.rs/xml}TIznos"/&gt;
	 *         &lt;element name="ukupan_porez" type="{http://www.ftn.uns.ac.rs/xml}TIznos"/&gt;
	 *         &lt;element name="oznaka_valute" type="{http://www.ftn.uns.ac.rs/xml}TOznaka_valute"/&gt;
	 *         &lt;element name="iznos_za_uplatu" type="{http://www.ftn.uns.ac.rs/xml}TIznos"/&gt;
	 *         &lt;element name="uplata_na_racun" type="{http://www.ftn.uns.ac.rs/xml}TBrojRacuna"/&gt;
	 *         &lt;element name="datum_valute" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
	 *       &lt;/sequence&gt;
	 *     &lt;/restriction&gt;
	 *   &lt;/complexContent&gt;
	 * &lt;/complexType&gt;
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "idPoruke", "brojRacuna", "nazivDobavljaca", "adresaDobavljaca", "pibDobavljaca",
			"nazivKupca", "adresaKupca", "pibKupca", "datumRacuna", "vrednostRobe", "vrednostUsluga",
			"ukupnoRobaIUsluge", "ukupanRabat", "ukupanPorez", "oznakaValute", "iznosZaUplatu", "uplataNaRacun",
			"datumValute" })
	@Entity
	@Table(name = "zaglavlje_fakture")
	public static class ZaglavljeFakture {

		@XmlElement(name = "id_poruke", required = true)
		protected String idPoruke;
		@XmlElement(name = "broj_racuna", required = true)
		protected String brojRacuna;
		@XmlElement(name = "naziv_dobavljaca", required = true)
		protected String nazivDobavljaca;
		@XmlElement(name = "adresa_dobavljaca", required = true)
		protected String adresaDobavljaca;
		@XmlElement(name = "pib_dobavljaca", required = true)
		protected String pibDobavljaca;
		@XmlElement(name = "naziv_kupca", required = true)
		protected String nazivKupca;
		@XmlElement(name = "adresa_kupca", required = true)
		protected String adresaKupca;
		@XmlElement(name = "pib_kupca", required = true)
		protected String pibKupca;
		@XmlElement(name = "datum_racuna", required = true)
		protected String datumRacuna;
		@XmlElement(name = "vrednost_robe", required = true)
		protected BigDecimal vrednostRobe;
		@XmlElement(name = "vrednost_usluga", required = true)
		protected BigDecimal vrednostUsluga;
		@XmlElement(name = "ukupno_roba_i_usluge", required = true)
		protected BigDecimal ukupnoRobaIUsluge;
		@XmlElement(name = "ukupan_rabat", required = true)
		protected BigDecimal ukupanRabat;
		@XmlElement(name = "ukupan_porez", required = true)
		protected BigDecimal ukupanPorez;
		@XmlElement(name = "oznaka_valute", required = true)
		protected String oznakaValute;
		@XmlElement(name = "iznos_za_uplatu", required = true)
		protected BigDecimal iznosZaUplatu;
		@XmlElement(name = "uplata_na_racun", required = true)
		protected String uplataNaRacun;
		@XmlElement(name = "datum_valute", required = true)
		protected String datumValute;

		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;

		/**
		 * Gets the value of the idPoruke property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getIdPoruke() {
			return idPoruke;
		}

		/**
		 * Sets the value of the idPoruke property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setIdPoruke(String value) {
			this.idPoruke = value;
		}

		/**
		 * Gets the value of the brojRacuna property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
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
		 * Gets the value of the nazivDobavljaca property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getNazivDobavljaca() {
			return nazivDobavljaca;
		}

		/**
		 * Sets the value of the nazivDobavljaca property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setNazivDobavljaca(String value) {
			this.nazivDobavljaca = value;
		}

		/**
		 * Gets the value of the adresaDobavljaca property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getAdresaDobavljaca() {
			return adresaDobavljaca;
		}

		/**
		 * Sets the value of the adresaDobavljaca property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setAdresaDobavljaca(String value) {
			this.adresaDobavljaca = value;
		}

		/**
		 * Gets the value of the pibDobavljaca property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getPibDobavljaca() {
			return pibDobavljaca;
		}

		/**
		 * Sets the value of the pibDobavljaca property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setPibDobavljaca(String value) {
			this.pibDobavljaca = value;
		}

		/**
		 * Gets the value of the nazivKupca property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getNazivKupca() {
			return nazivKupca;
		}

		/**
		 * Sets the value of the nazivKupca property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setNazivKupca(String value) {
			this.nazivKupca = value;
		}

		/**
		 * Gets the value of the adresaKupca property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getAdresaKupca() {
			return adresaKupca;
		}

		/**
		 * Sets the value of the adresaKupca property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setAdresaKupca(String value) {
			this.adresaKupca = value;
		}

		/**
		 * Gets the value of the pibKupca property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getPibKupca() {
			return pibKupca;
		}

		/**
		 * Sets the value of the pibKupca property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setPibKupca(String value) {
			this.pibKupca = value;
		}

		/**
		 * Gets the value of the datumRacuna property.
		 * 
		 * @return possible object is {@link XMLGregorianCalendar }
		 * 
		 */
		public String getDatumRacuna() {
			return datumRacuna;
		}

		/**
		 * Sets the value of the datumRacuna property.
		 * 
		 * @param value
		 *            allowed object is {@link XMLGregorianCalendar }
		 * 
		 */
		public void setDatumRacuna(String value) {
			this.datumRacuna = value;
		}

		/**
		 * Gets the value of the vrednostRobe property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getVrednostRobe() {
			return vrednostRobe;
		}

		/**
		 * Sets the value of the vrednostRobe property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setVrednostRobe(BigDecimal value) {
			this.vrednostRobe = value;
		}

		/**
		 * Gets the value of the vrednostUsluga property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getVrednostUsluga() {
			return vrednostUsluga;
		}

		/**
		 * Sets the value of the vrednostUsluga property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setVrednostUsluga(BigDecimal value) {
			this.vrednostUsluga = value;
		}

		/**
		 * Gets the value of the ukupnoRobaIUsluge property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getUkupnoRobaIUsluge() {
			return ukupnoRobaIUsluge;
		}

		/**
		 * Sets the value of the ukupnoRobaIUsluge property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setUkupnoRobaIUsluge(BigDecimal value) {
			this.ukupnoRobaIUsluge = value;
		}

		/**
		 * Gets the value of the ukupanRabat property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getUkupanRabat() {
			return ukupanRabat;
		}

		/**
		 * Sets the value of the ukupanRabat property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setUkupanRabat(BigDecimal value) {
			this.ukupanRabat = value;
		}

		/**
		 * Gets the value of the ukupanPorez property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getUkupanPorez() {
			return ukupanPorez;
		}

		/**
		 * Sets the value of the ukupanPorez property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setUkupanPorez(BigDecimal value) {
			this.ukupanPorez = value;
		}

		/**
		 * Gets the value of the oznakaValute property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getOznakaValute() {
			return oznakaValute;
		}

		/**
		 * Sets the value of the oznakaValute property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setOznakaValute(String value) {
			this.oznakaValute = value;
		}

		/**
		 * Gets the value of the iznosZaUplatu property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getIznosZaUplatu() {
			return iznosZaUplatu;
		}

		/**
		 * Sets the value of the iznosZaUplatu property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setIznosZaUplatu(BigDecimal value) {
			this.iznosZaUplatu = value;
		}

		/**
		 * Gets the value of the uplataNaRacun property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getUplataNaRacun() {
			return uplataNaRacun;
		}

		/**
		 * Sets the value of the uplataNaRacun property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setUplataNaRacun(String value) {
			this.uplataNaRacun = value;
		}

		/**
		 * Gets the value of the datumValute property.
		 * 
		 * @return possible object is {@link XMLGregorianCalendar }
		 * 
		 */
		public String getDatumValute() {
			return datumValute;
		}

		/**
		 * Sets the value of the datumValute property.
		 * 
		 * @param value
		 *            allowed object is {@link XMLGregorianCalendar }
		 * 
		 */
		public void setDatumValute(String value) {
			this.datumValute = value;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

	}

}
