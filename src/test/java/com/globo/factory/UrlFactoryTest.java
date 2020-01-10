package com.globo.factory;

import com.globo.entity.UrlHttp;
import com.globo.entity.UrlSsh;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrlFactoryTest {

    @Test
    public void decodeHttp() throws Exception {
        UrlHttp url = (UrlHttp) UrlFactory.decode("http://www.google.com/mail/user=fulano");
        assertEquals("http", url.getProtocolo());
        assertEquals("www", url.getHost());
        assertEquals("google.com", url.getDominio());
        assertEquals("mail", url.getPath());
        assertEquals("user=fulano", url.getParam());
    }

    @Test
    public void decodeHtts() throws Exception {
        UrlHttp url = (UrlHttp) UrlFactory.decode("https://globoesporte.globo.com/");
        assertEquals("https", url.getProtocolo());
        assertEquals("globoesporte", url.getHost());
        assertEquals("globo.com", url.getDominio());
    }

    @Test
    public void decodeSsh() throws Exception {
        UrlSsh url = (UrlSsh) UrlFactory.decode("ssh://fulano%senha@git.com/");
        assertEquals("ssh", url.getProtocolo());
        assertEquals("fulano", url.getUsuario());
        assertEquals("senha", url.getSenha());
        assertEquals("git.com", url.getDominio());
    }

    @Test(expected = IllegalArgumentException.class)
    public void decodeInvalidProtocol() throws Exception{
        UrlFactory.decode("INVALID://172.0.0.1/");
    }

    @Test(expected = IllegalArgumentException.class)
    public void decodeProtocolNotSuported() throws Exception {
        UrlFactory.decode("FTP://172.0.0.1//");
    }
}