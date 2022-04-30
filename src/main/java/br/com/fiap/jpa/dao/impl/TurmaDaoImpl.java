package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.TurmaDao;
import br.com.fiap.jpa.entity.Turma;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class TurmaDaoImpl implements TurmaDao{

	private EntityManager em;
	
	public TurmaDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Turma turma) {
		em.persist(turma);
		
	}

	public void atualizar(Turma turma) {
		em.merge(turma);
		
	}

	public Turma buscar(Integer codigo) throws IdNotFoundException {
		Turma turma = em.find(Turma.class, codigo);
		if(turma == null) {
			throw new IdNotFoundException();
		}
		return turma;
	}

	public void deletar(Integer codigo) throws IdNotFoundException {
		Turma turma = buscar(codigo);
		em.remove(turma);
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException(); 
		}
		
	}
}
