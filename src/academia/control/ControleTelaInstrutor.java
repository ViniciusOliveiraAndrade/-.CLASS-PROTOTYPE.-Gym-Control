package academia.control;

import academia.view.TelaAvaliacao;
import academia.view.TelaDeAtividades;
import academia.view.TelaInstrutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author vinicius
 */
public class ControleTelaInstrutor implements ActionListener {

    private TelaInstrutor tela;

    public ControleTelaInstrutor(TelaInstrutor tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==tela.getAvaliacaoItem()){
             tela.getPainel().addFrame(new TelaAvaliacao());
         }
         if(e.getSource()==tela.getAtividades()){
             tela.getPainel().addFrame(new TelaDeAtividades());
         }
        if(e.getSource()==tela.getExitItem()){
            System.exit(0);
        }
    }

}
