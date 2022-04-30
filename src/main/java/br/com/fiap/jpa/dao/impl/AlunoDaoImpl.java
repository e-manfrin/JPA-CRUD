package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.AlunoDao;
import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class AlunoDaoImpl implements AlunoDao{
	
	private EntityManager em;
	

	public AlunoDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Aluno aluno) {
		em.persist(aluno);
	}

	public void atualizar(Aluno aluno) {
		em.merge(aluno);
	}

	public Aluno buscar(Integer codigo) throws IdNotFoundException {
		Aluno aluno = em.find(Aluno.class, codigo);
		if(aluno == null) {
			throw new IdNotFoundException();
		}
		return aluno;
	}

	public void deletar(Integer codigo) throws IdNotFoundException {
		Aluno aluno = buscar(codigo);
		em.remove(aluno);
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
