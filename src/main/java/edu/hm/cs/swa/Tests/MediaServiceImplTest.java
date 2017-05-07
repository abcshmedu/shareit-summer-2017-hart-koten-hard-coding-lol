package edu.hm.cs.swa.Tests;

import edu.hm.cs.swa.controller.MediaServiceImpl;
import edu.hm.cs.swa.controller.MediaServiceResult;
import edu.hm.cs.swa.model.Book;
import edu.hm.cs.swa.model.Disc;
import edu.hm.cs.swa.model.Medium;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MediaServiceImplTest {

    Book book = new Book("Hermann Hesse", "0192301293012930", "Steppenwolf");

    Book book1 = new Book("Hermann Hesse", null, "Steppenwolf");

    Book book2 = new Book(null, "0192301293012930", "Steppenwolf");

    Book book3 = new Book("Hermann Hesse", "0192301293", null);

    Book book4 = new Book(null, "01923012930", "Steppenwold");

    private final Disc disc = new Disc("123456789", "Jesus Christ Superstar", 18, "keine Ahnung");

    private final Disc disc1 = new Disc(null, "Jesus", 18, "keine Ahnung");

    private final Disc disc2 = new Disc("123456789", null, 18, "keine Ahnung");

    private final Disc disc3 = new Disc("123456", "Jesus", 18, null);

    private final Disc disc4 = new Disc("123", null, 18, "keine Ahnung");

    MediaServiceImpl msi = new MediaServiceImpl();


    @Test
    public void addBookTest() {
        MediaServiceResult msr = msi.addBook(book);
        assertEquals(msr, MediaServiceResult.OK);
        msr = msi.addBook(book1);
        assertEquals(msr, MediaServiceResult.ISBN_NOT_FOUND);
        msr = msi.addBook(book2);
        assertEquals(msr, MediaServiceResult.ISBN_TAKEN);
        msr = msi.addBook(book3);
        assertEquals(msr, MediaServiceResult.AUTHOR_OR_TITLE_MISSING);
        msr = msi.addBook(book4);
        assertEquals(msr, MediaServiceResult.AUTHOR_OR_TITLE_MISSING);
    }


    @Test
    public void addDiscTest() {
        MediaServiceResult msr = msi.addDisc(disc);
        assertEquals(msr, MediaServiceResult.OK);
        msr = msi.addDisc(disc1);
        assertEquals(msr, MediaServiceResult.ISBN_NOT_FOUND);
        msr = msi.addDisc(disc2);
        assertEquals(msr, MediaServiceResult.ISBN_TAKEN);
        msr = msi.addDisc(disc3);
        assertEquals(msr, MediaServiceResult.AUTHOR_OR_TITLE_MISSING);
        msr = msi.addDisc(disc4);
        assertEquals(msr, MediaServiceResult.AUTHOR_OR_TITLE_MISSING);
    }


    @Test
    public void getBookTest() {
        msi.addBook(this.book);
        Medium book = msi.getBook("0192301293012930");
        assertEquals(book, this.book);
        book = msi.getBook("voirjefwhgbiksjhbgfn");
        assertEquals(book, null);
    }

}
