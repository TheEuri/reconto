package br.edu.cesarschool.cc.projetos3.entidades;

public class Cadastro {
	private String nome;
	private String email;
	private String senha;
	private Empresa empresa;
	
	public Cadastro(String nome, String email, String senha, Empresa empresa) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.empresa = empresa;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	protected String esquecerSenha (String email) {
		//implementar caso precise
		return null;
		
	}
	private void trocarSenha(String senhaAtual, String senhaNova) {
		//implementar caso precise
		
	}



}
