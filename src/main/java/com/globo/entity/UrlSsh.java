package com.globo.entity;

import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlSsh extends Url {


    private static final String REGEX = "(?<protocolo>\\w*):\\/\\/((?<usuario>[\\w]+)[\\%\\@]){1}((?<senha>[\\w]+)\\@){0,1}(?<dominio>[^\\/]*)";

    private String usuario;
    private String senha;

    public UrlSsh(String rawUrl) throws MalformedURLException {
        super(rawUrl);
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher( uri );

        if (m.find()) {
            protocolo = m.group("protocolo");
            usuario   = m.group("usuario");
            senha     = m.group("senha");
            dominio   = m.group("dominio");
        }else{
            throw new MalformedURLException("url inválida");
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("- protocolo: ").append( getProtocolo() ).append("\n");
        sb.append("- usuario: "  ).append( getUsuario()   ).append("\n");

        if( getSenha()!=null && !"".equals(getSenha()) ){
            sb.append("- senha: ").append( getSenha()).append("\n");
        }

        sb.append("- domínio: "  ).append( getDominio()   ).append("\n");
        return sb.toString();
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
