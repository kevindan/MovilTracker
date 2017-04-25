package org.kevin.moviltracker.controller;

import org.kevin.moviltracker.entity.Vehiculo;
import org.kevin.moviltracker.entity.Zona;
import org.kevin.moviltracker.model.VehiculoService;
import org.kevin.moviltracker.model.ZonaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by USUARIO on 6/04/2017.
 */
@Path("zona")
public class ZonaController {
    ZonaService zmodel;
    Zona zona;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Zona> ListarVehiculo() {
        zmodel = new ZonaService();
        List<Zona> lista = new ArrayList<Zona>();
        try {
            lista = zmodel.Listar();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return lista;
    }

    @GET
    @Path("/buscar/{zona_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Zona BuscarZona(@PathParam("zona_id") int zona_id) {
        zmodel = new ZonaService();
        zona = new Zona();
        zona.setZona_id(zona_id);

        try {
            zona = zmodel.Buscar(zona);
        } catch (Throwable th) {
            th.printStackTrace();
        }

        return zona;

    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)

    public void Grabar(Zona z) {
        zmodel = new ZonaService();
        try {
            zmodel.Grabar(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }

    }

    @PUT
    @Path("/modificar/{zona_id}")
    @Consumes(MediaType.APPLICATION_JSON)

    public void Actualizar(@PathParam("zona_id") int id, Zona z) {
        z.setZona_id(id);
        zmodel = new ZonaService();
        try {
            zmodel.Modificar(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @DELETE
    @Path("/eliminar/{zona_id}")
    @Consumes(MediaType.APPLICATION_JSON)

    public void Eliminar(@PathParam("zona_id") int id) {
        zona = new Zona();
        zona.setZona_id(id);
        zmodel = new ZonaService();
        try {
            zmodel.Eliminar(zona);
        } catch (Throwable th) {
            th.printStackTrace();
        }

    }
}
