package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ProfessorDao;
import br.com.fiap.jpa.entity.Professor;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class ProfessorDaoImpl implements ProfessorDao{

	private EntityManager em;
	
	public ProfessorDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Professor cadastrar) {
		em.persist(cadastrar);
	}

	public void atualizar(Professor cadastrar) {
		em.merge(cadastrar);	
	}

	public Professor buscar(Integer codigo) throws IdNotFoundException {
		Professor professor = em.find(Professor.class, codigo);
		if(professor == null) {
			throw new IdNotFoundException();
		}
		return professor;
	}

	public void deletar(Integer codigo) throws IdNotFoundException {
		Professor professor = buscar(codigo);
		em.remove(professor);
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
