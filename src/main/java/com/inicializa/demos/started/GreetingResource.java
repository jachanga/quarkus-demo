package com.inicializa.demos.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/api")
public class GreetingResource {

    @Inject
    GreetingService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hola/{name}")
    public String hola(@PathParam String name) {
        return service.greeting(name);
    }

    @GET
    @Path("/hola")
    @Produces(MediaType.TEXT_PLAIN)
    public String hola() {
        return "hola";
    }
}