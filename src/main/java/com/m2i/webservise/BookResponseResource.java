/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m2i.webservise;

/**
 *
 * @author elouf
 */

import java.io.IOException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("responseResource")
public class BookResponseResource {
    
    @GET
    @Path("ok/without_response")
    public String getbookwithoutResponse(){
        return "java For life ";
    }
    
    @GET
    @Path("ok")
    public Response getBook(){
        return Response.status(Response.Status.OK).entity(" Java For life").build();
    }
    
 /*   
    
    @GET
    @Path("ok/headers")
public Response getBookWithHeader(){
    return Response.Status(Response.Status.OK).(" Java For life")
            .header("param1", value1);
}    
    */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ok/json_annotation")
    public Book getBookJSONAnnotation() {
        Book current = new Book();
        current.setIsbn("1-111111-11");
        current.setName("Harry");
        return current;
    }
    @GET
    @Path("ok/json")
    public Response getBookJSON() {
        Book current = new Book();
        current.setIsbn("1-111111-11");
        current.setName("Harry");
        return Response.status(Response.Status.OK).entity(current).type(MediaType.APPLICATION_JSON).build();
    }

    
    
    @GET
    @Path("erreur/webapplicationexception")
    public String getBookWithApplicationExeption(@QueryParam("id") String id) {

        if (null == id) {
            throw new BadRequestException();
        }
        return "java for live" + id;

    }

    @GET
    @Path("erreur")
    public Response getBookWithErreur(@QueryParam("id") String id) {

        if (null == id) {
           return  Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).entity("java for live" + id).build();

    }  //http://localhost:8080/webServise/api/responseResource/erreur
       // http://localhost:8080/webServise/api/responseResource/erreur?id=1
    
    
    

}












  