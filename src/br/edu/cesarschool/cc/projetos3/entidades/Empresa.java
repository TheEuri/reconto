package br.edu.cesarschool.cc.projetos3.entidades;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	private String descricao;
	private String telefone;
	private String logo;
	private final String cnpj;
	private List<PontoDeColeta> pontosDeColeta; 
	private List<Descarte> descartes;
	private Dados dados;
	
	public Empresa(String descricao, String telefone, String logo, String cnpj, List<PontoDeColeta> pontosDeColeta) {
		this.descricao = descricao;
		this.telefone = telefone;
		this.logo = logo;
		this.cnpj = cnpj;
		this.pontosDeColeta = pontosDeColeta != null ? pontosDeColeta : new ArrayList<>();
		this.descartes = new ArrayList<>();
	}

	public Empresa(String descricao, String telefone, String logo, String cnpj) {
		this(descricao, telefone, logo, cnpj, null);
	}

	public Empresa(String telefone, String logo, String cnpj) {
		this(null, telefone, logo, cnpj, null);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<PontoDeColeta> getPontosDeColeta() {
		return pontosDeColeta;
	}

	public void setPontosDeColeta(List<PontoDeColeta> pontosDeColeta) {
		this.pontosDeColeta = pontosDeColeta;
	}

	public List<Descarte> getDescartes() {
		return descartes;
	}

	public void setDescartes(List<Descarte> descartes) {
		this.descartes = descartes;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void adicionarPontoDeColeta(PontoDeColeta pontoDeColeta) {
		if (pontoDeColeta != null) {
			pontosDeColeta.add(pontoDeColeta);
		}
	}

	public void adicionarDescarte(Descarte descarte) {
		if (descarte != null) {
			descartes.add(descarte);
		}
	}
}

