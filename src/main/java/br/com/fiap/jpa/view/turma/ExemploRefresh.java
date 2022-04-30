package br.com.fiap.jpa.view.turma;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Turma;

public class ExemploRefresh {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Turma turma = em.find(Turma.class, 1);
		
		if (turma == null) {
			throw new RuntimeException("Turma não encontrada");
		}
		
		turma.setNome("Não tem nova turma");
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.refresh(turma);
		
		System.out.println(turma.getCodigo());
		
		em.close();
		fabrica.close();
	}
}
