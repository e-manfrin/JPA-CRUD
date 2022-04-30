package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_RATE_PROFESSOR")
@SequenceGenerator(name="professor",sequenceName = "SQ_TB_PROFESSOR", allocationSize = 1)
public class Professor {

	@Id
	@Column(name="cd_professor")
	@GeneratedValue(generator = "professor", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@ManyToMany
	@JoinTable(name="T_RATE_INSTITUICAO_PROFESSOR",
	joinColumns= {@JoinColumn(name="cd_professor")},
	inverseJoinColumns= {@JoinColumn(name="cd_instituicao")})
	private List<Instituicao> listInstituicao = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="T_RATE_TURMA_PROFESSOR",
	joinColumns= {@JoinColumn(name="cd_professor")},
	inverseJoinColumns= {@JoinColumn(name="cd_turma")})
	private List<Turma> listTurma = new ArrayList<>();
	
	@Column(name="nm_professor", nullable = false, length = 50)
	private String nome;
	
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@Column(name="st_professor")
	private Boolean stProfessor;
		
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public List<Instituicao> getListInstituicao() {
		return listInstituicao;
	}

	public void setListInstituicao(List<Instituicao> listInstituicao) {
		this.listInstituicao = listInstituicao;
	}

	public List<Turma> getListTurma() {
		return listTurma;
	}

	public void setListTurma(List<Turma> listTurma) {
		this.listTurma = listTurma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getProfessor() {
		return stProfessor;
	}
	
	public void setProfessor(Boolean professor) {
		stProfessor = professor;
	}

	public Professor() {}

	public Professor(String nome, Calendar dataNascimento, Boolean stProfessor) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.stProfessor = stProfessor;
	}
}








