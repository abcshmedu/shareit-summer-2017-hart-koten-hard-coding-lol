package edu.hm.cs.swa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hm.cs.swa.model.Book;
import edu.hm.cs.swa.model.Disc;
import edu.hm.cs.swa.model.Medium;
import org.json.JSONArray;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST-API for ShareIt Service.
 *
 * @author Johannes Seidel, Michael Reile.
 */
@Singleton
@Path("/media")
public class MediaResource {

    private MediaService ms = new MediaServiceImpl();


    /**
     * Default c'tor.
     */
    public MediaResource() {
    }


    /**
     * Creates a book.
     *
     * @param book Book that will be created.
     * @return Response indicating success or failure.
     */
    @POST
    @Path("/books")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBook(@CookieParam("token") Cookie token, Book book) {
        String result = "jo";
        if (token != null) {
            result = ms.getCookie(token.getValue());
        }

        if (!result.equals("")) {
            System.out.println("jo ich gehe ab a\nlter");
            MediaServiceResult msr = ms.addBook(book);
            //      JSONObject json = new JSONObject();
//        json.put("status:", msr.getStatus());

            //    return Response.status(msr.getCode()).entity(json).build();
            //ObjectMapper mapper = new ObjectMapper();
            //String json = "";
            //try {
            //  json = mapper.writeValueAsString(msr.getStatus());
            //} catch (JsonProcessingException e) {
            //  e.printStackTrace();
            //}
            return Response.status(msr.getCode()).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }


    /**
     * Get a specific book, identified by its isbn.
     *
     * @param isbn isbn of desired book.
     * @return Response with status code and book as json.
     */
    @GET
    @Path("/books/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBook(@CookieParam("token") Cookie token, @PathParam("isbn") String isbn) {
        String result = "";
        if (token != null) {
            result = ms.getCookie(token.getValue());
        }

        if (!result.equals("")) {

            final Medium searchedBook = ms.getBook(isbn);

            ObjectMapper mapper = new ObjectMapper();
            try {
                String json = mapper.writeValueAsString(searchedBook);
                return Response.status(Response.Status.OK).entity(json).build();
            } catch (JsonProcessingException e) {
                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }


    /**
     * Get all the books available.
     *
     * @return Response indicating success or failure.
     */
    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks(@CookieParam("token") Cookie token) {
        //return (Book[]) ms.getBooks();
        String answer = "jo";
        if (token != null) {
            answer = ms.getCookie(token.getValue());
        }

        if (!answer.equals("")) {
            Book[] allBooks = ms.getBooks();

            JSONArray jsonArray = new JSONArray();
            ObjectMapper mapper = new ObjectMapper();

            //       List<Book> allB = Arrays.stream(allBooks).collect(Collectors.toList());
            try {
                String result = mapper.writeValueAsString(allBooks);
                return Response.status(Response.Status.OK).entity(result).build();

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            for (Medium book : allBooks) {

            }
            return Response.status(Response.Status.OK).entity(jsonArray.toString()).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }


    /**
     * Update an existing book.
     *
     * @param book Book that needs to be updated.
     * @return Response indicating success or failure.
     */
    @PUT
    @Path("/books/{isbn}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBook(@CookieParam("token") Cookie token, Book book) {
        String result = "";
        if (token != null) {
            result = ms.getCookie(token.getValue());
        }
        if (!result.equals("")) {

            MediaServiceResult msr = ms.updateBook(book);

            return Response.status(msr.getCode()).entity(msr.getStatus()).build();

        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }


    /**
     * Create a new disc.
     *
     * @param disc Disc that will be created.
     * @return Status code indicating success or failure.
     */
    @POST
    @Path("/discs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDisc(@CookieParam("token") Cookie token, Disc disc) {
        String result = "";
        if (token != null) {
            result = ms.getCookie(token.getValue());
        }
        if (!result.equals("")) {

            MediaServiceResult msr = ms.addDisc(disc);

            return Response.status(msr.getCode()).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }


    /**
     * Get a specific disc, identified by its barcode.
     *
     * @param barcode Barcode of the desired disc.
     * @return Status code indicating success or failure.
     */
    @GET
    @Path("/discs/{barcode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDisc(@CookieParam("token") Cookie token, @PathParam("barcode") String barcode) {
        String result = "";
        if (token != null) {
            result = ms.getCookie(token.getValue());
        }
        if (!result.equals("")) {

            final Medium searchedDisc = ms.getDisc(barcode);

            ObjectMapper mapper = new ObjectMapper();
            try {
                String json = mapper.writeValueAsString(searchedDisc);
                return Response.status(Response.Status.OK).entity(json).build();
            } catch (JsonProcessingException e) {
                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }


    /**
     * Get a list of available discs.
     *
     * @return Response indicating success or failure.
     */
    @GET
    @Path("/discs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiscs(@CookieParam("token") Cookie token) {

        String result = "";
        if (token != null) {
            result = ms.getCookie(token.getValue());
        }
        if (!result.equals("")) {

            final Disc[] allDiscs = (Disc[]) ms.getDiscs();

            JSONArray jsonArray = new JSONArray();

            for (Disc disc : allDiscs) {
                jsonArray.put(disc.getTitle());
            }
            return Response.status(Response.Status.OK).entity(jsonArray.toString()).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }


    /**
     * Update an existing disc.
     *
     * @param disc Disc that needs to be updated.
     * @return Response indicating success or failure.
     */
    @PUT
    @Path("/discs/{barcode}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDisc(@CookieParam("token") Cookie token, Disc disc) {
        String result = "";
        if (token != null) {
            result = ms.getCookie(token.getValue());
        }
        if (!result.equals("")) {

            MediaServiceResult msr = ms.updateDisc(disc);

            return Response.status(msr.getCode()).entity(msr.getStatus()).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
