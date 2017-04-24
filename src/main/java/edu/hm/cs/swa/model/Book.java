package edu.hm.cs.swa.model;

public class Book extends Medium {

    private final String author;

    private final String isbn;


    public Book() {

    }


    public Book(final String author, final String isbn, final String) {
        this.author = author;
        this.isbn = isbn;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Book book = (Book) o;

        if (!author.equals(book.author)) return false;
        return isbn.equals(book.isbn);
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
