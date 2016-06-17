/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.control;

import academia.view.Painel;
import academia.view.TelaFuncionairo;
import academia.view.TelaInstrutor;
import java.awt.Dimension;

/**
 *
 * @author vinicius
 */
public class ControleTelas extends Thread{
    TelaFuncionairo tela;
    TelaInstrutor telaI;
    public ControleTelas(TelaFuncionairo tela) {
    this.tela=tela;
    }
    public ControleTelas(TelaInstrutor telaI) {
    this.telaI=telaI;
    }
    
    public void run() {

     while(true)
                {
			if(telaI==null){tela.getPainel().atualizarTamanho(tela.getSize());}
                        else{telaI.getPainel().atualizarTamanho(telaI.getSize());}
			try {
				Thread.sleep(30);
                                } catch (InterruptedException e) {e.printStackTrace();}
		}
			
     
     
     }
}
