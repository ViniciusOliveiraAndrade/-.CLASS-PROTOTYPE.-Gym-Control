/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.model.DAO;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author vinicius
 */
public interface InterfaceDAO<T> {
    
    void save(T entity);
    void update(T entity);
    void remove(T entity);
    void merge(T entity);
    T getEntity(Serializable id);
    T getEntityByCriteria(Criteria criteria);
    List<T> getEntities();    
    List<T> getListByCriteria(Criteria criteria);    
    
}