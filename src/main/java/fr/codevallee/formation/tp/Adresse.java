package fr.codevallee.formation.tp;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(length=40)
	private String rue;
	
    private Integer numrue;
	
	private Integer codepostale;
	private String ville;
	
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public Integer getNumrue() {
		return numrue;
	}

	public void setNumrue(Integer numrue) {
		this.numrue = numrue;
	}

	public Integer getCodepostale() {
		return codepostale;
	}

	public void setCodepostale(Integer codepostale) {
		this.codepostale = codepostale;
	}

	

}
