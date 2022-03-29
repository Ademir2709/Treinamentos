import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class testaRemocao {

	public static void main(String[] args) throws SQLException{
		criaConexao criaconexao = new criaConexao();
		
		Connection con = criaconexao.recuperaConexao();
		
		Statement stm = con.createStatement();
		stm.execute("delete from produto where id > 2");
		
		Integer linhasAfetadas = stm.getUpdateCount();
		
		System.out.println("Quantidade de linhas afetadas:" + linhasAfetadas);
		
	}
			
			
}
