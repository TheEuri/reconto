package br.edu.cesarschool.cc.projetos3.telas;

import javax.swing.*;

import br.edu.cesarschool.cc.projetos3.entidades.Cliente;
import br.edu.cesarschool.cc.projetos3.mediator.ClienteMediator;

import java.awt.*;
import java.awt.event.ActionListener;

public class TelaLoginGUI {

  public static void main(String[] args) {
    new TelaLoginGUI();
  }

  public TelaLoginGUI() {
    JFrame frame = new JFrame("Login Screen");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1280, 800);

    // Main panel
    JPanel mainPanel = new JPanel();
    mainPanel.setBackground(new Color(0xE4EAEE));
    mainPanel.setLayout(new BorderLayout());

    // Left column
    JPanel leftColumn = new JPanel();
    leftColumn.setLayout(new BoxLayout(leftColumn, BoxLayout.Y_AXIS));
    leftColumn.setPreferredSize(new Dimension(580, 0));
    leftColumn.setBackground(Color.WHITE);

    // Image in left column
    JLabel leftImageLabel = new JLabel(new ImageIcon("src/br/edu/cesarschool/cc/projetos3/assets/img3.png"));
    leftImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    leftColumn.add(leftImageLabel);

    // Right column
    JPanel rightColumn = new JPanel();
    rightColumn.setLayout(new BoxLayout(rightColumn, BoxLayout.Y_AXIS));
    rightColumn.setPreferredSize(new Dimension(420, 0));

    // Inner right panel
    JPanel rightInnerPanel = new JPanel();
    rightInnerPanel.setLayout(new BoxLayout(rightInnerPanel, BoxLayout.Y_AXIS));
    rightInnerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    // Image in right column
    JLabel rightImageLabel = new JLabel(new ImageIcon("src/br/edu/cesarschool/cc/projetos3/assets/logo2.png"));
    rightImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    rightInnerPanel.add(rightImageLabel);

    // "Realize seu login" label
    JLabel loginLabel = new JLabel("Realize seu login");
    loginLabel.setFont(new Font("Inter", Font.BOLD, 40));
    loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    rightInnerPanel.add(Box.createRigidArea(new Dimension(0, 17)));
    rightInnerPanel.add(loginLabel);

    // "Acesse a plataforma" label
    JLabel platformLabel = new JLabel("Acesse a plataforma");
    platformLabel.setFont(new Font("Inter", Font.BOLD, 25));
    platformLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    rightInnerPanel.add(platformLabel);

    // Description label
    JLabel descriptionLabel = new JLabel("Preencha os campos abaixo com os seus dados de acesso");
    descriptionLabel.setFont(new Font("Inter", Font.PLAIN, 16));
    descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    rightInnerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    rightInnerPanel.add(descriptionLabel);

    // "E-mail" label
    JLabel emailLabel = new JLabel("CPF");
    emailLabel.setFont(new Font("Inter", Font.BOLD, 20));
    emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    rightInnerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
    rightInnerPanel.add(emailLabel);

    // Email input field
    JTextField emailField = new JTextField();
    emailField.setPreferredSize(new Dimension(300, 30));
    emailField.setMaximumSize(new Dimension(300, 30));
    rightInnerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
    rightInnerPanel.add(emailField);

    // "Senha" label
    JLabel passwordLabel = new JLabel("Senha");
    passwordLabel.setFont(new Font("Inter", Font.BOLD, 20));
    passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    rightInnerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
    rightInnerPanel.add(passwordLabel);

    // Password input field
    JPasswordField passwordField = new JPasswordField();
    passwordField.setPreferredSize(new Dimension(300, 30));
    passwordField.setMaximumSize(new Dimension(300, 30));
    rightInnerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
    rightInnerPanel.add(passwordField);

    // "Entrar" button
    JButton loginButton = new JButton("Entrar");
    loginButton.setPreferredSize(new Dimension(300, 30));
    loginButton.setBackground(new Color(0x1F571B));
    loginButton.setForeground(Color.WHITE);
    loginButton.setFont(new Font("Inter", Font.BOLD, 20));
    loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    rightInnerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
    rightInnerPanel.add(loginButton);

    loginButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent e) {
        String cpf = emailField.getText();
        String password = new String(passwordField.getPassword());

        ClienteMediator clienteMediator = ClienteMediator.obterInstancia();

        Cliente cliente = clienteMediator.autenticar(cpf, password);

        if (cliente != null) {
          JOptionPane.showMessageDialog(frame, "Entrada bem-sucedida!");
          frame.dispose();

          new TelaDescartesGUI(cliente);

        } else {
          JOptionPane.showMessageDialog(frame, "CPF ou senha inválidos!");
        }
      }

    });

    // "Criar minha conta" button
    JButton createAccountButton = new JButton("Criar minha conta");
    createAccountButton.setPreferredSize(new Dimension(300, 30));
    createAccountButton.setBackground(new Color(0xE4EAEE));
    createAccountButton.setForeground(new Color(0x3AAA37));
    createAccountButton.setFont(new Font("Inter", Font.BOLD, 20));
    createAccountButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    rightInnerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    rightInnerPanel.add(createAccountButton);

    createAccountButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent e) {
        frame.dispose();
        new TelaCadastroGUI();
      }
    });

    rightColumn.add(rightInnerPanel);

    // Add columns to main panel
    mainPanel.add(leftColumn, BorderLayout.WEST);
    mainPanel.add(rightColumn, BorderLayout.CENTER);

    frame.add(mainPanel);
    frame.setVisible(true);
  }

}
