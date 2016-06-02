package academia.model.DAO;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author vinicius
 */
public class HibernateDAO<T> implements InterfaceDAO<T>, Serializable {

    private static final long serialVersionUID = 1L;
    private Class<T> classe;
    private Session session;

    public HibernateDAO(Class<T> classe, Session session) {
        super();
        this.classe = classe;
        this.session = session;
    }

    @Override
    public void save(T entity) {
        session.save(entity);
        session.close();
    }

    @Override
    public void update(T entity) {
        System.out.println("chamando update");
        session.update(entity);
        session.flush();
        session.close();

    }

    @Override
    public void remove(T entity) {
        session.delete(entity);
        session.flush();
        session.close();
    }

    @Override
    public void merge(T entity) {
        session.merge(entity);
    }

    @Override
    public T getEntity(Serializable id) {
        T entity = (T) session.get(classe, id);
        return entity;
    }

    @Override
    public T getEntityByCriteria(Criteria criteria) {
        T entity = (T) criteria.uniqueResult();
        return entity;
    }

    @Override
    public List<T> getEntities() {
        List<T> entities = (List<T>) session.createCriteria(classe).list();
        return entities;
    }

    @Override
    public List<T> getListByCriteria(Criteria criteria) {
        return criteria.list();
    }

}
