package com.globo.entity;

import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlHttp extends Url{

    private static final String REGEX = "(?<protocolo>\\w*):\\/\\/((?<host>[\\w]+)\\.){1}(?<dominio>[^\\/]+)\\/?((?<path>\\w*)\\/)?(?<param>.*)?";

    private String host;
    private String path;
    private String param;

    public UrlHttp(String rawUrl) throws MalformedURLException {
        super(rawUrl);
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher( uri );

        if (m.find()) {
            protocolo = m.group("protocolo");
            host      = m.group("host");
            dominio   = m.group("dominio");
            path      = m.group("path");
            param     = m.group("param");
        }else{
            throw new MalformedURLException("url inválida");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("- protocolo: ").append( getProtocolo() ).append("\n");
        sb.append("- host: "     ).append( getHost()      ).append("\n");
        sb.append("- domínio: "  ).append( getDominio()   ).append("\n");

        if(path != null && !"".equals(path))
            sb.append("- path: "  ).append( getPath() ).append("\n");

        if(param != null && !"".equals(param))
            sb.append("- parâmeros: "  ).append( getParam() ).append("\n");

        return sb.toString();
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public String getParam() {
        return param;
    }
}
