import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	// Usuario | senha | Local | Link de Conexao com o Banco | //
	private static final String Usuario = "root";
	private static final String Senha = "password";
	private static String LocalBD = "localhost";
	private static String DataBase_url = "jdbc:mysql://"+LocalBD+":3306/Cadastro";
	
	// Criacao de uma variavel do tipo Connection //
	private static Connection conexao = null;
	
	// Funcao de Criacao da Conexao com o Banco //
	public static Connection createConnectionMySQL() {
		try {
			conexao = DriverManager.getConnection(DataBase_url, Usuario, Senha);
			
		}catch(SQLException e) {
			throw new RuntimeException("Ocorreu um Erro na Conexao com o Banco "+e);
		}
		return conexao;
	}
	
	// Funcao de Fechamento da Conexao com o Banco //
	public static void CloseConnectionMySQL() {
		try {
			if (conexao != null) {
				conexao.close();
				System.out.println("Conexao com o Banco Fechada com Sucesso !");
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro no Fechamento da Conexao com o Banco de Dados. "+e.getMessage());
		}
	}
}
