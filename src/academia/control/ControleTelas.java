/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.control;

import academia.view.TelaAluno;
import academia.view.TelaFuncionairo;
import academia.view.TelaInstrutor;

/**
 *
 * @author vinicius
 */
public class ControleTelas extends Thread {

    private TelaFuncionairo tela;
    private TelaInstrutor telaI;
    private TelaAluno telaA;

    public ControleTelas(TelaFuncionairo tela) {
        this.tela = tela;
    }

    public ControleTelas(TelaInstrutor telaI) {
        this.telaI = telaI;
    }

    public ControleTelas(TelaAluno telaA) {
        this.telaA = telaA;
    }

    public void run() {

        while (true) {
            if (telaI == null) {
                if (telaA == null) {
                    tela.getPainel().atualizarTamanho(tela.getSize());
                }else{telaA.getPainel().atualizarTamanho(telaA.getSize());}
            } else {
                telaI.getPainel().atualizarTamanho(telaI.getSize());
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
