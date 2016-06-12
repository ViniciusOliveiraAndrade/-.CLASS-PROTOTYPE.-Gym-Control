package academia.view;

import academia.control.ControleTelaInstrutor;
import java.awt.FlowLayout;
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

    private JMenuItem avaliacaoItem, exitItem;
    
    
    private ControleTelaInstrutor controle;
    
    public TelaInstrutor() {
        controle = new ControleTelaInstrutor(this);
        
        menuBar = new JMenuBar();
        
        avaliacaoMenu = new JMenu("Avaliação");
        file = new JMenu("File");

        avaliacaoItem = new JMenuItem("Avaliação");
        avaliacaoItem.addActionListener(controle);
        
        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(controle);
       
        file.add(exitItem);
        avaliacaoMenu.add(avaliacaoItem);
        
        menuBar.add(file);
        menuBar.add(avaliacaoMenu);
        
        setJMenuBar(menuBar);
        setTitle("Academia: Instrutor");
        setLayout(null);
        setSize(800, 500);
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

    public void setAvaliacaoItem(JMenuItem avaliacaoItem) {
        this.avaliacaoItem = avaliacaoItem;
    }

    public JMenuItem getExitItem() {
        return exitItem;
    }

    public void setExitItem(JMenuItem exitItem) {
        this.exitItem = exitItem;
    }
    
    
    
}
