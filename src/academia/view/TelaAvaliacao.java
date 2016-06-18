package academia.view;

import academia.control.ControleTelaAvaliacao;
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
public class TelaAvaliacao extends JInternalFrame {

    private JLabel nomeL;
    private JLabel cpfL;
    private JLabel bracoL;
    private JLabel quadrilL;
    private JLabel cinturaL;
    private JLabel coxaL;
    private JLabel panturrilhaL;
    private JLabel alturaL;
    private JLabel pesoL;

    private JLabel imagem;

    private JTextField nomeF;
    private JFormattedTextField cpfF;
    private JTextField bracoF;
    private JTextField quadrilF;
    private JTextField cinturaF;
    private JTextField coxaF;
    private JTextField panturrilhaF;
    private JTextField alturaF;
    private JTextField pesoF;

    private JButton cadastrarB;
    private JButton limparB;
    private JButton sairB;
    private JButton buscarPessoa;
    
    private Util util;

    private ControleTelaAvaliacao controle;
    public TelaAvaliacao() {
        controle = new ControleTelaAvaliacao(this);
        util = new Util();
        imagem = new JLabel();
        add(imagem);

        nomeL = new JLabel("Nome:");
        nomeF = new JTextField(5);

        cpfL = new JLabel("CPF:");
        cpfF = new JFormattedTextField(util.mascara("###.###.###-##"));

        bracoL = new JLabel("Braço:");
        bracoF = new JTextField(5);

        quadrilL = new JLabel("Quadril:");
        quadrilF = new JTextField(5);

        cinturaL = new JLabel("Cintura:");
        cinturaF = new JTextField(5);

        alturaL = new JLabel("Altura:");
        alturaF = new JTextField(5);

        pesoL = new JLabel("Peso:");
        pesoF = new JTextField(5);

        coxaL = new JLabel("Coxa:");
        coxaF = new JTextField(5);

        panturrilhaL = new JLabel("Panturrilha:");
        panturrilhaF = new JTextField(5);

        cadastrarB = new JButton("Cadastrar");
        cadastrarB.addActionListener(controle);

        limparB = new JButton("Limpar");
        limparB.addActionListener(controle);

        sairB = new JButton("sair");
        sairB.addActionListener(controle);

        buscarPessoa = new JButton("Buscar");
        buscarPessoa.addActionListener(controle);
        
        imagem.add(cpfL);
        imagem.add(cpfF);
        
        imagem.add(buscarPessoa);
        
        imagem.add(nomeL);
        imagem.add(nomeF);

        imagem.add(alturaL);
        imagem.add(alturaF);

        imagem.add(pesoL);
        imagem.add(pesoF);

        imagem.add(bracoL);
        imagem.add(bracoF);

        imagem.add(cinturaL);
        imagem.add(cinturaF);

        imagem.add(quadrilL);
        imagem.add(quadrilF);

        imagem.add(coxaL);
        imagem.add(coxaF);

        imagem.add(panturrilhaL);
        imagem.add(panturrilhaF);

        imagem.add(limparB);
        imagem.add(sairB);
        imagem.add(cadastrarB);

        nomeL.setBounds(10, 35, 50, 10);
        nomeF.setBounds(55, 30, 420, 20);

        cpfL.setBounds(10, 10, 43, 10);
        cpfF.setBounds(55, 5, 170, 20);

        bracoL.setBounds(260, 85, 53, 10);
        bracoF.setBounds(310, 80, 50, 20);

        alturaL.setBounds(10, 60, 53, 10);
        alturaF.setBounds(56, 55, 53, 20);

        pesoL.setBounds(117, 60, 50, 10);
        pesoF.setBounds(160, 55, 53, 20);

        cinturaL.setBounds(217, 60, 60, 10);
        cinturaF.setBounds(275, 55, 53, 20);

        quadrilL.setBounds(335, 60, 60, 10);
        quadrilF.setBounds(392, 55, 53, 20);

        coxaL.setBounds(10, 85, 40, 10);
        coxaF.setBounds(55, 80, 53, 20);
        
        panturrilhaL.setBounds(117, 85, 85, 10);
        panturrilhaF.setBounds(202, 80, 53, 20);
        
        limparB.setBounds(20, 120, 90, 30);

        sairB.setBounds(195, 120, 90, 30);

        cadastrarB.setBounds(370, 120, 105, 30);
        
        buscarPessoa.setBounds(240, 5, 90, 20);
        
        setTitle("Avaliação");
        setSize(500, 190);
        setVisible(true);
        setResizable(false);
    }

    public String getNomeF() {
        return nomeF.getText();
    }

    public void setNomeF(String nome) {
        this.nomeF.setText(nome);
    }

    public String getCpfF() {
        return cpfF.getText().replaceAll("[. -]", "");
    }

    public void setCpfF(String cpf) {
        this.cpfF.setText(cpf);
    }

    public double getBracoF() {
        return Double.parseDouble(bracoF.getText().replaceAll(",", "."));
    }

    public void setBracoF(double braco) {
        this.bracoF.setText(String.valueOf(braco));
    }

    public double getCinturaF() {
        return Double.parseDouble(cinturaF.getText().replaceAll(",", "."));
    }

    public void setCinturaF(double c) {
        this.cinturaF.setText(String.valueOf(c));
    }

    public double getCoxaF() {
        return Double.parseDouble(coxaF.getText().replaceAll(",", "."));
    }

    public void setCoxaF(double c) {
        this.coxaF.setText(String.valueOf(c));
    }

    public double getPanturrilhaF() {
        return Double.parseDouble(panturrilhaF.getText().replaceAll(",", "."));
    }

    public void setPanturrilhaF(double c) {
        this.panturrilhaF.setText(String.valueOf(c));
    }

    public double getAlturaF() {
        return Double.parseDouble(alturaF.getText().replaceAll(",", "."));
    }

    public void setAlturaF(double c) {
        this.alturaF.setText(String.valueOf(c));
    }

    public double getPesoF() {
        return Double.parseDouble(pesoF.getText().replaceAll(",", "."));
    }

    public void setPesoF(double c) {
        this.pesoF.setText(String.valueOf(c));
    }

    public JButton getCadastrarB() {
        return cadastrarB;
    }

    public JButton getLimparB() {
        return limparB;
    }

    public JButton getSairB() {
        return sairB;
    }

    public JButton getBuscarPessoa() {
        return buscarPessoa;
    }

    public double getQuadrilF() {
        return Double.parseDouble(quadrilF.getText().replaceAll(",", "."));
    }

    public void setQuadrilF(double quadrilF) {
        this.quadrilF.setText(String.valueOf(quadrilF));
    }

    
}
