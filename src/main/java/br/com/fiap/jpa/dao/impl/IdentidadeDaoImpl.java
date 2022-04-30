package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.IdentidadeDao;
import br.com.fiap.jpa.entity.Identidade;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class IdentidadeDaoImpl implements IdentidadeDao{

	private EntityManager em;
	
	public IdentidadeDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Identidade identidade) {
		em.persist(identidade);
		
	}
	
	public void atualizar(Identidade identidade) {
		em.merge(identidade);
		
	}

	public Identidade buscar(Integer codigoIdentidade) throws IdNotFoundException {
		Identidade identidade = em.find(Identidade.class, codigoIdentidade);
			if(identidade == null) {
				throw new IdNotFoundException();
			}
		return identidade;
	}

	public void deletar(Integer codigoIdentidade) throws IdNotFoundException {
		Identidade identidade = buscar(codigoIdentidade);
		em.remove(identidade);
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
		
	}
}
