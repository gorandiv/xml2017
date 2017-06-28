package company.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "racun_firme")
public class RacunFirme implements Serializable {

	private static final long serialVersionUID = 3906941923731740821L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Firma firma;

	@Column(name = "broj_racuna", unique = true, nullable = false)
	private String brojRacuna;

	@Column(name = "stanje_racuna", nullable = false)
	private BigDecimal stanjeRacuna;

	public RacunFirme() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Firma getFirma() {
		return firma;
	}

	public void setFirma(Firma firma) {
		this.firma = firma;
	}

	public BigDecimal getStanjeRacuna() {
		return stanjeRacuna;
	}

	public void setStanjeRacuna(BigDecimal stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

}
