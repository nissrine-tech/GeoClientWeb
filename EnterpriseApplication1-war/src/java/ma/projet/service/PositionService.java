/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;
import java.util.List;
import ma.projet.beans.Position;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author hp
 */
public class PositionService implements IDao<Position>{
    @Override
    public boolean create(Position o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }
    
    @Override
    public boolean update(Position o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }
    
    @Override
    public boolean delete(Position o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public List<Position> getAll() {
        List<Position> positions = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        positions = session.createQuery("from Position").list();
        session.getTransaction().commit();
        return positions;
    }

    @Override
    public Position getById(int id) {
        Position position = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        position = (Position) session.get(Position.class, id);
        session.getTransaction().commit();
        return position;
    }
}

