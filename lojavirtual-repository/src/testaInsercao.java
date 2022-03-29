import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testaInsercao {

		public static void main(String[] args) throws SQLException{
			criaConexao criaconexao = new criaConexao();
			
			Connection con = criaconexao.recuperaConexao();
			
			Statement stm = con.createStatement();
			stm.execute("insert into produto(nome, descricao) values('Notebook', 'Lenovo do Brasil')"
					, Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rst = stm.getGeneratedKeys();
			while(rst.next()){
				Integer id = rst.getInt(1);
				System.out.println("O Id criado foi: " + id);
				
			}

		}
}
