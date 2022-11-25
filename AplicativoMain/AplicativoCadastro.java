//package br.com.AppCadastro;
import DAO.*;
import modelos.*;

import java.util.Date;

public class AplicativoCadastro {
	public static void main(String args[]) {
		
		// Cria um Objeto da Classe UsusarioDao para apartir dele possa ser chamodo os Metodos do CRUD //
		UsuarioDao pessoa1 = new UsuarioDao();
		// Cria um outro Objeto Ususario, para Setar os valores em seus Campos //
		Usuario usu1 = new Usuario();
		usu1.setLogin("Quadro1786");
		usu1.setSenha("foto@789");
		usu1.setDataRegistro(new Date());
		
		// Agora fasso a chamada dos metodos CRUD, com o Objeto "pessoa1" da classe UsuarioDao //
		pessoa1.Criar(usu1);
		
// ######################################### //
		
		// Listar os Usuarios criados //
		
		for(Usuario percorre:UsuarioDao.pegarLista()) {
			System.out.println("############################################");
			System.out.println(" Nº de Indentificação do Usuario: "+percorre.getId());
			System.out.println(" Login do Usuario: "+percorre.getLogin());
			System.out.println(" Senha do Usuario: "+percorre.getSenha());
			System.out.println("############################################");
		}
	}
}
