package entidades;

import java.util.List;

public class Cliente extends Cadastro {
    
    private boolean permissaoLocalizacao;
    private String cpf;
    private Endereco endereco;
    private List<Credito> creditos;
    private List<CupomDescontoGerado> cupomDescontoGerado;

    
    public boolean isPermissaoLocalizacao() {
		return permissaoLocalizacao;
	}

	public void setPermissaoLocalizacao(boolean permissaoLocalizacao) {
		this.permissaoLocalizacao = permissaoLocalizacao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Credito> getCreditos() {
		return creditos;
	}

	public void setCreditos(List<Credito> creditos) {
		this.creditos = creditos;
	}

	public List<CupomDescontoGerado> getCupomDescontoGerado() {
		return cupomDescontoGerado;
	}

	public void setCupomDescontoGerado(List<CupomDescontoGerado> cupomDescontoGerado) {
		this.cupomDescontoGerado = cupomDescontoGerado;
	}

	public Cliente(String nome, String email, String senha, Empresa empresa, boolean permissaoLocalizacao, String cpf,
			Endereco endereco, List<Credito> creditos, List<CupomDescontoGerado> cupomDescontoGerado) {
		super(nome, email, senha, empresa);
		this.permissaoLocalizacao = permissaoLocalizacao;
		this.cpf = cpf;
		this.endereco = endereco;
		this.creditos = creditos;
		this.cupomDescontoGerado = cupomDescontoGerado;
	}

	public void adicionarCreditos(Empresa empresa, int qtdCredito) {
        // Implementar lógica ou lançar exceção se ainda não implementado
        // throw new UnsupportedOperationException("Método ainda não implementado.");
    }

    public void debitarCreditos(Empresa empresa, int qtdCreditos) {
        // Implementar lógica ou lançar exceção se ainda não implementado
        // throw new UnsupportedOperationException("Método ainda não implementado.");
    }

    public void adicionarDescarte(Descarte descarte) {
        // Implementar lógica ou lançar exceção se ainda não implementado
        // throw new UnsupportedOperationException("Método ainda não implementado.");
    }

    public void consultarCreditos(Empresa empresa) {
        // Implementar lógica ou lançar exceção se ainda não implementado
        // throw new UnsupportedOperationException("Método ainda não implementado.");
    }
}

