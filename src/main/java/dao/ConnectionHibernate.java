package dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionHibernate {
	
	private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("sistema-chamados");
	
	public static EntityManager getEntityManager() {
		return em.createEntityManager();
	}
	
	
}