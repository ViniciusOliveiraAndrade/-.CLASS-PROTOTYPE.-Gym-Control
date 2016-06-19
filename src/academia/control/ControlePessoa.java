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

    public static void criarAluno(Pessoa p, Endereco endereco, DadosPessoa d, Atividades ati) {
        Endereco.enderecoDAO().save(endereco);
        DadosPessoa.dadosPessoaDAO().save(d);
        Atividades.atividadesDAO().save(ati);

        p.setEndereco(endereco);
        p.setDados(d);
        p.setAtividades(ati);

        Pessoa.pessoaDAO().save(p);

    }

    public static Pessoa buscarCPF(String cpf) {
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

    public static String imc(Pessoa p) {
        String imc;
        double imcD;
        imcD = (p.getPeso() / (p.getAltura() * p.getAltura()));
        imcD = (double)Math.round(imcD*100)/100;
        imc = String.valueOf(imcD);
       
        if(imcD< 16){imc= imc+" Baixo peso M. grave";}
       
        if((imcD< 16.99)&&(imcD>=16)){imc= imc+" Baixo peso grave";}
        
        if((imcD<= 18.49)&&(imcD>=17)){imc= imc+" Baixo peso";}

        if((imcD<= 24.99)&&(imcD>=18.50)){imc= imc+" Peso normal";}
        
        if((imcD<=29.99)&&(imcD>=25)){imc= imc+" Sobrepeso";}
       
        if((imcD<= 34.99)&&(imcD>=30)){imc= imc+" Obesidade grau I";}
        
        if((imcD<= 39.99)&&(imcD>=35)){imc= imc+" Obesidade grau II";}
        
        if(imcD>=40){imc= imc+" Obesidade grau III";}
//        Baixo peso muito grave = IMC abaixo de 16 kg/m²
//        Baixo peso grave = IMC entre 16 e 16,99 kg/m²
//        Baixo peso = IMC entre 17 e 18,49 kg/m²
//        Peso normal = IMC entre 18,50 e 24,99 kg/m²
//        Sobrepeso = IMC entre 25 e 29,99 kg/m²
//        Obesidade grau I = IMC entre 30 e 34,99 kg/m²
//        Obesidade grau II = IMC entre 35 e 39,99 kg/m²
//        Obesidade grau III (obesidade mórbida) = IMC maior que 40 kg/m²
        return imc;
    }
}
