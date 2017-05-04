package edu.hm.cs.swa.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import edu.hm.cs.swa.model.Book;
import edu.hm.cs.swa.model.Disc;

public class MediaResource {
    
    MediaService ms = new MediaServiceImpl();
    
    MediaResource() {    
    }
    
    @POST
    @Path("/media/books")
    @Produces("application/json")
    public Response createBook(Book book) {
        return Response.status(200).build();
    }
    
    @GET
    @Path("/media/books/{isbn}")
    @Produces("application/json")
    public Response getBook(@PathParam("isbn") String isbn) {
        return Response.status(200).build();
    }
    
    @GET
    @Path("/media/books")
    @Produces("application/json")
    public Response getBooks() {
        return Response.ok().build();
    }
    
    @PUT
    @Path("/media/books/{isbn}")
    @Produces("application/json")
    public Response updateBook(Book book) {
        return Response.ok().build();
    }
    
    @POST
    @Path("/media/books")
    @Produces("application/json")
    public Response createDisc(Disc disc) {
        return Response.status(200).build();
    }
    
    @GET
    @Path("/media/discs/{barcode}")
    @Produces("application/json")
    public Response getDisc(@PathParam("barcode") String barcode) {
        return Response.status(200).build();
    }
    
    @GET
    @Path("/media/discs")
    @Produces("application/json")
    public Response getDiscs() {
        return Response.ok().build();
    }
    
    @PUT
    @Path("/media/discs/{barcode}")
    @Produces("application/json")
    public Response updateDisc(Disc disc) {
        return Response.ok().build();
    }
}
