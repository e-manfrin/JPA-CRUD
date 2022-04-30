package br.com.fiap.jpa.view.materia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Materia;

public class ExemploRefresh {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Materia materia = em.find(Materia.class, 1);
		if (materia == null) {
			throw new RuntimeException("Matéria não encontrada");
		}
		
		System.out.println(materia.getNomeMateria());
		
		System.out.println(materia.getCodigo());
		
		em.refresh(materia);
		
		System.out.println(materia.getCodigo());
		
		em.close();
		fabrica.close();
	}
}
