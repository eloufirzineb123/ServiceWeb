/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m2i.webservise;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriInfo;

@Path("/books")
public class Books {

    @GET
    public String getBooks() {
        return "book list";
    }

    @GET
    @Path("/borrowed")
    public String getBorrowedBooks() {
        return "borrowed book list";
    }
    
    @GET
    @Path("{id}")
    public String getBookById(@PathParam("id") int id){
        return "java For Life" + id ;
    }// http://localhost:8080/webServise/api/books/23
    
    @GET
    @Path("name-{name}-editor-{editor}")
    public String getBookByNameAndEditor(@PathParam("name") String name,@PathParam("editor") String editor){
      return "name :"+ name +" - editor: " + editor ;
    } // http://localhost:8080/webServise/api/books/name-zineb-editor-oufir
    
    
    @GET
    @Path("queryparamameters")
    public String getQueryParameterBook(
            @DefaultValue("all") @QueryParam("name") String name,
            @DefaultValue(" ?????") @QueryParam("isbn") String isbn,
            @DefaultValue("false") @QueryParam("isExtented") Boolean isExtented) {
        return name + "  aa " + isbn + "  bb " + isExtented;
    }  //http://localhost:8080/webServise/api/books/queryparamameters?name=zineb&isbn=1-1111&isExtented=true
    
    
    @POST
    @Path("createfromform")
    @Consumes("application/x-www-form-urlencoded")
    public String createBookFromForm(@FormParam("name") String name){
        System.out.println("BookResource.createBookFromForm()");
        return name;
    }
    
    
    
    @GET
    @Path("headerparamameters")
    public String getHeaderParameterBook(
            @DefaultValue("all") @HeaderParam("name") String name,
            @DefaultValue(" ?????") @HeaderParam("isbn") String isbn,
            @DefaultValue("false") @HeaderParam("isExtented") Boolean isExtented) {
        return name + "  aa " + isbn + "  bb " + isExtented;
    } 
    
    
    @GET
    @Path("informationfromuriinfo/{name}")
    public String getInformationFromUriInfo(@Context UriInfo uriInfo, @PathParam("name") String name) {
        StringBuffer result = new StringBuffer();

        result.append("getPath(): " + uriInfo.getPath() + "\n");
        List<PathSegment> pathSegments = uriInfo.getPathSegments();
        result.append("getPathSegements(): ");
        for (PathSegment pathSegment : pathSegments) {
            result.append(pathSegment.getPath() + " ");
        }
        result.append("\n");

        result.append("getPathParameters(): ");
        MultivaluedMap<String, String> pathParameters = uriInfo.getPathParameters();
        Set<String> pathParametersSet = pathParameters.keySet();
        for (String currentParameter : pathParametersSet) {
            result.append(currentParameter + " ");
        }
        result.append("\n");

        result.append("getQueryParameters(): ");
        MultivaluedMap<String, String> queryParameters = uriInfo.getQueryParameters();
        Set<String> queryParametersSet = queryParameters.keySet();
        for (String currentParameter : queryParametersSet) {
            result.append(currentParameter + " ");
        }
        result.append("\n");

        result.append("getAbsolutePath(): " + uriInfo.getAbsolutePath() + "\n");
        result.append("getBaseUri(): " + uriInfo.getBaseUri() + "\n");
        result.append("getRequestUri(): " + uriInfo.getRequestUri() + "\n");

        System.out.println(result.toString());
        return result.toString();
    }

    @GET
    @Path("informationfromhttpheaders")
    public String getInformationFromHttpHeaders(@Context HttpHeaders httpheaders) {
        StringBuffer result = new StringBuffer("Cookies:");
        Map<String, Cookie> cookies = httpheaders.getCookies();
        Set<String> currentKeySet = cookies.keySet();
        for (String currentCookie : currentKeySet) {
            result.append(currentCookie + "\n");
        }

        result.append("RequestHeaders:" + "\n");
        MultivaluedMap<String, String> requestHeaders = httpheaders.getRequestHeaders();
        Set<String> requestHeadersSet = requestHeaders.keySet();
        for (String currentHeader : requestHeadersSet) {
            result.append(currentHeader + ": " + requestHeaders.get(currentHeader) + "\n");
        }

        System.out.println(result.toString());
        return result.toString();
    }

@GET
@Path ("details/{id}")
@Produces(MediaType.TEXT_PLAIN)
public String getDetailTextBookId(@PathParam("id") String id){
    return "Ce livre est une intro";
}


@GET
@Path ("details/{id}")
@Produces(MediaType.TEXT_XML)
public String getDetailXMLBookId(@PathParam("id") String id){
    return "<?xml version=\"1.0\"?>" +"<details> Ce livre est une intro" + "</details>";
} 
    

@GET
@Path ("details/{id}")
@Produces(MediaType.TEXT_HTML)
public String getDetailHTMLBookId(@PathParam("id") String id){
    return "<HTML>" +"<titre>" +"Detail" + "</titre>" + "<body><h1>"+"Ce livre est une intro" +"</body></h1>"+ "</html>";
} 
//header key :Accept   value : text/plain

    
}

