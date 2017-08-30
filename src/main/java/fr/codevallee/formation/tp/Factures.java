package fr.codevallee.formation.tp;

import java.sql.Date;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Factures {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long total;
	
	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public Set<LigneFactures> getLignefactures() {
		return lignefactures;
	}

	public void setLignefactures(Set<LigneFactures> lignefactures) {
		this.lignefactures = lignefactures;
	}

	private Date date;
	
	// Une facture ne peut appartenir qu'à un client
	@OneToOne
	private Clients clients;
	
	// Une facture comporte plusieurs lignes de factures
	@OneToMany
	private Set<LigneFactures> lignefactures;
	
	

}
