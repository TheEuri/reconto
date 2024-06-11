package telas;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import entidades.Cliente;
import entidades.Descarte;
import entidades.Empresa;
import entidades.Produto;
import mediator.DescarteMediator;

public class TelaMenuPrincipal extends JFrame {
  private Cliente cliente;
  private TelaLoginGUI telaLoginGUI;

  public TelaMenuPrincipal(Cliente cliente, TelaLoginGUI telaLoginGUI) {
    this.cliente = cliente;
    this.telaLoginGUI = telaLoginGUI;

    setTitle("Menu Principal");
    setSize(1280, 720);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 1));

    JButton criarDescarteButton = new JButton("Realizar Descarte");
    criarDescarteButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Cria uma nova janela de diálogo para inserir o produto e a empresa
        JDialog dialog = new JDialog(TelaMenuPrincipal.this, "Realizar Descarte", true);
        dialog.setLayout(new GridLayout(3, 2));

        // Cria campos de texto para inserir o produto e a empresa
        JTextField produtoField = new JTextField();
        JTextField empresaField = new JTextField();
        JTextField codigoProdutoField = new JTextField();

        // Adiciona os campos de texto à janela de diálogo
        dialog.add(new JLabel("Produto:"));
        dialog.add(produtoField);
        dialog.add(new JLabel("Codigo produto:"));
        dialog.add(codigoProdutoField);
        dialog.add(new JLabel("Fabricante:"));
        dialog.add(empresaField);

        // Cria um botão para confirmar a criação do descarte
        JButton confirmButton = new JButton("Confirmar");
        confirmButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {

            DescarteMediator descarteMediator = DescarteMediator.obterInstancia();
            // Obtém o produto e a empresa inseridos pelo usuário
            String nomeProduto = produtoField.getText();
            String nomeEmpresa = empresaField.getText();
            String codigoProduto = codigoProdutoField.getText();

            // Procura o produto e a empresa nas listas de produtos e empresas
            Produto produto = new Produto(nomeProduto, codigoProduto, nomeEmpresa);
            String codAutenticacao = descarteMediator.gerarCodigoAutenticacao();

              Descarte descarte = new Descarte(false, 0, UUID.randomUUID().toString(), codAutenticacao, null, produto,
                  null, cliente);
              // Adiciona o descarte à lista de descartes
              descarteMediator.incluir(descarte);
              JOptionPane.showMessageDialog(dialog, "Descarte criado com sucesso. No ato do descarte informe o codigo de autenticação: " + codAutenticacao);
            

            dialog.dispose();
          }
        });
        dialog.add(confirmButton);

        dialog.pack();
        dialog.setLocationRelativeTo(TelaMenuPrincipal.this);
        dialog.setVisible(true);
      }
    });

    panel.add(criarDescarteButton);

    JButton meusDescartesButton = new JButton("Meus Descartes");
    meusDescartesButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Cria uma nova janela de diálogo para mostrar os descartes
        JDialog dialog = new JDialog(TelaMenuPrincipal.this, "Meus Descartes", true);
        dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
    
        // Obtém a lista de descartes do cliente
        DescarteMediator descarteMediator = DescarteMediator.obterInstancia();
        List<Descarte> descartes = descarteMediator.buscarTodosDescartesCliente(cliente.getCpf());
    
        // Para cada descarte, cria um painel com as informações do descarte
        for (Descarte descarte : descartes) {
          JPanel descartePanel = new JPanel(new GridLayout(4, 1));
          descartePanel.setBorder(BorderFactory.createTitledBorder("Descarte"));
    
          descartePanel.add(new JLabel("Status: " + (descarte.isStatusDescarte() ? "Concluído" : "Pendente")));
          descartePanel.add(new JLabel("Código de Autenticação: " + descarte.getCodigoAutenticacao()));
          descartePanel.add(new JLabel("Nome do Produto: " + descarte.getProduto().getNome()));
          descartePanel.add(new JLabel("Código do Produto: " + descarte.getProduto().getCodigo()));
    
          dialog.add(descartePanel);
        }
    
        dialog.pack();
        dialog.setLocationRelativeTo(TelaMenuPrincipal.this);
        dialog.setVisible(true);
      }
    });

    JButton sairButton = new JButton("Sair");
    sairButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        TelaMenuPrincipal.this.dispose();
        telaLoginGUI.setVisible(true);
      }
    });

    panel.add(criarDescarteButton);
    panel.add(meusDescartesButton);
    panel.add(sairButton);

    JLabel logadoComoLabel = new JLabel("Logado como: " + cliente.getNome() + " (" + cliente.getCpf() + ")");
    logadoComoLabel.setHorizontalAlignment(JLabel.RIGHT);
    panel.add(logadoComoLabel);

    this.add(panel);
    setVisible(true);
  }
}