//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.24 at 02:52:09 PM CEST 
//

package company.bean;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
 *         &lt;element name="id_poruke" type="{http://www.ftn.uns.ac.rs/xml}TIDPoruke"/&gt;
 *         &lt;element name="duznik"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="255"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="svrha_placanja"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="255"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="primalac"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="255"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="podaci_o_uplati"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="oznaka_valute" type="{http://www.ftn.uns.ac.rs/xml}TOznaka_valute"/&gt;
 *                   &lt;element name="iznos" type="{http://www.ftn.uns.ac.rs/xml}TIznos"/&gt;
 *                   &lt;element name="racun_duznika" type="{http://www.ftn.uns.ac.rs/xml}TRacun"/&gt;
 *                   &lt;element name="racun_poverioca" type="{http://www.ftn.uns.ac.rs/xml}TRacun"/&gt;
 *                   &lt;element name="datum_valute" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="hitno" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="datum_naloga" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
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
@XmlType(name = "nalog_za_prenos", propOrder = { "idPoruke", "duznik", "svrhaPlacanja","poverilac", "podaciOUplati" })
@XmlRootElement(name = "nalog_za_prenos", namespace = "http://www.ftn.uns.ac.rs/nalogZaPrenos")
@Entity
@Table(name = "nalog_za_prenos")
public class NalogZaPrenos {

	@XmlElement(name = "id_poruke", namespace = "http://www.ftn.uns.ac.rs/nalogZaPrenos", required = true)
	protected String idPoruke;
	@XmlElement(namespace = "http://www.ftn.uns.ac.rs/nalogZaPrenos", required = true)
	protected String duznik;
	@XmlElement(name = "svrha_placanja", namespace = "http://www.ftn.uns.ac.rs/nalogZaPrenos", required = true)
	protected String svrhaPlacanja;
	@XmlElement(namespace = "http://www.ftn.uns.ac.rs/nalogZaPrenos", required = true)
	protected String poverilac;
	@XmlElement(name = "podaci_o_uplati", namespace = "http://www.ftn.uns.ac.rs/nalogZaPrenos", required = true)
	@ManyToOne(cascade = CascadeType.ALL)
	protected NalogZaPrenos.PodaciOUplati podaciOUplati;

	@XmlTransient
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@XmlTransient
	@Column(name = "poslat", nullable = false)
	private Boolean poslat;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getPoslat() {
		return poslat;
	}

	public void setPoslat(Boolean poslat) {
		this.poslat = poslat;
	}

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
	 * Gets the value of the duznik property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDuznik() {
		return duznik;
	}

	/**
	 * Sets the value of the duznik property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDuznik(String value) {
		this.duznik = value;
	}

	/**
	 * Gets the value of the svrhaPlacanja property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}

	/**
	 * Sets the value of the svrhaPlacanja property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSvrhaPlacanja(String value) {
		this.svrhaPlacanja = value;
	}

	/**
	 * Gets the value of the primalac property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPoverilac() {
		return poverilac;
	}

	/**
	 * Sets the value of the primalac property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPoverilac(String poverilac) {
		this.poverilac = poverilac;
	}

	/**
	 * Gets the value of the podaciOUplati property.
	 * 
	 * @return possible object is {@link NalogZaPrenos.PodaciOUplati }
	 * 
	 */
	public NalogZaPrenos.PodaciOUplati getPodaciOUplati() {
		return podaciOUplati;
	}

