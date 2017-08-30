package fr.codevallee.formation.tp;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

 	
	
	@Entity
	public class LigneFactures {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		
		private Integer nbrarticles;

		@OneToOne
		private Articles articles;
		
		public int getNbrarticles() {
			return nbrarticles;
		}


		public void setNbrarticles(int nbrarticles) {
			this.nbrarticles = nbrarticles;
		}

}
