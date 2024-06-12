package br.edu.cesarschool.cc.projetos3.entidades;

import java.time.LocalDate;

public class CupomDescontoGerado {
    private String codigo;
    private LocalDate validade;
    private CupomDesconto cupomDesconto;
    private Cliente cliente;

    public CupomDescontoGerado(String codigo, LocalDate validade, CupomDesconto cupomDesconto, Cliente cliente) {
        this.codigo = codigo;
        this.validade = validade;
        this.cupomDesconto = cupomDesconto;
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public CupomDesconto getCupomDesconto() {
        return cupomDesconto;
    }

    public void setCupomDesconto(CupomDesconto cupomDesconto) {
        this.cupomDesconto = cupomDesconto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
