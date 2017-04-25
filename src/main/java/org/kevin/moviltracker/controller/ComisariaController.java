package org.kevin.moviltracker.controller;


import org.kevin.moviltracker.entity.Comisaria;
import org.kevin.moviltracker.model.ComisariaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("comisaria")
public class ComisariaController {

    ComisariaService cmodel;
    Comisaria comisaria;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comisaria> Listar() {
        cmodel = new ComisariaService();
        List<Comisaria> lista = new ArrayList<Comisaria>();
        try {
            lista = cmodel.Listar();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return lista;
    }

    @GET
    @Path("/buscar/{comisaria_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comisaria Buscar(@PathParam("comisaria_id") int id) {
        comisaria = new Comisaria();
        cmodel = new ComisariaService();
        comisaria.setComisaria_id(id);

        try {
            comisaria = cmodel.Buscar(comisaria);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return comisaria;
    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void Grabar(Comisaria c) {
        cmodel = new ComisariaService();

        try {
            cmodel.Grabar(c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @PUT
    @Path("/modificar/{comisaria_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void Actualizar(@PathParam("comisaria_id") int id, Comisaria c) {
        c.setComisaria_id(id);
        cmodel = new ComisariaService();
        try {
            cmodel.Modificar(c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @DELETE
    @Path("/eliminar/{comisaria_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void Eliminar(@PathParam("comisaria_id") int id) {
        comisaria = new Comisaria();
        comisaria.setComisaria_id(id);
        cmodel = new ComisariaService();
        try {
            cmodel.Modificar(comisaria);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }


}
