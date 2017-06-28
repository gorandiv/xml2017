package company.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "firma")
public class Firma implements Serializable {

	private static final long serialVersionUID = 9037164225662144173L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;

	@Column(name = "pib", unique = true, nullable = false)
	private String pib;

	@Column(name = "ime", unique = true, nullable = false)
	private String ime;

	@Column(name = "adresa", unique = true, nullable = false)
	private String adresa;

	@Column(name = "adresa_firme", unique = true, nullable = false)
	private String adresaFirme;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "banka_id")
	@JsonBackReference
	private Banka banka;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "firma")
	@JsonManagedReference
	private List<ProizvodIliUsluga> proizvodiIliUsluge;

	public Firma() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}

	public String getAdresaFirme() {
		return adresaFirme;
	}

	public void setAdresaFirme(String adresaFirme) {
		this.adresaFirme = adresaFirme;
	}

	public List<ProizvodIliUsluga> getProizvodiIliUsluge() {
		return proizvodiIliUsluge;
	}

	public void setProizvodiIliUsluge(List<ProizvodIliUsluga> proizvodiIliUsluge) {
		this.proizvodiIliUsluge = proizvodiIliUsluge;
	}

}
