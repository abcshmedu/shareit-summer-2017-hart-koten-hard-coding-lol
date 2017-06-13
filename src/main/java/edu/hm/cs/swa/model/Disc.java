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
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
        result = prime * result + ((director == null) ? 0 : director.hashCode());
        result = prime * result + fsk;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Disc other = (Disc) obj;
        if (barcode == null) {
            if (other.barcode != null) {
                return false;
            }
        } else if (!barcode.equals(other.barcode)) {
            return false;
        }
        if (director == null) {
            if (other.director != null) {
                return false;
            }
        } else if (!director.equals(other.director)) {
            return false;
        }
        return fsk == other.fsk;
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
