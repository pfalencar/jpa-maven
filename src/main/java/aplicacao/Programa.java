package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		
		deletar(em, 1);
//		buscarPorId(em, 5);
//		salvar(em);
		em.close();
		emf.close();
	}
	
	public static void salvar(EntityManager em) {
		Pessoa p1 = new Pessoa(null, "Silva", "silva@gmail.com");
		Pessoa p2 = new Pessoa(null, "Torres", "torres@gmail.com");
		Pessoa p3 = new Pessoa(null, "Maria", "maria@gmail.com");
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Salvo!");		
	}
	
	public static Pessoa buscarPorId(EntityManager em, int id) {
		Pessoa p = em.find(Pessoa.class, id);
		System.out.println(p);
		System.out.println("Encontrei!");
		return p;
	}
	
	public static void deletar(EntityManager em, int id) {		
		Pessoa p = em.find(Pessoa.class, id);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Deletado!");
	}
	

}
