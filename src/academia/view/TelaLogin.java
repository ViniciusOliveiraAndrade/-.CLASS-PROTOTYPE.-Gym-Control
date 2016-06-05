package academia.view;

import academia.control.ControleTelaLogin;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import util.Util;

public class TelaLogin extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel loginLabel;
    private JFormattedTextField loginField;
    private JLabel senhaLabel;

    private JButton logarButton;
    private JButton sairButton;
    private JButton limparButton;

    private JPasswordField senhaField;
    private JLabel imagem;
    private ControleTelaLogin controle;
    private Util util;
    
    public TelaLogin() {
//        setLayout(new FlowLayout());
        imagem = new JLabel();
        util = new Util();
        loginLabel = new JLabel("CPF:");
        loginField = new JFormattedTextField(util.Mascara("###.###.###-##"));

        senhaLabel = new JLabel("SENHA:");

        senhaField = new JPasswordField(15);

        logarButton = new JButton("Logar");
        sairButton = new JButton("Sair");
        limparButton = new JButton("Limpar");

        controle = new ControleTelaLogin(this);

        logarButton.addActionListener(controle);
        sairButton.addActionListener(controle);
        limparButton.addActionListener(controle);

        add(imagem);

        imagem.add(loginLabel);
        imagem.add(loginField);
        imagem.add(senhaLabel);
        imagem.add(senhaField);
        imagem.add(limparButton);
        imagem.add(sairButton);
        imagem.add(logarButton);

        loginLabel.setBounds(10, 13, 45, 15);
        loginField.setBounds(50, 8, 225, 20);

        senhaLabel.setBounds(10, 40, 60, 10);
        senhaField.setBounds(70, 35, 205, 20);

        limparButton.setBounds(20, 62, 120, 25);
        limparButton.setBackground(Color.red);

        sairButton.setBounds(150, 62, 120, 25);
        sairButton.setBackground(Color.red);

        logarButton.setBounds(45, 93, 200, 25);
        logarButton.setBackground(Color.GREEN);

        setTitle("Academia");
        setSize(290, 150);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource("/res/Icon.png")).getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    /*
	 *
	 * =================================================== Gets & Sets =============================================================
	 * 
	 * */

    public String getLoginField() {
        return loginField.getText().replaceAll("[.-]", "");
    }

    public void setLoginField(String t) {
        loginField.setText(t);
    }

    public String getSenhaField() {
        return senhaField.getText();
    }

    public void setSenhaField(String t) {
        senhaField.setText(t);
    }

    public JButton getLogarButton() {
        return logarButton;
    }

    public void setLogarButton(JButton logarButton) {
        this.logarButton = logarButton;
    }

    public JButton getSairButton() {
        return sairButton;
    }

    public void setSairButton(JButton sairButton) {
        this.sairButton = sairButton;
    }

    public JButton getLimparButton() {
        return limparButton;
    }

    public void setLimparButton(JButton limparButton) {
        this.limparButton = limparButton;
    }

}
