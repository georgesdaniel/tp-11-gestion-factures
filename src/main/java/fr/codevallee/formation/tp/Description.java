package fr.codevallee.formation.tp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Description {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nomdescription;

	public String getNomdescription() {
		return nomdescription;
	}

	public void setNomdescription(String nomdescription) {
		this.nomdescription = nomdescription;
	}

	
	
}
