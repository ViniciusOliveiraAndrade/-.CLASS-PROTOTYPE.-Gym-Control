package academia.view;

import academia.control.ControleTelaRemover;
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
public class TelaRemover extends JInternalFrame {

    private JLabel nomeL;
    private JLabel senhaL;
    private JLabel enderecoL;
    private JLabel telefoneL;
    private JLabel ruaL;
    private JLabel bairroL;
    private JLabel numeroL;
    private JLabel cepL;
    private JLabel imagem;
    private JLabel buscarL;
    private JLabel alturaL;
    private JLabel pesoL;

    private JTextField nomeF;
    private JTextField senhaF;
    private JFormattedTextField telefoneF;
    private JTextField ruaF;
    private JTextField bairroF;
    private JTextField numeroF;
    private JFormattedTextField cepF;
    private JFormattedTextField buscarT;
    private JTextField alturaF;
    private JTextField pesoF;

    private JButton Remover;
    private JButton limparB;
    private JButton sairB;
    private JButton BuscarB;

    private ControleTelaRemover controle;
    private Util util;

    public TelaRemover() {
        controle = new ControleTelaRemover(this);
        util = new Util();
        imagem = new JLabel();
        add(imagem);

        nomeL = new JLabel("Nome:");
        senhaL = new JLabel("Senha:");
        enderecoL = new JLabel("Endereço:");
        telefoneL = new JLabel("Telefone/Celular:");
        ruaL = new JLabel("Rua:");
        bairroL = new JLabel("Bairro:");
        numeroL = new JLabel("N°:");
        cepL = new JLabel("CEP:");
        buscarL = new JLabel("Buscar / CPF:");
        alturaL = new JLabel("Altura:");
        pesoL = new JLabel("Peso:");

        nomeF = new JTextField(39);
        nomeF.setEditable(false);

        senhaF = new JTextField(15);
        senhaF.setEditable(false);

        telefoneF = new JFormattedTextField(util.Mascara("(##)#####-####"));
        telefoneF.setEditable(false);

        ruaF = new JTextField(30);
        ruaF.setEditable(false);

        bairroF = new JTextField(30);
        bairroF.setEditable(false);

        numeroF = new JTextField(8);
        numeroF.setEditable(false);

        cepF = new JFormattedTextField(util.Mascara("##.###-###"));
        cepF.setEditable(false);

        buscarT = new JFormattedTextField(util.Mascara("###.###.###-##"));

        alturaF = new JTextField();
        alturaF.setEditable(false);

        pesoF = new JTextField();
        pesoF.setEditable(false);

        Remover = new JButton("Remover");
        Remover.addActionListener(controle);

        limparB = new JButton("Limpar");
        limparB.addActionListener(controle);

        sairB = new JButton("Sair");
        sairB.addActionListener(controle);

        BuscarB = new JButton("Buscar");
        BuscarB.addActionListener(controle);

//=====================================adição ao label==========================
        imagem.add(buscarL);
        imagem.add(buscarT);
        imagem.add(BuscarB);

        imagem.add(nomeL);
        imagem.add(nomeF);

        imagem.add(senhaL);
        imagem.add(senhaF);

        imagem.add(telefoneL);
        imagem.add(telefoneF);

        imagem.add(alturaL);
        imagem.add(alturaF);

        imagem.add(pesoL);
        imagem.add(pesoF);

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

        imagem.add(Remover);
//=====================================set localização no label==========================        
        buscarL.setBounds(10, 10, 95, 10);
        buscarT.setBounds(105, 5, 170, 20);
        BuscarB.setBounds(305, 5, 90, 20);

        nomeL.setBounds(10, 50, 50, 10);
        nomeF.setBounds(55, 46, 440, 20);

        senhaL.setBounds(275, 75, 53, 10);
        senhaF.setBounds(325, 70, 170, 20);

        telefoneL.setBounds(10, 75, 140, 10);
        telefoneF.setBounds(140, 70, 130, 20);

        alturaL.setBounds(10, 100, 53, 10);
        alturaF.setBounds(60, 95, 60, 20);

        pesoL.setBounds(150, 100, 53, 10);
        pesoF.setBounds(190, 95, 60, 20);

        enderecoL.setBounds(10, 125, 83, 10);

        ruaL.setBounds(10, 150, 38, 10);
        ruaF.setBounds(45, 145, 300, 20);

        numeroL.setBounds(365, 150, 30, 10);
        numeroF.setBounds(390, 145, 100, 20);

        bairroL.setBounds(10, 175, 63, 10);
        bairroF.setBounds(60, 170, 285, 20);

        cepL.setBounds(355, 175, 41, 10);
        cepF.setBounds(390, 170, 100, 20);

        limparB.setBounds(20, 202, 90, 30);

        sairB.setBounds(200, 202, 90, 30);

        Remover.setBounds(380, 202, 100, 30);

        setTitle("Remover");
        setSize(500, 270);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public String getNomeF() {
        return nomeF.getText();
    }

    public void setNomeF(String a) {
        this.nomeF.setText(a);
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

    public JButton getRemover() {
        return Remover;
    }

    public JButton getSairB() {
        return sairB;
    }

    public JButton getLimparB() {
        return limparB;
    }

    public String getBuscarT() {
        return buscarT.getText().replaceAll("[.-]", "");
    }

    public void setBuscarT(String buscarT) {
        this.buscarT.setText(buscarT);
    }

    public JButton getBuscarB() {
        return BuscarB;
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

}
