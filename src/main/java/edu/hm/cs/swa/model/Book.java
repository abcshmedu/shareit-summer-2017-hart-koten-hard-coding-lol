package edu.hm.cs.swa.model;

import javax.persistence.*;

/**
 * Model class for a book.
 *
 * @author Johannes Seidel, Michael Reile.
 */
@Entity
@Table(name = "Book")
public class Book extends Medium {

    /**
     * String representation of an author.
     */
    @Column(name = "Author")
    private String author;

    /**
     * String representation of the isbn number.
     */
    @Id
    private String isbn;

    /**
     * String representation of the title
     */
    @Column(name = "Title")
    private String title;


    /**
     * Custom constructor for a book.
     *
     * @param author author of the book.
     * @param isbn   isbn number of the book.
     * @param title  title of the book.
     */
    public Book(final String author, final String isbn, final String title) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }


    /**
     * Default constructor.
     */
    private Book() {
        this.author = "";
        this.title = "";
        this.isbn = "";
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Book book = (Book) o;
        return author.equals(book.author) && isbn.equals(book.isbn);
    }


    @Override
    public int hashCode() {
        int result = author.hashCode();
        result = 31 * result + isbn.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "Book{"
               + "author='" + author + '\''
               + ", isbn='" + isbn + '\''
               + '}';
    }


    public String getTitle() {
        return title;
    }


    /**
     * Getter for author.
     *
     * @return author's name.
     */
    public String getAuthor() {
        return author;
    }


    /**
     * Getter for isbn number.
     *
     * @return isbn number.
     */
    public String getIsbn() {
        return isbn;
    }
}
