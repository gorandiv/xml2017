package centralbank.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "banka")
public class Banka implements Serializable {

	private static final long serialVersionUID = 116080674641647673L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "ime", unique = true, nullable = false)
	private String ime;

	@Column(name = "adresa", unique = true, nullable = false)
	private String adresa;

	@Column(name = "cb_adr", nullable = false)
	private String adresaCentralneBanke;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "banka")
	@JsonManagedReference
	private List<Firma> firme;

	@Column(name = "swift_kod", unique = true, nullable = false)
	private String swiftKod;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<RacunFirme> racuniFirme;
	
	

	public List<RacunFirme> getRacuniFirme() {
		return racuniFirme;
	}

	public void setRacuniFirme(List<RacunFirme> racuniFirme) {
		this.racuniFirme = racuniFirme;
	}

	public Banka() {
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getAdresaCentralneBanke() {
		return adresaCentralneBanke;
	}

	public void setAdresaCentralneBanke(String adresaCentralneBanke) {
		this.adresaCentralneBanke = adresaCentralneBanke;
	}

	public List<Firma> getFirme() {
		return firme;
	}

	public void setFirme(List<Firma> firme) {
		this.firme = firme;
	}

	public String getSwiftKod() {
		return swiftKod;
	}

	public void setSwiftKod(String swiftKod) {
		this.swiftKod = swiftKod;
	}

}
