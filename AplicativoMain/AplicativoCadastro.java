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
		usu1.setNome("Marcos Antonio");
		usu1.setLogin("Quadro1786");
		usu1.setSenha("foto@789");
		usu1.setDataRegistro(new Date());
		
		// Agora fasso a chamada dos metodos CRUD, com o Objeto "pessoa1" da classe UsuarioDao //
		//pessoa1.Criar(usu1);
		
// ######################################## //

		// Atualizar os Dados do Usuario //

		UsuarioDao pessoa2 = new UsuarioDao();
		Usuario usu2 = new Usuario();
		usu2.setNome("Jose Armando");
		usu2.setLogin("ParedeHotmail");
		usu2.setSenha("Armario@4322");
		usu2.setDataRegistro(new Date());
		// Passer o Id especifico que vai passar por modificação //
		usu2.setId(2);
		// E chama o Método para Atualizar os Dados //
		pessoa2.Atualizar(usu2);

// ######################################### //

		// Apagar um Usuario no Banco //

		UsuarioDao apagar = new UsuarioDao();
		apagar.Deletar(3);

// ######################################### //
		
		// Listar os Usuarios criados //
		
		for(Usuario percorre:UsuarioDao.pegarLista()) {
			System.out.println("############################################");
			System.out.println(" Nº de Indentificação do Usuario: "+percorre.getId());
			System.out.println(" Nome do Usuario: "+percorre.getNome());
			System.out.println(" Login do Usuario: "+percorre.getLogin());
			System.out.println(" Senha do Usuario: "+percorre.getSenha());
			System.out.println("############################################");
		}
	}
}
