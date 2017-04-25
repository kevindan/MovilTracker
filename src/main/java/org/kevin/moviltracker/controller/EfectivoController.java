package org.kevin.moviltracker.controller;

import org.kevin.moviltracker.entity.Efectivo;
import org.kevin.moviltracker.model.EfectivoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USUARIO on 6/04/2017.
 */

@Path("efectivo")
public class EfectivoController {

    EfectivoService emodel;
    Efectivo efectivo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Efectivo> ListarEfectivo() {
        emodel = new EfectivoService();
        List<Efectivo> lista = new ArrayList<Efectivo>();
        try {
            lista = emodel.Listar();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return lista;
    }

    @GET
    @Path("/buscar/{efectivo_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Efectivo BuscarEfectivo(@PathParam("efectivo_id") int efectivo_id) {
        emodel = new EfectivoService();
        efectivo = new Efectivo();
        efectivo.setEfectivo_id(efectivo_id);

        try {
            efectivo = emodel.Buscar(efectivo);
        } catch (Throwable th) {
            th.printStackTrace();
        }

        return efectivo;

    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)

    public void Grabar(Efectivo efect) {
        emodel = new EfectivoService();
        try {
            emodel.Grabar(efect);
        } catch (Throwable th) {
            th.printStackTrace();
        }

    }

    @PUT
    @Path("/modificar/{efectivo_id}")
    @Consumes(MediaType.APPLICATION_JSON)

    public void Actualizar(@PathParam("efectivo_id") int id, Efectivo efect) {
        efect.setEfectivo_id(id);
        emodel = new EfectivoService();
        try {
            emodel.Modificar(efect);
        } catch (Throwable th) {
            th.printStackTrace();
        }

    }

    @DELETE
    @Path("/eliminar/{efectivo_id}")
    @Consumes(MediaType.APPLICATION_JSON)

    public void Eliminar(@PathParam("efectivo_id") int id) {
        efectivo = new Efectivo();
        efectivo.setEfectivo_id(id);
        emodel = new EfectivoService();
        try {
            emodel.Eliminar(efectivo);
        } catch (Throwable th) {
            th.printStackTrace();
        }

    }

}
