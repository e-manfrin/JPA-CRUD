package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_RATE_AVALIACAO")
@SequenceGenerator(name="avaliacao",sequenceName = "SQ_TB_AVALIACAO", allocationSize = 1)
public class Avaliacao {

	@Id
	@Column(name="cd_avaliacao")
	@GeneratedValue(generator = "avaliacao", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name="professor_id")
	private Professor professor;
	
	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Aluno aluno;
	
	@Column(name="ds_avaliacao")
	private String dsAvaliacao;
	
	@Column(name="nr_estrelas")
	private Integer nrEstrelas;
	
	@Column(name="dt_avaliacao")
	private Calendar dataAvaliacao;
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getDsAvaliacao() {
		return dsAvaliacao;
	}

	public void setDsAvaliacao(String dsAvaliacao) {
		this.dsAvaliacao = dsAvaliacao;
	}

	public Integer getNrEstrelas() {
		return nrEstrelas;
	}

	public void setNrEstrelas(Integer nrEstrelas) {
		this.nrEstrelas = nrEstrelas;
	}

	public Calendar getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Calendar dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public Avaliacao() {}

	public Avaliacao(Professor professor, String dsAvaliacao, Integer nrEstrelas, Calendar dataAvaliacao) {
		this.professor = professor;
		this.dsAvaliacao = dsAvaliacao;
		this.nrEstrelas = nrEstrelas;
		this.dataAvaliacao = dataAvaliacao;
	}
}












