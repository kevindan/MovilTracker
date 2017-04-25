package org.kevin.moviltracker.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kevin.moviltracker.entity.Asignacion;
import org.kevin.moviltracker.util.HibernateUtil;

import java.util.List;

/**
 * Created by kevin on 16/04/17.
 */
public class AsignacionService {



    public void Grabar(Asignacion o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(o);
        System.out.println("Asignacion grabada con éxito grabada con éxito");
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }


    public void Modificar(Asignacion o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("update Asignacion set efectivo_id =:efectivo_id, " +
                " comisaria_id=:comisaria_id,zona_id=:zona_id,fecha_asignacion=:fecha_asignacion" +
                " where vehiculo_id=:vehiculo_id and activo = 1");
        query.setParameter("efectivo_id",o.getEfectivo_id());
        query.setParameter("comisaria_id",o.getComisaria_id());
        query.setParameter("zona_id",o.getZona_id());
        query.setParameter("fecha_asignacion",o.getFecha_asignacion());
        query.setParameter("vehiculo_id",o.getVehiculo_id());
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }


    public void Eliminar(Asignacion o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Asignacion asignacion = (Asignacion) session.get(Asignacion.class, o.getVehiculo_id());

        asignacion.setActivo(0);

        System.out.println("Asignacion eliminada con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }


    public List<Asignacion> Buscar(Asignacion o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id = o.getVehiculo_id();
        Query query = session.createQuery("from Asignacion where vehiculo_id = :id and activo = 1");
        query.setParameter("id",id);
        List<Asignacion> asignacion = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return asignacion;

    }


}
