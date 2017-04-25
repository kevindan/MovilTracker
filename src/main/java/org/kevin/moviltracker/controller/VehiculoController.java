package org.kevin.moviltracker.controller;


import org.kevin.moviltracker.entity.Vehiculo;
import org.kevin.moviltracker.model.VehiculoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USUARIO on 6/04/2017.
 */
@Path("vehiculo")
public class VehiculoController {

    VehiculoService vmodel;
    Vehiculo vehiculo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehiculo> ListarVehiculo() {
        vmodel = new VehiculoService();
        List<Vehiculo> lista = new ArrayList<Vehiculo>();
        try {
            lista = vmodel.Listar();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return lista;
    }

    @GET
    @Path("/buscar/{vehiculo_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vehiculo BuscarVechiculo(@PathParam("vehiculo_id") int vehiculo_id) {
        vmodel = new VehiculoService();
        vehiculo = new Vehiculo();
        vehiculo.setVehiculo_id(vehiculo_id);

        try {
            vehiculo = vmodel.Buscar(vehiculo);
        } catch (Throwable th) {
            th.printStackTrace();
        }

        return vehiculo;

    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)

    public void Grabar(Vehiculo v) {
        vmodel = new VehiculoService();
        try {
            vmodel.Grabar(v);
        } catch (Throwable th) {
            th.printStackTrace();
        }

    }

    @PUT
    @Path("/modificar/{vehiculo_id}")
    @Consumes(MediaType.APPLICATION_JSON)

    public void Actualizar(@PathParam("vehiculo_id") int id, Vehiculo v) {
        v.setVehiculo_id(id);
        vmodel = new VehiculoService();
        try {
            vmodel.Modificar(v);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @DELETE
    @Path("/eliminar/{vehiculo_id}")
    @Consumes(MediaType.APPLICATION_JSON)

    public void Eliminar(@PathParam("vehiculo_id") int id) {
        vehiculo = new Vehiculo();
        vehiculo.setVehiculo_id(id);
        vmodel = new VehiculoService();
        try {
            vmodel.Eliminar(vehiculo);
        } catch (Throwable th) {
            th.printStackTrace();
        }

    }

}
