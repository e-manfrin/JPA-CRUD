package br.com.fiap.jpa.view.aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Aluno;

public class ExemploRemocao {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Aluno aluno = em.find(Aluno.class, 41);
		if (aluno == null) {
			throw new RuntimeException("Aluno não encontrada");
		}
		
		em.remove(aluno);

		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println(aluno.getNome());
		
		em.close();
		fabrica.close();
	}
}
