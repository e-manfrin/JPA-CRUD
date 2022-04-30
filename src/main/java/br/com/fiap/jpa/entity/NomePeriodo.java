package br.com.fiap.jpa.entity;

public enum NomePeriodo {

	MANHA(1),TARDE(2),NOITE(3);
	
	private int number;

	private NomePeriodo(int number) {
		this.number = number;
	}
}
