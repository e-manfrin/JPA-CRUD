package br.com.fiap.jpa.view.instituicao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Instituicao;

public class ExemploAtualizacao {

	public static void main(String[] args) {
EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Instituicao instituicao = em.find(Instituicao.class, 1);
		if (instituicao == null) {
			throw new RuntimeException("Instituicao n�o encontrada");
		}
		
		instituicao.setPlano("intermedi�rio");
		
		em.merge(instituicao);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
