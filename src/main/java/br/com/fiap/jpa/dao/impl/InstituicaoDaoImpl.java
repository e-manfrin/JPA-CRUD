package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.InstituicaoDao;
import br.com.fiap.jpa.entity.Instituicao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class InstituicaoDaoImpl implements InstituicaoDao{

	private EntityManager em;
	
	public InstituicaoDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Instituicao cadastrar) {
		em.persist(cadastrar);	
	}

	public void atualizar(Instituicao cadastrar) {
		em.merge(cadastrar);
	}

	public Instituicao buscar(Integer codigo) throws IdNotFoundException {
		Instituicao instituicao = em.find(Instituicao.class, codigo);
		if(instituicao == null) {
			throw new IdNotFoundException();
		}
		return instituicao;
	}

	public void deletar(Integer codigo) throws IdNotFoundException {
		Instituicao instituicao = buscar(codigo);
		em.remove(instituicao);
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
