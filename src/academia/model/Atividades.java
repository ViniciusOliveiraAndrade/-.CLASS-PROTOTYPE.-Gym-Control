package academia.model;

import academia.HibernateUtil;
import academia.model.DAO.HibernateDAO;
import academia.model.DAO.InterfaceDAO;
import java.io.Serializable;
import java.util.ArrayList;
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

    private String segunda;

    @OneToOne(mappedBy = "atividades")
    private Pessoa pessoa;

    public Atividades() {
    }

    public Atividades(String segunda) {
        this.segunda = segunda;
    }

    public String getSegunda() {
        return segunda;
    }

    public void setSegunda(String segunda) {
        this.segunda = segunda;
    }

//    public String getTerca() {
//        return terca;
//    }
//
//    public void setTerca(String terca) {
//        this.terca = terca;
//    }
//
//    public String getQuarta() {
//        return quarta;
//    }
//
//    public void setQuarta(String quarta) {
//        this.quarta = quarta;
//    }
//
//    public String getQuinta() {
//        return quinta;
//    }
//
//    public void setQuinta(String quinta) {
//        this.quinta = quinta;
//    }
//
//    public String getSexta() {
//        return sexta;
//    }
//
//    public void setSexta(String sexta) {
//        this.sexta = sexta;
//    }
//
//    public String getSabado() {
//        return sabado;
//    }
//
//    public void setSabado(String sabado) {
//        this.sabado = sabado;
//    }
//
//    public String getDomingo() {
//        return domingo;
//    }
//
//    public void setDomingo(String domingo) {
//        this.domingo = domingo;
//    }
    public ArrayList getArray() {
        ArrayList<String> array = new ArrayList();

        if (segunda.isEmpty()) {
            for (int a = 0; a < 35; a++) {
                array.add(".");
            }
        } else {
            
            String segundaA[] = segunda.split(":");

            for (int z = 0; z < segundaA.length; z++) {
                array.add(segundaA[z]);
                
            }
        }
        return array;

    }

    public void setArray(ArrayList<String> array) {
        segunda ="";
        for (String a : array) {
            segunda += ":" + a;
        }
       segunda= segunda.substring(1);

    }

    public static InterfaceDAO<Atividades> atividadesDAO() {
        InterfaceDAO<Atividades> atividadesDAO = new HibernateDAO<Atividades>(Atividades.class, HibernateUtil.getSessionFactory().openSession());
        return atividadesDAO;
    }
}
