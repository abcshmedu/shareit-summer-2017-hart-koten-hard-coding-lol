package edu.hm.cs.swa.persistence;

import edu.hm.cs.swa.model.Book;

import java.util.List;

/**
 * Created by Jojo on 13.06.2017.
 */
public interface DataBase {

    void createBook(Book book);

    void deleteBook(Book book);

    Book getBook(String isbn);

    List<Book> getBooks();

    void updateBook(Book book);

}
