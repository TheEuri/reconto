package mediator;

import dao.GenericDAO;
import entidades.Descarte;

public class DescarteMediator {
    private GenericDAO<Descarte> descarteDao;
    private static DescarteMediator instancia;

    private DescarteMediator() {
        descarteDao = new GenericDAO<>();
    }

    public static DescarteMediator obterInstancia() {
        if (instancia == null) {
            instancia = new DescarteMediator();
        }
        return instancia;
    }

    public Descarte buscar(String id) {
        return descarteDao.buscar(id);
    }

    public String validar(Descarte descarte) {
        return "Validação realizada com sucesso.";
    }

    public String incluir(Descarte descarte) {
        if (descarteDao.incluir(descarte)) {
            return "Descarte incluído com sucesso.";
        } else {
            return "Falha ao incluir descarte.";
        }
    }

    public String alterar(Descarte descarte) {
        if (descarteDao.alterar(descarte)) {
            return "Descarte alterado com sucesso.";
        } else {
            return "Falha ao alterar descarte.";
        }
    }

    public String excluir(String id) {
        if (descarteDao.excluir(id)) {
            return "Descarte excluído com sucesso.";
        } else {
            return "Falha ao excluir descarte.";
        }
    }
}
