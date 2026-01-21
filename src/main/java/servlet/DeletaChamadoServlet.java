package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChamadoDAO;
import dao.ConnectionHibernate;

/**
 * Servlet implementation class DeletaChamadoServlet
 */
@WebServlet(name = "DeletaChamadoServlet", urlPatterns = {"/deletaChamado"})
public class DeletaChamadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			ChamadoDAO dao = new ChamadoDAO(ConnectionHibernate.getEntityManager());

			dao.delete(Integer.parseInt(req.getParameter("id")));


			resp.sendRedirect("chamado");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
