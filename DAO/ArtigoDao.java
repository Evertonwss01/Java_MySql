package br.com.DAO;
import br.com.ConexaoBanco.Conexao;
import br.com.modelos.Artigo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtigoDao {

	public void CriaArtigo(Artigo art) {
		
		//int idusu;
		String sql = "INSERT INTO Artigo (nome, title, resume, text, slug, dataRegistro) VALUES(?, ?, ?, ?, ?, ?);";
		try {
			Connection conexao = Conexao.createConnectionMySQL();
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			pstm.setString(1, art.getNome());
			pstm.setString(2, art.getTitulo());
			pstm.setString(3, art.getResumo());
			pstm.setString(4, art.getTexto());
			pstm.setString(5, art.getSlug());
			pstm.setDate(6, new Date(art.getDataRegistro().getTime()));
			
			pstm.execute();
			System.out.println("Artigo Criado com Sucesso !");
		}catch(Exception w) {
			System.out.println("Erro ao Tentar a conexao com o Banco !"+w.getMessage());;
		}
	}
	
	
	public static int Atualizar(Artigo art) {
		int status =0;
		
		String sql = "UPDATE Artigo SET nome=?, title=?, resume=?, text=?, slug=?, dataRegistro=? WHERE id = ?";
		
		try {
		Connection conexao = Conexao.createConnectionMySQL();
		PreparedStatement pstm = conexao.prepareStatement(sql);
		
		pstm.setString(1, art.getNome());
		pstm.setString(2, art.getTitulo());
		pstm.setString(3, art.getResumo());
		pstm.setString(4, art.getTexto());
		pstm.setString(5, art.getSlug());
		pstm.setDate(6, new Date(art.getDataRegistro().getTime()));
		
		pstm.executeUpdate();
		status = pstm.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static void Apagar(int id) {
		String sql ="DELETE * FROM Artigo WHERE id =?;";
		
		try {
			Connection conexao = Conexao.createConnectionMySQL();
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			pstm.setInt(1, id);
			pstm.execute();
			
		}catch(Exception w) {
			w.printStackTrace();
		}
	}
	
	public static List<Artigo> pegarLista(){
		List<Artigo> lista = new ArrayList<Artigo>();
		try {
			Connection conexao= Conexao.createConnectionMySQL();
			PreparedStatement pstm = conexao.prepareStatement("SELECT * FROM Artigo;");
			ResultSet retorno = pstm.executeQuery();
			
			while(retorno.next()) {
				Artigo art = new Artigo();
				art.setNome(retorno.getString("nome"));
				art.setTitulo(retorno.getString("title"));
				art.setResumo(retorno.getString("resume"));
				art.setTexto(retorno.getString("text"));
				art.setSlug(retorno.getString("slug"));
				art.setDataRegistro(retorno.getDate("dataRegistro"));
			}
											
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	} 
}

