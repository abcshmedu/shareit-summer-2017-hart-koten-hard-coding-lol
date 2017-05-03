package edu.hm.cs.swa.model;

public class Book extends Medium {

    String author;

    String isbn;


    public Book(final String author, final String isbn, final String title) {
        super(title);
        this.author = author;
        this.isbn = isbn;
    }


    Book() {

    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

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
        return "Book{" +
               "author='" + author + '\'' +
               ", isbn='" + isbn + '\'' +
               '}';
    }


    public String getAuthor() {
        return author;
    }


    public String getIsbn() {
        return isbn;
    }
}
