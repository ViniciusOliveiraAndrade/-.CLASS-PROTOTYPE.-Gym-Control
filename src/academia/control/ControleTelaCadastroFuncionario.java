package academia.control;

import academia.model.Endereco;
import academia.model.Pessoa;
import academia.view.TelaCadastroFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author vinicius
 */
public class ControleTelaCadastroFuncionario implements ActionListener {

    private TelaCadastroFuncionario tela;

    public ControleTelaCadastroFuncionario(TelaCadastroFuncionario tela) {
        this.tela = tela;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tela.getSairB()) {
            tela.dispose();
        }
        if (e.getSource() == tela.getLimparB()) {
            tela.setNomeF("");
            tela.setCepF("");
            tela.setCpfF("");
            tela.setSenhaF("");
            tela.setTelefoneF("");
            tela.setNumeroF("");
            tela.setRuaF("");
            tela.setBairroF("");
            tela.setCepF("");

        }
        if (e.getSource() == tela.getCadastrarB()) {

            Endereco endereco = new Endereco(tela.getRuaF(), tela.getBairroF(), Integer.parseInt(tela.getNumeroF()), tela.getCepF());
            Pessoa p = new Pessoa(tela.getNomeF(), tela.getCpfF(), tela.getTelefoneF(), tela.getSenhaF(), null,2);

            try {
                
                ControlePessoa.criar(p,endereco);
                JOptionPane.showMessageDialog(tela, "Funcionario Cadastrado");
                tela.setNomeF("");
                tela.setCepF("");
                tela.setSenhaF("");
                tela.setTelefoneF("");
                tela.setNumeroF("");
                tela.setRuaF("");
                tela.setBairroF("");
                tela.setCpfF("");
            } catch (ConstraintViolationException constraintViolationException) {
                JOptionPane.showMessageDialog(tela, "CPF Ja Cadastrado");
                return;
            }
        }
    }

}
