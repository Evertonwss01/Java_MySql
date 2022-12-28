//package com.CrudJspJava.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//import com.CrudJspJava.modelo.Usuario;

public class UsuarioDao {

	// ############### Conexao com o Banco de Dados ####################### //
	
	public static Connection getConnection() {
		Connection conexao =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/CrudJscp","root","password");
			
		}catch(Exception w) {
			w.printStackTrace();
		}
		return conexao;
	}
	
	// ######################  Criar um Usuario  ######################## //
	
	public static int CriarUsuario(Usuario usu) {
		int status =0;
		try {
		Connection conexao = getConnection();
		PreparedStatement pstm = conexao.prepareStatement("INSERT INTO usuario (nome, password, email, sexo, pais) VALUES (?,?,?,?,?)");
		
		pstm.setString(1, usu.getNome());
		pstm.setString(2, usu.getSenha());
		pstm.setString(3, usu.getEmail());
		pstm.setString(4, usu.getSexo());
		pstm.setString(5, usu.getPais());
		
		status = pstm.executeUpdate();
		
		}catch(Exception e) {
			System.out.println("ERRO "+e.getMessage());
			e.printStackTrace();
		}
		
		return status;
	}
	
	// ###################  Pegar um Usuario Especifico como uma busca  ##################### //
	
	public static Usuario PegarEspecifico(int id) {
		Usuario usu = null;
		try {
			Connection conexao = getConnection();
			PreparedStatement pstm = conexao.prepareStatement("SELECT * FROM usuario WHERE id =?");
			
			// Executar com o pstm Primeiro //
			pstm.setInt(1, id);
			
			// Como sera um retorno, será usado o ResultSet//
			ResultSet retorno = pstm.executeQuery();
			
			// Usa um While para percorrer os campos do banco e retornar os valores //
			while(retorno.next()) {
				// Cria uma Instacia de Usuario //
				usu = new Usuario();
				// Passar os Valores //
				usu.setId(retorno.getInt("id"));
				usu.setNome(retorno.getString("nome"));
				usu.setSenha(retorno.getString("password"));
				usu.setEmail(retorno.getString("email"));
				usu.setSexo(retorno.getString("sexo"));
				usu.setPais(retorno.getString("pais"));
			}
		}catch(Exception e) {e.printStackTrace();}
		return usu;
	}
	
	// #######################  Atualizar Dados de um Usuario  ################################ //
	
	public static int AtualizarCadastro(Usuario usu) {
		int status =0;
		try {
		Connection conexao = getConnection();
		PreparedStatement pstm = conexao.prepareStatement("UPDATE usuario SET nome=?, password=?, email=?, sexo=?, pais=? WHERE id= ?");
		
		// Passar novo valores aos campos do Banco //
		
		pstm.setString(1, usu.getNome());
		pstm.setString(2, usu.getSenha());
		pstm.setString(3, usu.getEmail());
		pstm.setString(4, usu.getSexo());
		pstm.setString(5, usu.getPais());
		pstm.setInt(6, usu.getId());
		
		status = pstm.executeUpdate();
		
		}catch(Exception w) {w.printStackTrace();}
		return status;
	}
	
	// #######################  Apagar Dados de um Usuario no Banco  ################################ //
	
	public static int AgagarUsuario(Usuario usu) {
		int status=0;
		try {
			Connection conexao = getConnection();
			PreparedStatement pstm = conexao.prepareStatement("DELETE FROM usuario WHERE id =?");
			
			pstm.setInt(1,usu.getId());
			
			status = pstm.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
		return status;
		
		
	}
	
	// #####################  Listar Registros de um Usuario  ######################## //
	
	public static  List<Usuario> PegarLista(){
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			Connection conexao = getConnection();
			PreparedStatement pstm = conexao.prepareStatement("SELECT * FROM usuario");
			
			ResultSet retorno = pstm.executeQuery();
			// Percorre o Banco e Setando os valores na Lista //
			while(retorno.next()) {
				
				// Criar uma Instancia de Usuario // 
				Usuario usu = new Usuario();
				
				usu.setId(retorno.getInt("id"));
				usu.setNome(retorno.getString("nome"));
				usu.setSenha(retorno.getString("password"));
				usu.setEmail(retorno.getString("email"));
				usu.setSexo(retorno.getString("sexo"));
				usu.setPais(retorno.getString("pais"));
				
				// Adicionar na Lista os Dados //
				lista.add(usu);
			}
			
		}catch(Exception e) {e.printStackTrace();}
		
		return lista;
	}
}