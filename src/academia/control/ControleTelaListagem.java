/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.control;

import academia.model.Pessoa;
import academia.view.TelaListagem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author vinicius
 */
public class ControleTelaListagem implements ActionListener{
private TelaListagem tela;
    
    public ControleTelaListagem(TelaListagem tela) {
    this.tela=tela;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==tela.getListarClientes()){
        tela.addInformacao(ControlePessoa.listar(1));
        }
        if(e.getSource()==tela.getListarFuncionario()){
        tela.addInformacao(ControlePessoa.listar(2));
        }
        if(e.getSource()==tela.getListarInstrutor()){
        tela.addInformacao(ControlePessoa.listar(3));
        }
        if(e.getSource()==tela.getListarGeral()){
            ArrayList<Pessoa> array = ControlePessoa.listar(1);
            for(Pessoa p : ControlePessoa.listar(2)){
                array.add(p);
            }
             for(Pessoa p : ControlePessoa.listar(3)){
                array.add(p);
            }
            tela.addInformacao(array);
        }

    }
    
}
