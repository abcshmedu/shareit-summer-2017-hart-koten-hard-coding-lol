package edu.hm.cs.swa.controller;

import javax.ws.rs.core.Response;

import edu.hm.cs.swa.model.Book;

public class MediaResource {
    MediaResource() {
        
    }
    
    public Response createBook(Book book) {
        return Response.ok().build();
    }
    
    public Response getBooks() {
        return Response.ok().build();
    }
    
    public Response updateBook(Book book) {
        return Response.ok().build();
    }
}
