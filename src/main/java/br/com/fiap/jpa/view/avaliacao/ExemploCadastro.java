package br.com.fiap.jpa.view.avaliacao;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Avaliacao;
import br.com.fiap.jpa.entity.Professor;

public class ExemploCadastro {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Calendar dtAvaliacaoProfessor = Calendar.getInstance();
		Professor professor = new Professor("André", dtAvaliacaoProfessor, true);
		
		Calendar dtAvaliacao = Calendar.getInstance();
		
		Avaliacao avaliacao = new Avaliacao(professor, "Aula boa", 5, dtAvaliacao); 
		
		avaliacao.setProfessor(professor);
		
		em.persist(professor);
		
		em.persist(avaliacao);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
