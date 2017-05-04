package edu.hm.cs.swa.controller;

import edu.hm.cs.swa.model.Book;
import edu.hm.cs.swa.model.Disc;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

public class MediaResource {

    MediaService ms = new MediaServiceImpl();


    MediaResource() {
    }


    @POST
    @Path("/media/books")
    public Response createBook(Book book) {

        MediaServiceResult msr = ms.addBook(book);

        return Response.status(msr.getStatus()).build();
    }


    @GET
    @Path("/media/books/{isbn}")
    @Produces("application/json")
    public Response getBook(@PathParam("isbn") String isbn) {
        MediaServiceResult msr = ms.getBook(isbn);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Status: ", msr.getStatus());
        return Response.status(msr.getCode()).entity(jsonObject.toString()).build();

    }


    @GET
    @Path("/media/books")
    @Produces("application/json")
    public Response getBooks() {
        return Response.ok().build();
    }


    @PUT
    @Path("/media/books/{isbn}")
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
