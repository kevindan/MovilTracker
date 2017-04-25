package org.kevin.moviltracker.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kevin.moviltracker.entity.Efectivo;
import org.kevin.moviltracker.util.HibernateUtil;

import java.util.List;

/**
 * Created by USUARIO on 6/04/2017.
 */
public class EfectivoService {


    public void Grabar(Efectivo o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(o);
        System.out.println("Efectivo grabado con éxito");
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }


    public void Modificar(Efectivo o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Efectivo efectivo = (Efectivo) session.get(Efectivo.class, o.getEfectivo_id());

        efectivo.setNombres(o.getNombres());
        efectivo.setApellidos(o.getApellidos());
        efectivo.setEfectivo_cip(o.getEfectivo_cip());
        efectivo.setGrado_id(o.getGrado_id());

        System.out.println("Efectivo actualizado con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }


    public void Eliminar(Efectivo o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Efectivo efectivo = (Efectivo) session.get(Efectivo.class, o.getEfectivo_id());

        efectivo.setActivo(0);

        System.out.println("Efectivo eliminado con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }


    public List<Efectivo> Listar() throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Efectivo where activo = 1 order by efectivo_id asc");
        List<Efectivo> efectivos = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return efectivos;

    }


    public List<Efectivo> Filtrar(Efectivo o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Efectivo where nombres like :nombres and activo = 1 order by efectivo_id asc");
        query.setParameter("nombres",o.getNombres());
        List<Efectivo> efectivos = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return efectivos;
    }


    public Efectivo Buscar(Efectivo o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id = o.getEfectivo_id();
        Query query = session.createQuery("from Efectivo where efectivo_id = :id and activo = 1");
        query.setParameter("id",id);
        Efectivo efectivo = (Efectivo) query.list().get(0);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return efectivo;

    }
}
