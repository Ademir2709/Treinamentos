import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class criaConexao {

	public Connection recuperaConexao() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost:3306/lojavirtual?useTimezone=true&serverTimezone=UTC",
				"root", "");
	}
}
