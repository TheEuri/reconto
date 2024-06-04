package entidades;

public class Empresa {
	
	private String descricao;
	private String telefone;
	private String logo;
	private String cnpj; ;//presumi que o cnpj não será algo que vai ser permitido trocar, tendo em vista q é algo unico de cada empresa, por isso sem set
	private PontoDeColeta pontoDeColetaEmpresa; //o addPontoDeColeta do diagrama não seria o próprio set?
	
	
	public Empresa() 
	{
		super();
	}
	
	
	public Empresa(String descricao, String telefone, String logo, String cnpj, PontoDeColeta pontoDeColetaEmpresa) 
	{
		super();
		this.descricao = descricao;
		this.telefone = telefone;
		this.logo = logo;
		this.cnpj = cnpj;
		this.pontoDeColetaEmpresa = pontoDeColetaEmpresa;
	}
	
	public Empresa(String descricao, String telefone, String logo, String cnpj) //construtor sem Ponto de coleta
	{
		this(descricao, telefone, logo, cnpj, null);
	}
	
	public Empresa(String telefone, String logo, String cnpj) //construtor sem ponto de coleta e sem descrição
	{
		this(null, telefone, logo, cnpj, null);
	}
	
	public Empresa(String telefone, String logo, String cnpj, PontoDeColeta pontoDeColetaEmpresa) 
	{
		this(null, telefone, logo, cnpj, pontoDeColetaEmpresa);
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


	public PontoDeColeta getPontoDeColetaEmpresa() {
		return pontoDeColetaEmpresa;
	}


	public void setPontoDeColetaEmpresa(PontoDeColeta pontoDeColetaEmpresa) {
		this.pontoDeColetaEmpresa = pontoDeColetaEmpresa;
	}


	public String getCnpj() {
		return cnpj;
	}
	
	
	

}
