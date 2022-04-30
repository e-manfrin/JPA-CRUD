package br.com.fiap.jpa.view.identidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Identidade;

public class ExemploAtualizar {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Identidade identidade = new Identidade("34.567.345-6");
		
		Identidade copia = em.merge(identidade);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		copia.setNrRg("99.567.345-9");
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

}
