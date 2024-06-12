package br.edu.cesarschool.cc.projetos3.mediator;

import br.edu.cesarschool.cc.projetos3.dao.GenericDAO;
import br.edu.cesarschool.cc.projetos3.entidades.PontoDeColeta;

public class PontoDeColetaMediator {
    private GenericDAO<PontoDeColeta> pontoDeColetaDao;
    private static PontoDeColetaMediator instancia;

    private PontoDeColetaMediator() {
        pontoDeColetaDao = new GenericDAO<>();
    }

    public static PontoDeColetaMediator obterInstancia() {
        if (instancia == null) {
            instancia = new PontoDeColetaMediator();
        }
        return instancia;
    }

    public PontoDeColeta buscar(String idPontoDeColeta) {
        return pontoDeColetaDao.buscar(idPontoDeColeta);
    }

    public String validar(PontoDeColeta pontoDeColeta) {
        return "Validação realizada com sucesso.";
    }

    public String incluir(PontoDeColeta pontoDeColeta) {
        if (pontoDeColetaDao.incluir(pontoDeColeta)) {
            return "Ponto de coleta incluído com sucesso.";
        } else {
            return "Falha ao incluir ponto de coleta.";
        }
    }

    public String alterar(PontoDeColeta pontoDeColeta) {
        if (pontoDeColetaDao.alterar(pontoDeColeta)) {
            return "Ponto de coleta alterado com sucesso.";
        } else {
            return "Falha ao alterar ponto de coleta.";
        }
    }

    public String excluir(String idPontoDeColeta) {
        if (pontoDeColetaDao.excluir(idPontoDeColeta)) {
            return "Ponto de coleta excluído com sucesso.";
        } else {
            return "Falha ao excluir ponto de coleta.";
        }
    }
}
