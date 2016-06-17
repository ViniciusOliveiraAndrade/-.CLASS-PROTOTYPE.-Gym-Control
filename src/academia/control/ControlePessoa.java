package academia.control;

import academia.HibernateUtil;
import academia.model.DadosPessoa;
import academia.model.Endereco;
import academia.model.Pessoa;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vinicius
 */
public class ControlePessoa {

    public static void criar(Pessoa p, Endereco endereco) {
        Endereco.enderecoDAO().save(endereco);
        p.setEndereco(endereco);
        Pessoa.pessoaDAO().save(p);

    }
    public static void criarAluno(Pessoa p, Endereco endereco,DadosPessoa d) {
        Endereco.enderecoDAO().save(endereco);
        DadosPessoa.dadosPessoaDAO().save(d);
        p.setEndereco(endereco);
        p.setDados(d);
        Pessoa.pessoaDAO().save(p);

    }
    
    public static Pessoa buscarCPF(String cpf){
     Criteria crit = HibernateUtil.getSessionFactory().openSession().createCriteria(Pessoa.class);
        crit.add(Restrictions.eq("cpf", cpf));
        Pessoa p = Pessoa.pessoaDAO().getEntityByCriteria(crit);
        return p;
        
    }
    
    public static Pessoa buscar(String cpf, int tipo) {
        Criteria crit = HibernateUtil.getSessionFactory().openSession().createCriteria(Pessoa.class);
        crit.add(Restrictions.eq("cpf", cpf)).add(Restrictions.eq("tipo", tipo));
        Pessoa p = Pessoa.pessoaDAO().getEntityByCriteria(crit);
        return p;
    }

}
