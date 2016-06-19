/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.control;

import academia.model.Atividades;
import academia.model.Pessoa;
import academia.view.TelaDeAtividades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author vinicius
 */
public class ControleTelaAtividades implements ActionListener {

    private Pessoa p;
    private TelaDeAtividades tela;

    public ControleTelaAtividades(TelaDeAtividades tela) {
        this.tela = tela;

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tela.getSairB()) {
            tela.dispose();
        }
//==================================================================================================
        if (e.getSource() == tela.getBuscarB()) {

            p = ControlePessoa.buscar(tela.getCpfF(), 1);

            if (p == null) {
                JOptionPane.showMessageDialog(tela, "CPF não encontrado");
            } else {
                tela.addInformacoes(p.getAtividades().getArray());
            }

        }
//===================================================================================
        if (e.getSource() == tela.getCadastrarB()) {
            if (p == null) {
                JOptionPane.showMessageDialog(tela, "CPF não encontrado");
            } else {
                ArrayList<String> arrayA = new ArrayList();

                for (JTextField t : tela.getInformacoes()) {
                    arrayA.add(t.getText());
                }
                
                p.getAtividades().setArray(arrayA);
                
                try {
                    Pessoa.pessoaDAO().update(p);
                    
                    JOptionPane.showMessageDialog(tela, "Alteração comcluida");
                    
                    for (JTextField t : tela.getInformacoes()) {
                        t.setText("");
                    }
                    tela.setCpfF("");
                    p=null;

                } catch (ConstraintViolationException constraintViolationException) {
                    JOptionPane.showMessageDialog(tela, "Não pode comcluir a Alteração");
                    return;
                }
            }

        }
    }

}
