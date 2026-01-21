package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.Chamado;

public class ChamadoDAO {
	private EntityManager em;

	public ChamadoDAO(EntityManager em) {
		this.em = em;
	}

	public Chamado insert(Chamado chamado) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(chamado);
			em.getTransaction().commit();
			return chamado;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}

	}

	public void delete(int id) throws Exception {
		try {
			em.getTransaction().begin();
			em.remove(getById(id));;
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
	}

	public List<Chamado> getAll() throws Exception {
		try {
			String jpql = "SELECT c FROM Chamado c";
			List<Chamado> chamado = em.createQuery(jpql, Chamado.class).getResultList();
			return chamado;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
	}

	public Chamado getById(int id) throws Exception {
		try {
			em.getTransaction().begin();
			Chamado chamado = em.find(Chamado.class, id);
			em.getTransaction().commit();
			return chamado;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
	}

	public void update(int id, String titulo, String descricao, String status) throws Exception {
		try {
			Chamado chamado = this.getById(id);
			em.getTransaction().begin();
			em.persist(chamado);
			chamado.setTitulo(titulo);
			chamado.setDescricao(descricao);
			chamado.setStatus(status);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
	}

}
