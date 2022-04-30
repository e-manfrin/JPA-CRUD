package br.com.fiap.jpa.view.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Curso;

public class ExemploPesquisa {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();

		Curso curso = em.find(Curso.class, 1);
		if (curso == null) {
			throw new RuntimeException("Curso n�o encontrada");
		}
		
		System.out.println(curso.getNome());
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
