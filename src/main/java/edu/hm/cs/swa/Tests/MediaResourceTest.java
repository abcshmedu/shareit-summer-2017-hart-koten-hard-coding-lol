package edu.hm.cs.swa.Tests;

import edu.hm.cs.swa.controller.MediaResource;
import edu.hm.cs.swa.model.Book;
import edu.hm.cs.swa.model.Disc;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MediaResourceTest {

    MediaResource resourceMock;

    Book bookMock;

    Disc discMock;

    Cookie tokenMock;

    Response responseOK;

    Response responseUNAUTH;

    String ISBN;


    @Before
    public void init() {
        resourceMock = mock(MediaResource.class);
        bookMock = mock(Book.class);
        discMock = mock(Disc.class);
        tokenMock = mock(Cookie.class);
        responseOK = Response.status(Response.Status.OK).build();
        responseUNAUTH = Response.status(Response.Status.UNAUTHORIZED).build();
        ISBN = "";
    }


    @Test
    public void addBookTestSuccess() {
        when(resourceMock.createBook(tokenMock, bookMock)).thenReturn(responseOK);
        assertEquals(responseOK, resourceMock.createBook(tokenMock, bookMock));
    }


    @Test
    public void addBookTestFail() {
        when(resourceMock.createBook(tokenMock, bookMock)).thenReturn(responseUNAUTH);
        assertEquals(responseUNAUTH, resourceMock.createBook(tokenMock, bookMock));
    }


    @Test
    public void addDiscTestSuccess() {
        when(resourceMock.createDisc(tokenMock, discMock)).thenReturn(responseOK);
        assertEquals(responseOK, resourceMock.createDisc(tokenMock, discMock));
    }


    @Test
    public void addDiscTestFail() {
        when(resourceMock.createDisc(tokenMock, discMock)).thenReturn(responseUNAUTH);
        assertEquals(responseUNAUTH, resourceMock.createDisc(tokenMock, discMock));
    }


    @Test
    public void getBookTestSuccess() {
        when(resourceMock.getBook(tokenMock, ISBN)).thenReturn(responseOK);
        assertEquals(responseOK, resourceMock.getBook(tokenMock, ISBN));
    }


    @Test
    public void getBookTestFail() {
        when(resourceMock.getBook(tokenMock, ISBN)).thenReturn(responseUNAUTH);
        assertEquals(responseUNAUTH, resourceMock.getBook(tokenMock, ISBN));
    }


    @Test
    public void getDiscTestSuccess() {
        when(resourceMock.getDisc(tokenMock, ISBN)).thenReturn(responseOK);
        assertEquals(responseOK, resourceMock.getDisc(tokenMock, ISBN));
    }


    @Test
    public void getDiscTestFail() {
        when(resourceMock.getDisc(tokenMock, ISBN)).thenReturn(responseUNAUTH);
        assertEquals(responseUNAUTH, resourceMock.getDisc(tokenMock, ISBN));
    }


    @Test
    public void updateBookTestSuccess() {
        when(resourceMock.updateBook(tokenMock, bookMock)).thenReturn(responseOK);
        assertEquals(responseOK, resourceMock.updateBook(tokenMock, bookMock));
    }

}
