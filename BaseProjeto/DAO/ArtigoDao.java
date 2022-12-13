package com.Crudjsp.Dao;
import com.Crudjsp.Dao.Conexao;
import com.Crudjsp.modelos.Artigo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtigoDao {

	public static int CriaArtigo(Artigo art) {
		int status =0;
		//int idusu;
		String sql = "INSERT INTO Artigo (nome, title, resume, text, slug, dataRegistro) VALUES(?, ?, ?, ?, ?);";
		try {
			Connection conexao = Conexao.createConnectionMySQL();
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			pstm.setString(1, art.getTitulo());
			pstm.setString(2, art.getResumo());
			pstm.setString(3, art.getTexto());
			pstm.setString(4, art.getSlug());
			pstm.setDate(5, new Date(art.getDataRegistro().getTime()));
			
			status = pstm.executeUpdate();			//System.out.println("Artigo Criado com Sucesso !");
		}catch(Exception w) {
			//System.out.println("Erro ao Tentar a conexao com o Banco !"+w.getMessage());;
		}
		return status;
	}
	
	public Artigo PegarEspecifico(int id) {
		Artigo art=null;
		String sql = "SELECT * FROM Artigo WHERE id=?";
		
		try {
			
			Connection conexao = Conexao.createConnectionMySQL();
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.execute();
			ResultSet retorno = pstm.executeQuery();
			
			while(retorno.next()) {
				art = new Artigo();
				
				art.setId(retorno.getInt("id"));
				art.setTitulo(retorno.getString("title"));
				art.setResumo(retorno.getString("resume"));
				art.setTexto(retorno.getString("text"));
				art.setSlug(retorno.getString("dataRegistro"));
				
			}
		}catch(Exception e) {e.printStackTrace();}
		
		return art;
	}
	
	
	public static int Atualizar(Artigo art) {
		int status =0;
		
		String sql = "UPDATE Artigo SET title=?, resume=?, text=?, slug=?, dataRegistro=? WHERE id = ?";
		
		try {
		Connection conexao = Conexao.createConnectionMySQL();
		PreparedStatement pstm = conexao.prepareStatement(sql);
		
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

	public static int  Apagar(int id) {
		int status =0;
		String sql ="DELETE * FROM Artigo WHERE id =?;";
		
		try {
			Connection conexao = Conexao.createConnectionMySQL();
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			pstm.setInt(1, id);
			status = pstm.executeUpdate();
			
		}catch(Exception w) {
			w.printStackTrace();
		}
		return status;
	}
	
	public static List<Artigo> pegarLista(){
		List<Artigo> lista = new ArrayList<Artigo>();
		try {
			Connection conexao= Conexao.createConnectionMySQL();
			PreparedStatement pstm = conexao.prepareStatement("SELECT * FROM Artigo;");
			ResultSet retorno = pstm.executeQuery();
			
			while(retorno.next()) {
				Artigo art = new Artigo();
				
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

