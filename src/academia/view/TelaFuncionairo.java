package academia.view;

import academia.Academia;
import academia.control.ControleTelaFunconario;
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
public class TelaFuncionairo extends JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JMenuBar menuBar;

    private JMenu cadastrarMenu, fileMenu, editarMenu,removerMenu;

    private JMenuItem cadastarFIntem, cadastarIIntem, cadastarAIntem, exitItem;
    private JMenuItem editarAlunoItem, editarFuncionarioItem, editarInstrutorItem,removerItemMenu;
    
    private ControleTelaFunconario controle;

    private Dimension size;
    private Painel painel;
    private ControleTelas atualizar;
    public TelaFuncionairo() {
        size = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
//        painel = new Painel(size,Academia.pessoaLogada.getNome());
        painel = new Painel(size,"logo");
        atualizar =new ControleTelas(this);
        atualizar.start();
        controle = new ControleTelaFunconario(this);
        menuBar = new JMenuBar();

        setJMenuBar(menuBar);

        cadastrarMenu = new JMenu("Cadastrar");
        cadastrarMenu.setMnemonic('C');
       
        cadastarFIntem = new JMenuItem("Cadastar Funcionario");
        cadastarFIntem.addActionListener(controle);

        cadastarIIntem = new JMenuItem("Cadastar Instrutor");
        cadastarIIntem.addActionListener(controle);

        cadastarAIntem = new JMenuItem("Cadastar Aluno");
        cadastarAIntem.addActionListener(controle);

        cadastrarMenu.add(cadastarFIntem);
        cadastrarMenu.add(cadastarIIntem);
        cadastrarMenu.add(cadastarAIntem);

        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('f');

        exitItem = new JMenuItem("exit");
        exitItem.addActionListener(controle);

        fileMenu.add(exitItem);

        editarMenu = new JMenu("Editar");
        editarMenu.setMnemonic('e');
        
        editarAlunoItem = new JMenuItem("Editar Cliente");
        editarAlunoItem.addActionListener(controle);
        
        editarFuncionarioItem = new JMenuItem("Editar Funcionario/Instrutor");
        editarFuncionarioItem.addActionListener(controle);
        
        removerMenu = new JMenu("remover");
        removerMenu.setMnemonic('r');
        
        removerItemMenu = new JMenuItem("Remover");
        removerItemMenu.addActionListener(controle);
        
        removerMenu.add(removerItemMenu);
        
        editarMenu.add(editarFuncionarioItem);
        editarMenu.add(editarAlunoItem);
        
        
        
        //============================ Iniciu menu=================================
        
        menuBar.add(fileMenu);
        menuBar.add(cadastrarMenu);
        menuBar.add(editarMenu);
        menuBar.add(removerMenu);
        
        getContentPane().add(painel);
        setTitle("Academia: Funcionario");
        setLayout(null);
        setSize(size);
        setIconImage(new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource("/res/Icon.png")).getImage());
        setExtendedState( MAXIMIZED_BOTH );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        
    }
 
    /*
    =================================Gets & Sets===========================    
     */
    public JMenuItem getCadastarFIntem() {
        return cadastarFIntem;
    }

    public JMenuItem getCadastarIIntem() {
        return cadastarIIntem;
    }

    public JMenuItem getCadastarAIntem() {
        return cadastarAIntem;
    }

    public JMenuItem getExitItem() {
        return exitItem;
    }

    public JMenuItem getEditarAlunoItem() {
        return editarAlunoItem;
    }

    public JMenuItem getEditarFuncionarioItem() {
        return editarFuncionarioItem;
    }

    public JMenuItem getRemoverItemMenu() {
        return removerItemMenu;
    }

    public Painel getPainel() {
        return painel;
    }

}
