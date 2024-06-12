package br.edu.cesarschool.cc.projetos3.entidades;

public class Dados {
	private int qtdDescartesRealizados;
	private int qtdCupomGerados;
	public Dados(int qtdDescartesRealizados, int qtdCupomGerados) {
		super();
		this.qtdDescartesRealizados = qtdDescartesRealizados;
		this.qtdCupomGerados = qtdCupomGerados;
	}
	public int getQtdDescartesRealizados() {
		return qtdDescartesRealizados;
	}
	public void setQtdDescartesRealizados(int qtdDescartesRealizados) {
		this.qtdDescartesRealizados = qtdDescartesRealizados;
	}
	public int getQtdCupomGerados() {
		return qtdCupomGerados;
	}
	public void setQtdCupomGerados(int qtdCupomGerados) {
		this.qtdCupomGerados = qtdCupomGerados;
	}
	
}
