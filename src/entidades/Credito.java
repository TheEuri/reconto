package entidades;

public class Credito {
    private int creditos;
    private Cliente cliente;
    private Empresa empresa;

    public Credito(int creditos, Cliente cliente, Empresa empresa) {
        this.creditos = creditos;
        this.cliente = cliente;
        this.empresa = empresa;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public CupomDescontoGerado gerarCupom(CupomDesconto cupomDesconto) {
    	// implementar caso precise
        return null;
    }
}




	





