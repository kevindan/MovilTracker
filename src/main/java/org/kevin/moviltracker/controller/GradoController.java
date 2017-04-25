package org.kevin.moviltracker.controller;

import org.kevin.moviltracker.entity.Grado;
import org.kevin.moviltracker.model.GradoService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USUARIO on 6/04/2017.
 */
@Path("grado")
public class GradoController {


    GradoService gmodel;
    Grado grado;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Grado> ListarGrado() {
        gmodel = new GradoService();
        List<Grado> lista = new ArrayList<Grado>();
        try {
            lista = gmodel.Listar();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return lista;
    }

    @GET
    @Path("/buscar/{grado_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Grado BuscarGrado(@PathParam("grado_id") int grado_id) {
        gmodel = new GradoService();
        grado = new Grado();
        grado.setGrado_id(grado_id);

        try {
            grado = gmodel.Buscar(grado);
        } catch (Throwable th) {
            th.printStackTrace();
        }

        return grado;

    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)

    public void Grabar(Grado g) {
        gmodel = new GradoService();
        try {
            gmodel.Grabar(g);
        } catch (Throwable th) {
            th.printStackTrace();
        }

    }

    @PUT
    @Path("/modificar/{grado_id}")
    @Consumes(MediaType.APPLICATION_JSON)

    public void Actualizar(@PathParam("grado_id") int id, Grado g) {
        g.setGrado_id(id);
        gmodel = new GradoService();
        try {
            gmodel.Modificar(g);
        } catch (Throwable th) {
            th.printStackTrace();
        }

    }

    @DELETE
    @Path("/eliminar/{grado_id}")
    @Consumes(MediaType.APPLICATION_JSON)

    public void Eliminar(@PathParam("grado_id") int id) {
        grado = new Grado();
        grado.setGrado_id(id);
        gmodel = new GradoService();
        try {
            gmodel.Eliminar(grado);
        } catch (Throwable th) {
            th.printStackTrace();
        }

    }
}
