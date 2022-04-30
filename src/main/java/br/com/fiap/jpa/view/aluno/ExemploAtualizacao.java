package br.com.fiap.jpa.view.aluno;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Aluno;


public class ExemploAtualizacao {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
				
		EntityManager em = fabrica.createEntityManager();
				
		Aluno aluno = new Aluno("Maria",LocalDate.of(1965, Month.AUGUST, 10), true);
		
		Aluno copia = em.merge(aluno);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		copia.setNome("Mônica");
				
		em.getTransaction().begin();
		em.getTransaction().commit();
			
		em.close();
		fabrica.close();
			
		}
}


