package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_RATE_CURSO")
@SequenceGenerator(name="curso",sequenceName = "SQ_TB_CURSO", allocationSize = 1)
public class Curso {

	@Id
	@Column(name="cd_curso")
	@GeneratedValue(generator = "curso", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@ManyToMany
	@JoinTable(name="T_RATE_CURSO_MATERIA",
	joinColumns= {@JoinColumn(name="cd_curso")},
	inverseJoinColumns= {@JoinColumn(name="cd_materia")})
	private List<Materia> listMateria = new ArrayList<>();
	
	@Column(name="nm_curso", nullable = false, length = 50)
	private String nome;
	
	@Column(name="nm_periodo", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private NomePeriodo periodo;
	
	private Integer ativo;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public List<Materia> getListMateria() {
		return listMateria;
	}

	public void setListMateria(List<Materia> listMateria) {
		this.listMateria = listMateria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NomePeriodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(NomePeriodo periodo) {
		this.periodo = periodo;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public Curso() {
		ativo = 1;
	}

	public Curso(String nome) {
		this.nome = nome;
		ativo = 1;
	}

	public Curso(String nome, NomePeriodo periodo) {
		this.nome = nome;
		this.periodo = periodo;
		ativo = 1;
	}
}
