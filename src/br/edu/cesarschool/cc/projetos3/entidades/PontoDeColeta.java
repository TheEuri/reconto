package br.edu.cesarschool.cc.projetos3.entidades;

import java.time.LocalDateTime;
import java.util.Random;

public class PontoDeColeta {
	
	private String nome;
	private String descricaoPC; 
	private String telefone;
	private LocalDateTime horarioFuncionamento;
	private final int id;
	private Endereco enderecoPC;

	public PontoDeColeta() {
		this.id = gerarId(); 
	}

	public PontoDeColeta(String nome, String descricaoPC, String telefone, LocalDateTime horarioFuncionamento, Endereco enderecoPC) {
		this.nome = nome;
		this.descricaoPC = descricaoPC;
		this.telefone = telefone;
		this.horarioFuncionamento = horarioFuncionamento;
		this.enderecoPC = enderecoPC;
		this.id = gerarId(); 
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricaoPC() {
		return descricaoPC;
	}

	public void setDescricaoPC(String descricaoPC) {
		this.descricaoPC = descricaoPC;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDateTime getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(LocalDateTime horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public Endereco getEnderecoPC() {
		return enderecoPC;
	}

	public void setEnderecoPC(Endereco enderecoPC) {
		this.enderecoPC = enderecoPC;
	}

	public int getId() {
		return id;
	}

	protected double calcularDistancia(Endereco endereco) {
	// implementar se precisar
		return 0.0;
	}

	private int gerarId() {
		Random random = new Random();
		return random.nextInt(1000000); 
	}
}

