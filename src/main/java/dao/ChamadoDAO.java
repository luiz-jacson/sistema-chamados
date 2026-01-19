package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Chamado;

public class ChamadoDAO {
	private Connection connection;

	public ChamadoDAO(Connection connection) {
		this.connection = connection;
	}

	public Chamado insert(Chamado chamado) throws Exception {
		String sql = "INSERT INTO chamado (titulo, descricao, status) VALUES (? , ? , ?)";
		try(PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))  {

			stm.setString(1, chamado.getTitulo());
			stm.setString(2, chamado.getDescricao());
			stm.setString(3, chamado.getStatus());

			stm.execute();

			connection.commit();
			return chamado;
		} catch (Exception e) {
			connection.rollback();
			throw new Exception(e.getMessage());
		}

	}
	
	public void delete(int id) throws Exception{
		String sql = "DELETE FROM chamado WHERE id = ?";
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			stm.setInt(1, id);
			
			stm.execute();
			
			connection.commit();
			
		}catch(Exception e) {
			connection.rollback();
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Chamado> getAll() throws Exception{
		String sql = "SELECT * FROM chamado";
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			
			ResultSet rst = stm.executeQuery();
			
			List<Chamado> chamados = new ArrayList<Chamado>();
			
			while(rst.next()) {
				Chamado chamado = new Chamado();
				chamado.setId(rst.getInt("id"));
				chamado.setTitulo(rst.getString("titulo"));
				chamado.setDescricao(rst.getString("descricao"));
				chamado.setStatus(rst.getString("status"));
				
				chamados.add(chamado);
			}
			connection.commit();
			return chamados;
		}catch(Exception e){
			connection.rollback();
			throw new Exception(e.getMessage());
		}
	}
	
	public Chamado getById(int id) throws Exception{
		String sql = "SELECT * FROM chamado WHERE id = ?";
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			
			stm.setInt(1, id);
			
			ResultSet rst = stm.executeQuery();
			
				Chamado chamado = new Chamado();
				chamado.setId(rst.getInt("id"));
				chamado.setTitulo(rst.getString("titulo"));
				chamado.setDescricao(rst.getString("descricao"));
				chamado.setStatus(rst.getString("status"));
				
			connection.commit();
			return chamado;
		}catch(Exception e){
			connection.rollback();
			throw new Exception(e.getMessage());
		}
	}
	
	public void update(int id, String titulo, String descricao, String status) throws Exception{
		String sql = "UPDATE chamado SET titulo = ?, descricao = ?, status = ? WHERE id = ?";
		try(PreparedStatement stm = connection.prepareStatement(sql))  {

			stm.setString(1, titulo);
			stm.setString(2, descricao);
			stm.setString(3, status);
			stm.setInt(4, id);

			stm.execute();
			
			Integer linhasModificadas = stm.getUpdateCount();

			if (linhasModificadas == 0) {
				throw new Exception("Item não encontrado!");
			}

			if (linhasModificadas > 1) {
				throw new Exception("Mais de uma linha foi modificada!");
			}

			connection.commit();
		} catch (Exception e) {
			connection.rollback();
			throw new Exception(e.getMessage());
		}
	}

}
