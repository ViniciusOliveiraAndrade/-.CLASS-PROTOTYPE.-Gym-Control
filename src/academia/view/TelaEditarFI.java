package academia.view;

import academia.control.ControleTelaEditarFI;
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
public class TelaEditarFI extends JInternalFrame {

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

    private JTextField nomeF;
    private JTextField senhaF;
    private JFormattedTextField telefoneF;
    private JTextField ruaF;
    private JTextField bairroF;
    private JTextField numeroF;
    private JFormattedTextField cepF;
    private JFormattedTextField buscarT;

    private JButton cadastrarB;
    private JButton limparB;
    private JButton sairB;
    private JButton BuscarB;

    private ControleTelaEditarFI controle;
    private Util util;

    public TelaEditarFI() {
        controle = new ControleTelaEditarFI(this);
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

        nomeF = new JTextField(39);
        senhaF = new JTextField(15);
        telefoneF = new JFormattedTextField(util.Mascara("(##)#####-####"));
        ruaF = new JTextField(30);
        bairroF = new JTextField(30);
        numeroF = new JTextField(8);
        numeroF.addKeyListener(util.CosumeLetter());
        
        cepF = new JFormattedTextField(util.Mascara("##.###-###"));
        buscarT = new JFormattedTextField(util.Mascara("###.###.###-##"));
        cadastrarB = new JButton("edtar");
        cadastrarB.addActionListener(controle);

        limparB = new JButton("Limpar");
        limparB.addActionListener(controle);

        sairB = new JButton("sair");
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

        enderecoL.setBounds(10, 105, 83, 10);

        ruaL.setBounds(10, 130, 38, 10);
        ruaF.setBounds(45, 125, 300, 20);

        numeroL.setBounds(365, 130, 30, 10);
        numeroF.setBounds(390, 125, 100, 20);

        bairroL.setBounds(10, 155, 63, 10);
        bairroF.setBounds(60, 150, 285, 20);

        cepL.setBounds(355, 155, 41, 10);
        cepF.setBounds(390, 150, 100, 20);

        limparB.setBounds(20, 200, 90, 30);

        sairB.setBounds(200, 200, 90, 30);

        cadastrarB.setBounds(380, 200, 100, 30);

        setTitle("Editar Funcioanrio");
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

    public JButton getCadastrarB() {
        return cadastrarB;
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

}
