package edu.hm.cs.swa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model class for a disc.
 *
 * @author Johannes Seidel, Michael Reile.
 */
@Entity
@Table(name = "Disc")
public class Disc extends Medium {

    @Column(name = "Barcode")
    @Id private String barcode;

    @Column(name = "Director")
    private String director;

    @Column(name = "FSK")
    private int fsk;

    @Column(name = "Title")
    private String title;


    /**
     * Constructor for a disc.
     *
     * @param barcode  barcode of the disc.
     * @param director director of the disc.
     * @param fsk      fsk of the disc.
     * @param title    title of the disc.
     */
    public Disc(String barcode, String director, int fsk, String title) {
        this.title = title;
        this.barcode = barcode;
        this.director = director;
        this.fsk = fsk;
    }


    /**
     * Default c'tor.
     */
    Disc() {

    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Disc)) return false;

        final Disc disc = (Disc) o;

        if (getFsk() != disc.getFsk()) return false;
        if (!getBarcode().equals(disc.getBarcode())) return false;
        if (!getDirector().equals(disc.getDirector())) return false;
        return getTitle().equals(disc.getTitle());
    }


    @Override
    public int hashCode() {
        int result = getBarcode().hashCode();
        result = 31 * result + getDirector().hashCode();
        result = 31 * result + getFsk();
        result = 31 * result + getTitle().hashCode();
        return result;
    }


    /**
     * Getter for barcode.
     *
     * @return barcode.
     */
    public String getBarcode() {
        return barcode;
    }


    /**
     * Getter for director.
     *
     * @return director.
     */
    public String getDirector() {
        return director;
    }


    public String getTitle() {
        return title;
    }


    /**
     * Getter for fsk.
     *
     * @return fsk.
     */
    public int getFsk() {
        return fsk;
    }


    @Override
    public String toString() {
        return "Disc{" +
               "barcode='" + barcode + '\'' +
               ", director='" + director + '\'' +
               ", fsk=" + fsk +
               ", title='" + title + '\'' +
               '}';
    }
}
