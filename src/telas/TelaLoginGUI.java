package telas;

import javax.swing.*;

import entidades.Cliente;
import mediator.ClienteMediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLoginGUI extends JFrame {
  private ClienteMediator clienteMediator = ClienteMediator.obterInstancia();

  public TelaLoginGUI() {
    setTitle("Tela Fluxo Cliente");
    setSize(1280, 720);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(2, 1));

    JButton entrarButton = new JButton("Entrar");
    entrarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        processaEntrada();
      }
    });

    JButton cadastrarButton = new JButton("Cadastrar");
    cadastrarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        processaInclusao();
      }
    });

    panel.add(entrarButton);
    panel.add(cadastrarButton);

    this.add(panel);
  }

  private void processaEntrada() {
    JDialog dialog = new JDialog(this, "Entrar", true);
    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    dialog.setSize(300, 200);
    dialog.setLocationRelativeTo(this);
  
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 1));
  
    JTextField cpfField = new JTextField();
    panel.add(new JLabel("CPF:"));
    panel.add(cpfField);
  
    JPasswordField senhaField = new JPasswordField();
    panel.add(new JLabel("Senha:"));
    panel.add(senhaField);
  
    JButton entrarButton = new JButton("Entrar");
    entrarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String cpf = cpfField.getText();
        String senha = new String(senhaField.getPassword());
  
        Cliente cliente = clienteMediator.autenticar(cpf, senha);
        if (cliente != null) {
          JOptionPane.showMessageDialog(dialog, "Entrada bem-sucedida!");
          dialog.dispose();
          TelaLoginGUI.this.dispose();
          new TelaMenuPrincipal(cliente, TelaLoginGUI.this);
        } else {
          JOptionPane.showMessageDialog(dialog, "CPF ou senha inválidos!");
        }
      }
    });
  
    panel.add(entrarButton);
  
    dialog.add(panel);
    dialog.setVisible(true);
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

  public static void main(String[] args) {
    new TelaLoginGUI();
  }
}