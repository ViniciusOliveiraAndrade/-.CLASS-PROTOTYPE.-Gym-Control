package academia.control;

import academia.HibernateUtil;
import academia.model.Pessoa;
import academia.view.TelaRemover;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author vinicius
 */
public class ControleTelaRemover implements ActionListener {

    private TelaRemover tela;

    public ControleTelaRemover(TelaRemover telaRemover) {
        this.tela = telaRemover;
    }

    public void buscar(String cpf) {
        Criteria crit = HibernateUtil.getSessionFactory().openSession().createCriteria(Pessoa.class);
        crit.add(Restrictions.eq("cpf", cpf));
        Pessoa p = Pessoa.pessoaDAO().getEntityByCriteria(crit);

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

        if (e.getSource() == tela.getRemover()) {

            Criteria crit = HibernateUtil.getSessionFactory().openSession().createCriteria(Pessoa.class);
            crit.add(Restrictions.eq("cpf", tela.getBuscarT()));
            Pessoa p = Pessoa.pessoaDAO().getEntityByCriteria(crit);

            if (p == null) {
                JOptionPane.showMessageDialog(tela, "CPF não encontrado");
            } else {
                try {
                    Pessoa.pessoaDAO().remove(p);
                    JOptionPane.showMessageDialog(tela, "Remoção comcluida");
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
                } catch (ConstraintViolationException constraintViolationException) {
                    JOptionPane.showMessageDialog(tela, "Não pode comcluir a Remoção");
                    return;
                }
            }
        }
        if (e.getSource() == tela.getBuscarB()) {
            buscar(tela.getBuscarT());
        }

    }

}
