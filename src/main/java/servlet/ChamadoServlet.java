package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChamadoDAO;
import dao.ConnectionFactory;
import model.Chamado;

@WebServlet(name = "chamadoServlet", urlPatterns = { "/chamado" })
public class ChamadoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			ConnectionFactory criaConexao = new ConnectionFactory();
			Connection connection = criaConexao.recuperarConexao();
			ChamadoDAO dao = new ChamadoDAO(connection);
			connection.setAutoCommit(false);

			String titulo = request.getParameter("titulo");
			String descricao = request.getParameter("descricao");
			String status = request.getParameter("status");

			Chamado chamado = new Chamado();
			chamado.setTitulo(titulo);
			chamado.setStatus(status);
			chamado.setDescricao(descricao);

			Chamado result = dao.insert(chamado);

			connection.close();
//			RequestDispatcher rd = request.getRequestDispatcher("/ListarChamados.jsp");
//			request.setAttribute("titulo", chamado.getTitulo());
//			rd.forward(request, response);
			
			response.sendRedirect("chamado");
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ConnectionFactory criaConexao = new ConnectionFactory();
			Connection connection = criaConexao.recuperarConexao();
			ChamadoDAO dao = new ChamadoDAO(connection);
			connection.setAutoCommit(false);
			
			List<Chamado> chamados = dao.getAll();
			

			connection.close();
			RequestDispatcher rd = req.getRequestDispatcher("/ListarChamados.jsp");
			req.setAttribute("chamados", chamados);
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ConnectionFactory criaConexao = new ConnectionFactory();
			Connection connection = criaConexao.recuperarConexao();
			ChamadoDAO dao = new ChamadoDAO(connection);
			connection.setAutoCommit(false);
			int id = Integer.parseInt(req.getParameter("id"));
			String titulo = req.getParameter("titulo");
			String descricao = req.getParameter("descricao");
			String status = req.getParameter("status");


			dao.update(id, titulo, descricao, status);

			connection.close();
			
			resp.sendRedirect("chamado");
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			ConnectionFactory criaConexao = new ConnectionFactory();
			Connection connection = criaConexao.recuperarConexao();
			ChamadoDAO dao = new ChamadoDAO(connection);
			connection.setAutoCommit(false);
			
			dao.delete(Integer.parseInt(req.getParameter("id")));
			
			connection.close();
			
			resp.sendRedirect("/chamado");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
