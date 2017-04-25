package org.kevin.moviltracker.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kevin.moviltracker.entity.Vehiculo;
import org.kevin.moviltracker.util.HibernateUtil;
import java.util.List;

/**
 * Created by USUARIO on 6/04/2017.
 */
public class VehiculoService {

    public void Grabar(Vehiculo o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(o);
        System.out.println("Vehículo grabado con éxito");
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }


    public void Modificar(Vehiculo o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Vehiculo vehiculo = (Vehiculo) session.get(Vehiculo.class, o.getVehiculo_id());

        vehiculo.setNro_placa(o.getNro_placa());
        vehiculo.setMarca_id(o.getMarca_id());
        vehiculo.setAnio_fabricacion(o.getAnio_fabricacion());

        System.out.println("Vehículo actualizado con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }


    public void Eliminar(Vehiculo o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Vehiculo vehiculo = (Vehiculo) session.get(Vehiculo.class, o.getVehiculo_id());

        vehiculo.setActivo(0);

        System.out.println("Vehículo eliminado con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }


    public List<Vehiculo> Listar() throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Vehiculo where activo = 1 order by vehiculo_id asc");
        List<Vehiculo> efectivos = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return efectivos;

    }


    public List<Vehiculo> Filtrar(Vehiculo o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Vehiculo where nro_placa like :nro_placa and activo = 1 order by vehiculo_id asc");
        query.setParameter("nro_placa",o.getNro_placa());
        List<Vehiculo> vehiculos = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return vehiculos;
    }


    public Vehiculo Buscar(Vehiculo o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id = o.getVehiculo_id();
        Query query = session.createQuery("from Vehiculo where vehiculo_id = :id and activo = 1");
        query.setParameter("id",id);
        Vehiculo vehiculo = (Vehiculo) query.list().get(0);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return vehiculo;

    }

}
