package entidades;

import java.time.LocalDateTime;

public class PontoDeColeta {
	
	private String nome;
	private String descricaoPC; //descricaoPC = descrição ponto de coleta
	private String telefone;
	private LocalDateTime horarioFuncionamento;
	private int id; //assume-se que o id é único de cada ponto de coleta, então não poderá ser mudado, por isso n tem metodo set
	private Endereco enderecoPC;
	
	public PontoDeColeta () 
	{
		super();
	}
	
	public PontoDeColeta(String nome, String descricaoPC, String telefone, LocalDateTime horarioFuncionamento, int id, Endereco enderecoPC) 
	{
		super();
		this.nome = nome;
		this.descricaoPC = descricaoPC;
		this.telefone = telefone;
		this.horarioFuncionamento = horarioFuncionamento;
		this.id = id;
		this.enderecoPC = enderecoPC;
	}
	

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	

	public String getDescricaoPC() 
	{
		return descricaoPC;
	}
	

	public void setDescricaoPC(String descricaoPC) 
	{
		this.descricaoPC = descricaoPC;
	}
	

	public String getTelefone() 
	{
		return telefone;
	}
	

	public void setTelefone(String telefone) 
	{
		this.telefone = telefone;
	}
	

	public LocalDateTime getHorarioFuncionamento() 
	{
		return horarioFuncionamento;
	}
	

	public void setHorarioFuncionamento(LocalDateTime horarioFuncionamento) 
	{
		this.horarioFuncionamento = horarioFuncionamento;
	}
	

	public Endereco getEnderecoPC() 
	{
		return enderecoPC;
	}
	

	public void setEnderecoPC(Endereco enderecoPC) 
	{
		this.enderecoPC = enderecoPC;
	}
	

	public int getId() 
	{
		return id;
	}
	
	
	protected double calcularDistancia(Endereco endereco) //talvez endereco da pessoa?
	{
		return 0.0;//implementar
	}
	
	public String gerarId() //o id foi definido com int, então pq nesse metodo o retorno é uma string?
	{
		return null; //implementar
	}
	
	
	
}
