package entidades;

public class Produto {
	private String nome;
	private String codigo;
	private Fabricante fabricante;
	public Produto(String nome, String codigo, Fabricante fabricante) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.fabricante = fabricante;
	}

  public Produto(String nome, String codigo, String fabricante) {
    this.nome = nome;
    this.codigo = codigo;
    this.fabricante = new Fabricante(fabricante);
  }

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}


}
