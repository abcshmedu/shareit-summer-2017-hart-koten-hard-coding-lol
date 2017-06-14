package edu.hm.cs.swa.Tests;

import edu.hm.cs.swa.controller.MediaServiceImpl;
import edu.hm.cs.swa.controller.MediaServiceResult;
import edu.hm.cs.swa.model.Book;
import edu.hm.cs.swa.model.Disc;
import edu.hm.cs.swa.model.Medium;
import edu.hm.cs.swa.persistence.DataBase;
import edu.hm.cs.swa.persistence.DataBaseImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class MediaServiceImplTest {

    private Book book = new Book("Hermann Hesse", "0192301293012930", "Steppenwolf");

    private Book book1 = new Book("Hermann Hesse", null, "Steppenwolf");

    private Book book2 = new Book(null, "0192301293012930", "Steppenwolf");

    private Book book3 = new Book("Hermann Hesse", "0192301293", null);

    private Book book4 = new Book(null, "01923012930", "Steppenwold");

    private final Disc disc = new Disc("123456789", "Jesus Christ Superstar", 18, "keine Ahnung");

    private final Disc disc1 = new Disc(null, "Jesus", 18, "keine Ahnung");

    private final Disc disc2 = new Disc("123456789", null, 18, "keine Ahnung");

    private final Disc disc3 = new Disc("123456", "Jesus", 18, null);

    private final Disc disc4 = new Disc("123", null, 18, "keine Ahnung");

    private DataBaseImpl db = new DataBaseImpl();

    private MediaServiceImpl msi = new MediaServiceImpl(db);


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


    @Test
    public void getDiscTest() {
        msi.addDisc(this.disc);
        Medium disc = msi.getDisc("123456789");
        assertEquals(disc, this.disc);
        disc = msi.getDisc("sojhbgfijdhkg");
        assertEquals(disc, null);
    }


    @Test
    public void getBooksTest() {
        msi.addBook(book);
        Medium[] expectedBooks = new Medium[1];
        expectedBooks[0] = book;
        assertArrayEquals(expectedBooks, msi.getBooks());

        expectedBooks[0] = book1;
        assertNotEquals(expectedBooks, msi.getBooks());
    }


    @Test
    public void getDiscsTest() {
        msi.addDisc(disc);
        Medium[] expectedDiscs = new Medium[1];
        expectedDiscs[0] = disc;
        assertArrayEquals(expectedDiscs, msi.getDiscs());

        expectedDiscs[0] = disc1;
        assertNotEquals(expectedDiscs, msi.getDiscs());
    }


    @Test
    public void updateBookTest() {
        msi.addBook(book);
        Book newBook = new Book("niemand", "0192301293012930", "was immer man will");
        MediaServiceResult msr = msi.updateBook(newBook);
        assertEquals(msr, MediaServiceResult.OK);
        msr = msi.updateBook(new Book("pifn", "jedbhfgv", "dfljh"));
        assertEquals(msr, MediaServiceResult.ISBN_NOT_FOUND);
        msr = msi.updateBook(new Book(null, "0192301293012930", "edhbgf"));
        assertEquals(msr, MediaServiceResult.AUTHOR_OR_TITLE_MISSING);
        msr = msi.updateBook(new Book("dpoihg", "0192301293012930", null));
        assertEquals(msr, MediaServiceResult.AUTHOR_OR_TITLE_MISSING);
    }


    @Test
    public void updateDiscTest() {
        msi.addDisc(disc);
        Disc newdisc = new Disc("123456789", "niemand", 18, "was immer man will");
        MediaServiceResult msr = msi.updateDisc(newdisc);
        assertEquals(msr, MediaServiceResult.OK);

        msr = msi.updateDisc(new Disc("987461320", "ojfnb", 18, "dffgojnbh"));
        assertEquals(msr, MediaServiceResult.ISBN_NOT_FOUND);

        msr = msi.updateDisc(new Disc("123456789", null, 18, "ojdsbf"));
        assertEquals(msr, MediaServiceResult.AUTHOR_OR_TITLE_MISSING);

        msr = msi.updateDisc(new Disc("123456789", "dojgf", 18, null));
        assertEquals(msr, MediaServiceResult.AUTHOR_OR_TITLE_MISSING);
    }

}
