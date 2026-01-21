package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChamadoDAO;
import dao.ConnectionHibernate;
import model.Chamado;


@WebServlet(name = "AtualizaChamadoServlet", urlPatterns = {"/atualizaChamado"})
public class AtualizaChamadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		ChamadoDAO dao = new ChamadoDAO(ConnectionHibernate.getEntityManager());
			int id = Integer.parseInt(req.getParameter("id"));
			Chamado chamado = dao.getById(id);
			
	        req.setAttribute("chamado", chamado);

	        RequestDispatcher dispatcher = req.getRequestDispatcher("atualizaChamado.jsp");

	        dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
    }


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ChamadoDAO dao = new ChamadoDAO(ConnectionHibernate.getEntityManager());
			int id = Integer.parseInt(req.getParameter("id"));
			String titulo = req.getParameter("titulo");
			String descricao = req.getParameter("descricao");
			String status = req.getParameter("status");
			
			


			dao.update(id, titulo, descricao, status);
			
			resp.sendRedirect("chamado");
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
