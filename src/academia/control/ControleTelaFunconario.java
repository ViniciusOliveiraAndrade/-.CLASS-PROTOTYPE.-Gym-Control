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
            telaFuncionairo.setDesk(new TelaCadastroFuncionario());

        }
        if (e.getSource() == telaFuncionairo.getCadastarIIntem()) {
           telaFuncionairo.setDesk( new TelaCadastroInstrutor());
        }
        if (e.getSource() == telaFuncionairo.getCadastarAIntem()) {
            telaFuncionairo.setDesk(new TelaCadastroAluno());
        }
        if (e.getSource() == telaFuncionairo.getExitMenu()) {
            System.exit(0);
        }
        if (e.getSource() == telaFuncionairo.getEditarFuncionario()) {
            telaFuncionairo.setDesk(new TelaEditarFI());
        }
        if (e.getSource() == telaFuncionairo.getEditarAluno()) {
            telaFuncionairo.setDesk(new TelaEditarAluno());
        }
        if (e.getSource() == telaFuncionairo.getRemoverItemMenu()) {
            telaFuncionairo.setDesk(new TelaRemover());
        }
    }

}
