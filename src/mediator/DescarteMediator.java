package mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    // buscarTodosDescartesCliente
    public List<Descarte> buscarTodosDescartesCliente(String cpf) {
    // Obtém a lista de todos os descartes
    List<Descarte> todosDescartes = descarteDao.buscarTodos();

    // Filtra a lista para incluir apenas os descartes do cliente especificado
    List<Descarte> descartesCliente = new ArrayList<>();
    for (Descarte descarte : todosDescartes) {
        if (descarte.getCliente().getCpf().equals(cpf)) {
            descartesCliente.add(descarte);
        }
    }

    return descartesCliente;
}

    public String gerarCodigoAutenticacao() {
    String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random random = new Random();
    StringBuilder codigo = new StringBuilder(6);
    for (int i = 0; i < 6; i++) {
        codigo.append(letras.charAt(random.nextInt(letras.length())));
    }
    return codigo.toString();
}
}
