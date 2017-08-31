package fr.codevallee.formation.tp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




@Entity
public class Articles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(length=40)
	private String reference;
	
	private Double prixarticle;
	
	
	//PLusieurs articles peuvent avoir une même description
	@ManyToOne
	private Description description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Double getPrixarticle() {
		return prixarticle;
	}

	public void setPrixarticle(Double prixarticle) {
		this.prixarticle = prixarticle;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}
	
}
