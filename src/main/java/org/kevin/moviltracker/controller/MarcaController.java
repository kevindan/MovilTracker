package org.kevin.moviltracker.controller;

import org.kevin.moviltracker.entity.Marca;
import org.kevin.moviltracker.model.MarcaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USUARIO on 6/04/2017.
 */
@Path("marca")
public class MarcaController{


        MarcaService m_model;
        Marca marca;

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<Marca> ListarEfectivo() {
            m_model = new MarcaService();
            List<Marca> lista = new ArrayList<Marca>();
            try {
                lista = m_model.Listar();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return lista;
        }

        @GET
        @Path("/buscar/{marca_id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Marca BuscarEfectivo(@PathParam("marca_id") int marca_id) {
            m_model = new MarcaService();
            marca = new Marca();
            marca.setMarca_id(marca_id);

            try {
                marca = m_model.Buscar(marca);
            } catch (Throwable th) {
                th.printStackTrace();
            }

            return marca;

        }

        @POST
        @Path("/insertar")
        @Consumes(MediaType.APPLICATION_JSON)

        public void Grabar(Marca m) {
            m_model = new MarcaService();
            try {
                m_model.Grabar(m);
            } catch (Throwable th) {
                th.printStackTrace();
            }

        }

        @PUT
        @Path("/modificar/{marca_id}")
        @Consumes(MediaType.APPLICATION_JSON)

        public void Actualizar(@PathParam("marca_id") int id, Marca m) {
            m.setMarca_id(id);
            m_model = new MarcaService();
            try {
                m_model.Modificar(m);
            } catch (Throwable th) {
                th.printStackTrace();
            }

        }

        @DELETE
        @Path("/eliminar/{marca_id}")
        @Consumes(MediaType.APPLICATION_JSON)

        public void Eliminar(@PathParam("marca_id") int id) {
            marca = new Marca();
            marca.setMarca_id(id);
            m_model = new MarcaService();
            try {
                m_model.Eliminar(marca);
            } catch (Throwable th) {
                th.printStackTrace();
            }

        }


}
