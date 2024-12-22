package com.example.service;

import com.example.model.Gasto;
import com.example.repository.GastoRepository;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/gastos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GastoService{
    private GastoRepository repository = new GastoRepository();

    @GET
    public List<Gasto> getAll(){
        return repository.getAll();
    }
    @GET
    @Path("/{id}")
    public Gasto getById(@PathParam("id") int id){
        return repository.getById(id).orElseThrow(() -> new WebApplicationException("Gasto no encontrado",404));
    }

    @POST
    public void add(Gasto gasto) {
        repository.add(gasto);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") int id, Gasto gasto) {
        gasto.setId(id);
        repository.update(gasto);
    }
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        repository.delete(id);
    }

    @GET
    @Path("/promedio")
    public double getAverage(){
        return repository.getAverage();

    }

    @GET
    @Path("/rango")
    public List<Gasto> getByDateRange(@QueryParam("inicio") long inicio, @QueryParam("fin") long fin){
        return repository.getByDateRange(inicio, fin);
    }
}
