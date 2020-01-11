package com.globo.enums;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class IdentifiableEnumTest {

    @Test
    public void findByNameOk() {
        ProtocoloEnum enumHttp  = IdentifiableEnum.findByName("http",  ProtocoloEnum.class);
        ProtocoloEnum enumHttps = IdentifiableEnum.findByName("https", ProtocoloEnum.class);
        ProtocoloEnum enumFtp   = IdentifiableEnum.findByName("ftp",   ProtocoloEnum.class);

        assertEquals(ProtocoloEnum.HTTP,  enumHttp);
        assertEquals(ProtocoloEnum.HTTPS, enumHttps);
        assertEquals(ProtocoloEnum.FTP,   enumFtp);
    }

    @Test(expected = NoSuchElementException.class)
    public void findByNameNomeInvalido() {
        IdentifiableEnum.findByName("htttp",  ProtocoloEnum.class);
    }
}