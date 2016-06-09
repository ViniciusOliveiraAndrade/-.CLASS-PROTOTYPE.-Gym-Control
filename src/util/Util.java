package util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author vinicius
 */
public class Util {

    public KeyAdapter cosumeLetter() {
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

    public MaskFormatter mascara(String Mascara) {
        MaskFormatter F_Mascara = new MaskFormatter();
        try {
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
        } catch (Exception excecao) {
            excecao.printStackTrace();
        }
        return F_Mascara;
    }

    
}
