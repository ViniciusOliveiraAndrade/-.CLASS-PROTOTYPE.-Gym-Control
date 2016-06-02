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
public class Endereco implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String rua;
    private String bairro;

    private int numero;
    private String cep;

    @OneToOne(mappedBy = "endereco")
    private Pessoa pessoa;

    public Endereco() {
    }

    public Endereco(String rua, String bairro, int numero, String cep) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
    }
    

    /*
	 *
	 * ===================================================== Gets & Sets =============================================================
	 * 
	 * */
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public static InterfaceDAO<Endereco> enderecoDAO() {
        InterfaceDAO<Endereco> enderecoDAO = new HibernateDAO<Endereco>(Endereco.class, HibernateUtil.getSessionFactory().openSession());
        return enderecoDAO;
    }

}
