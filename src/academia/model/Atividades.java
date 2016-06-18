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
public class Atividades implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String[] segunda;
    private String[] terca;
    private String[] quarta;
    private String[] quinta;
    private String[] sexta;
    private String[] sabado;
    private String[] domingo;

    @OneToOne(mappedBy = "atividade")
    private Pessoa pessoa;

    public Atividades() {
    }

    public Atividades(String[] segunda, String[] terca, String[] quarta, String[] quinta, String[] sexta, String[] sabado, String[] domingo) {
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
        this.domingo = domingo;
    }

    public String[] getSegunda() {
        return segunda;
    }

    public void setSegunda(String[] segunda) {
        this.segunda = segunda;
    }

    public String[] getTerca() {
        return terca;
    }

    public void setTerca(String[] terca) {
        this.terca = terca;
    }

    public String[] getQuarta() {
        return quarta;
    }

    public void setQuarta(String[] quarta) {
        this.quarta = quarta;
    }

    public String[] getQuinta() {
        return quinta;
    }

    public void setQuinta(String[] quinta) {
        this.quinta = quinta;
    }

    public String[] getSexta() {
        return sexta;
    }

    public void setSexta(String[] sexta) {
        this.sexta = sexta;
    }

    public String[] getSabado() {
        return sabado;
    }

    public void setSabado(String[] sabado) {
        this.sabado = sabado;
    }

    public String[] getDomingo() {
        return domingo;
    }

    public void setDomingo(String[] domingo) {
        this.domingo = domingo;
    }

    public static InterfaceDAO<Atividades> atividadesDAO() {
        InterfaceDAO<Atividades> atividadesDAO = new HibernateDAO<Atividades>(Atividades.class, HibernateUtil.getSessionFactory().openSession());
        return atividadesDAO;
    }
}
