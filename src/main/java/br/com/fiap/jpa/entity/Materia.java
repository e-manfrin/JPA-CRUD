package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_RATE_MATERIA")
@SequenceGenerator(name="materia",sequenceName = "SQ_TB_MATERIA", allocationSize = 1)
public class Materia {
	
	@Id
	@Column(name="cd_materia")
	@GeneratedValue(generator = "materia", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_materia", nullable = false, length = 50)
	private String nomeMateria;
	
	@Column(name="ds_materia")
	private String dsMateria;

	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeMateria() {
		return nomeMateria;
	}

	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}

	public String getDsMateria() {
		return dsMateria;
	}

	public void setDsMateria(String dsMateria) {
		this.dsMateria = dsMateria;
	}

	public Materia() {
		
	}

	public Materia(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}	
}
