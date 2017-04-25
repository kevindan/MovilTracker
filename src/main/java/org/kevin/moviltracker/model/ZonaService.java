package org.kevin.moviltracker.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kevin.moviltracker.entity.Zona;
import org.kevin.moviltracker.util.HibernateUtil;

import java.util.List;

/**
 * Created by USUARIO on 6/04/2017.
 */
public class ZonaService {

    public void Grabar(Zona o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(o);
        System.out.println("Zona grabada con éxito");
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }


    public void Modificar(Zona o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Zona zona = (Zona) session.get(Zona.class, o.getZona_id());

        zona.setZona(o.getZona());

        System.out.println("Zona actualizada con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }


    public void Eliminar(Zona o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Zona zona = (Zona) session.get(Zona.class, o.getZona_id());

        zona.setActivo(0);

        System.out.println("Zona eliminada con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }


    public List<Zona> Listar() throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Zona where activo = 1 order by zona_id asc");
        List<Zona> zonas = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return zonas;

    }


    public List<Zona> Filtrar(Zona o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Zona where zona like :zona and activo=1 order by zona_id asc");
        query.setParameter("zona",o.getZona());
        List<Zona> zonas = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return zonas;
    }


    public Zona Buscar(Zona o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id = o.getZona_id();
        Query query = session.createQuery("from Zona where zona_id = :id and activo = 1");
        query.setParameter("id",id);
        Zona zona = (Zona) query.list().get(0);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return zona;

    }

}
