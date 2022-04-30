package br.com.fiap.jpa.view.professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Professor;

public class ExemploRemocao {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();

		Professor professor = em.find(Professor.class, 9);
		if (professor == null) {
			throw new RuntimeException("Professor não encontrada");
		}
		
		em.remove(professor);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		System.out.println(professor.getCodigo());
		
		em.close();
		fabrica.close();
	}
}
