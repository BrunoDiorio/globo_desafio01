package com.globo.entity;

/**
 * Classe abstrata para urls informadas
 * @author diorio
 */
public abstract class Url {

    protected String uri;
    protected String protocolo;
    protected String dominio;

    public Url(String uri){
        this.uri = uri;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public String getDominio() {
        return dominio;
    }
}