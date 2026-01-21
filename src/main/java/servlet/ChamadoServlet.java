package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChamadoDAO;
import dao.ConnectionHibernate;
import model.Chamado;

@WebServlet(name = "chamadoServlet", urlPatterns = { "/chamado" })
public class ChamadoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			ChamadoDAO dao = new ChamadoDAO(ConnectionHibernate.getEntityManager());

			String titulo = request.getParameter("titulo");
			String descricao = request.getParameter("descricao");
			String status = request.getParameter("status");

			Chamado chamado = new Chamado();
			chamado.setTitulo(titulo);
			chamado.setStatus(status);
			chamado.setDescricao(descricao);

			Chamado result = dao.insert(chamado);
			
			response.sendRedirect("chamado");
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ChamadoDAO dao = new ChamadoDAO(ConnectionHibernate.getEntityManager());
			
			List<Chamado> chamados = dao.getAll();
			
			RequestDispatcher rd = req.getRequestDispatcher("/ListarChamados.jsp");
			req.setAttribute("chamados", chamados);
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}




}
