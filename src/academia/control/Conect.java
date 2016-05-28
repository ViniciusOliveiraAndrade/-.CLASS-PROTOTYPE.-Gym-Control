package academia.control;

import academia.HibernateUtil;

/**
 *
 * @author vinicius
 */
public class Conect extends Thread {

    public void run() {
        HibernateUtil.getSessionFactory().openSession();
    }
}
