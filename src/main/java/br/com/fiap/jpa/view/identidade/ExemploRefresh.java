package br.com.fiap.jpa.view.identidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Identidade;

public class ExemploRefresh {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Identidade identidade = em.find(Identidade.class, 1);
		if(identidade == null) {
			throw new RuntimeException("Identidade não encontrada");
		}
		
		System.out.println(identidade.getNrRg());
		
		identidade.setNrRg("12.987.987-9");
		
		System.out.println(identidade.getNrRg());
		
		em.refresh(identidade);
		
		System.out.println(identidade.getNrRg());
		
		em.close();
		fabrica.close();
	}
}
