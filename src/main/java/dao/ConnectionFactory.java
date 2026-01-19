package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/chamados");
		comboPooledDataSource.setUser("postgres");
		comboPooledDataSource.setPassword("admin");
		
		comboPooledDataSource.setMaxPoolSize(15);
		
		this.dataSource = (DataSource) comboPooledDataSource;
	}
	
	
	public Connection recuperarConexao() throws SQLException {
		 try {
		        Class.forName("org.postgresql.Driver");
		    } catch (ClassNotFoundException e) {
		        throw new RuntimeException(e);
		    }
		return this.dataSource.getConnection();
	}
	
}