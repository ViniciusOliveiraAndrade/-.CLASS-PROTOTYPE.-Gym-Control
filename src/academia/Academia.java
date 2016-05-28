package academia;

import academia.control.Conect;
import academia.view.TelaFuncionairo;
import academia.view.TelaLogin;

/**
 *
 * @author vinicius
 */
public class Academia {

    public static void main(String[] args) {
        Conect c = new Conect();
        c.start();
//        new TelaFuncionairo();
        new TelaLogin();
    }

}
