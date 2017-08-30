package fr.codevallee.formation.tp;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

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
			
			
			// Insertion d'un Client
			Clients client1 = new Clients ();
			client1.setNom("Garfield");	
			client1.setPrenom("Cassandre");
						
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
	