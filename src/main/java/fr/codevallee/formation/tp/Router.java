package fr.codevallee.formation.tp;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Router implements SparkApplication {

	public void init() {

		final Logger logger = LoggerFactory.getLogger(Router.class);

		
		get("/exemple1", (request, response) -> {

			logger.debug("start");

			Map<String, Object> attributes = new HashMap<>();
            						
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			
			
			//Insertion d'une adresse
			Adresse adresse1 = new Adresse();
			adresse1.setNumrue(1);
			adresse1.setRue("rue des prés bas");
			adresse1.setCodepostale(63000);
			adresse1.setVille("clermont ferrand");
			
			TypedQuery<Adresse> queryadresse = entityManager.createQuery("from Adresse", Adresse.class);
			attributes.put("objets", queryadresse.getResultList());
			
			entityManager.getTransaction().begin();
			entityManager.persist(adresse1);
			entityManager.getTransaction().commit();
			
			
			// Insertion d'un Client avec une adresse
			
			Clients client1 = new Clients ();
			client1.setNom("Garfield2");	
			client1.setPrenom("Cassandre2");
			
			// Récuperation de l'adresse pour l'incorporer dans le Client
			Set<Adresse> set1 = new HashSet<>();
			set1.add(adresse1);
			
			client1.setAdresse(set1);
					
									
			TypedQuery<Clients> query = entityManager.createQuery("from Clients", Clients.class);
			attributes.put("objets", query.getResultList());

			entityManager.getTransaction().begin();
			entityManager.persist(client1);
			entityManager.getTransaction().commit();
					
			entityManager.close();
			
		
			return new ModelAndView(attributes, "home.ftl");
			
		}, getFreeMarkerEngine());
				

	}

	private FreeMarkerEngine getFreeMarkerEngine() {
		FreeMarkerEngine engine = new FreeMarkerEngine();
		Configuration configuration = new Configuration(new Version(2, 3, 23));
		configuration.setTemplateUpdateDelayMilliseconds(Long.MAX_VALUE);
		configuration.setClassForTemplateLoading(FreeMarkerEngine.class, "");
		engine.setConfiguration(configuration);
		return engine;
	}

}
	