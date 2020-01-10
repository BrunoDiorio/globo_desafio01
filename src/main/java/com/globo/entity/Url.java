package com.globo.entity;

import java.net.MalformedURLException;

public abstract class Url {

    protected String uri;
    protected String protocolo;
    protected String dominio;

    public Url(String uri){
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public String getDominio() {
        return dominio;
    }
}