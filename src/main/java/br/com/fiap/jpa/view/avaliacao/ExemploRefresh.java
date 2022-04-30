package br.com.fiap.jpa.view.avaliacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Avaliacao;

public class ExemploRefresh {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Avaliacao avaliacao = em.find(Avaliacao.class, 9);
		
		System.out.println(avaliacao.getDsAvaliacao());
		
		avaliacao.setNrEstrelas(3);

		System.out.println(avaliacao.getNrEstrelas());
		
		em.refresh(avaliacao);
		
		System.out.println(avaliacao.getNrEstrelas());
		
		em.close();
		fabrica.close();
	}

}
