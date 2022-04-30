package br.com.fiap.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_RATE_IDENTIDADE")
@SequenceGenerator(name="identidade", sequenceName="SQ_T_RATE_IDENTIDADE", allocationSize=1)
public class Identidade {

	@Id
	@Column(name="cd_identidade")
	@GeneratedValue(generator="identidade", strategy= GenerationType.SEQUENCE)
	private Integer codigoIdentidade;
	
	@Column(name="nr_rg", nullable= false, length= 12)
	private String nrRg;
	
	@Column(name="dt_expedicao")
	private Date dtExpedicao;

	public Integer getCodigo() {
		return codigoIdentidade;
	}

	public void setCodigo(Integer codigo) {
		this.codigoIdentidade = codigo;
	}

	public String getNrRg() {
		return nrRg;
	}

	public void setNrRg(String nrRg) {
		this.nrRg = nrRg;
	}

	public Date getDtExpedicao() {
		return dtExpedicao;
	}

	public void setDtExpedicao(Date dtExpedicao) {
		this.dtExpedicao = dtExpedicao;
	}

	public Identidade(String nrRg) {
		this.nrRg = nrRg;
	}

	public Identidade() {
	}
}
