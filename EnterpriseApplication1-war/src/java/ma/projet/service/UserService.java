/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import ma.projet.beans.User;
import ma.projet.dao.IDao;

/**
 *
 * @author hp
 */
public class UserService implements IDao<User>{
    @Override
    public boolean create(User o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(User o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(User o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.flush();
        session.getTransaction().commit();
        return true;
    }

    @Override
    public User getById(int id) {
        User user  = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        user  = (User) session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public List<User> getAll() {
        List <User> users = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        users  = session.createQuery("from User").list();
        session.getTransaction().commit();
        return users;
    }
    
    
    public List<Object[]> nbuser(){
        List<Object[]> users = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        users  = session.createQuery("select count(u.nom), u.nom from User u group by u.nom").list();
        session.getTransaction().commit();
        return users;
    }
    
    public List<User> getbydates(Date d1 , Date d2){
        List <User> users = new ArrayList<>();
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
         users  = session.createQuery("from User u where u.dateCreation between :d1 and :d2").setParameter("d1", d1).setParameter("d2", d2).list();
        session.getTransaction().commit();
        return users;
        
    }
}
