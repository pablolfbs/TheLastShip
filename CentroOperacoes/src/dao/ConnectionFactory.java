package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://tfs.academico.net.br:3306/bdg4develop?useTimezone=true&serverTimezone=UTC", "bdg4develop", "Rn4dS");
			System.out.println("Conectado com sucesso!!");
		} catch (SQLException e) {
			System.out.println("Não pode conectar: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

}
