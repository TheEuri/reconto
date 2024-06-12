package br.edu.cesarschool.cc.projetos3.mediator;

import br.edu.cesarschool.cc.projetos3.dao.GenericDAO;
import br.edu.cesarschool.cc.projetos3.entidades.Empresa;
import br.edu.cesarschool.cc.projetos3.utils.ValidadorCNPJ;

public class EmpresaMediator {
    
    private GenericDAO<Empresa> empresaDao;
    private static EmpresaMediator instancia;

    private EmpresaMediator() {
        empresaDao = new GenericDAO<>();
    }

    public static EmpresaMediator obterInstancia() {
        if (instancia == null) {
            instancia = new EmpresaMediator();
        }
        return instancia;
    }

    public Empresa buscar(String cnpj) {
        return empresaDao.buscar(cnpj);
    }

    public String validar(Empresa empresa) {
        if (empresa.getDescricao() == null || empresa.getDescricao().isEmpty()) {
            return "Descrição da empresa não pode ser vazia.";
        }
        if (empresa.getCnpj() == null || empresa.getCnpj().isEmpty()) {
            return "CNPJ da empresa não pode ser vazio.";
        }
        if (!ValidadorCNPJ.isCnpjValido(empresa.getCnpj())) {
            return "CNPJ da empresa é inválido.";
        }
        return "Empresa válida.";
    }

    public String incluir(Empresa empresa) {
        String validacao = validar(empresa);
        if (!validacao.equals("Empresa válida.")) {
            return validacao;
        }
        if (empresaDao.incluir(empresa)) {
            return "Empresa incluída com sucesso.";
        } else {
            return "Erro ao incluir empresa. Empresa já existe.";
        }
    }

    public String alterar(Empresa empresa) {
        String validacao = validar(empresa);
        if (!validacao.equals("Empresa válida.")) {
            return validacao;
        }
        if (empresaDao.alterar(empresa)) {
            return "Empresa alterada com sucesso.";
        } else {
            return "Erro ao alterar empresa. Empresa não encontrada.";
        }
    }

    public String excluir(String cnpj) {
        if (empresaDao.excluir(cnpj)) {
            return "Empresa excluída com sucesso.";
        } else {
            return "Erro ao excluir empresa. Empresa não encontrada.";
        }
    }
}
