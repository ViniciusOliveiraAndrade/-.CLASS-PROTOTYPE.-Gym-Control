package academia.view;

import academia.Academia;
import academia.control.ControleTelaInstrutor;
import academia.control.ControleTelas;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author vinicius
 */
public class TelaInstrutor extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JMenuBar menuBar;

    private JMenu avaliacaoMenu, file;

    private JMenuItem avaliacaoItem, exitItem, atividades;
    
    
    private ControleTelaInstrutor controle;
    
    private Dimension size;
    private Painel painel;
    private ControleTelas atualizar;
    
    public TelaInstrutor() {
        size = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        painel = new Painel(size,Academia.pessoaLogada.getNome());
         atualizar =new ControleTelas(this);
        atualizar.start();
        controle = new ControleTelaInstrutor(this);
        
        menuBar = new JMenuBar();
        
        avaliacaoMenu = new JMenu("Avaliação");
        file = new JMenu("File");

        avaliacaoItem = new JMenuItem("Avaliação");
        avaliacaoItem.addActionListener(controle);
        
        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(controle);
        
        atividades = new JMenuItem("Atividades");
        atividades.addActionListener(controle);
       
        file.add(exitItem);
        
        avaliacaoMenu.add(avaliacaoItem);
        avaliacaoMenu.add(atividades);
        
        menuBar.add(file);
        menuBar.add(avaliacaoMenu);
        
        setJMenuBar(menuBar);
        getContentPane().add(painel);
        setTitle("Academia: Instrutor");
        setLayout(null);
        setSize(size);
        setIconImage(new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource("/res/Icon.png")).getImage());
        setExtendedState( MAXIMIZED_BOTH );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);

    }

    public JMenuItem getAvaliacaoItem() {
        return avaliacaoItem;
    }

    public JMenuItem getExitItem() {
        return exitItem;
    }
    public Painel getPainel(){
    return painel;
    }

    public JMenuItem getAtividades() {
        return atividades;
    }
    
}
