package telas;

import javax.swing.*;
import javax.swing.border.LineBorder;

import entidades.Cliente;
import mediator.ClienteMediator;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;



public class TelaCadastroGUI {

    public static void main(String[] args) {
        new TelaCadastroGUI();
    }

    public TelaCadastroGUI() {
        JFrame frame = new JFrame("Cadastro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1000);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(228, 234, 238));

        // div-2 Panel
        JPanel div2Panel = new JPanel();
        div2Panel.setLayout(new BoxLayout(div2Panel, BoxLayout.X_AXIS));
        div2Panel.setBackground(new Color(228, 234, 238));

        // column Panel
        JPanel columnPanel = new JPanel();
        columnPanel.setLayout(new BoxLayout(columnPanel, BoxLayout.Y_AXIS));
        columnPanel.setBackground(new Color(228, 234, 238));
        columnPanel.setPreferredSize(new Dimension(68, 600));

        // div-3 Panel with Image
        JPanel div3Panel = new JPanel(new GridBagLayout());
        div3Panel.setBackground(new Color(17, 17, 17));
        div3Panel.setPreferredSize(new Dimension(609, 600));

        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(new ImageIcon("src/assets/logo3.png")); // Atualize o caminho da imagem
        div3Panel.add(imgLabel, new GridBagConstraints());

        columnPanel.add(div3Panel);

        // column-2 Panel
        JPanel column2Panel = new JPanel();
        column2Panel.setLayout(new BoxLayout(column2Panel, BoxLayout.Y_AXIS));
        column2Panel.setBackground(new Color(228, 234, 238));
        column2Panel.setPreferredSize(new Dimension(32, 600));
        column2Panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        // div-4 Panel
        JPanel div4Panel = new JPanel();
        div4Panel.setLayout(new BoxLayout(div4Panel, BoxLayout.Y_AXIS));
        div4Panel.setBackground(new Color(228, 234, 238));

        // Adding elements to div-4 Panel
        JLabel div5Label = new JLabel("Realize o seu cadastro");
        div5Label.setFont(new Font("Inter", Font.BOLD, 40));
        div5Label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel div6Label = new JLabel("Criar Conta");
        div6Label.setFont(new Font("Inter", Font.BOLD, 30));
        div6Label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel div7Label = new JLabel("Preencha os campos abaixo com os seus dados para criar sua conta");
        div7Label.setFont(new Font("Inter", Font.PLAIN, 16));
        div7Label.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create text fields with placeholder
        JTextField nomeField = createStyledTextField("Nome");
        JTextField cpfField = createStyledTextField("CPF");
        JTextField emailField = createStyledTextField("E-mail");
        JTextField enderecoField = createStyledTextField("Endereço");
        JTextField senhaField = createStyledTextField("Senha");

        // Checkbox for location access
        JCheckBox locationCheckBox = new JCheckBox("Permitir acesso à localização");
        locationCheckBox.setFont(new Font("Inter", Font.PLAIN, 16));
        locationCheckBox.setBackground(new Color(228, 234, 238));
        locationCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(new Font("Inter", Font.BOLD, 20));
        cadastrarButton.setBackground(new Color(31, 87, 27));
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        cadastrarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String email = emailField.getText();
            String senha = senhaField.getText();
            String cpf = cpfField.getText();
            boolean permissaoLocalizacao = locationCheckBox.isSelected();

            ClienteMediator clienteMediator = ClienteMediator.obterInstancia();

            Cliente cliente = new Cliente(nome, email, senha, null, permissaoLocalizacao, cpf, null, null, null);
            String retorno = clienteMediator.incluir(cliente);
            if (retorno == null) {
                JOptionPane.showMessageDialog(frame, "Cliente incluído com sucesso!");
                frame.dispose();
                new TelaLoginGUI();
            } else {
                JOptionPane.showMessageDialog(frame, retorno);
                if (retorno.equals("Cliente incluído com sucesso.")) {
                    frame.dispose();
                    new TelaLoginGUI();
                }
               
            }
        });

        div4Panel.add(div5Label);
        div4Panel.add(Box.createRigidArea(new Dimension(0, 30)));
        div4Panel.add(div6Label);
        div4Panel.add(Box.createRigidArea(new Dimension(0, 30)));
        div4Panel.add(div7Label);
        div4Panel.add(Box.createRigidArea(new Dimension(0, 30)));
        div4Panel.add(nomeField);
        div4Panel.add(Box.createRigidArea(new Dimension(0, 10)));
        div4Panel.add(cpfField);
        div4Panel.add(Box.createRigidArea(new Dimension(0, 10)));
        div4Panel.add(emailField);
        div4Panel.add(Box.createRigidArea(new Dimension(0, 10)));
        div4Panel.add(enderecoField);
        div4Panel.add(Box.createRigidArea(new Dimension(0, 10)));
        div4Panel.add(senhaField);
        div4Panel.add(Box.createRigidArea(new Dimension(0, 15)));
        div4Panel.add(locationCheckBox);
        div4Panel.add(Box.createRigidArea(new Dimension(0, 30)));
        div4Panel.add(cadastrarButton);

        column2Panel.add(div4Panel);

        // Adding columns to div2Panel
        div2Panel.add(columnPanel);
        div2Panel.add(column2Panel);

        // Adding div2Panel to mainPanel
        mainPanel.add(div2Panel, BorderLayout.CENTER);

        // Adding mainPanel to frame
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JTextField createStyledTextField(String placeholder) {
        JTextField textField = new JTextField();
        textField.setBorder(new LineBorder(Color.white, 1, true));
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        textField.setFont(new Font("Inter", Font.PLAIN, 16));
        textField.setMargin(new Insets(5, 10, 5, 10)); // padding

        // Placeholder logic
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });

        return textField;
    }
}
