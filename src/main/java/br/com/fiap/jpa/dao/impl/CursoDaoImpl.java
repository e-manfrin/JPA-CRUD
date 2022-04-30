package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.CursoDao;
import br.com.fiap.jpa.entity.Curso;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class CursoDaoImpl implements CursoDao{
	
	private EntityManager em;
	
	public CursoDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Curso curso) {
		em.persist(curso);
	}

	public void atualizar(Curso curso) {
		em.merge(curso);
	}

	public Curso buscar(Integer codigo) throws IdNotFoundException {
		Curso curso = em.find(Curso.class, codigo);
		if(curso == null) {
			throw new IdNotFoundException();
		}
		return curso;
	}

	public void deletar(Integer codigo)  {
		Curso curso;
		try {
			curso = buscar(codigo);
			em.remove(curso);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
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
