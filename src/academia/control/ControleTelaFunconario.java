package academia.control;

import academia.view.TelaCadastroAluno;
import academia.view.TelaCadastroFuncionario;
import academia.view.TelaCadastroInstrutor;
import academia.view.TelaEditarAluno;
import academia.view.TelaEditarFI;
import academia.view.TelaFuncionairo;
import academia.view.TelaRemover;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author vinicius
 */
public class ControleTelaFunconario implements ActionListener {

    private TelaFuncionairo telaFuncionairo;

    public ControleTelaFunconario(TelaFuncionairo telaFuncionairo) {
        this.telaFuncionairo = telaFuncionairo;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaFuncionairo.getCadastarFIntem()) {
            telaFuncionairo.getPainel().addFrame(new TelaCadastroFuncionario());

        }
        if (e.getSource() == telaFuncionairo.getCadastarIIntem()) {
           telaFuncionairo.getPainel().addFrame( new TelaCadastroInstrutor());
        }
        if (e.getSource() == telaFuncionairo.getCadastarAIntem()) {
            telaFuncionairo.getPainel().addFrame(new TelaCadastroAluno());
        }
        if (e.getSource() == telaFuncionairo.getExitItem()) {
            System.exit(0);
        }
        if (e.getSource() == telaFuncionairo.getEditarFuncionarioItem()) {
            telaFuncionairo.getPainel().addFrame(new TelaEditarFI());
        }
        if (e.getSource() == telaFuncionairo.getEditarAlunoItem()) {
            telaFuncionairo.getPainel().addFrame(new TelaEditarAluno());
        }
        if (e.getSource() == telaFuncionairo.getRemoverItemMenu()) {
            telaFuncionairo.getPainel().addFrame(new TelaRemover());
        }
    }

}
