//package com.CrudJspJava.modelo;

public class Usuario {
	
	// Atributos //
		private int id;
		private String nome;
		private String senha;
		private String email;
		private String sexo;
		private String pais;
		
		// Metodos Especiais //
		public String getEmail() {
			return email;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		public String getSexo() {
			return sexo;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		public String getPais() {
			return pais;
		}
		public void setPais(String pais) {
			this.pais = pais;
		}
		public void setEmail(String email) {
			this.email = email;
		}
}