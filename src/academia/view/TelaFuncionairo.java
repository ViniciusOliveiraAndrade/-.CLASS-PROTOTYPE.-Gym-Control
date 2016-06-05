package academia.view;

import academia.control.ControleTelaFunconario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author vinicius
 */
public class TelaFuncionairo extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JMenuBar menuBar;

    private JMenu cadastrarMenu, file, editar,remover;

    private JMenuItem cadastarFIntem, cadastarIIntem, cadastarAIntem, exitMenu;
    private JMenuItem editarAluno, editarFuncionario, editarInstrutor,removerItemMenu;
    
    private ControleTelaFunconario controle;

    private JDesktopPane desk;
    private JPanel pane;
    private Dimension size;
//    private ImageIcon icon;
    
    public TelaFuncionairo() {
//        icon = new ImageIcon("res\\Icon.png");
       
        controle = new ControleTelaFunconario(this);
        menuBar = new JMenuBar();

        setJMenuBar(menuBar);

        cadastrarMenu = new JMenu("Cadastrar");
        cadastrarMenu.setMnemonic('C');
        
        size = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        
        pane = new JPanel();
        System.out.println(pane.getBackground().getColorSpace());
        
        desk = new JDesktopPane();
        desk.setSize(size.width-(size.width/4),size.height);
        desk.setBackground(new Color(238,238,238));
        desk.setLocation(0, 0);
        
        cadastarFIntem = new JMenuItem("Cadastar Funcionario");
        cadastarFIntem.addActionListener(controle);

        cadastarIIntem = new JMenuItem("Cadastar Instrutor");
        cadastarIIntem.addActionListener(controle);

        cadastarAIntem = new JMenuItem("Cadastar Aluno");
        cadastarAIntem.addActionListener(controle);

        cadastrarMenu.add(cadastarFIntem);
        cadastrarMenu.add(cadastarIIntem);
        cadastrarMenu.add(cadastarAIntem);

        file = new JMenu("File");
        file.setMnemonic('f');

        exitMenu = new JMenuItem("exit");
        exitMenu.addActionListener(controle);

        file.add(exitMenu);

        editar = new JMenu("Editar");
        editar.setMnemonic('e');
        
        editarAluno = new JMenuItem("Editar Cliente");
        editarAluno.addActionListener(controle);
        
        editarFuncionario = new JMenuItem("Editar Funcionario/Instrutor");
        editarFuncionario.addActionListener(controle);
        
        remover = new JMenu("remover");
        remover.setMnemonic('r');
        
        removerItemMenu = new JMenuItem("Remover");
        removerItemMenu.addActionListener(controle);
        
        remover.add(removerItemMenu);
        
        editar.add(editarFuncionario);
        editar.add(editarAluno);
        
        
        
        //============================ Iniciu menu=================================
        
        menuBar.add(file);
        menuBar.add(cadastrarMenu);
        menuBar.add(editar);
        menuBar.add(remover);
        
        getContentPane().add(desk);

        setTitle("Academia: Funcionario");
        setLayout(null);
        setSize(800, 500);
        setIconImage(new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource("/res/Icon.png")).getImage());
        setExtendedState( MAXIMIZED_BOTH );
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    /*
    =================================Gets & Sets===========================    
     */
    public JMenuItem getCadastarFIntem() {
        return cadastarFIntem;
    }

    public void setCadastarFIntem(JMenuItem cadastarFIntem) {
        this.cadastarFIntem = cadastarFIntem;
    }

    public JMenuItem getCadastarIIntem() {
        return cadastarIIntem;
    }

    public void setCadastarIIntem(JMenuItem cadastarIIntem) {
        this.cadastarIIntem = cadastarIIntem;
    }

    public JMenuItem getCadastarAIntem() {
        return cadastarAIntem;
    }

    public void setCadastarAIntem(JMenuItem cadastarAIntem) {
        this.cadastarAIntem = cadastarAIntem;
    }

    public JMenuItem getExitMenu() {
        return exitMenu;
    }

    public void setExitMenu(JMenuItem exitMenu) {
        this.exitMenu = exitMenu;
    }

    public JDesktopPane getDesk() {
        return desk;
    }

    public void setDesk(JInternalFrame iframe) {
        this.desk.add(iframe);
    }

    public JMenuItem getEditarAluno() {
        return editarAluno;
    }

    public JMenuItem getEditarFuncionario() {
        return editarFuncionario;
    }

    public JMenuItem getRemoverItemMenu() {
        return removerItemMenu;
    }
    

}
