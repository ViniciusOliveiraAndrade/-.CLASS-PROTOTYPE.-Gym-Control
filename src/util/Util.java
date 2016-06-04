package util;

import academia.HibernateUtil;
import academia.model.Pessoa;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.text.MaskFormatter;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vinicius
 */
public class Util {

    public KeyAdapter CosumeLetter() {
        KeyAdapter keyAdapter = new KeyAdapter() {

            public void keyTyped(KeyEvent ev) {
                String caracteres = "0987654321";
                if (!caracteres.contains(ev.getKeyChar() + "")) {
                    ev.consume();
                }
            }
        };
        
        return keyAdapter;
    }

    public MaskFormatter Mascara(String Mascara) {
        MaskFormatter F_Mascara = new MaskFormatter();
        try {
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
        } catch (Exception excecao) {
            excecao.printStackTrace();
        }
        return F_Mascara;
    }

    public Pessoa buscar(String cpf, int tipo) {
        Criteria crit = HibernateUtil.getSessionFactory().openSession().createCriteria(Pessoa.class);
        crit.add(Restrictions.eq("cpf", cpf)).add(Restrictions.eq("tipo",tipo));
        Pessoa p = Pessoa.pessoaDAO().getEntityByCriteria(crit);
        return p;
    }
}
