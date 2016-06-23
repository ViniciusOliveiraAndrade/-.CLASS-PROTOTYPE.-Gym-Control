package academia.control;

import academia.model.Pessoa;
import academia.view.TelaEditarAluno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author vinicius
 */
public class ControleTelaEditarAluno implements ActionListener {

    private TelaEditarAluno tela;
    private Pessoa p;

    public ControleTelaEditarAluno(TelaEditarAluno telaEditarAluno) {
        this.tela = telaEditarAluno;
       
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
            tela.setBuscarT("");
            tela.setAlturaF("");
            tela.setPesoF("");

        }

        if (e.getSource() == tela.getCadastrarB()) {

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
                p.setPeso(tela.getPesoF());
                p.setAltura(tela.getAlturaF());

                try {
                    Pessoa.pessoaDAO().update(p);
                    JOptionPane.showMessageDialog(tela, "Alteração concluida");
                    tela.setNomeF("");
                    tela.setCepF("");
                    tela.setSenhaF("");
                    tela.setTelefoneF("");
                    tela.setNumeroF("");
                    tela.setRuaF("");
                    tela.setBairroF("");
                    tela.setBuscarT("");
                    tela.setAlturaF("");
                    tela.setPesoF("");
                    p=null;

                } catch (ConstraintViolationException constraintViolationException) {
                    JOptionPane.showMessageDialog(tela, "Não pode concluir a Alteração");
                    return;
                }
            }
        }
        if (e.getSource() == tela.getBuscarB()) {
            p = ControlePessoa.buscar(tela.getBuscarT(),1);
            
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
                tela.setPesoF(String.valueOf(p.getPeso()));
                tela.setAlturaF(String.valueOf(p.getAltura()));
            }
        }

    }

}
