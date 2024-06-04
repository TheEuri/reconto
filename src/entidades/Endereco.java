package entidades;

public class Endereco {
	
	private String rua;
	private String cidade;
	private String estado;
	private String cep;
	private String pontoReferencia;
	
	public Endereco () 
	{
		super();
	}
	
	public Endereco(String rua, String cidade, String estado, String cep, String pontoReferencia) 
	{
		super();
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.pontoReferencia = pontoReferencia;
	}
	
	public Endereco (String rua, String cidade, String estado, String cep) 
	{
		this(rua, cidade, estado, cep, null);
	}
	

	public String getRua() 
	{
		return rua;
	}
	

	public void setRua(String rua) 
	{
		this.rua = rua;
	}
	

	public String getCidade() 
	{
		return cidade;
	}
	

	public void setCidade(String cidade) 
	{
		this.cidade = cidade;
	}
	

	public String getEstado() 
	{
		return estado;
	}
	

	public void setEstado(String estado) 
	{
		this.estado = estado;
	}
	

	public String getCep() 
	{
		return cep;
	}
	

	public void setCep(String cep) 
	{
		this.cep = cep;
	}
	

	public String getPontoReferencia() 
	{
		return pontoReferencia;
	}
	

	public void setPontoReferencia(String pontoReferencia) 
	{
		this.pontoReferencia = pontoReferencia;
	}
	
	

}
