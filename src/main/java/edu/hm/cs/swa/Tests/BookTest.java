package edu.hm.cs.swa.Tests;

import edu.hm.cs.swa.model.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookTest {

    private final String author = "Jesus";

    private final String isbn = "123456789";

    private final String title = "was weiß denn ich";


    @Test
    public void test() {
        Book book = new Book(author, isbn, title);
        assertEquals(" \"Book{\"\n" +
                     "               + \"author='\" + author + '\\''\n" +
                     "               + \", isbn='\" + isbn + '\\''\n" +
                     "               + '}';", book.toString());
    }


    public void equalsTest() {
        Book book = new Book(author, isbn, title);
        Book anotherBook = new Book(author, isbn, title);
        assertTrue(book.equals(anotherBook));
    }

}
