/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.control;

import academia.model.Pessoa;
import academia.view.TelaAvaliacao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author vinicius
 */
public class ControleTelaAvaliacao implements ActionListener {

    private TelaAvaliacao tela;
    private Pessoa p;

    public ControleTelaAvaliacao(TelaAvaliacao tela) {
        this.tela = tela;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tela.getBuscarPessoa()) {
            p = ControlePessoa.buscar(tela.getCpfF(), 1);

            if (p == null) {
                JOptionPane.showMessageDialog(tela, "CPF não encontrado");
            } else {

                tela.setAlturaF(p.getAltura());
                tela.setBracoF(p.getDados().getBraco());
                tela.setCinturaF(p.getDados().getCintura());
                tela.setCoxaF(p.getDados().getCoxa());
                tela.setNomeF(p.getNome());
                tela.setPanturrilhaF(p.getDados().getPanturrilha());
                tela.setPesoF(p.getPeso());
                tela.setQuadrilF(p.getDados().getQuadril());

            }

        }
        if (e.getSource() == tela.getCadastrarB()) {

            if (p == null) {
                JOptionPane.showMessageDialog(tela, "CPF não encontrado");
            } else {
                p.getDados().setBraco(tela.getBracoF());
                p.getDados().setCintura(tela.getCinturaF());
                p.getDados().setCoxa(tela.getCoxaF());
                p.getDados().setPanturrilha(tela.getPanturrilhaF());
                p.getDados().setQuadril(tela.getQuadrilF());
                p.setPeso(tela.getPesoF());
                p.setAltura(tela.getAlturaF());

                try {
                    Pessoa.pessoaDAO().update(p);
                    JOptionPane.showMessageDialog(tela, "Alteração comcluida");
                    tela.setAlturaF(0);
                    tela.setBracoF(0);
                    tela.setCinturaF(0);
                    tela.setCoxaF(0);
                    tela.setCpfF("");
                    tela.setNomeF("");
                    tela.setPanturrilhaF(0);
                    tela.setPesoF(0);
                    tela.setQuadrilF(0);

                } catch (ConstraintViolationException constraintViolationException) {
                    JOptionPane.showMessageDialog(tela, "Não pode comcluir a Alteração");
                    return;
                }
            }

        }
        if (e.getSource() == tela.getLimparB()) {

            tela.setAlturaF(0);
            tela.setBracoF(0);
            tela.setCinturaF(0);
            tela.setCoxaF(0);
            tela.setCpfF("");
            tela.setNomeF("");
            tela.setPanturrilhaF(0);
            tela.setPesoF(0);
            tela.setQuadrilF(0);

        }
        if (e.getSource() == tela.getSairB()) {
            System.exit(0);
        }
    }

}
