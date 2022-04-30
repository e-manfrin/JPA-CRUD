package br.com.fiap.jpa.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_RATE_ALUNO")
@SequenceGenerator(name="aluno",sequenceName = "SQ_TB_ALUNO", allocationSize = 1)
public class Aluno {

	@Id
	@Column(name="cd_aluno")
	@GeneratedValue(generator = "aluno", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_aluno", nullable = false, length = 50)
	private String nome;
	
	@Column(name="dt_nascimento")
	private LocalDate dataNascimento;
	
	@Column(name="st_aluno")
	private Boolean stAluno;
	
	@ManyToMany
	@JoinTable(name="T_RATE_INSTITUICAO_ALUNO",
	joinColumns= {@JoinColumn(name="cd_aluno")},
	inverseJoinColumns= {@JoinColumn(name="cd_instituicao")})
	private List<Instituicao> listInstituicao = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="T_RATE_TURMA_ALUNO",
	joinColumns= {@JoinColumn(name="cd_aluno")},
	inverseJoinColumns= {@JoinColumn(name="cd_turma")})
	private List<Turma> listTurma = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="cd_identidade")
	private Identidade codigoIdentidade;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setCodigoIdentidade(Identidade codigoIdentidade) {
		this.codigoIdentidade = codigoIdentidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getStAluno() {
		return stAluno;
	}

	public void setStAluno(Boolean stAluno) {
		this.stAluno = stAluno;
	}

	public List<Instituicao> getListInstituicao() {
		return listInstituicao;
	}

	public void addListInstituicao(Instituicao instituicao) {
		this.listInstituicao.add(instituicao);
	}

	public List<Turma> getListTurma() {
		return listTurma;
	}

	public void addListTurma(Turma turma) {
		this.listTurma.add(turma);
	}

	public void setListInstituicao(List<Instituicao> listInstituicao) {
		this.listInstituicao = listInstituicao;
	}

	public void setListTurma(List<Turma> listTurma) {
		this.listTurma = listTurma;
	}

	public Aluno() {}

	public Aluno(String nome, LocalDate dataNascimento, Boolean stAluno) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.stAluno = stAluno;
	}

	@Override
	public String toString() {
		return "Aluno [codigo=" + codigo + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", stAluno="
				+ stAluno + ", listInstituicao=" + listInstituicao + ", listTurma=" + listTurma + ", codigoIdentidade="
				+ codigoIdentidade + "]";
	}
}
