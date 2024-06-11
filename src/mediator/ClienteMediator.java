package mediator;

import dao.GenericDAO;
import entidades.Cliente;
import utils.ValidadorCPF;

public class ClienteMediator {
    
    private GenericDAO<Cliente> clienteDao;
    private static ClienteMediator instancia;

    private ClienteMediator() {
        clienteDao = new GenericDAO<>();
    }

    public static ClienteMediator obterInstancia() {
        if (instancia == null) {
            instancia = new ClienteMediator();
        }
        return instancia;
    }

    public Cliente buscar(String cpf) {
        return clienteDao.buscar(cpf);
    }

    public String validar(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            return "Nome do cliente não pode ser vazio.";
        }
        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            return "CPF do cliente não pode ser vazio.";
        }
        if (!ValidadorCPF.isCpfValido(cliente.getCpf())) {
            return "CPF do cliente é inválido.";
        }
        return "Cliente válido.";
    }

    public String incluir(Cliente cliente) {
        String validacao = validar(cliente);
        if (!validacao.equals("Cliente válido.")) {
            return validacao;
        }
        if (clienteDao.incluir(cliente)) {
            return "Cliente incluído com sucesso.";
        } else {
            return "Erro ao incluir cliente. Cliente já existe.";
        }
    }

    public String alterar(Cliente cliente) {
        String validacao = validar(cliente);
        if (!validacao.equals("Cliente válido.")) {
            return validacao;
        }
        if (clienteDao.alterar(cliente)) {
            return "Cliente alterado com sucesso.";
        } else {
            return "Erro ao alterar cliente. Cliente não encontrado.";
        }
    }

    public String excluir(String cpf) {
        if (clienteDao.excluir(cpf)) {
            return "Cliente excluído com sucesso.";
        } else {
            return "Erro ao excluir cliente. Cliente não encontrado.";
        }
    }

    public Cliente autenticar(String cpf, String senha) {
        Cliente cliente = clienteDao.buscar(cpf);
        if (cliente != null && cliente.getSenha().equals(senha)) {
            return cliente;
        }
        return null;
    }
}
