package academia.view;

import academia.control.ControleTelaCadastroAluno;
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
public class TelaCadastroAluno extends JInternalFrame {

    private JLabel nomeL;
    private JLabel cpfL;
    private JLabel senhaL;
    private JLabel enderecoL;
    private JLabel telefoneL;
    private JLabel alturaL;
    private JLabel pesoL;
    private JLabel ruaL;
    private JLabel bairroL;
    private JLabel numeroL;
    private JLabel cepL;
    private JLabel imagem;

    private JTextField nomeF;
    private JFormattedTextField cpfF;
    private JTextField senhaF;
    private JFormattedTextField telefoneF;
    private JTextField alturaF;
    private JTextField pesoF;
    private JTextField ruaF;
    private JTextField bairroF;
    private JTextField numeroF;
    private JFormattedTextField cepF;

    private JButton cadastrarB;
    private JButton limparB;
    private JButton sairB;

    private ControleTelaCadastroAluno controle;
    private Util util;

    public TelaCadastroAluno() {

        controle = new ControleTelaCadastroAluno(this);
        util = new Util();
        imagem = new JLabel();
        add(imagem);

        nomeL = new JLabel("Nome:");
        cpfL = new JLabel("CPF:");
        senhaL = new JLabel("Senha:");
        enderecoL = new JLabel("Endereço:");
        telefoneL = new JLabel("Telefone/Celular:");
        alturaL = new JLabel("Altura:");
        pesoL = new JLabel("Peso:");
        ruaL = new JLabel("Rua:");
        bairroL = new JLabel("Bairro:");
        numeroL = new JLabel("N°:");
        cepL = new JLabel("CEP:");

        nomeF = new JTextField(39);
        cpfF = new JFormattedTextField(util.mascara("###.###.###-##"));
        senhaF = new JTextField(15);
        telefoneF = new JFormattedTextField(util.mascara("(##)#####-####"));
        alturaF = new JTextField(5);
        pesoF = new JTextField(5);
        ruaF = new JTextField(30);
        bairroF = new JTextField(30);
        numeroF = new JTextField(8);
        numeroF.addKeyListener(util.cosumeLetter());
        
        cepF = new JFormattedTextField(util.mascara("##.###-###"));

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

        imagem.add(alturaL);
        imagem.add(alturaF);

        imagem.add(pesoL);
        imagem.add(pesoF);

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

        alturaL.setBounds(10, 60, 53, 10);
        alturaF.setBounds(56, 55, 50, 20);

        pesoL.setBounds(117, 60, 50, 10);
        pesoF.setBounds(160, 55, 50, 20);

        telefoneL.setBounds(217, 60, 140, 10);
        telefoneF.setBounds(340, 55, 130, 20);

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

        cadastrarB.setBounds(380, 180, 110, 30);

        setTitle("Cadastro de Cliente");
        setSize(550, 300);
        setVisible(true);
        setResizable(false);

    }


    /*
	 *
	 * ===================================================== Gets & Sets =============================================================
	 * 
	 * */
    public String getNomeF() {
        return nomeF.getText();
    }

    public void setNomeF(String nomeF) {
        this.nomeF.setText(nomeF);
    }

    public String getCpfF() {
        return cpfF.getText().replaceAll("[.-]", "");
    }

    public void setCpfF(String cpfF) {
        this.cpfF.setText(cpfF);
    }

    public String getSenhaF() {
        return senhaF.getText();
    }

    public void setSenhaF(String senhaF) {
        this.senhaF.setText(senhaF);
    }

    public String getTelefoneF() {
        return telefoneF.getText().replaceAll("[()-]", "");
    }

    public void setTelefoneF(String telefoneF) {
        this.telefoneF.setText(telefoneF);
    }

    public double getAlturaF() {
        return Double.parseDouble(alturaF.getText());
    }

    public void setAlturaF(String alturaF) {
        this.alturaF.setText(alturaF);
    }

    public double getPesoF() {
        return Double.parseDouble(pesoF.getText());
    }

    public void setPesoF(String pesoF) {
        this.pesoF.setText(pesoF);
    }

    public String getRuaF() {
        return ruaF.getText();
    }

    public void setRuaF(String ruaF) {
        this.ruaF.setText(ruaF);
    }

    public String getBairroF() {
        return bairroF.getText();
    }

    public void setBairroF(String bairroF) {
        this.bairroF.setText(bairroF);
    }

    public String getNumeroF() {
        return numeroF.getText();
    }

    public void setNumeroF(String numeroF) {
        this.numeroF.setText(numeroF);
    }

    public String getCepF() {
        return cepF.getText().replaceAll("[.-]", "");
    }

    public void setCepF(String cepF) {
        this.cepF.setText(cepF);
    }

    public JButton getCadastrarB() {
        return cadastrarB;
    }

    public void setCadastrarB(JButton cadastrarB) {
        this.cadastrarB = cadastrarB;
    }

    public JButton getLimparB() {
        return limparB;
    }

    public void setLimparB(JButton limparB) {
        this.limparB = limparB;
    }

    public JButton getSairB() {
        return sairB;
    }

    public void setSairB(JButton sairB) {
        this.sairB = sairB;
    }

}
