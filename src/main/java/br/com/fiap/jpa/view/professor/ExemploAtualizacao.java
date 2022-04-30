package br.com.fiap.jpa.view.professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Professor;

public class ExemploAtualizacao {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Professor professor = em.find(Professor.class, 9);
		if (professor == null) {
			throw new RuntimeException("Professor não encontrada");
		}
		
		professor.setCodigo(9);
		
		em.merge(professor);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
