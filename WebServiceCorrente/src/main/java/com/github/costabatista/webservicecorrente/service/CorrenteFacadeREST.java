/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.costabatista.webservicecorrente.service;

import com.github.costabatista.webservicecorrente.Corrente;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author paulo
 */
@Stateless
@Path("corrente")
public class CorrenteFacadeREST extends AbstractFacade<Corrente> {

    @PersistenceContext(unitName = "com.github.costabatista_WebServiceCorrente_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public CorrenteFacadeREST() {
        super(Corrente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Corrente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Corrente entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Corrente find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Corrente> findAll() {
        return super.findAll();
    }

    @GET
    @Path("valor")
    @Produces({MediaType.APPLICATION_JSON})
    public String getCorrenteTotal() {
        EntityManager em = getEntityManager();
        List<Corrente> listaDeCorrente = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("corrente.consultarPorNaoEnviadaAoWebservice");
            query.setParameter("enviadoparawebservice", false);
            listaDeCorrente = query.getResultList();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            listaDeCorrente = new ArrayList<>();
        } 
        
        Gson gson = new Gson();
        
        return gson.toJson(listaDeCorrente.get(0));
    }
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Corrente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
