package org.kevin.moviltracker.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kevin.moviltracker.entity.Marca;
import org.kevin.moviltracker.util.HibernateUtil;

import java.util.List;

/**
 * Created by USUARIO on 6/04/2017.
 */
public class MarcaService {

    public void Grabar(Marca o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(o);
        System.out.println("Marca grabada con éxito");
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }


    public void Modificar(Marca o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Marca marca = (Marca) session.get(Marca.class, o.getMarca_id());

        marca.setMarca(o.getMarca());

        System.out.println("Marca actualizada con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }


    public void Eliminar(Marca o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Marca marca = (Marca) session.get(Marca.class, o.getMarca_id());

        marca.setActivo(0);

        System.out.println("Marca eliminada con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }


    public List<Marca> Listar() throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Marca where activo = 1 order by marca_id asc");
        List<Marca> marcas = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return marcas;

    }


    public List<Marca> Filtrar(Marca o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Marca where marca like :marca and activo = 1 order by marca_id asc");
        query.setParameter("marca",o.getMarca());
        List<Marca> marcas = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return marcas;
    }


    public Marca Buscar(Marca o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id = o.getMarca_id();
        Query query = session.createQuery("from Marca where marca_id = :id and activo = 1");
        query.setParameter("id",id);
        Marca marca = (Marca) query.list().get(0);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return marca;

    }

}