	/**
	 * Sets the value of the podaciOUplati property.
	 * 
	 * @param value
	 *            allowed object is {@link NalogZaPrenos.PodaciOUplati }
	 * 
	 */
	public void setPodaciOUplati(NalogZaPrenos.PodaciOUplati value) {
		this.podaciOUplati = value;
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
	 *         &lt;element name="oznaka_valute" type="{http://www.ftn.uns.ac.rs/xml}TOznaka_valute"/&gt;
	 *         &lt;element name="iznos" type="{http://www.ftn.uns.ac.rs/xml}TIznos"/&gt;
	 *         &lt;element name="racun_duznika" type="{http://www.ftn.uns.ac.rs/xml}TRacun"/&gt;
	 *         &lt;element name="racun_poverioca" type="{http://www.ftn.uns.ac.rs/xml}TRacun"/&gt;
	 *         &lt;element name="datum_valute" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
	 *         &lt;element name="hitno" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
	 *         &lt;element name="datum_naloga" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
	 *       &lt;/sequence&gt;
	 *     &lt;/restriction&gt;
	 *   &lt;/complexContent&gt;
	 * &lt;/complexType&gt;
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "oznakaValute", "iznos", "racunDuznika", "racunPoverioca", "datumValute", "hitno",
			"datumNaloga" })
	@Entity
	@Table(name = "podaci_o_uplati")
	public static class PodaciOUplati {

		@XmlElement(name = "oznaka_valute", namespace = "http://www.ftn.uns.ac.rs/nalogZaPrenos", required = true)
		protected String oznakaValute;
		@XmlElement(namespace = "http://www.ftn.uns.ac.rs/nalogZaPrenos", required = true)
		protected BigDecimal iznos;
		@XmlElement(name = "racun_duznika", namespace = "http://www.ftn.uns.ac.rs/nalogZaPrenos", required = true)
		@ManyToOne(cascade = CascadeType.ALL)
		protected TRacun racunDuznika;
		@XmlElement(name = "racun_poverioca", namespace = "http://www.ftn.uns.ac.rs/nalogZaPrenos", required = true)
		@ManyToOne(cascade = CascadeType.ALL)
		protected TRacun racunPoverioca;
		@XmlElement(name = "datum_valute", namespace = "http://www.ftn.uns.ac.rs/nalogZaPrenos", required = true)
		protected String datumValute;
		@XmlElement(namespace = "http://www.ftn.uns.ac.rs/nalogZaPrenos", defaultValue = "true")
		protected boolean hitno;
		@XmlElement(name = "datum_naloga", namespace = "http://www.ftn.uns.ac.rs/nalogZaPrenos", required = true)
		protected String datumNaloga;
		
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
		 * Gets the value of the iznos property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getIznos() {
			return iznos;
		}

		/**
		 * Sets the value of the iznos property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setIznos(BigDecimal value) {
			this.iznos = value;
		}

		/**
		 * Gets the value of the racunDuznika property.
		 * 
		 * @return possible object is {@link TRacun }
		 * 
		 */
		public TRacun getRacunDuznika() {
			return racunDuznika;
		}

		/**
		 * Sets the value of the racunDuznika property.
		 * 
		 * @param value
		 *            allowed object is {@link TRacun }
		 * 
		 */
		public void setRacunDuznika(TRacun value) {
			this.racunDuznika = value;
		}

		/**
		 * Gets the value of the racunPoverioca property.
		 * 
		 * @return possible object is {@link TRacun }
		 * 
		 */
		public TRacun getRacunPoverioca() {
			return racunPoverioca;
		}

		/**
		 * Sets the value of the racunPoverioca property.
		 * 
		 * @param value
		 *            allowed object is {@link TRacun }
		 * 
		 */
		public void setRacunPoverioca(TRacun value) {
			this.racunPoverioca = value;
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

		/**
		 * Gets the value of the hitno property.
		 * 
		 */
		public boolean isHitno() {
			return hitno;
		}

		/**
		 * Sets the value of the hitno property.
		 * 
		 */
		public void setHitno(boolean value) {
			this.hitno = value;
		}

		/**
		 * Gets the value of the datumNaloga property.
		 * 
		 * @return possible object is {@link XMLGregorianCalendar }
		 * 
		 */
		public String getDatumNaloga() {
			return datumNaloga;
		}

		/**
		 * Sets the value of the datumNaloga property.
		 * 
		 * @param value
		 *            allowed object is {@link XMLGregorianCalendar }
		 * 
		 */
		public void setDatumNaloga(String value) {
			this.datumNaloga = value;
		}

	}

}
