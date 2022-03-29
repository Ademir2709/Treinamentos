package treiGui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TestaClass {

	public static void main(String[] args) {

		final String primeiroNome = "Maestro";
		final String sobreNome = "Grill Bar";

		Pessoa pessoa = new Pessoa();

		pessoa.setPrimeiroNome(primeiroNome);
		pessoa.setSobreNome(sobreNome);
		pessoa.setNomeCompleto(primeiroNome, sobreNome);

		System.out.println("Nome completo:" + pessoa.getNomeCompleto());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		System.out.println("yyyy/MM/dd HH:mm:ss-> " + dtf.format(LocalDateTime.now()));

		try {
			ConexaoFactory factory = new ConexaoFactory();
			Connection conexao = factory.recuperaConexao();

			Statement stmt = conexao.createStatement();

			String dadosPessoa = "'" + primeiroNome + "','" + sobreNome + "','" + pessoa.getNomeCompleto() + "','"
					+ dtf.format(LocalDateTime.now()) + "'";

			String instrucaoSQL = "insert into tb_pessoa(primeiro_nome, sobrenome, nome_completo, data_criacao) values("
					+ dadosPessoa + ")";

			System.out.println(instrucaoSQL);

			stmt.execute(instrucaoSQL);

			ResultSet rs = null;

			String consultaBase = "select * from tb_pessoa";
			rs = stmt.executeQuery(consultaBase);

			System.out.println("stmt: " + stmt);

			System.out.println("Buscando dados da base...");

			ArrayList<String> dados = new ArrayList<String>();
			while (rs.next()) {
				String retornoBase = "Base de Dados " + rs.getString("id") + ", ";
				retornoBase = retornoBase + rs.getString("primeiro_nome") + ", ";
				retornoBase = retornoBase + rs.getString("sobrenome") + ", ";
				retornoBase = retornoBase + rs.getString("nome_completo") + ", ";
				retornoBase = retornoBase + rs.getString("data_criacao");
				
				dados.add(retornoBase);
				System.out.println(retornoBase);
			}
			
//			int dadosArray = dados.size();
//			int j;
//			for (j = 0; j < dadosArray; j++) {
//				System.out.println("Trazendo da ArrayList: " + dados.get(j));
//			}
			
			//ArrayList com base de dados
			
			System.out.println("Inciando DTO...");
			
			rs = stmt.executeQuery(consultaBase);

			ArrayList<Pessoa> dtopessoa = new ArrayList<Pessoa>();
			
			ArrayList<Pessoa> dtopessoaencontrada = new ArrayList<Pessoa>();
			
			String stringAPesquisar = "Maestro";

			while(rs.next()){
				Pessoa pessoa2 = new Pessoa();
				pessoa2.setPrimeiroNome(rs.getString("primeiro_nome"));
				pessoa2.setSobreNome(rs.getString("sobrenome"));
				pessoa2.setNomeCompleto(rs.getString("primeiro_nome"),rs.getString("sobrenome"));
				pessoa2.setDataCriacao(rs.getDate("data_criacao"));
				dtopessoa.add(pessoa2);
				
				System.out.println(rs.getString("primeiro_nome"));
				if(rs.getString("primeiro_nome").equals(stringAPesquisar)) {
					dtopessoaencontrada.add(pessoa2);
				}
			}
			
			int l;
			System.out.println("Início dados encotrados...");
			System.out.println("==========================");
			for(Pessoa pessoa2 : dtopessoaencontrada ) {
				System.out.println("Encontrado->" + pessoa2.getId() + ", " + pessoa2.getPrimeiroNome());
			}
			System.out.println("Fim dados encotrados...");
			
//			System.out.println("Inciando DTO 2...");
//
//			for(Pessoa pessoa2 : dtopessoa ) {
//				System.out.println(pessoa2.getPrimeiroNome() + ", " + pessoa2.getSobreNome() + ", " + pessoa2.getNomeCompleto() + ", " + pessoa2.getDataCriacao());
//			}
//			
//			int dadosDTO;
//			int k;
//			dadosDTO = dtopessoa.size();
//			System.out.println("dadosDTO 2.1:");
//			for( k = 0; k < dadosDTO; k++) {
//				System.out.println("Dados DTO:" + dtopessoa.get(k));
//			}
		}
		catch (SQLException e){
		} 
	} 
}
