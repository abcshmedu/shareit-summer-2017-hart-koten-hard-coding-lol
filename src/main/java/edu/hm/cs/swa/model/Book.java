package edu.hm.cs.swa.model;

/**
 * Model class for a book.
 * @author Johannes Seidel, Michael Reile.
 *
 */
public class Book extends Medium {

    /**
     * String representation of an author.
     */
    private String author;

    /**
     * String representation of the isbn number.
     */
    private String isbn;


    /**
     * Custom constructor for a book.
     * @param author author of the book.
     * @param isbn isbn number of the book.
     * @param title title of the book.
     */
    public Book(final String author, final String isbn, final String title) {
        super(title);
        this.author = author;
        this.isbn = isbn;
    }

    /**
     * Default constructor.
     */
    Book() {

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


    /**
     * Getter for author.
     * @return author's name.
     */
    public String getAuthor() {
        return author;
    }


    /**
     * Getter for isbn number.
     * @return isbn number.
     */
    public String getIsbn() {
        return isbn;
    }
}
