package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_RATE_INSTITUICAO")
@SequenceGenerator(name="intituicao",sequenceName = "SQ_TB_INSTITUICAO", allocationSize = 1)
public class Instituicao {

	@Id
	@Column(name="cd_intituicao")
	@GeneratedValue(generator = "intituicao", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_intituicao", nullable = false, length = 50)
	private String nome;
	
	@Column(name="nr_cnpj")
	private Integer cnpj;
	
	@Column(name="ds_plano", nullable = false, length = 50)
	private String plano;
	
	private Integer ativo;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getcnpj() {
		return cnpj;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}
	
	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public Instituicao() {
		ativo = 1;
	}

	public Instituicao(String nome, Integer cnpj, String plano) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.plano = plano;
		ativo = 1;
	}
}
