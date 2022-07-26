/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m2i.webservise;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/hello")
public class HelloWorld {
    
    @GET
    @Produces("text/plain")
    public String getHelloWorld(){
        return "hello World from text/plain";
    }
    
}
