package edu.hm.cs.swa.controller;

import edu.hm.cs.swa.model.Book;
import edu.hm.cs.swa.model.Disc;
import edu.hm.cs.swa.model.Medium;

import java.util.HashMap;

/**
 * Implementation of the MediaService.
 *
 * @author Johannes Seidel, Michael Reile.
 */
public class MediaServiceImpl implements MediaService {

    private HashMap<String, Book> bookHashMap = new HashMap<>();

    private HashMap<String, Disc> discHashMap = new HashMap<>();


    /**
     * Default c'tor.
     */
    public MediaServiceImpl() {

    }


    @Override
    public MediaServiceResult addBook(Book newBook) {
        MediaServiceResult msr = MediaServiceResult.OK;

        if (newBook.getIsbn() == null) {
            msr = MediaServiceResult.ISBN_NOT_FOUND;
        } else if (bookHashMap.containsKey(newBook.getIsbn())) {
            msr = MediaServiceResult.ISBN_TAKEN;
        } else if (newBook.getAuthor() == null || newBook.getTitle() == null) {
            msr = MediaServiceResult.AUTHOR_OR_TITLE_MISSING;
        } else {
            bookHashMap.put(newBook.getIsbn(), newBook);
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
        int counter = 0;
        for (Book book : bookHashMap.values()) {
            allBooks[counter] = book;
            counter++;
        }
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
        final Book bookToChange = bookHashMap.get(newBook.getIsbn());

        if (bookToChange == null) {
            result = MediaServiceResult.ISBN_NOT_FOUND;
        } else if (newBook.getAuthor() == null || newBook.getTitle() == null) {
            result = MediaServiceResult.AUTHOR_OR_TITLE_MISSING;
        } else {
            bookHashMap.replace(newBook.getIsbn(), newBook);
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
    public Medium getBook(String isbn) {
        return bookHashMap.get(isbn);
    }


    @Override
    public Medium getDisc(String barcode) {
        return discHashMap.get(barcode);
    }
    
//    public Boolean validateISBN(String isbn) {
//        
//    }

}
