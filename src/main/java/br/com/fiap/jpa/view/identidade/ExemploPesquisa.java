package br.com.fiap.jpa.view.identidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Identidade;

public class ExemploPesquisa {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle"); 
		
		EntityManager em = fabrica.createEntityManager();
		
		Identidade identidade = em.find(Identidade.class, 1);
		if(identidade == null) {
			throw new RuntimeException("Identidade não encontrada");
		}
		
		System.out.println(identidade.getNrRg());
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

}
