package academia.control;

import academia.HibernateUtil;
import academia.model.Atividades;
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
    public static void criarAluno(Pessoa p, Endereco endereco,DadosPessoa d,Atividades ati) {
        Endereco.enderecoDAO().save(endereco);
        DadosPessoa.dadosPessoaDAO().save(d);
        Atividades.atividadesDAO().save(ati);
        
        p.setEndereco(endereco);
        p.setDados(d);
        p.setAtividades(ati);
        
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
