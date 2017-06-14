package edu.hm.cs.swa.persistence;

import edu.hm.cs.swa.guice.ShareitServletContextListener;
import edu.hm.cs.swa.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Jojo on 13.06.2017 easy life.
 */
public class DataBaseImpl implements DataBase {

    private Session dataManager;

    private Transaction transaction;

    public DataBaseImpl() {
    }


    @Override
    public void createBook(Book book) {
        dataManager = ShareitServletContextListener.getInjectorInstance().getInstance(
                SessionFactory.class).getCurrentSession();
        transaction = dataManager.beginTransaction();
        dataManager.saveOrUpdate(book);
        transaction.commit();
    }


    @Override
    public void deleteBook(Book book) {
        dataManager = ShareitServletContextListener.getInjectorInstance().getInstance(
                SessionFactory.class).getCurrentSession();
        transaction = dataManager.beginTransaction();
        dataManager.delete(book);
    }


    @Override
    public Book getBook(String isbn) {

        dataManager = ShareitServletContextListener.getInjectorInstance().getInstance(
                SessionFactory.class).getCurrentSession();
        transaction = dataManager.beginTransaction();
        Book book = dataManager.get(Book.class, isbn);
        transaction.commit();
        return book;
    }


    @Override
    public List<Book> getBooks() {
        dataManager = ShareitServletContextListener.getInjectorInstance().getInstance(
                SessionFactory.class).getCurrentSession();
        transaction = dataManager.beginTransaction();
        return dataManager.createQuery("From Book").list();
    }


    @Override
    public void updateBook(Book book) {
        dataManager = ShareitServletContextListener.getInjectorInstance().getInstance(
                SessionFactory.class).getCurrentSession();
        transaction = dataManager.beginTransaction();


    }
}
