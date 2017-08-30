package fr.codevallee.formation.tp;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Clients {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 40)
	private String nom;

	@Column(length = 40)
	private String prenom;
	
	// Un client peut avoir plusieurs adresses
		@OneToMany
		private Set<Adresse> adresse;

	// Un client peut avoir plusieurs factures
	@OneToMany
	private Set<Factures> factures;

	// Un client peut avoir plusieurs articles
	@OneToMany
	private Set<Articles> articles;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
