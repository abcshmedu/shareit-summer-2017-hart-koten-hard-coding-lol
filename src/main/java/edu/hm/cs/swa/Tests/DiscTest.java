package edu.hm.cs.swa.Tests;

import edu.hm.cs.swa.model.Disc;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DiscTest {

    private final String director = "Jesus";

    private final String barcode = "123456789";

    private final String title = "was weiß denn ich";

    private final int fsk = 18;


    @Test
    public void test() {
        Disc disc = new Disc(barcode, director, fsk, title);
        assertEquals("Disc{" +
                     "barcode='" + barcode + '\'' +
                     ", director='" + director + '\'' +
                     ", fsk=" + fsk +
                     ", title='" + title + '\'' +
                     '}', disc);
    }


    public void equalsTest() {
        Disc disc = new Disc(barcode, director, fsk, title);
        Disc anotherDisc = new Disc(barcode, director, fsk, title);
        assertTrue(disc.equals(anotherDisc));
    }

}
