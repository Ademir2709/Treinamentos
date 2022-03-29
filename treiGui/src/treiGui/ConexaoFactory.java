package treiGui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public Connection recuperaConexao() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/treigui?useTimezone=true&serverTimezone=UTC",
				"root",
				""
			);
	}

}
