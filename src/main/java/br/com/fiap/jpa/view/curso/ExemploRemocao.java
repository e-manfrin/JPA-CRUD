package br.com.fiap.jpa.view.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import br.com.fiap.jpa.dao.CursoDao;
import br.com.fiap.jpa.dao.impl.CursoDaoImpl;
import br.com.fiap.jpa.entity.Curso;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class ExemploRemocao {

	public static void main(String[] args) throws IdNotFoundException  {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		CursoDao cursoSQL = new CursoDaoImpl(em);
		
		
		try {
			em.getTransaction().begin();
			cursoSQL.deletar(1);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().begin();
			Curso curso = em.find(Curso.class, 1);
			curso.setAtivo(0);
			em.merge(curso);
			em.getTransaction().commit();
		}
		
		em.close();
		fabrica.close();
	}
}
