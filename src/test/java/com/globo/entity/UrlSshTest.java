package com.globo.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UrlSshTest {

    UrlSsh url1;
    UrlSsh url2;
    UrlSsh url3;
    UrlSsh url4;

    @Before
    public void setUp() throws Exception {
        this.url1 = new UrlSsh("ssh://fulano%senha@git.com/");
        this.url2 = new UrlSsh("ssh://fulano%senha@git.com");
        this.url3 = new UrlSsh("ssh://fulano@git.com/");
        this.url4 = new UrlSsh("ssh://fulano@git.com");
    }

    @Test
    public void getProtocolo() {
        assertEquals("ssh", url1.getProtocolo());
        assertEquals("ssh", url2.getProtocolo());
        assertEquals("ssh", url3.getProtocolo());
        assertEquals("ssh", url4.getProtocolo());
    }

    @Test
    public void getUsuario() {
        assertEquals("fulano", url1.getUsuario());
        assertEquals("fulano", url2.getUsuario());
        assertEquals("fulano", url3.getUsuario());
        assertEquals("fulano", url4.getUsuario());
    }

    @Test
    public void getSenha() {
        assertEquals("senha", url1.getSenha());
        assertEquals("senha", url2.getSenha());
        assertNull( url3.getSenha());
        assertNull( url4.getSenha());
    }

    @Test
    public void getDominio() {
        assertEquals("git.com", url1.getDominio());
        assertEquals("git.com", url2.getDominio());
        assertEquals("git.com", url3.getDominio());
        assertEquals("git.com", url4.getDominio());
    }
}