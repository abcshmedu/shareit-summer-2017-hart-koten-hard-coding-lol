package edu.hm.cs.swa.persistence;

import edu.hm.cs.swa.model.Book;

/**
 * Created by Jojo on 13.06.2017.
 */
public interface DataBase {

    void createBook(Book book);

    void deleteBook(Book book);

    void getBook(String isbn);

    void getBooks();

    void updateBook(Book book);

}
