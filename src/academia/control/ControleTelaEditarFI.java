package academia.control;

import academia.HibernateUtil;
import academia.model.Pessoa;
import academia.view.TelaEditarFI;
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
public class ControleTelaEditarFI implements ActionListener {

    private TelaEditarFI tela;

    public ControleTelaEditarFI(TelaEditarFI tela) {
        this.tela = tela;
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

        }

        if (e.getSource() == tela.getCadastrarB()) {

            Criteria crit = HibernateUtil.getSessionFactory().openSession().createCriteria(Pessoa.class);
            crit.add(Restrictions.eq("cpf", tela.getBuscarT()));
            Pessoa p = Pessoa.pessoaDAO().getEntityByCriteria(crit);

            if (p == null) {
                JOptionPane.showMessageDialog(tela, "CPF não encontrado");
            } else {
                p.getEndereco().setRua(tela.getRuaF());
                p.getEndereco().setBairro(tela.getBairroF());
                System.out.println(p.getEndereco().getBairro());
                p.getEndereco().setNumero(Integer.parseInt(tela.getNumeroF()));
                p.getEndereco().setCep(tela.getCepF());
                p.setNome(tela.getNomeF());
                System.out.println(tela.getNomeF());
                p.setTelefone(tela.getTelefoneF());
                System.out.println(tela.getTelefoneF());
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
            buscar(tela.getBuscarT());
        }

    }

}
