package centralbank.bean;

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
@Table(name="racun_firme")
public class RacunFirme implements Serializable{
<<<<<<< HEAD

	/**
	 * 
	 */
=======
	
>>>>>>> 6463503ba504adefd5375b30a2bc120251e5a286
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(cascade=CascadeType.ALL)
	private Firma firma;
	
<<<<<<< HEAD
	@Column(name="stanje_racuna",nullable=false)
	private BigDecimal stanjeRacuna;

	
	public RacunFirme() {
		super();
		// TODO Auto-generated constructor stub
	}
	
=======
	@Column(name = "broj_racuna", unique = true, nullable = false)
	private String brojRacuna;
	
	@Column(name="stanje_racuna",nullable=false)
	private BigDecimal stanjeRacuna;
	
	
	public RacunFirme() {
	
	}
	
	
>>>>>>> 6463503ba504adefd5375b30a2bc120251e5a286
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

	
	
	
}
