package br.com.fiap.jpa.view.identidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Identidade;

public class ExemploRemocao {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Identidade identidade = em.find(Identidade.class, 1);
		if(identidade == null) {
			throw new RuntimeException("Identidade não encontrada");
		}
		
		em.remove(identidade);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

}
