/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.view;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import util.Util;

/**
 *
 * @author vinicius
 */
public class TelaDeAtividades extends JFrame {

    private JTextField cpfF;
    private JLabel cpfL;
    private JTextField segundaL, tercaL, quartaL, quintaL, sextaL, sabadoL, domingoL;

    private ArrayList<JTextField> informacoes;

    private JPanel painel;

    private JButton cadastrarB;
    private JButton BuscarB;

    public TelaDeAtividades() throws HeadlessException {
        informacoes = new ArrayList();
        iniciarCampos();
        painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder(""));
        painel.setBounds(0, 60, 800, 240);
        painel.setLayout(new GridLayout(6, 7));
        cpfL = new JLabel("CPF:");
        cpfF = new JFormattedTextField(new Util().mascara("###.###.###-##"));

        cpfL.setBounds(10, 25, 43, 10);
        cpfF.setBounds(55, 20, 170, 20);

        cadastrarB = new JButton("Concluir");
//        cadastrarB.addActionListener(controle);
        cadastrarB.setBounds(500, 18, 100, 25);
        BuscarB = new JButton("Buscar");
//        BuscarB.addActionListener(controle);
        BuscarB.setBounds(245, 20, 90, 20);

        segundaL = new JTextField("Segunda");
        segundaL.setEditable(false);
        
        tercaL = new JTextField("Terça");
        tercaL.setEditable(false);
        
        quartaL = new JTextField("Quarta");
        quartaL.setEditable(false);
        
        quintaL = new JTextField("Quinta");
        quintaL.setEditable(false);
        
        sextaL = new JTextField("Sexta");
        sextaL.setEditable(false);

        sabadoL = new JTextField("Sabado");
        sabadoL.setEditable(false);

        domingoL = new JTextField("Domingo");
        domingoL.setEditable(false);
        
        painel.add(segundaL);
        painel.add(tercaL);
        painel.add(quartaL);
        painel.add(quintaL);
        painel.add(sextaL);
        painel.add(sabadoL);
        painel.add(domingoL);
        addPainel();
        add(cpfL);
        add(cpfF);
        add(BuscarB);
        add(cadastrarB);
        add(painel);

        setTitle("Atividades");
        setSize(800, 320);
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void iniciarCampos(){
        for(int i=0; i<35;i++){
        informacoes.add(new JTextField(5));
        }
    }
    public void addPainel(){
        for(JTextField field : informacoes){
            painel.add(field);
        }
    }
}
