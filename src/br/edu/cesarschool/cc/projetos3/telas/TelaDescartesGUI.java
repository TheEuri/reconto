package br.edu.cesarschool.cc.projetos3.telas;  

import javax.swing.*;
import javax.swing.border.LineBorder;

import br.edu.cesarschool.cc.projetos3.entidades.Cliente;
import br.edu.cesarschool.cc.projetos3.entidades.Descarte;
import br.edu.cesarschool.cc.projetos3.entidades.Produto;
import br.edu.cesarschool.cc.projetos3.mediator.DescarteMediator;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.UUID;

public class TelaDescartesGUI extends JFrame {

  private JPanel descartesPanel; 

    public TelaDescartesGUI(Cliente cliente) {
        setTitle("Descartes Recentes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(Color.WHITE);

        JPanel panel1 = createFirstBlock(cliente);
        add(panel1);

        descartesPanel = createSecondBlock(cliente);
        add(descartesPanel);

        setVisible(true);
    }

    private JPanel createFirstBlock(Cliente cliente) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(1400, 330));
        panel.setBackground(Color.WHITE);

        JPanel existingContent = new JPanel();
        existingContent.setBorder(new LineBorder(new Color(228, 234, 238), 1));
        existingContent.setLayout(new BorderLayout());
        existingContent.setPreferredSize(new Dimension(1400, 100));
        existingContent.setBackground(Color.WHITE);

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 35));
        innerPanel.setPreferredSize(new Dimension(1400, 100));
        innerPanel.setBackground(Color.BLACK);

        JLabel logoLabel = createImageLabel("src/br/edu/cesarschool/cc/projetos3/assets/logo4.png", 92, 70);
        innerPanel.add(logoLabel);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonsPanel.setBackground(Color.BLACK);

        JLabel inicioLabel = createTextLabel("início", 14);
        inicioLabel.setForeground(Color.WHITE);
        buttonsPanel.add(inicioLabel);

        JLabel pontosLabel = createTextLabel("pontos de coleta", 14);
        pontosLabel.setForeground(Color.WHITE);
        buttonsPanel.add(pontosLabel);

        JLabel creditosLabel = createTextLabel("créditos", 14);
        creditosLabel.setForeground(Color.WHITE);
        buttonsPanel.add(creditosLabel);

        JButton actionButton = new JButton("realizar descarte");
        actionButton.setBackground(new Color(58, 170, 55));
        actionButton.setForeground(Color.WHITE);
        actionButton.setBorder(new LineBorder(new Color(58, 170, 55), 1));
        buttonsPanel.add(actionButton);

        innerPanel.add(buttonsPanel);
        existingContent.add(innerPanel, BorderLayout.CENTER);

        JPanel novoDescartePanel = new JPanel();
        novoDescartePanel.setBorder(new LineBorder(new Color(228, 234, 238), 1));
        novoDescartePanel.setLayout(new BorderLayout());
        novoDescartePanel.setPreferredSize(new Dimension(1400, 500));
        novoDescartePanel.setBackground(Color.WHITE);
        
        JLabel novoDescarteLabel = createTextLabel("Novo Descarte", 20);
        novoDescartePanel.add(novoDescarteLabel, BorderLayout.NORTH);
        
        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        
        JLabel infoLabel = createTextLabel("Informações do Descarte", 16);
        infoLabel.setLayout(new FlowLayout(FlowLayout.LEFT));
        formPanel.add(infoLabel);

        JPanel nomePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nomeLabel = createTextLabel("Nome do Produto:", 14);
        nomePanel.add(nomeLabel);
        JTextField nomeField = new JTextField();
        nomeField.setPreferredSize(new Dimension(200, 20));
        nomePanel.add(nomeField);
        formPanel.add(nomePanel);
        
        JPanel codigoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel codigoLabel = createTextLabel("Código do Produto:", 14);
        codigoPanel.add(codigoLabel);
        JTextField codigoField = new JTextField();
        codigoField.setPreferredSize(new Dimension(200, 20));
        codigoPanel.add(codigoField);
        formPanel.add(codigoPanel);
        
        JPanel fabricantePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel fabricanteLabel = createTextLabel("Fabricante:", 14);
        fabricantePanel.add(fabricanteLabel);
        JTextField fabricanteField = new JTextField();
        fabricanteField.setPreferredSize(new Dimension(200, 20)); 
        fabricantePanel.add(fabricanteField);
        formPanel.add(fabricantePanel);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton realizarDescarteButton = new JButton("Realizar Descarte");
        realizarDescarteButton.setMaximumSize(new Dimension(300, 50));
        realizarDescarteButton.setBackground(new Color(58, 170, 55));
        realizarDescarteButton.setForeground(Color.WHITE);
        realizarDescarteButton.setBorder(new LineBorder(new Color(58, 170, 55), 1));
        buttonPanel.add(realizarDescarteButton);
        formPanel.add(buttonPanel);

        realizarDescarteButton.addActionListener(e -> {
          if (nomeField.getText().isEmpty() || codigoField.getText().isEmpty() || fabricanteField.getText().isEmpty()) return;
            DescarteMediator descarteMediator = DescarteMediator.obterInstancia();
            Produto produto = new Produto(nomeField.getText(), codigoField.getText(), fabricanteField.getText());

            String codAutenticacao = descarteMediator.gerarCodigoAutenticacao();

            Descarte descarte = new Descarte(false, 0, UUID.randomUUID().toString(), codAutenticacao, null, produto,
                  null, cliente);

            descarteMediator.incluir(descarte);
            getContentPane().remove(descartesPanel);
            descartesPanel = createSecondBlock(cliente);
            getContentPane().add(descartesPanel);
            getContentPane().revalidate();
            getContentPane().repaint();
            JOptionPane.showMessageDialog(this, "Descarte criado com sucesso. No ato do descarte informe o codigo de autenticação: " + codAutenticacao);

        });
        
        novoDescartePanel.add(formPanel, BorderLayout.CENTER);

        panel.add(existingContent);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(novoDescartePanel);

        return panel;
    }

    private JPanel createSecondBlock(Cliente cliente) {
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(228, 234, 238), 1));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(1400, 600));
        panel.setBackground(Color.WHITE);

        JLabel titleRecentes = createTextLabel("Descartes Recentes", 20);
        panel.add(titleRecentes);

        DescarteMediator descarteMediator = DescarteMediator.obterInstancia();
        List<Descarte> descartes = descarteMediator.buscarTodosDescartesCliente(cliente.getCpf());

        if (descartes.isEmpty()) {
            JLabel semDescartesLabel = createTextLabel("Você ainda não realizou nenhum descarte.", 16);
            panel.add(semDescartesLabel);
        } else {
            for (Descarte descarte : descartes) {
                panel.add(createItemBlock(descarte.getProduto().getNome(), "Rua do Sol, 124\nSanto Antônio, Recife - PE, 50030-230", descarte.isStatusDescarte() ? "Concluído" : "Pendente",
                        descarte.getProduto().getFabricante().toString(), descarte.getCodigoAutenticacao()));
                panel.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }
        
        return panel;
    }

    private JPanel createItemBlock(String title, String address, String status, String brand, String codAut) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(1400, 200));
        panel.setBackground(Color.WHITE);

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 12));

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        detailsPanel.setPreferredSize(new Dimension(480, 200));

        JLabel titleLabel = createTextLabel(title, 20);
        JLabel addressLabel = createTextLabel("<html>" + address.replaceAll("\n", "<br>") + "</html>", 12);
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel actionLabel = createTextLabel("Saiba mais", 12);
        actionLabel.setForeground(Color.BLUE);
        JLabel iconLabel = createImageLabel("src/br/edu/cesarschool/cc/projetos3/assets/seta.png", 16, 16);
        actionPanel.add(actionLabel);
        actionPanel.add(iconLabel);

        detailsPanel.add(titleLabel);
        detailsPanel.add(addressLabel);
        detailsPanel.add(actionPanel);

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));
        statusPanel.setPreferredSize(new Dimension(200, 200));

        JPanel statusLine = new JPanel();
        statusLine.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel statusIconLabel;
        if (status.equals("Concluído")) {
            statusIconLabel = createImageLabel("src/br/edu/cesarschool/cc/projetos3/assets/confirmado.png", 16, 16);
        } else {
            statusIconLabel = createImageLabel("src/br/edu/cesarschool/cc/projetos3/assets/pendente.png", 16, 16);
        }
        JLabel statusLabel = createTextLabel(status, 12);
        statusLine.add(statusIconLabel);
        statusLine.add(statusLabel);

        JPanel brandLine = new JPanel();
        brandLine.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel brandLabel = createTextLabel(brand, 12);
        brandLine.add(brandLabel);

        JPanel priceLine = new JPanel();
        priceLine.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel priceLabel = createTextLabel(codAut, 12);
        priceLine.add(priceLabel);

        statusPanel.add(statusLine);
        statusPanel.add(brandLine);
        statusPanel.add(priceLine);

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel imageLabel = createImageLabel("src/br/edu/cesarschool/cc/projetos3/assets/img4.png", 100, 100);
        imagePanel.add(imageLabel);

        innerPanel.add(detailsPanel);
        innerPanel.add(statusPanel);
        innerPanel.add(imagePanel);

        panel.add(innerPanel, BorderLayout.CENTER);

        return panel;
    }

    private JLabel createTextLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Inter", Font.PLAIN, fontSize));
        label.setLayout(new FlowLayout(FlowLayout.LEFT));
        return label;
    }

    private JLabel createImageLabel(String path, int width, int height) {
        ImageIcon icon = null;
        try {
            URL url = new URL("file:///" + System.getProperty("user.dir") + "/" + path);
            icon = new ImageIcon(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new JLabel(new ImageIcon(image));
    }

    
}
