/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;
import java.util.List;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import ma.projet.beans.SmartPhone;
import ma.projet.dao.IDao;
/**
 *
 * @author hp
 */
public class SmartPhoneService implements IDao<SmartPhone>{
    @Override
    public boolean create(SmartPhone o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }
    @Override
    public boolean update(SmartPhone o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }
    @Override
    public boolean delete(SmartPhone o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public SmartPhone getById(int id) {
        SmartPhone smartphone  = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        smartphone  = (SmartPhone) session.get(SmartPhone.class, id);
        session.getTransaction().commit();
        return smartphone;
    }

    @Override
    public List<SmartPhone> getAll() {
        
         List <SmartPhone> smartphones = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        smartphones  = session.createQuery("from SmartPhone").list();
        session.getTransaction().commit();
        return smartphones;
    }
    
}
