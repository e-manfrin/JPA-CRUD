package br.com.fiap.jpa.view.instituicao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import br.com.fiap.jpa.dao.InstituicaoDao;
import br.com.fiap.jpa.dao.impl.InstituicaoDaoImpl;
import br.com.fiap.jpa.entity.Instituicao;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class ExemploRemocao {

	public static void main(String[] args) throws IdNotFoundException {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		InstituicaoDao instituicaoSQL = new InstituicaoDaoImpl(em);
		
		try {
			em.getTransaction().begin();
			instituicaoSQL.deletar(1);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().begin();
			Instituicao instituicao = em.find(Instituicao.class, 1);
			instituicao.setAtivo(0);
			em.merge(instituicao);
			em.getTransaction().commit();
		}
		
		em.close();
		fabrica.close();
	}
}
