/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m2i.webservise;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author elouf
 */
@Path("annulaireServise")
public class AnnuaireServise {

    Annuaire annuaire;

    @GET
    @Path("{id}")
    public Response getPersonneID(@Context HttpServletRequest req, @PathParam("id") int id) {

        HttpSession session = req.getSession();

        annuaire = (Annuaire) session.getAttribute("annuaire");
        if (annuaire == null) {
            annuaire = new Annuaire();
            session.setAttribute("annuaire", annuaire);

        }

        Personne per = annuaire.personeByID(id);
        if(per !=null){
        return Response.status(Response.Status.OK).entity(per).build();}
        else{
        return Response.status(Response.Status.BAD_REQUEST).entity("id n'existe pas").build();}
        
    }

    @GET
    @Path("list")
    public List<Personne> getPersonneliste(@Context HttpServletRequest req) {

        HttpSession session = req.getSession();

        annuaire = (Annuaire) session.getAttribute("annuaire");
        if (annuaire == null) {
            annuaire = new Annuaire();
            session.setAttribute("annuaire", annuaire);

        }

        return annuaire.getAnnuaire();
    }

    @POST
    @Path("ajouter")
    public Response personneCreate(@Context HttpServletRequest req, @FormParam("id") int id,
            @DefaultValue("nom") @FormParam("nom") String nom, @DefaultValue("prenon") @FormParam("prenon") String prenon) {

        HttpSession session = req.getSession();

        annuaire = (Annuaire) session.getAttribute("annuaire");
        if (annuaire == null) {
            annuaire = new Annuaire();
            session.setAttribute("annuaire", annuaire);
        }

        Personne per = new Personne();
        per.setId(id);
        per.setNom(nom);
        per.setPrenon(prenon);
        annuaire.addPersone(per);

        System.out.println("persone annu" + annuaire.personeByID(id));
        System.out.println("persone" + per);
       return Response.status(Response.Status.CREATED).entity(per).build();
        //  annuaire.getAnnuaire();
    }

    @Path("modifier/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_XML})
    public Response personneModifier(@Context HttpServletRequest req, @PathParam("id") int id, Personne perr) {

        HttpSession session = req.getSession();

        annuaire = (Annuaire) session.getAttribute("annuaire");
        if (annuaire == null) {
            annuaire = new Annuaire();
            session.setAttribute("annuaire", annuaire);
        }
        
        if(perr == null ){ return Response.status(Response.Status.BAD_REQUEST).entity("pas de modif").build();}

        annuaire.modifiePersone(id, perr);
        System.out.println("persone annu" + annuaire.personeByID(perr.getId()));
        
        return Response.status(Response.Status.ACCEPTED).entity(perr).build();

       

    }

    @Path("supprimer/{id}")
    @DELETE
    public void personneSupprimer(@Context HttpServletRequest req, @PathParam("id") int id) {

        HttpSession session = req.getSession();

        annuaire = (Annuaire) session.getAttribute("annuaire");
        if (annuaire == null) {
            annuaire = new Annuaire();
            session.setAttribute("annuaire", annuaire);
        }

        annuaire.removePersone(id);

    }

}
