package model.dao;

import model.entities.Point;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PointDao implements EntityDao<Point> {
    @Override
    public void insertEntity(Point point) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(point);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public List<Point> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Point.class);
        List<Point> results = criteria.list();
        session.getTransaction().commit();
        session.close();
        Collections.sort(results, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Long.compare(o1.getId(),o2.getId());
            }
        });
        return results;
    }

    @Override
    public void clearAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<Point> points = (ArrayList<Point>) getAll();
        for (Point point:points) session.delete(point);
        session.getTransaction().commit();
        session.close();
    }
}

