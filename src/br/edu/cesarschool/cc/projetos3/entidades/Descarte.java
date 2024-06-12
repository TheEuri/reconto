package br.edu.cesarschool.cc.projetos3.entidades;

import java.util.UUID;

public class Descarte {
	private boolean statusDescarte;
	private int creditosObtidos;
	private String id;
	private String codigoAutenticacao;
	private PontoDeColeta pontoDeColeta;
	private Produto produto;
	private Empresa empresa;
	private Cliente cliente;
	
	public Descarte(boolean statusDescarte, int creditosObtidos, String id, String codigoAutenticacao,
			PontoDeColeta pontoDeColeta, Produto produto, Empresa empresa, Cliente cliente) {
		super();
		this.statusDescarte = statusDescarte;
		this.creditosObtidos = creditosObtidos;
		this.id = id;
		this.codigoAutenticacao = codigoAutenticacao;
		this.pontoDeColeta = pontoDeColeta;
		this.produto = produto;
		this.empresa = empresa;
		this.cliente = cliente;
	}

	public boolean isStatusDescarte() {
		return statusDescarte;
	}

	public void setStatusDescarte(boolean statusDescarte) {
		this.statusDescarte = statusDescarte;
	}

	public int getCreditosObtidos() {
		return creditosObtidos;
	}

	public void setCreditosObtidos(int creditosObtidos) {
		this.creditosObtidos = creditosObtidos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigoAutenticacao() {
		return codigoAutenticacao;
	}

	public void setCodigoAutenticacao(String codigoAutenticacao) {
		this.codigoAutenticacao = codigoAutenticacao;
	}

	public PontoDeColeta getPontoDeColeta() {
		return pontoDeColeta;
	}

	public void setPontoDeColeta(PontoDeColeta pontoDeColeta) {
		this.pontoDeColeta = pontoDeColeta;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String gerarCodigo() {
		 this.codigoAutenticacao = UUID.randomUUID().toString();
	     return this.codigoAutenticacao;
	}
	public String realizarDescarte(String codigoAutenticacao) {
		  if (this.codigoAutenticacao != null && this.codigoAutenticacao.equals(codigoAutenticacao)) {
	            this.statusDescarte = true;
	           // this.creditosObtidos = calcularCreditos(); // Método fictício para calcular créditos
	            return "Descarte realizado com sucesso." /*Créditos obtidos: " + this.creditosObtidos*/;
	        } else {
	            return "Código de autenticação inválido.";
	        }
	}

}

