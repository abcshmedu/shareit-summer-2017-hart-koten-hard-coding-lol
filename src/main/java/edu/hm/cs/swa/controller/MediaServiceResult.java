package edu.hm.cs.swa.controller;

import javax.net.ssl.SSLEngineResult.Status;

/**
 * Created by CaptainEinsicht on 03.05.2017. Alle Rechte vorbehalten bei
 * Missbrauch wird zurück Missbraucht
 */
public enum MediaServiceResult {

    OK(200), INVALID_ISBN(300), ISBN_TAKEN(301), AUTHOR_OR_TITLE_MISSING(302), ISBN_NOT_FOUND(303),
    MODIFIY_ISBN(304), AUTHOR_AND_TITLE_MISSING(305);

    private int statusCode;

    private MediaServiceResult(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
