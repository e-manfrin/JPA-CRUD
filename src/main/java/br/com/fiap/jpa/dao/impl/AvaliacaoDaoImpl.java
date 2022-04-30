package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.AvaliacaoDao;
import br.com.fiap.jpa.entity.Avaliacao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class AvaliacaoDaoImpl implements AvaliacaoDao{

	private EntityManager em;
	
	public AvaliacaoDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Avaliacao avaliacao) {
		em.persist(avaliacao);	
	}

	public void atualizar(Avaliacao avaliacao) {
		em.merge(avaliacao);
	}

	public Avaliacao buscar(Integer codigo) throws IdNotFoundException {
		Avaliacao avaliacao = em.find(Avaliacao.class, codigo);
		if(avaliacao == null) {
			throw new IdNotFoundException();
		}
		return avaliacao;
	}

	public void deletar(Integer codigo) throws IdNotFoundException {
		Avaliacao avaliacao = buscar(codigo);
		em.remove(avaliacao);
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
