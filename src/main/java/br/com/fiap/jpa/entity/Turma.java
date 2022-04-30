package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_RATE_TURMA")
@SequenceGenerator(name="turma",sequenceName = "SQ_TB_TURMA", allocationSize = 1)
public class Turma {

	@Id
	@Column(name="cd_turma")
	@GeneratedValue(generator = "turma", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	@JoinColumn(name= "cd_curso")
	private Curso curso;
	
	@Column(name="nm_turma", nullable = false, length = 50, unique=true)
	private String nome;
	
	private Integer ativo;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public Turma() {
		ativo = 1;
	}

	public Turma(Curso curso, String nome) {
		this.curso = curso;
		this.nome = nome;
		ativo = 1;
	}
}
