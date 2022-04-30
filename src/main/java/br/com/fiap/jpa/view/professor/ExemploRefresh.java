package br.com.fiap.jpa.view.professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Professor;

public class ExemploRefresh {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Professor professor = em.find(Professor.class, 9);
		if (professor == null) {
			throw new RuntimeException("Professor não encontrada");
		}
		
		System.out.println(professor.getNome());
		
		System.out.println(professor.getCodigo());
		
		em.refresh(professor);
		
		System.out.println(professor.getCodigo());
		
		em.close();
		fabrica.close();
	}
}
