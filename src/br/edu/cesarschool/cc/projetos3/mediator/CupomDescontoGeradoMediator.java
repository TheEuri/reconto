package br.edu.cesarschool.cc.projetos3.mediator;

import br.edu.cesarschool.cc.projetos3.dao.GenericDAO;
import br.edu.cesarschool.cc.projetos3.entidades.CupomDescontoGerado;

public class CupomDescontoGeradoMediator {
    private GenericDAO<CupomDescontoGerado> cupomDescontoGeradoDAO;
    private static CupomDescontoGeradoMediator instancia;

    private CupomDescontoGeradoMediator() {
        cupomDescontoGeradoDAO = new GenericDAO<>();
    }

    public static CupomDescontoGeradoMediator obterInstancia() {
        if (instancia == null) {
            instancia = new CupomDescontoGeradoMediator();
        }
        return instancia;
    }

    public CupomDescontoGerado buscar(String codigo) {
        return cupomDescontoGeradoDAO.buscar(codigo);
    }

    public String validar(CupomDescontoGerado cupomDescontoGerado) {
        return "Validação realizada com sucesso.";
    }

    public String incluir(CupomDescontoGerado cupomDescontoGerado) {
        if (cupomDescontoGeradoDAO.incluir(cupomDescontoGerado)) {
            return "Cupom de desconto gerado incluído com sucesso.";
        } else {
            return "Falha ao incluir cupom de desconto gerado.";
        }
    }

    public String alterar(CupomDescontoGerado cupomDescontoGerado) {
        if (cupomDescontoGeradoDAO.alterar(cupomDescontoGerado)) {
            return "Cupom de desconto gerado alterado com sucesso.";
        } else {
            return "Falha ao alterar cupom de desconto gerado.";
        }
    }

    public String excluir(String codigo) {
        if (cupomDescontoGeradoDAO.excluir(codigo)) {
            return "Cupom de desconto gerado excluído com sucesso.";
        } else {
            return "Falha ao excluir cupom de desconto gerado.";
        }
    }
}
