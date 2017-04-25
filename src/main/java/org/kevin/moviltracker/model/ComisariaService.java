package org.kevin.moviltracker.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kevin.moviltracker.entity.Comisaria;
import org.kevin.moviltracker.util.HibernateUtil;

import java.util.List;

/**
 * Created by USUARIO on 6/04/2017.
 */
public class ComisariaService {


    public void Grabar(Comisaria o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(o);
        System.out.println("Comisaria grabada con éxito");
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }


    public void Modificar(Comisaria o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Comisaria comisaria = (Comisaria) session.get(Comisaria.class, o.getComisaria_id());

        comisaria.setComisaria(o.getComisaria());

        System.out.println("Comisaria actualizada con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }


    public void Eliminar(Comisaria o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Comisaria comisaria = (Comisaria) session.get(Comisaria.class, o.getComisaria_id());

        comisaria.setActivo(0);

        System.out.println("Comisaria eliminada con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }


    public List<Comisaria> Listar() throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Comisaria where activo = 1 order by comisaria_id asc");
        List<Comisaria> comisarias = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return comisarias;

    }

    public List<Comisaria> Filtrar(Comisaria o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Comisaria where comisaria like :comisaria and activo = 1 order by  comisaria_id asc");
        query.setParameter("comisaria",o.getComisaria());
        List<Comisaria> efectivos = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return efectivos;
    }

    public Comisaria Buscar(Comisaria o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id = o.getComisaria_id();
        Query query = session.createQuery("from Comisaria where comisaria_id = :id and activo = 1");
        query.setParameter("id",id);
        Comisaria comisaria = (Comisaria) query.list().get(0);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return comisaria;

    }

}
