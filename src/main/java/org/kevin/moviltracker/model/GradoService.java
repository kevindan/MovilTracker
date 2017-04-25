package org.kevin.moviltracker.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kevin.moviltracker.entity.Grado;
import org.kevin.moviltracker.util.HibernateUtil;

import java.util.List;

/**
 * Created by USUARIO on 6/04/2017.
 */
public class GradoService {


    public void Grabar(Grado o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(o);
        System.out.println("Grado grabado con éxito");
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void Modificar(Grado o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Grado grado = (Grado) session.get(Grado.class, o.getGrado_id());

        grado.setGrado(o.getGrado());

        System.out.println("Grado actualizado con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }


    public void Eliminar(Grado o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Grado grado = (Grado) session.get(Grado.class, o.getGrado_id());

        grado.setActivo(0);

        System.out.println("grado eliminado con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }


    public List<Grado> Listar() throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Grado where activo = 1 order by grado_id asc");
        List<Grado> grados = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return grados;

    }


    public List<Grado> Filtrar(Grado o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Grado where grado like :grado and activo = 1 order by grado_id");
        query.setParameter("grado",o.getGrado());
        List<Grado> grados = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return grados;
    }


    public Grado Buscar(Grado o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Grado where grado_id = :id and activo = 1");
        query.setParameter("id",o.getGrado_id());
        Grado grado = (Grado) query.list().get(0);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return grado;

    }

}
