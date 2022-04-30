package br.com.fiap.jpa.view.aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Aluno;

public class ExemploPesquisa {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Aluno aluno = em.find(Aluno.class, 41);
		if (aluno == null) {
			throw new RuntimeException("Aluno não encontrada");
		}
		
		System.out.println(aluno.getNome());
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();	
	}
}
