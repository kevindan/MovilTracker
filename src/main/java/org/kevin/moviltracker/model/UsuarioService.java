package org.kevin.moviltracker.model;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kevin.moviltracker.entity.Perfil;
import org.kevin.moviltracker.entity.Usuario;
import org.kevin.moviltracker.util.HibernateUtil;

import java.util.List;

/**
 * Created by USUARIO on 6/04/2017.
 */
public class UsuarioService {

    public void Grabar(Usuario o) throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        System.out.println("Usuario grabado con éxito");
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }


    public void Modificar(Usuario o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Usuario usuario = (Usuario) session.get(Usuario.class, o.getEfectivo_id());

        usuario.setContrasena(o.getContrasena());

        System.out.println("Usuario actualizado con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }

    public void Eliminar(Usuario o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Usuario usuario = (Usuario) session.get(Usuario.class, o.getEfectivo_id());

        usuario.setActivo(0);

        System.out.println("Usuario eliminado con éxito");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }


    public List<Usuario> Listar() throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Usuario where activo = 1 order by efectivo_id asc");
        List<Usuario> usuarios = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return usuarios;

    }

    public Usuario Buscar(Usuario o) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id = o.getEfectivo_id();
        Query query = session.createQuery("from Usuario where efectivo_id = :id and activo = 1");
        query.setParameter("id", id);
        Usuario usuario = (Usuario) query.list().get(0);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return usuario;

    }

    public Perfil Autenticacion(Usuario o){
        String h;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String sql = "select efectivo.efectivo_id, efectivo.nombres, efectivo.apellidos,grado.grado, "
                   + " comisaria.comisaria,zona.zona,marca.marca,vehiculo.nro_placa "
               + " from efectivo,marca,grado,comisaria,zona,vehiculo,asignacion,usuario "
              +"  where asignacion.efectivo_id = efectivo.efectivo_id and asignacion.vehiculo_id = vehiculo.vehiculo_id and "
               +" asignacion.comisaria_id = comisaria.comisaria_id and asignacion.zona_id = zona.zona_id and "
                +" vehiculo.marca_id = marca.marca_id and efectivo.grado_id = grado.grado_id and efectivo.efectivo_id = usuario.efectivo_id and "
                +" usuario.efectivo_cip = :cip and usuario.contrasena = :pass and usuario.activo = 1 and efectivo.activo = 1 ";

        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Perfil.class);
        query.setParameter("cip", o.getEfectivo_cip());
        query.setParameter("pass",o.getContrasena());
        Perfil perfil = (Perfil) query.list().get(0);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        if(!(perfil.getNombres()==null)){
            return perfil;
        }else{
            perfil = null;
            return perfil ;
        }

    }


}
