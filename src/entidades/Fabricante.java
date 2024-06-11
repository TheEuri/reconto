package entidades;

public class Fabricante {
	private String nome;
	private Credito credito;
	public Fabricante(String nome, Credito credito) {
		super();
		this.nome = nome;
		this.credito = credito;
	}
  public Fabricante(String nome) {
    this.nome = nome;
  }
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Credito getCredito() {
		return credito;
	}
	public void setCredito(Credito credito) {
		this.credito = credito;
	}

}
