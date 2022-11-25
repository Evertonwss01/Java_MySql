import br.com.ConexaoBanco.*;		// Pacote Importado para trazer a clsse Conexao com o Banco de Dados //
import br.com.modelos.*;			// Pacote Importado para trazer a classe Modelo "Usuario" //


import java.sql.Connection;			// Pacote de Conexao com o Banco SQL //
import java.sql.PreparedStatement;	// Pacote de Preparacao de Query para ser executada no Banco de Dados //
import java.sql.ResultSet;			// Pacote
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;				// Pacote para trazer a Data Atual //

public class UsuarioDao {

	// Metodo Criate //
	public void Criar(Usuario uso) {
		
		// Variavel String com o comando MySql //
		String sql = "INSERT INTO Usuario (username, password, dataRegistro)values( ?, ?, ?)";
		
		// Variaveis | "conexao" para conexao com o Banco | "pstm" para Preparar a String para executar no Banco //
		Connection conexao = null;
		PreparedStatement pstm = null;
		
		try {
		// Cria a Conexao | Prepara a String "slq" para o "pstm" //
			conexao = Conexao.createConnectionMySQL();
			pstm = conexao.prepareStatement(sql);
		// Passa os valores que serão adicionados nos parametros //
			pstm.setString(1, uso.getLogin());
			pstm.setString(2, uso.getSenha());
			pstm.setDate(3, new Date(uso.getDataRegistro().getTime()));
		// Excuta a Query // 
			pstm.execute();
			System.out.println("Dados Salvos com Sucesso !");
		}catch(Exception e) {
			e.printStackTrace();;
		}
		
		// Vamos para a parte Final do Metodo para fehar a Conexao com a Query e o Banco de Dados. //
		finally {
			try {
		// Fechando a Conexao com a Query //
				if(pstm != null) {
					pstm.close();
				}
		// Fechando a conexao com o Banco //		
				if(conexao != null) {
					conexao.close();
				}
			}catch(Exception w) {
				w.getMessage();
			}
		}
	}
	
	
	//Metod Read //
	public static List<Usuario> pegarLista(){
		
		String sql = "SELECT * FROM Usuario";
		
		List<Usuario> pessoa = new ArrayList<Usuario>();
		
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet retorno = null;
		
		try {
			conexao = Conexao.createConnectionMySQL();
			pstm = conexao.prepareStatement(sql);
			retorno = pstm.executeQuery();
			
			while(retorno.next()) {
				Usuario usu = new Usuario();
				
				usu.setId(retorno.getInt("id"));
				usu.setLogin(retorno.getString("username"));
				usu.setSenha(retorno.getString("password"));
				
				pessoa.add(usu);
			}
		}catch(Exception w) {
			w.printStackTrace();
		}
		finally {
			try {
				if(retorno != null) {
					retorno.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conexao != null) {
					conexao.close();
				}
			}catch(Exception p) {
				p.printStackTrace();
			}
		}
		return pessoa;
	}

	// Metodo Update //
	public void Atualizar(Usuario uso) {
		
		String slq = "UPDATE Usuario SET username = ?, password = ?, dataRegistro = ? WHERE id = ?";
		
		Connection conexao = null;
		PreparedStatement pstm = null;
		try {
			conexao = Conexao.createConnectionMySQL();
			pstm = conexao.prepareStatement(slq);
			
			pstm.setString(1, uso.getLogin());
			pstm.setString(2, uso.getSenha());
			pstm.setDate(3, new Date(uso.getDataRegistro().getTime()));
			
			// Informar qual será o Id, que será modificado //
			pstm.setInt(4, uso.getId());
			
			pstm.execute();
			System.out.println("Atualizado Concluida !");
		}catch(Exception w) {
			w.printStackTrace();
		}
		finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conexao != null) {
					conexao.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
