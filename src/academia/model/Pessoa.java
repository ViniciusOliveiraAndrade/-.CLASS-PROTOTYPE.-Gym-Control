package academia.model;

import academia.HibernateUtil;
import academia.model.DAO.HibernateDAO;
import academia.model.DAO.InterfaceDAO;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author vinicius
 */
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    
    private String nome;

    @Column(unique = true)
    private String cpf;
    private String senha;
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Endereco endereco;
    
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private DadosPessoa dados;
    
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Atividades atividades;
   
    private double altura;
    private double peso;
    private double pagamento;

    //private Date dataDeEntrada;
    private int tipo = 1;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String telefone, String senha, Endereco endereco, double altura, double peso,int tipo, DadosPessoa dados, Atividades ativiade) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.altura = altura;
        this.peso = peso;
        this.telefone = telefone;
        this.tipo = tipo;
        this.dados = dados;
        this.atividades = ativiade;
    }

    public Pessoa(String nome, String cpf, String telefone, String senha, Endereco endereco,int tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipo = tipo;
        this.dados=null;
    }

//    public void criar(Pessoa p,Endereco endereco) {
//        Endereco.enderecoDAO().save(endereco);
//        p.setEndereco(endereco);
//        pessoaDAO().save(p);
//
//    }

//    public void update(Pessoa p) {
////        this.endereco = endereco;
//        pessoaDAO().update(p);
//    }

    public static InterfaceDAO<Pessoa> pessoaDAO() {
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, HibernateUtil.getSessionFactory().openSession());
        return pessoaDAO;
    }

    /*
	 * 
	 * 
	 * ====================================================== Gets & Sets ==============================================================
	 * 
	 * 
	 * */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPagamento() {
        return pagamento;
    }

    public void setPagamento(double pagamento) {
        this.pagamento = pagamento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public DadosPessoa getDados() {
        return dados;
    }

    public void setDados(DadosPessoa dados) {
        this.dados = dados;
    }

    public Atividades getAtividades() {
        return atividades;
    }

    public void setAtividades(Atividades atividades) {
        this.atividades = atividades;
    }
    
    

}
