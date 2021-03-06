package edu.hm.cs.swa.controller;

import com.google.inject.Inject;
import edu.hm.cs.swa.guice.ShareitServletContextListener;
import edu.hm.cs.swa.model.Book;
import edu.hm.cs.swa.model.Disc;
import edu.hm.cs.swa.model.Medium;
import edu.hm.cs.swa.persistence.DataBase;
import edu.hm.cs.swa.persistence.DataBaseImpl;

import java.util.HashMap;

/**
 * Implementation of the MediaService.
 *
 * @author Johannes Seidel, Michael Reile.
 */
public class MediaServiceImpl implements MediaService {

    private HashMap<String, Book> bookHashMap = new HashMap<>();

    private HashMap<String, Disc> discHashMap = new HashMap<>();

    @Inject private final DataBase db = ShareitServletContextListener.getInjectorInstance().getInstance(DataBase.class);


    /**
     * Default c'tor.
     */
    public MediaServiceImpl() {
    }


    @Override
    public MediaServiceResult addBook(Book newBook) {
        MediaServiceResult msr = MediaServiceResult.OK;

        if (!validISBN(newBook.getIsbn())) {
            msr = MediaServiceResult.INVALID_ISBN;
        } else if (newBook.getIsbn() == null) {
            msr = MediaServiceResult.ISBN_NOT_FOUND;
        } else if (bookHashMap.containsKey(newBook.getIsbn())) {
            msr = MediaServiceResult.ISBN_TAKEN;
        } else if (newBook.getAuthor() == null || newBook.getTitle() == null) {
            msr = MediaServiceResult.AUTHOR_OR_TITLE_MISSING;
        } else {
            bookHashMap.put(newBook.getIsbn(), newBook);
            db.createBook(newBook);
        }

        return msr;
    }


    @Override
    public MediaServiceResult addDisc(Disc newDisc) {
        MediaServiceResult msr = MediaServiceResult.OK;

        if (newDisc.getBarcode() == null) {
            msr = MediaServiceResult.ISBN_NOT_FOUND;
        } else if (discHashMap.containsKey(newDisc.getBarcode())) {
            msr = MediaServiceResult.ISBN_TAKEN;
        } else if (newDisc.getDirector() == null || newDisc.getTitle() == null) {
            msr = MediaServiceResult.AUTHOR_OR_TITLE_MISSING;
        } else {
            discHashMap.put(newDisc.getBarcode(), newDisc);

        }

        return msr;
    }


    @Override
    public Book[] getBooks() {
        Book[] allBooks = new Book[bookHashMap.values().size()];
        //int counter = 0;
        //for (Book book : bookHashMap.values()) {
        //  allBooks[counter] = book;
        //counter++;
        //}
        allBooks = db.getBooks().toArray(new Book[0]);
        return allBooks;
        //return bookHashMap.values().toArray(new Book[bookHashMap.size()]);
    }


    @Override
    public Disc[] getDiscs() {

        Disc[] allDiscs = new Disc[discHashMap.size()];
        int counter = 0;
        for (Disc disc : discHashMap.values()) {
            allDiscs[counter] = disc;
            counter++;
        }
        return allDiscs;
    }


    @Override
    public MediaServiceResult updateBook(Book newBook) {
        final MediaServiceResult result;
        //final Book bookToChange = bookHashMap.get(newBook.getIsbn());
        final Book bookToChange = db.getBook(newBook.getIsbn());
        if (bookToChange == null) {
            result = MediaServiceResult.ISBN_NOT_FOUND;
        } else if (newBook.getAuthor() == null || newBook.getTitle() == null) {
            result = MediaServiceResult.AUTHOR_OR_TITLE_MISSING;
        } else {
            //bookHashMap.replace(newBook.getIsbn(), newBook);
            db.updateBook(newBook);
            result = MediaServiceResult.OK;
        }

        return result;
    }


    @Override
    public MediaServiceResult updateDisc(Disc newDisc) {
        final MediaServiceResult result;
        final Disc discToChange = discHashMap.get(newDisc.getBarcode());

        if (discToChange == null) {
            result = MediaServiceResult.ISBN_NOT_FOUND;
        } else if (newDisc.getDirector() == null || newDisc.getTitle() == null) {
            result = MediaServiceResult.AUTHOR_OR_TITLE_MISSING;
        } else {
            discHashMap.replace(newDisc.getBarcode(), newDisc);
            result = MediaServiceResult.OK;
        }

        return result;
    }


    @Override
    public String getCookie(final String token) {
        return "passt schone";
        //        ClientConfig config = new DefaultClientConfig();
        //      Client client = Client.create(config);
        //    WebResource webResource = client.resource(UriBuilder.fromUri(authServiceLink).build());
        //  JSONObject body = new JSONObject();
        //body.put("token", token);
        //ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, body.toString());
        //String result = response.getEntity(String.class);
    }


    @Override
    public Medium getBook(String isbn) {
        //return bookHashMap.get(isbn);
        return db.getBook(isbn);
    }


    @Override
    public Medium getDisc(String barcode) {
        return discHashMap.get(barcode);
    }


    private boolean validISBN(String isbn) {
        if (isbn == null) {
            return false;
        }

        isbn = isbn.replaceAll("-", "");

        if (isbn.length() != 13) {
            return false;
        }

        try {
            int tot = 0;
            for (int i = 0; i < 12; i++) {
                int digit = Integer.parseInt(isbn.substring(i, i + 1));
                tot += (i % 2 == 0) ? digit : digit * 3;
            }

            //checksum must be 0-9. If calculated as 10 then = 0
            int checksum = 10 - (tot % 10);
            if (checksum == 10) {
                checksum = 0;
            }

            return checksum == Integer.parseInt(isbn.substring(12));
        } catch (NumberFormatException nfe) {
            //to catch invalid ISBNs that have non-numeric characters in them
            return false;
        }
    }
}

