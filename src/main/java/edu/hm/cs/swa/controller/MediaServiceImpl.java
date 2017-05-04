package edu.hm.cs.swa.controller;

import edu.hm.cs.swa.model.Book;
import edu.hm.cs.swa.model.Disc;
import edu.hm.cs.swa.model.Medium;

import java.util.HashMap;

public class MediaServiceImpl implements MediaService {

    private HashMap<String, Book> bookHashMap;

    private HashMap<String, Disc> discHashMap;


    MediaServiceImpl() {

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
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Medium[] getBooks() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Medium[] getDiscs() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public MediaServiceResult updateBook(Book oldBook) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public MediaServiceResult updateDisc(Disc oldDisc) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public MediaServiceResult getBook(String isbn) {
        return null;
    }


    @Override
    public MediaServiceResult getDisc(String barcode) {
        // TODO Auto-generated method stub
        return null;
    }

}
