package edu.hm.cs.swa.persistence;

import edu.hm.cs.swa.guice.ShareitServletContextListener;
import edu.hm.cs.swa.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * Created by Jojo on 13.06.2017.
 */
public class DataBaseImpl implements DataBase {

    private Session dataManager;


    public DataBaseImpl() {
        dataManager = ShareitServletContextListener.getInjectorInstance().getInstance(
                SessionFactory.class).getCurrentSession();
    }


    @Override
    public void createBook(Book book) {

    }


    @Override
    public void deleteBook(Book book) {

    }


    @Override
    public void getBook(String isbn) {

    }


    @Override
    public void getBooks() {

    }


    @Override
    public void updateBook(Book book) {

    }
}
