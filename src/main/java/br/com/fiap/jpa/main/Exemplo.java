package br.com.fiap.jpa.main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GenericDao;
import br.com.fiap.jpa.dao.impl.GenericDaoImpl;
import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.Curso;
import br.com.fiap.jpa.entity.Instituicao;
import br.com.fiap.jpa.entity.NomePeriodo;
import br.com.fiap.jpa.entity.Turma;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Exemplo {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();

		EntityManager em = fabrica.createEntityManager();
		
		GenericDao<Aluno, Integer> daoAluno = new GenericDaoImpl<Aluno,Integer>(em) {};
		GenericDao<Curso, Integer> daoCurso = new GenericDaoImpl<Curso,Integer>(em) {};
		GenericDao<Turma, Integer> daoTurma = new GenericDaoImpl<Turma,Integer>(em) {};
		GenericDao<Instituicao, Integer> daoInstituicao = new GenericDaoImpl<Instituicao,Integer>(em) {};
		
		Instituicao instituicao = new Instituicao("Fiap", 123456, "basico");
		Curso curso = new Curso("ADS", NomePeriodo.MANHA);
		Turma turma = new Turma(curso, "2TDSS");
		
		Aluno aluno01 = new Aluno();
		aluno01.setNome("Ana");	
		aluno01.setDataNascimento(LocalDate.of(2000,9,14));
		aluno01.addListInstituicao(instituicao);
		aluno01.addListTurma(turma);
		
		daoCurso.cadastrar(curso);
		daoTurma.cadastrar(turma);
		daoInstituicao.cadastrar(instituicao);
		daoAluno.cadastrar(aluno01);
		
		try {
			daoCurso.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
}
