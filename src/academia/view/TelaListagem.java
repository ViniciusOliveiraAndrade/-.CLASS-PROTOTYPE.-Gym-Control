package academia.view;

import academia.control.ControleTelaListagem;
import academia.model.Pessoa;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinicius
 */
public class TelaListagem extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private ControleTelaListagem controle;
    private JPanel painel,painelButton,painelPainel;
    private JButton listarClientes,listarFuncionario,listarInstrutor,listarGeral;
    
    public TelaListagem() {
        setLayout(new BorderLayout());
        controle = new ControleTelaListagem(this);
        listarClientes = new JButton("Listar Clientes");
        listarClientes.addActionListener(controle);
        
        listarFuncionario = new JButton("Listar Funcionário");
        listarFuncionario.addActionListener(controle);
        
        listarInstrutor = new JButton("Listar Instrutores");
        listarInstrutor.addActionListener(controle);
        
        listarGeral = new JButton("Listar Todos");
        listarGeral.addActionListener(controle);
        
        painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder(""));
        painel.setLayout(new BorderLayout());
        
        painelButton  = new JPanel();
        painelButton.setBorder(BorderFactory.createTitledBorder(""));
        painelButton.setLayout(new FlowLayout());

        painelButton.add(listarClientes);
        painelButton.add(listarFuncionario);
        painelButton.add(listarInstrutor);
        painelButton.add(listarGeral);
        
//        painelPainel = new JPanel();
//        painelPainel.setBorder(BorderFactory.createTitledBorder(""));
//        painelPainel.add(painel); 
        
        model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Telefone");
        model.addColumn("Tipo");
        
        

        table = new JTable(model);
        table.setFont(new Font("Arial", Font.BOLD, 14));
        table.setCellEditor(null);

        scroll = new JScrollPane(table);

        painel.add(scroll, BorderLayout.CENTER);
        
        
        add(painelButton,BorderLayout.NORTH);
        add(painel,BorderLayout.CENTER);
        
        setTitle("Atividades");
        setSize(700, 400);
        setClosable(true);
        setVisible(true);

    }
    public void addInformacao(ArrayList<Pessoa> p){
        String tipo=""; 
        
        try {
            if(model.getRowCount()!=0){ 
//                for(int i = 0; i<model.getRowCount();i++){
//                    model.removeRow(i++);
//                }
                model.setNumRows(0);
            }
            for(Pessoa a:p){
            switch(a.getTipo()){
                case 1: tipo="Cliente";
                            break;
                case 2: tipo="Funcionário";
                            break;
                case 3: tipo="Instrutor";
                            break;            
            }
            model.addRow(new Object[] {a.getNome(),""+a.getCpf().substring(0, 3)+"."+a.getCpf().substring(3, 6)+"."+a.getCpf().substring(6,9)+"-"+a.getCpf().substring(9, 11),a.getTelefone(),tipo});
                System.out.println(tipo);
            }
         } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JButton getListarClientes() {
        return listarClientes;
    }

    public JButton getListarFuncionario() {
        return listarFuncionario;
    }

    public JButton getListarInstrutor() {
        return listarInstrutor;
    }

    public JButton getListarGeral() {
        return listarGeral;
    }
    
}
