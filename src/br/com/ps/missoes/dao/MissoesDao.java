package br.com.ps.missoes.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.ps.missoes.model.Missoes;
import br.com.ps.missoes.util.JPAUtil;

public class MissoesDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("ps");
	EntityManager entityManager = factory.createEntityManager();
	
	EntityManager manager = JPAUtil.getManager();
	
	
	public List<Missoes> buscarTodos() {
		TypedQuery<Missoes> query = 
				manager.createQuery("SELECT a FROM Missoes a", Missoes.class);
		return query.getResultList();
	}
	
	public void apagar(Missoes missoes) {
		manager.getTransaction().begin();
		manager.remove(missoes);
		manager.getTransaction().commit();
	}

	public void apagar(Long id) {
		apagar(buscarPorId(id));
	}

	public Missoes buscarPorId(Long id) {
		return manager.find(Missoes.class, id);
	}
	
	public Missoes editar(Missoes entity) {
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
		return entity;
	}
	public void create(Missoes missoes) {
		manager.getTransaction().begin();
		manager.persist(missoes);
		manager.getTransaction().commit();
		
	}
}