package bank.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "proizvod_ili_usluga")
public class ProizvodIliUsluga implements Serializable {

	private static final long serialVersionUID = 369046781371202685L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "ime", nullable = false)
	private String ime;

	@Column(name = "jedinica_mere")
	private String jedinicaMere;

	@Column(name = "cena", nullable = false)
	private BigDecimal cena;

	@Column(name = "porez", nullable = false)
	private BigDecimal porez;

	@Column(name = "jel_proizvod", nullable = false) 
	private Boolean jelProizvod;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "firma_id")
	@JsonBackReference
	private Firma firma;

	public ProizvodIliUsluga() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public BigDecimal getCena() {
		return cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public BigDecimal getPorez() {
		return porez;
	}

	public void setPorez(BigDecimal porez) {
		this.porez = porez;
	}

	public Firma getFirma() {
		return firma;
	}

	public void setFirma(Firma firma) {
		this.firma = firma;
	}

	public Boolean getJelProizvod() {
		return jelProizvod;
	}

	public void setJelProizvod(Boolean jelProizvod) {
		this.jelProizvod = jelProizvod;
	}

}
