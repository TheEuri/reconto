package telas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Credito;
import entidades.CupomDescontoGerado;
import entidades.Endereco;
import mediator.ClienteMediator;
import entidades.Empresa;

public class TelaCliente {
  private static final String DIGITE_O_CPF = "Digite o CPF: ";
  private static final String CLIENTE_NAO_ENCONTRADO = "Cliente não encontrado!";
  private static final Scanner ENTRADA = new Scanner(System.in);
  private static final BufferedReader ENTRADA_STR = new BufferedReader(new InputStreamReader(System.in));
  private ClienteMediator clienteMediator = ClienteMediator.obterInstancia();

  public void inicializaTelasCadastroCliente() {
    while (true) {
      imprimeMenuPrincipal();
      int opcao = lerInteiro();
      if (opcao == 1) {
        processaInclusao();
      } else if (opcao == 2) {
        processaAlteracao();
      } else if (opcao == 3) {
        processaExclusao();
      } else if (opcao == 4) {
        processaBusca();
      } else if (opcao == 5) {
        System.out.println("Saindo...");
        break;
      } else {
        System.out.println("Opção inválida!");
      }
    }
  }

  private void imprimeMenuPrincipal() {
    System.out.println("1- Incluir");
    System.out.println("2- Alterar");
    System.out.println("3- Excluir");
    System.out.println("4- Buscar");
    System.out.println("5- Sair");
    System.out.print("Digite a opção: ");
  }

  private void processaInclusao() {
    Cliente cliente = capturaCliente();
    String retorno = clienteMediator.incluir(cliente);
    if (retorno == null) {
      System.out.println("Cliente incluído com sucesso!");
    } else {
      System.out.println(retorno);
    }
  }

  private void processaAlteracao() {
    System.out.print("Digite o CPF do cliente: ");
    String cpf = lerString();
    Cliente cliente = clienteMediator.buscar(cpf);
    if (cliente == null) {
      System.out.println("Cliente não encontrado!");
      return;
    }
    
  }

  private void processaExclusao() {
    System.out.print("Digite o CPF do cliente: ");
    String cpf = lerString();
    String retorno = clienteMediator.excluir(cpf);
    if (retorno == null) {
      System.out.println("Cliente excluído com sucesso!");
    } else {
      System.out.println(retorno);
    }
  }

  private void processaBusca() {
    System.out.print("Digite o CPF do cliente: ");
    String cpf = lerString();
    Cliente cliente = clienteMediator.buscar(cpf);
    if (cliente == null) {
      System.out.println("Cliente não encontrado!");
    } else {
      System.out.println("Dados do cliente:");
      System.out.println(cliente.toString());
    }
  }

  private Cliente capturaCliente() {
    System.out.print("Digite o nome do cliente: ");
    String nome = lerString();
    
    System.out.print("Digite o email do cliente: ");
    String email = lerString();
    
    System.out.print("Digite a senha do cliente: ");
    String senha = lerString();
    
    System.out.print("É empresa? (s/n): ");
    boolean isEmpresa = ENTRADA.next().equalsIgnoreCase("s");

    Empresa empresa = null;
    if (isEmpresa) {
      empresa = capturaEmpresa();
    } 
     
    System.out.print("Permissão de localização (true/false): ");
    boolean permissaoLocalizacao = ENTRADA.nextBoolean();
    
    System.out.print("Digite o CPF do cliente: ");
    String cpf = lerString();
    
    System.out.println("Digite o endereço do cliente:");
    Endereco endereco = capturaEndereco();
    
    List<Credito> creditos = capturaCreditos();
    List<CupomDescontoGerado> cupomDescontoGerado = capturaCuponsDesconto();
    
    return new Cliente(nome, email, senha, empresa, permissaoLocalizacao, cpf, endereco, creditos, cupomDescontoGerado);
  }
  

  private String lerString() {
    try {
      return ENTRADA_STR.readLine();
    } catch (IOException e) {
      System.out.println("Erro ao ler entrada.");
      return null;
    }

  }

  private int lerInteiro() {
    while (!ENTRADA.hasNextInt()) {
      System.out.println("Por favor, digite um número inteiro.");
      ENTRADA.next();
    }
    return ENTRADA.nextInt();
  }

  
  private Endereco capturaEndereco() {
    // Implemente caso precise
    return null;
  }

  private List<Credito> capturaCreditos() {
    // Implemente caso precise
    return null;
  }

  private List<CupomDescontoGerado> capturaCuponsDesconto() {
    // Implemente caso precise
    return null;
  }

  private Empresa capturaEmpresa() {
    // Implemente caso precise
    return null;
  }

}