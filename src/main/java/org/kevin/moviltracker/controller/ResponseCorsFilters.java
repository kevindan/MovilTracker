package org.kevin.moviltracker.controller;

import org.glassfish.jersey.server.ContainerResponse;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

/**
 * Created by kevin on 20/04/17.
 */
public class ResponseCorsFilters implements ContainerResponseFilter{


    @Override
    public void filter(ContainerRequestContext request,
                       ContainerResponseContext response) throws IOException {

        response.getHeaders().add("Access-Control-Allow-Origin","*");
        response.getHeaders().add("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        response.getHeaders().add("Access-Control-Allow-Credentials","true");
        response.getHeaders().add("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
}
