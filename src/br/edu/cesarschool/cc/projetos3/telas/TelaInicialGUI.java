package br.edu.cesarschool.cc.projetos3.telas;

import javax.swing.*;
import java.awt.*;

public class TelaInicialGUI {

  private static JFrame frame; 

  
  public TelaInicialGUI () {
    SwingUtilities.invokeLater(() -> {
      frame = new JFrame("Reconto Platform");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1920, 1280);
      frame.setLayout(new BorderLayout());

      JPanel mainPanel = new JPanel();
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
      mainPanel.setBackground(new Color(228, 234, 238));
      mainPanel.setBorder(BorderFactory.createEmptyBorder(68, 80, 68, 80));

      ImageIcon imgIcon = new ImageIcon("src/br/edu/cesarschool/cc/projetos3/assets/logo1.png");
      JLabel imgLabel = new JLabel(imgIcon);
      imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      mainPanel.add(imgLabel);

      JLabel textLabel = new JLabel("Onde sustentabilidade e colaboração se unem para tornar o mundo melhor");
      textLabel.setForeground(new Color(31, 87, 27));
      textLabel.setFont(new Font("Inter", Font.BOLD, 40));
      textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
      mainPanel.add(textLabel);

      JTextArea description = new JTextArea(
          "Reconto é uma plataforma que facilita o descarte correto de lixos eletrônicos em Recife, " +
              "incentivando a população a contribuir com o Sistema de Logística Reversa. Em parceria com a Prefeitura "
              +
              "e empresas locais de eletrônicos, o site oferece acesso através de plataformas de compra e do Conecta Recife. "
              +
              "Além disso, proporciona às empresas participantes um ecossistema para gerenciar os descartes e monitorar o lixo eletrônico. "
              +
              "A plataforma orienta os consumidores sobre como descartar eletrônicos adequadamente, oferecendo créditos e descontos em lojas "
              +
              "de tecnologia e serviços municipais.");
      description.setLineWrap(true);
      description.setWrapStyleWord(true);
      description.setEditable(false);
      description.setBackground(mainPanel.getBackground());
      description.setFont(new Font("Inter", Font.PLAIN, 16));
      mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
      mainPanel.add(description);

      JPanel sectionPanel = new JPanel();
      sectionPanel.setLayout(new GridLayout(2, 2, 20, 20));
      sectionPanel.setBackground(mainPanel.getBackground());
      mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
      mainPanel.add(sectionPanel);

      JPanel slrPanel = createSection(
          "O que é SLR?",
          "O Sistema de Logística Reversa (SLR) é uma estratégia logística que coordena o retorno de produtos, embalagens e materiais pós-consumo para reutilização, reciclagem ou descarte adequado. Ele gerencia o fluxo inverso, do consumidor de volta ao fabricante ou à cadeia de suprimentos, para cumprir regulamentações ambientais, minimizar impactos e fomentar a economia circular.");
      sectionPanel.add(slrPanel);

      ImageIcon img2Icon = new ImageIcon("src/br/edu/cesarschool/cc/projetos3/assets/img1.png");
      JLabel img2Label = new JLabel(img2Icon);
      sectionPanel.add(img2Label);

      JPanel disposePanel = createSection(
          "Como descartar?",
          "Na plataforma Reconto, o descarte de eletrônicos é simplificado e ágil. O usuário cadastra as informações do produto, recebe um código de verificação e a localização para descarte. No ponto de coleta, apresenta o código, em um processo monitorado por colaboradores. Esse sistema assegura a destinação adequada dos produtos, promovendo a preservação ambiental.");
      sectionPanel.add(disposePanel);

      ImageIcon img3Icon = new ImageIcon("src/br/edu/cesarschool/cc/projetos3/assets/img2.png");
      JLabel img3Label = new JLabel(img3Icon);
      sectionPanel.add(img3Label);

      JLabel creditsLabel = new JLabel("Como funciona o sistema de créditos?");
      creditsLabel.setFont(new Font("Inter", Font.BOLD, 25));
      creditsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));
      mainPanel.add(creditsLabel);

      JTextArea creditsDescription = new JTextArea(
          "O crédito na plataforma Reconto é uma recompensa oferecida aos usuários que descartam adequadamente lixo eletrônico. "
              +
              "Ao utilizar a plataforma para o descarte, os usuários acumulam créditos em suas contas, os quais podem ser utilizados "
              +
              "para obter descontos em compras de produtos eletrônicos ou em serviços oferecidos pela prefeitura. Essa iniciativa "
              +
              "incentiva a participação dos consumidores na logística reversa, promove o consumo consciente e contribui para a preservação "
              +
              "do meio ambiente.");
      creditsDescription.setLineWrap(true);
      creditsDescription.setWrapStyleWord(true);
      creditsDescription.setEditable(false);
      creditsDescription.setBackground(mainPanel.getBackground());
      creditsDescription.setFont(new Font("Inter", Font.PLAIN, 16));
      mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
      mainPanel.add(creditsDescription);

      JButton loginButton = new JButton("Realize seu login");
      loginButton.setFont(new Font("Inter", Font.BOLD, 20));
      loginButton.setBackground(new Color(31, 87, 27));
      loginButton.setForeground(Color.WHITE);
      loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      loginButton.setMaximumSize(new Dimension(321, 50));

      loginButton.addActionListener(e -> {
        frame.dispose();  // fechar a janela atual
        new TelaLoginGUI();  // abrir a nova janela
      });
      
      mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));
      mainPanel.add(loginButton);
      frame.add(new JScrollPane(mainPanel), BorderLayout.CENTER);
      frame.setVisible(true);

    });
  }

  private static JPanel createSection(String title, String content) {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBackground(new Color(228, 234, 238));

    JLabel titleLabel = new JLabel(title);
    titleLabel.setFont(new Font("Inter", Font.BOLD, 25));
    titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(titleLabel);

    JTextArea contentArea = new JTextArea(content);
    contentArea.setLineWrap(true);
    contentArea.setWrapStyleWord(true);
    contentArea.setEditable(false);
    contentArea.setBackground(panel.getBackground());
    contentArea.setFont(new Font("Inter", Font.PLAIN, 16));
    panel.add(Box.createRigidArea(new Dimension(0, 10)));
    panel.add(contentArea);

    return panel;
  }
}
