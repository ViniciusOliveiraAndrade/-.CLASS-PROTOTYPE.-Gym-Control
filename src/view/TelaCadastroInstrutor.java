package view;

import control.ControleTelaCadastroInstrutor;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import util.Util;

/**
 *
 * @author vinicius
 */
public class TelaCadastroInstrutor extends JInternalFrame {

    private JLabel nomeL;
    private JLabel cpfL;
    private JLabel senhaL;
    private JLabel enderecoL;
    private JLabel telefoneL;
    private JLabel ruaL;
    private JLabel bairroL;
    private JLabel numeroL;
    private JLabel cepL;
    private JLabel imagem;

    private JTextField nomeF;
    private JFormattedTextField cpfF;
    private JTextField senhaF;
    private JFormattedTextField telefoneF;
    private JTextField ruaF;
    private JTextField bairroF;
    private JFormattedTextField numeroF;
    private JFormattedTextField cepF;

    private JButton cadastrarB;
    private JButton limparB;
    private JButton sairB;

    private ControleTelaCadastroInstrutor controle;
    private Util util;

    public TelaCadastroInstrutor() {

        controle = new ControleTelaCadastroInstrutor(this);
        util = new Util();
        imagem = new JLabel();
        add(imagem);

        nomeL = new JLabel("Nome:");
        cpfL = new JLabel("CPF:");
        senhaL = new JLabel("Senha:");
        enderecoL = new JLabel("Endereço:");
        telefoneL = new JLabel("Telefone/Celular:");
        ruaL = new JLabel("Rua:");
        bairroL = new JLabel("Bairro:");
        numeroL = new JLabel("N°:");
        cepL = new JLabel("CEP:");

        nomeF = new JTextField(39);
        cpfF = new JFormattedTextField(util.Mascara("###.###.###-##"));
        senhaF = new JTextField(15);
        telefoneF = new JFormattedTextField(util.Mascara("(##)#####-####"));
        ruaF = new JTextField(30);
        bairroF = new JTextField(30);
        numeroF = new JFormattedTextField(util.CosumeLetter());
        cepF = new JFormattedTextField(util.Mascara("##.###-###"));

        cadastrarB = new JButton("Cadastrar");
        cadastrarB.addActionListener(controle);

        limparB = new JButton("Limpar");
        limparB.addActionListener(controle);

        sairB = new JButton("sair");
        sairB.addActionListener(controle);

        imagem.add(nomeL);
        imagem.add(nomeF);

        imagem.add(cpfL);
        imagem.add(cpfF);

        imagem.add(senhaL);
        imagem.add(senhaF);

        imagem.add(telefoneL);
        imagem.add(telefoneF);

        imagem.add(enderecoL);

        imagem.add(ruaL);
        imagem.add(ruaF);

        imagem.add(numeroL);
        imagem.add(numeroF);

        imagem.add(bairroL);
        imagem.add(bairroF);

        imagem.add(cepL);
        imagem.add(cepF);

        imagem.add(limparB);

        imagem.add(sairB);

        imagem.add(cadastrarB);

        nomeL.setBounds(10, 10, 50, 10);
        nomeF.setBounds(55, 6, 420, 20);

        cpfL.setBounds(10, 35, 43, 10);
        cpfF.setBounds(55, 30, 170, 20);

        senhaL.setBounds(245, 35, 53, 10);
        senhaF.setBounds(295, 30, 180, 20);

        telefoneL.setBounds(10, 60, 140, 10);
        telefoneF.setBounds(140, 55, 130, 20);

        enderecoL.setBounds(10, 85, 83, 10);

        ruaL.setBounds(10, 110, 38, 10);
        ruaF.setBounds(40, 105, 290, 20);

        numeroL.setBounds(340, 110, 30, 10);
        numeroF.setBounds(360, 105, 100, 20);

        bairroL.setBounds(10, 135, 63, 10);
        bairroF.setBounds(55, 130, 260, 20);

        cepL.setBounds(320, 135, 41, 10);
        cepF.setBounds(360, 130, 100, 20);

        limparB.setBounds(20, 180, 90, 30);

        sairB.setBounds(200, 180, 90, 30);

        cadastrarB.setBounds(380, 180, 100, 30);

        setTitle("Cadastro Instrutor");
        setSize(550, 300);
        setVisible(true);
        setResizable(false);

    }

    public String getNomeF() {
        return nomeF.getText();
    }

    public void setNomeF(String a) {
        this.nomeF.setText(a);
    }

    public String getCpfF() {
        return cpfF.getText().replaceAll("[.-]", "");
    }

    public void setCpfF(String a) {
        this.cpfF.setText(a);
    }

    public String getSenhaF() {
        return senhaF.getText();
    }

    public void setSenhaF(String a) {
        this.senhaF.setText(a);
    }

    public String getTelefoneF() {
        return telefoneF.getText().replaceAll("[()-]", "");
    }

    public void setTelefoneF(String a) {
        this.telefoneF.setText(a);
    }

    public String getRuaF() {
        return ruaF.getText();
    }

    public void setRuaF(String a) {
        this.ruaF.setText(a);
    }

    public String getBairroF() {
        return bairroF.getText();
    }

    public void setBairroF(String a) {
        this.bairroF.setText(a);
    }

    public String getNumeroF() {
        return numeroF.getText();
    }

    public void setNumeroF(String a) {
        this.numeroF.setText(a);
    }

    public String getCepF() {
        return cepF.getText().replaceAll("[.-]", "");
    }

    public void setCepF(String a) {
        this.cepF.setText(a);
    }

    public JButton getCadastrarB() {
        return cadastrarB;
    }

    public void setCadastrarB(JButton cadastrarB) {
        this.cadastrarB = cadastrarB;
    }

    public JButton getSairB() {
        return sairB;
    }

    public void setSairB(JButton sairB) {
        this.sairB = sairB;
    }

    public JButton getLimparB() {
        return limparB;
    }

    public void setLimparB(JButton limparB) {
        this.limparB = limparB;
    }

}
