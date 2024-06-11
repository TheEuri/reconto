package telas;

import javax.swing.*;
import entidades.Cliente;
import mediator.ClienteMediator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaClienteGUI extends JFrame {
  private ClienteMediator clienteMediator = ClienteMediator.obterInstancia();

  public TelaClienteGUI() {
    setTitle("Tela Cliente");
    setSize(300, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(5, 1));

    JButton incluirButton = new JButton("Incluir");
    incluirButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        processaInclusao();
      }
    });

    JButton alterarButton = new JButton("Alterar");
    alterarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        processaAlteracao();
      }
    });

    JButton excluirButton = new JButton("Excluir");
    excluirButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        processaExclusao();
      }
    });

    JButton buscarButton = new JButton("Buscar");
    buscarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        processaBusca();
      }
    });

    JButton sairButton = new JButton("Sair");
    sairButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    panel.add(incluirButton);
    panel.add(alterarButton);
    panel.add(excluirButton);
    panel.add(buscarButton);
    panel.add(sairButton);

    this.add(panel);
  }

  private void processaInclusao() {
    JDialog dialog = new JDialog(this, "Incluir Cliente", true);
    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    dialog.setSize(300, 200);
    dialog.setLocationRelativeTo(this);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(7, 1));

    JTextField nomeField = new JTextField();
    panel.add(new JLabel("Nome:"));
    panel.add(nomeField);

    JTextField emailField = new JTextField();
    panel.add(new JLabel("Email:"));
    panel.add(emailField);

    JPasswordField senhaField = new JPasswordField();
    panel.add(new JLabel("Senha:"));
    panel.add(senhaField);

    JCheckBox isEmpresaCheckBox = new JCheckBox("É empresa?");
    panel.add(isEmpresaCheckBox);

    JTextField cpfField = new JTextField();
    panel.add(new JLabel("CPF:"));
    panel.add(cpfField);

    JCheckBox permissaoLocalizacaoCheckBox = new JCheckBox("Permissão de localização");
    panel.add(permissaoLocalizacaoCheckBox);

    JButton incluirButton = new JButton("Incluir");
    incluirButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String nome = nomeField.getText();
        String email = emailField.getText();
        String senha = new String(senhaField.getPassword());
        boolean isEmpresa = isEmpresaCheckBox.isSelected();
        String cpf = cpfField.getText();
        boolean permissaoLocalizacao = permissaoLocalizacaoCheckBox.isSelected();

        Cliente cliente = new Cliente(nome, email, senha, null, permissaoLocalizacao, cpf, null, null, null);

        String retorno = clienteMediator.incluir(cliente);
        if (retorno == null) {
          JOptionPane.showMessageDialog(dialog, "Cliente incluído com sucesso!");
          dialog.dispose();
        } else {
          JOptionPane.showMessageDialog(dialog, retorno);
          dialog.dispose();
        }
      }
    });

    panel.add(incluirButton);

    dialog.add(panel);
    dialog.setVisible(true);
  }

  private void processaAlteracao() {
  }

  private void processaExclusao() {
    JDialog dialog = new JDialog(this, "Excluir Cliente", true);
    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    dialog.setSize(300, 200);
    dialog.setLocationRelativeTo(this);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 1));

    JTextField cpfField = new JTextField();
    panel.add(new JLabel("Digite o CPF do cliente:"));
    panel.add(cpfField);

    JButton excluirButton = new JButton("Excluir");
    excluirButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String cpf = cpfField.getText();
        String retorno = clienteMediator.excluir(cpf);
        if (retorno == null) {
          JOptionPane.showMessageDialog(dialog, "Cliente excluído com sucesso!");
        } else {
          JOptionPane.showMessageDialog(dialog, retorno);
        }
        dialog.dispose();
      }
    });

    panel.add(excluirButton);

    dialog.add(panel);
    dialog.setVisible(true);
  }

  private void processaBusca() {
    JDialog dialog = new JDialog(this, "Buscar Cliente", true);
    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    dialog.setSize(300, 200);
    dialog.setLocationRelativeTo(this);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 1));

    JTextField cpfField = new JTextField();
    panel.add(new JLabel("Digite o CPF do cliente:"));
    panel.add(cpfField);

    JButton buscarButton = new JButton("Buscar");
    buscarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String cpf = cpfField.getText();
        Cliente cliente = clienteMediator.buscar(cpf);
        if (cliente == null) {
          JOptionPane.showMessageDialog(dialog, "Cliente não encontrado!");
        } else {
          JOptionPane.showMessageDialog(dialog, "Dados do cliente:\n" + cliente.toString());
        }
        dialog.dispose();
      }
    });

    panel.add(buscarButton);

    dialog.add(panel);
    dialog.setVisible(true);
  }

  public static void main(String[] args) {
    new TelaClienteGUI();
  }
}