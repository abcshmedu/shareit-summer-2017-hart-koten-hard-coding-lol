package edu.hm.cs.swa.controller;

import edu.hm.cs.swa.model.Book;
import edu.hm.cs.swa.model.Disc;
import edu.hm.cs.swa.model.Medium;

/**
 * Created by CaptainEinsicht on 03.05.2017.
 * Alle Rechte vorbehalten bei Missbrauch wird zurück Missbraucht
 */
public interface MediaService {

    MediaServiceResult addBook(Book newBook);

    MediaServiceResult addDisc(Disc newDisc);

    Medium[] getBooks();

    Medium[] getDiscs();

    MediaServiceResult updateBook(Book oldBook);

    MediaServiceResult updateDisc(Disc oldDisc);
}
