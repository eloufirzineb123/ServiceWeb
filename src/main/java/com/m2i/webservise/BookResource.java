/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m2i.webservise;

import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author elouf
 */
 @Path("/bookResource")
public class BookResource {
    
    @Path("xml")
    @Consumes(MediaType.APPLICATION_XML)
    @PUT
    public void updateContentBookWithXML(Book current) throws IOException {
        System.out.println("BookContentResource.updateContentBooksWithXML()");
        System.out.println("Name: " + current.getName() + ", ISBN: " + current.getIsbn());
    }
    /**
     * URI: /xml
     */
    @Path("xml")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Book getContentBookWithXML() {
        System.out.println("BookContentResource.getContentBooksWithXML()");
        Book current = new Book();
        current.setIsbn("1-111111-11");
        current.setName("Harry");
        return current;
    }
    
    
       @Path("json")
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public void updateContentBookWithJson(Book current) throws IOException {
        System.out.println("BookContentResource.updateContentBookWithJson()");
        System.out.println("Name: " + current.getName() + ", ISBN: " + current.getIsbn());
    }
    /**
     * URI: /xml
     */
    @Path("json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Book getContentBookWithJson() {
        Book current = new Book();
        current.setIsbn("1-11");
        current.setName("Harry");
        return current;
    }
    
    @Path("jsonxml")
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Book update(Book book){
    return book;
    }
    
    
}
