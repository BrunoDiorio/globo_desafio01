package com.globo.factory;

import com.globo.entity.Url;
import com.globo.entity.UrlHttp;
import com.globo.entity.UrlSsh;
import com.globo.enums.IdentifiableEnum;
import com.globo.enums.ProtocoloEnum;

import java.net.MalformedURLException;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contrução da url dependendo do protocolo utilizado
 * @author diorio
 */
public class UrlFactory {

    public static final String REGEX_PROTOCOLO = "^(?<protocolo>\\w+)://";

    public static Url decode(String rawUrl) throws NoSuchElementException, MalformedURLException {

        Url url;

        Pattern p = Pattern.compile(REGEX_PROTOCOLO);
        Matcher m = p.matcher(rawUrl);


        if(!m.find()){
            throw new IllegalArgumentException("Protocolo não informado");
        }

        try{
            ProtocoloEnum protocoloEnum = IdentifiableEnum.findByName(m.group("protocolo"), ProtocoloEnum.class);

            switch (protocoloEnum){
                case HTTP:
                case HTTPS:
                    url = new UrlHttp(rawUrl);
                    break;
                case SSH:
                    url = new UrlSsh(rawUrl);
                    break;
                default:
                    throw new IllegalArgumentException("Protocolo não suportado");
            }

        }catch (NoSuchElementException e){
            throw new IllegalArgumentException("Protocolo de cominicação nao identificado");
        }

        return url;
    }
}
