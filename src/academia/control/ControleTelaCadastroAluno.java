package academia.control;

import academia.model.Atividades;
import academia.model.DadosPessoa;
import academia.model.Endereco;
import academia.model.Pessoa;
import academia.view.TelaCadastroAluno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author vinicius
 */
public class ControleTelaCadastroAluno implements ActionListener {

    private TelaCadastroAluno telaCadastro;

    public ControleTelaCadastroAluno(TelaCadastroAluno tela) {
        telaCadastro = tela;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == telaCadastro.getSairB()) {
            telaCadastro.dispose();
        }
        if (e.getSource() == telaCadastro.getLimparB()) {
            telaCadastro.setNomeF("");
            telaCadastro.setCepF("");
            telaCadastro.setCpfF("");
            telaCadastro.setSenhaF("");
            telaCadastro.setTelefoneF("");
            telaCadastro.setNumeroF("");
            telaCadastro.setRuaF("");
            telaCadastro.setBairroF("");
            telaCadastro.setCepF("");
            telaCadastro.setAlturaF("");
            telaCadastro.setPesoF("");
        }
        if (e.getSource() == telaCadastro.getCadastrarB()) {
            if (ControlePessoa.buscarCPF(telaCadastro.getCpfF()) == null) {

                Endereco endereco = new Endereco(telaCadastro.getRuaF(), telaCadastro.getBairroF(), Integer.parseInt(telaCadastro.getNumeroF()), telaCadastro.getCepF());
                Pessoa p = new Pessoa(telaCadastro.getNomeF(), telaCadastro.getCpfF(), telaCadastro.getTelefoneF(), telaCadastro.getSenhaF(), null, telaCadastro.getAlturaF(), telaCadastro.getPesoF(), 1, null,null);
                DadosPessoa d = new DadosPessoa(0, 0, 0, 0, 0);
                String [] at= {"oi","oi","ola","oi","oi"};
                Atividades ati = new Atividades(at, at, at, at, at, at, at);
                telaCadastro.setNomeF("");
                telaCadastro.setCepF("");
                telaCadastro.setCpfF("");
                telaCadastro.setSenhaF("");
                telaCadastro.setTelefoneF("");
                telaCadastro.setNumeroF("");
                telaCadastro.setRuaF("");
                telaCadastro.setBairroF("");
                telaCadastro.setCepF("");
                telaCadastro.setAlturaF("");
                telaCadastro.setPesoF("");
                try {
                    ControlePessoa.criarAluno(p, endereco, d,ati);
                    JOptionPane.showMessageDialog(telaCadastro, "Usuario Cadastrado");

                } catch (ConstraintViolationException constraintViolationException) {
                    JOptionPane.showMessageDialog(telaCadastro, "CPF Ja Cadastrado");
                    return;
                }
            }else{JOptionPane.showMessageDialog(telaCadastro, "CPF Ja Cadastrado");}
        }

    }

}
