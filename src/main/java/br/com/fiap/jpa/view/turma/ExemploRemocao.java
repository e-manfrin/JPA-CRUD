package br.com.fiap.jpa.view.turma;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import br.com.fiap.jpa.dao.TurmaDao;
import br.com.fiap.jpa.dao.impl.TurmaDaoImpl;
import br.com.fiap.jpa.entity.Turma;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class ExemploRemocao {

	public static void main(String[] args) throws IdNotFoundException {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		TurmaDao turmaSQL = new TurmaDaoImpl(em);
		
		try {
			em.getTransaction().begin();
			turmaSQL.deletar(1);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().begin();
			Turma turma = em.find(Turma.class, 1);
			turma.setAtivo(0);
			em.merge(turma);
			em.getTransaction().commit();
		}
		
		em.close();
		fabrica.close();

	}

}
