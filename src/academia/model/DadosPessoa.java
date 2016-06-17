package academia.model;

import academia.HibernateUtil;
import academia.model.DAO.HibernateDAO;
import academia.model.DAO.InterfaceDAO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author vinicius
 */
@Entity
public class DadosPessoa implements Serializable{
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private double braco;
    private double quadril;
    private double cintura;
    private double coxa;
    private double panturrilha;
           

    @OneToOne(mappedBy = "dados")
    private Pessoa pessoa;

    public DadosPessoa(double braco, double quadril, double cintura, double coxa, double panturrilha) {
        this.braco = braco;
        this.quadril = quadril;
        this.cintura = cintura;
        this.coxa = coxa;
        this.panturrilha = panturrilha;
    }
        

    
    public static InterfaceDAO<DadosPessoa> dadosPessoaDAO() {
        InterfaceDAO<DadosPessoa> dadosPessoaDAO = new HibernateDAO<DadosPessoa>(DadosPessoa.class, HibernateUtil.getSessionFactory().openSession());
        return dadosPessoaDAO;
    }

    public double getBraco() {
        return braco;
    }

    public void setBraco(double braco) {
        this.braco = braco;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getCoxa() {
        return coxa;
    }

    public void setCoxa(double coxa) {
        this.coxa = coxa;
    }

    public double getPanturrilha() {
        return panturrilha;
    }

    public void setPanturrilha(double panturrilha) {
        this.panturrilha = panturrilha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
}
