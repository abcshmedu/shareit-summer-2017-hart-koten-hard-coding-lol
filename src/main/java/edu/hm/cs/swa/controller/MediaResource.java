package edu.hm.cs.swa.controller;

import edu.hm.cs.swa.model.Book;
import edu.hm.cs.swa.model.Disc;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

/**
 * REST-API for ShareIt Service.
 * @author Johannes Seidel, Michael Reile.
 *
 */
public class MediaResource {

    private static final int OK = 200;
    
    private MediaService ms = new MediaServiceImpl();

    /**
     * Default c'tor.
     */
    MediaResource() {
    }

    /**
     * Creates a book.
     * @param book Book that will be created.
     * @return Response indicating success or failure.
     */
    @POST
    @Path("/media/books")
    public Response createBook(Book book) {

        MediaServiceResult msr = ms.addBook(book);

        return Response.status(msr.getStatus()).build();
    }


    /**
     * Get a specific book, identified by its isbn.
     * @param isbn isbn of desired book.
     * @return Response with status code and book as json.
     */
    @GET
    @Path("/media/books/{isbn}")
    @Produces("application/json")
    public Response getBook(@PathParam("isbn") String isbn) {
        MediaServiceResult msr = ms.getBook(isbn);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Status: ", msr.getStatus());
        return Response.status(msr.getCode()).entity(jsonObject.toString()).build();

    }

    /**
     * Get all the books available.
     * @return Response indicating success or failure.
     */
    @GET
    @Path("/media/books")
    @Produces("application/json")
    public Response getBooks() {
        return Response.ok().build();
    }

    /**
     * Update an existing book.
     * @param book Book that needs to be updated.
     * @return Response indicating success or failure.
     */
    @PUT
    @Path("/media/books/{isbn}")
    public Response updateBook(Book book) {
        return Response.ok().build();
    }

    /**
     * Create a new disc.
     * @param disc Disc that will be created.
     * @return Status code indicating success or failure.
     */
    @POST
    @Path("/media/books")
    @Produces("application/json")
    public Response createDisc(Disc disc) {
        return Response.status(OK).build();
    }

    /**
     * Get a specific disc, identified by its barcode.
     * @param barcode Barcode of the desired disc.
     * @return Status code indicating success or failure.
     */
    @GET
    @Path("/media/discs/{barcode}")
    @Produces("application/json")
    public Response getDisc(@PathParam("barcode") String barcode) {
        return Response.status(OK).build();
    }

    /**
     * Get a list of available discs.
     * @return Response indicating success or failure.
     */
    @GET
    @Path("/media/discs")
    @Produces("application/json")
    public Response getDiscs() {
        return Response.ok().build();
    }

    /**
     * Update an existing disc.
     * @param disc Disc that needs to be updated.
     * @return Response indicating success or failure.
     */
    @PUT
    @Path("/media/discs/{barcode}")
    @Produces("application/json")
    public Response updateDisc(Disc disc) {
        return Response.ok().build();
    }
}
