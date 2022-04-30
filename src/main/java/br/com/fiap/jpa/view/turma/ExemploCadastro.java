package br.com.fiap.jpa.view.turma;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Curso;
import br.com.fiap.jpa.entity.NomePeriodo;
import br.com.fiap.jpa.entity.Turma;

public class ExemploCadastro {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Curso curso = new Curso("ADS", NomePeriodo.MANHA);
		em.persist(curso);
		Turma turma = new Turma(curso, "Análise e Desenvolvimento de Sistemas");
		
		em.persist(turma);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
