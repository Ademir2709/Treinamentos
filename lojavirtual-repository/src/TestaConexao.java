import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException{
	
		criaConexao criaconexao = new criaConexao();

		Connection connection = criaconexao.recuperaConexao();
		
		System.out.println("Fechando a conexão!!!");
		
		connection.close();
		
	}
}
