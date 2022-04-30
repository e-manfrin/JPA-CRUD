package br.com.fiap.jpa.view.avaliacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Avaliacao;

public class ExemploRemocao {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Avaliacao avaliacao = em.find(Avaliacao.class, 9);
		if (avaliacao == null) {
			throw new RuntimeException("Avaliacao não encontrada");
		}
		
		em.remove(avaliacao);

		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println(avaliacao.getCodigo());
		
		em.close();
		fabrica.close();
	}
}
