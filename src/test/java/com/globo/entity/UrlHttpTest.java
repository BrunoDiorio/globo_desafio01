package com.globo.entity;

import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class UrlHttpTest {

    UrlHttp url1;
    UrlHttp url2;
    UrlHttp url3;

    @Before
    public void setUp() throws Exception {
        this.url1 = new UrlHttp("https://globoesporte.globo.com/");
        this.url2 = new UrlHttp("https://globoesporte.globo.com");
        this.url3 = new UrlHttp("http://www.google.com/mail/user=fulano");
    }

    @Test
    public void getProtocolo() {
        assertEquals("https", url1.getProtocolo());
        assertEquals("https", url2.getProtocolo());
        assertEquals("http", url3.getProtocolo());
    }

    @Test
    public void getHost() {
        assertEquals("globoesporte", url1.getHost());
        assertEquals("globoesporte", url2.getHost());
        assertEquals("www", url3.getHost());
    }

    @Test
    public void getDominio() {
        assertEquals("globo.com", url1.getDominio());
        assertEquals("globo.com", url2.getDominio());
        assertEquals("google.com", url3.getDominio());
    }

    @Test
    public void getPath(){
        assertEquals("mail", url3.getPath());
    }

    @Test
    public void getParam(){
        assertEquals("user=fulano", url3.getParam());
    }

    @Test(expected = MalformedURLException.class)
    public void invalidUrl() throws Exception {
        new UrlHttp("globoesporte.globo.com/");
    }
}