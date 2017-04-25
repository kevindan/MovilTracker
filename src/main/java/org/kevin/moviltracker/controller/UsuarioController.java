package org.kevin.moviltracker.controller;

import org.kevin.moviltracker.entity.Efectivo;
import org.kevin.moviltracker.entity.Perfil;
import org.kevin.moviltracker.entity.Usuario;
import org.kevin.moviltracker.model.EfectivoService;
import org.kevin.moviltracker.model.UsuarioService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by USUARIO on 6/04/2017.
 */
@Path("usuario")
public class UsuarioController {

    UsuarioService umodel;
    Usuario usuario;
    Perfil perfil;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)

    public Perfil Login(Usuario u) {
        perfil = new Perfil();

        umodel = new UsuarioService();
        try {
            perfil = umodel.Autenticacion(u);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return perfil;
    }

}