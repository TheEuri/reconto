package entidades;

import java.util.List;

public class CupomDesconto {
    private int custo;
    private List<CupomDescontoGerado> cupomDescontoGerado;
    private Empresa empresa;

    public CupomDesconto(int custo, List<CupomDescontoGerado> cupomDescontoGerado, Empresa empresa) {
        this.custo = custo;
        this.cupomDescontoGerado = cupomDescontoGerado;
        this.empresa = empresa;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public List<CupomDescontoGerado> getCupomDescontoGerado() {
        return cupomDescontoGerado;
    }

    public void setCupomDescontoGerado(List<CupomDescontoGerado> cupomDescontoGerado) {
        this.cupomDescontoGerado = cupomDescontoGerado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
