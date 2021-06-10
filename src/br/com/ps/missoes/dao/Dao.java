package br.com.ps.missoes.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ps.missoes.model.Missoes;

public class Dao {

	public void create(Missoes missoes) {
		
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("ps");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(missoes);
		manager.getTransaction().commit();
				
		manager.close();
	}

}
