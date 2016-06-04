package academia.control;

import academia.model.Pessoa;
import academia.view.TelaEditarFI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.hibernate.exception.ConstraintViolationException;
import util.Util;

/**
 *
 * @author vinicius
 */
public class ControleTelaEditarFI implements ActionListener {

    private TelaEditarFI tela;
    private Util util;

    public ControleTelaEditarFI(TelaEditarFI tela) {
        this.tela = tela;
        util = new Util();
    }

//==============================================================================
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tela.getSairB()) {
            tela.dispose();
        }
        if (e.getSource() == tela.getLimparB()) {
            tela.setNomeF("");
            tela.setCepF("");
            tela.setSenhaF("");
            tela.setTelefoneF("");
            tela.setNumeroF("");
            tela.setRuaF("");
            tela.setBairroF("");

        }

        if (e.getSource() == tela.getCadastrarB()) {
            Pessoa p = util.buscar(tela.getBuscarT(), 3);
            if (p == null) {
                p = util.buscar(tela.getBuscarT(), 2);
            }
            if (p == null) {
                JOptionPane.showMessageDialog(tela, "CPF não encontrado");
            } else {
                p.getEndereco().setRua(tela.getRuaF());
                p.getEndereco().setBairro(tela.getBairroF());
                p.getEndereco().setNumero(Integer.parseInt(tela.getNumeroF()));
                p.getEndereco().setCep(tela.getCepF());
                p.setNome(tela.getNomeF());
                p.setTelefone(tela.getTelefoneF());
                p.setSenha(tela.getSenhaF());

                try {
                    Pessoa.pessoaDAO().update(p);
                    JOptionPane.showMessageDialog(tela, "Alteração comcluida");
                    tela.setNomeF("");
                    tela.setCepF("");
                    tela.setSenhaF("");
                    tela.setTelefoneF("");
                    tela.setNumeroF("");
                    tela.setRuaF("");
                    tela.setBairroF("");
                    tela.setBuscarT("");
                } catch (ConstraintViolationException constraintViolationException) {
                    JOptionPane.showMessageDialog(tela, "Não pode comcluir a Alteração");
                    return;
                }
            }
        }
        if (e.getSource() == tela.getBuscarB()) {
            Pessoa p = util.buscar(tela.getBuscarT(), 2);
            if (p == null) {
                p = util.buscar(tela.getBuscarT(), 3);
            }
            if (p == null) {
                JOptionPane.showMessageDialog(tela, "CPF não encontrado");
            } else {
                tela.setNomeF(p.getNome());
                tela.setCepF(p.getEndereco().getCep());
                tela.setSenhaF(p.getSenha());
                tela.setTelefoneF(p.getTelefone());
                tela.setNumeroF(String.valueOf(p.getEndereco().getNumero()));
                tela.setRuaF(p.getEndereco().getRua());
                tela.setBairroF(p.getEndereco().getBairro());
            }
        }

    }

}
