package br.com.fiap.jpa.view.turma;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Turma;

public class ExemploAtualizacao {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
				
		Turma turma = em.find(Turma.class, 1);
		if (turma == null) {
			throw new RuntimeException("Turma não encontrada");
		}
	
		turma.setNome("1TDSS");
		
		em.merge(turma);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
