package academia.view;

import academia.Academia;
import academia.control.ControlePessoa;
import academia.control.ControleTelas;
import academia.model.Pessoa;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author vinicius
 */
public class TelaAluno extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JMenuBar menuBar;

    private JMenu file;

    private JMenuItem exitItem, atividades;

    private Dimension size;
    private Painel painel;

    public TelaAluno() {
        size = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(size);

        painel = new Painel(getSize(), Academia.pessoaLogada.getNome());

        menuBar = new JMenuBar();

        file = new JMenu("File");

        exitItem = new JMenuItem("Exit");
//        exitItem.addActionListener(controle);

        atividades = new JMenuItem("Atividades");
//        atividades.addActionListener(controle);

        file.add(exitItem);

        menuBar.add(file);
        menuBar.add(atividades);
        dadosAluno();
        setJMenuBar(menuBar);
        getContentPane().add(painel);
        setTitle("Academia: Aluno");
        setLayout(null);

        setIconImage(new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource("/res/Icon.png")).getImage());
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);

    }

    public JMenuItem getExitItem() {
        return exitItem;
    }

    public JMenuItem getAtividades() {
        return atividades;
    }

    public Painel getPainel() {
        return painel;
    }

    public void dadosAluno() {
        JLabel imc, braco, quadril, cintura, coxa, panturrilha;
        imc = new JLabel("IMC: " + ControlePessoa.imc(Academia.pessoaLogada));
        imc.setBounds(10, 40,(size.width/4), 10);
        
        braco = new JLabel("Braço: " + Academia.pessoaLogada.getDados().getBraco());
        braco.setBounds(10, 60,(size.width/4), 10);
        
        quadril = new JLabel("Quadril: " + Academia.pessoaLogada.getDados().getQuadril());
        quadril.setBounds(10, 80,(size.width/4), 10);
        
        cintura = new JLabel("Cintura: " + Academia.pessoaLogada.getDados().getCintura());
        cintura.setBounds(10, 100,(size.width/4), 10);
        
        coxa = new JLabel("Coxa: " + Academia.pessoaLogada.getDados().getCoxa());
        coxa.setBounds(10, 120,(size.width/4), 10);
        
        panturrilha = new JLabel("Panturrilha: " + Academia.pessoaLogada.getDados().getPanturrilha());
        panturrilha.setBounds(10, 140,(size.width/4), 10);
        
        painel.getPane().setSize(size.width/4, size.height/3);
        
        
        painel.getPane().add(imc);
        painel.getPane().add(braco);
        painel.getPane().add(quadril);
        painel.getPane().add(cintura);
        painel.getPane().add(coxa);
        painel.getPane().add(panturrilha);

    }

}
