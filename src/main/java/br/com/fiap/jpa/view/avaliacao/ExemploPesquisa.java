package br.com.fiap.jpa.view.avaliacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Avaliacao;

public class ExemploPesquisa {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();

		Avaliacao avaliacao = em.find(Avaliacao.class, 9);
		if (avaliacao == null) {
			throw new RuntimeException("Avaliacao n�o encontrada");
		}
		
		System.out.println(avaliacao.getDsAvaliacao());
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
