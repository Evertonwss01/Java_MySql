package com.Crudjsp.Dao;					// Pacote Atual //
import com.Crudjsp.modelos.Usuario;
import com.Crudjsp.Dao.Conexao;				// Pacote de Conexao com o Banco //
import com.Crudjsp.modelos.*;				// Pacote dos Modelos //

//import java.util.Date;
import java.sql.Connection;			// Pacote de Conexao com o Banco SQL //
import java.sql.PreparedStatement;	// Pacote de Preparacao de Query para ser executada no Banco de Dados //
import java.sql.ResultSet;			// Pacote de Retorno do Banco de Dados o ResultSet //
import java.sql.SQLException;		// Exceção de MySql //
import java.util.ArrayList;			// ArrayLista para Listar todos os Registros do Banco //
import java.util.List;				// O tipo List //
import java.sql.Date;				// Pacote para trazer a Data Atual //

public class UsuarioDao {

	// Metodo Criate //
	public static int Criar(Usuario uso) {
		
		// Essa Variavel guardará o resultado 0 para Erro ou 1 para certo, será util para utilizamos na paginas WEB //
		int status =0;
		// Variavel String com o comando MySql //
		String sql = "INSERT INTO Usuario (nome, username, password, dataRegistro)values( ?, ?, ?, ?)";
		
		// Variaveis | "conexao" para conexao com o Banco | "pstm" para Preparar a String para executar no Banco //
		Connection conexao = null;
		PreparedStatement pstm = null;
		
		try {
		// Cria a Conexao | Prepara a String "slq" para o "pstm" //
			conexao = Conexao.createConnectionMySQL();
			pstm = conexao.prepareStatement(sql);
		// Passa os valores que serão adicionados nos parametros //
			pstm.setString(1, uso.getNome());
			pstm.setString(2, uso.getLogin());
			pstm.setString(3, uso.getSenha());
			pstm.setDate(4, new Date(uso.getDataRegistro().getTime()));
		// Excuta a Query // 
			status = pstm.executeUpdate();
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
		return status;
	}
	
	// ###################  Pegar um Usuario Especifico como uma busca  ##################### //
	
	public static Usuario PegarUsuarioEspacifico(int id) {
		Usuario usu = null;
		
		String sql = "SELECT * FROM Usuario WHERE id =?";
		Connection conexao = null;
		PreparedStatement pstm = null;
		try {
			conexao = Conexao.createConnectionMySQL();
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, id);
			
			pstm.execute();
			ResultSet retorno = pstm.executeQuery();
			while(retorno.next()) {
				// Cria uma Instacia de Usuario //
				usu = new Usuario();
				// Passar os Valores //
				usu.setId(retorno.getInt("id"));
				usu.setNome(retorno.getString("nome"));
				usu.setLogin(retorno.getString("username"));
				usu.setSenha(retorno.getString("password"));
			}
		}catch(Exception e) {e.printStackTrace();}
	return usu;		
			
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
				usu.setNome(retorno.getString("nome"));
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
	public static int Atualizar(Usuario uso) {
		int status =0;
		String slq = "UPDATE Usuario SET nome = ?, username = ?, password = ?, dataRegistro = ? WHERE id = ?";
		
		Connection conexao = null;
		PreparedStatement pstm = null;
		try {
			conexao = Conexao.createConnectionMySQL();
			pstm = conexao.prepareStatement(slq);
			
			pstm.setString(1, uso.getNome());
			pstm.setString(2, uso.getLogin());
			pstm.setString(3, uso.getSenha());
			pstm.setDate(4, new Date(uso.getDataRegistro().getTime()));
			
			// Informar qual será o Id, que será modificado //
			pstm.setInt(4, uso.getId());
			
			status = pstm.executeUpdate();
			System.out.println("Atualização Concluida !");
		}catch(SQLException w) {
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
		return status;
	}
	
	
	// Metodo Delete //
	public static int Apagar(int id) {
		int status =0;
		String sql = "DELETE FROM Usuario WHERE id = ?";
		
		Connection conexao = null;
		PreparedStatement pstm = null;
		try{
			conexao = Conexao.createConnectionMySQL();
			pstm = conexao.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.executeQuery();
		}catch(Exception w){
			w.printStackTrace();
		}
		finally{
			try{
				if (pstm != null){
					pstm.close();
				}
				if(conexao != null){
					conexao.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return status;
	}
}