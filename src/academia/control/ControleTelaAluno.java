/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.control;

import academia.Academia;
import academia.view.TelaAluno;
import academia.view.TelaAvaliacao;
import academia.view.TelaDeAtividades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author vinicius
 */
public class ControleTelaAluno implements ActionListener{
    private TelaAluno tela;
    public ControleTelaAluno(TelaAluno tela) {
        this.tela=tela;
    }
        
    
    public void atividade(TelaAluno tela){
       TelaDeAtividades atividade= new TelaDeAtividades();
       atividade.getBuscarB().setVisible(false);
       atividade.getCadastrarB().setVisible(false);
       atividade.setCpfF(Academia.pessoaLogada.getCpf());
       atividade.addInformacoes(Academia.pessoaLogada.getAtividades().getArray());
       for(JTextField t: atividade.getInformacoes()){
           t.setEditable(false);
       }
       atividade.cpfVisi(false);
       tela.getPainel().addFrame(atividade);
    }
    
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==tela.getAtividades()){
             atividade(tela);
         }
        if(e.getSource()==tela.getExitItem()){
            System.exit(0);
        }
    }
    
}
