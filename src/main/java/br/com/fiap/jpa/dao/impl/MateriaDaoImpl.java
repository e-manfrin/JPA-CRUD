package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.MateriaDao;
import br.com.fiap.jpa.entity.Materia;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class MateriaDaoImpl implements MateriaDao{

	private EntityManager em;
	
	public MateriaDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Materia material) {
		em.persist(material);
	}

	public void atualizar(Materia material) {
		em.merge(material);
		
	}

	public Materia buscar(Integer codigo) throws IdNotFoundException {
		Materia materia = em.find(Materia.class, codigo);
		if(materia == null) {
			throw new IdNotFoundException();
		}
		return materia;
	}

	public void deletar(Integer codigo) throws IdNotFoundException {
		Materia materia = buscar(codigo);
		em.remove(materia);
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
