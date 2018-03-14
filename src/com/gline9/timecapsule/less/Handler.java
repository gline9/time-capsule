package com.gline9.timecapsule.less;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.github.sommeri.less4j.Less4jException;
import com.github.sommeri.less4j.core.DefaultLessCompiler;

public class Handler extends URLStreamHandler
{

    private static final Map<String, String> dynamicFiles;
    static
    {
        String was = System.getProperty("java.protocol.handler.pkgs", "");
        System.setProperty("java.protocol.handler.pkgs",  Handler.class.getPackage().getName().replace(".less", "") + (was.isEmpty() ? "" : "|" + was ));
        dynamicFiles = new HashMap<>();
    }
    
    public static void registerStyleSheet(String path)
    {
        String contents;
        try
        {
            contents = new DefaultLessCompiler().compile(new File(path)).getCss();
            System.out.println(contents);
        } catch (Less4jException e)
        {
            throw new IllegalStateException("Invalid syntax", e);
        }
        dynamicFiles.put(path, contents);
    }
    
    @Override
    protected URLConnection openConnection(URL u) throws IOException
    {
        return new StringURLConnection(u, dynamicFiles.get(u.getPath()));
    }
    
    private static class StringURLConnection extends URLConnection
    {
        private final String contents;
        
        public StringURLConnection(URL url, String contents)
        {
            super(url);
            this.contents = contents;
        }
        
        @Override
        public void connect() throws IOException {}
        
        @Override
        public InputStream getInputStream() throws IOException
        {
            return IOUtils.toInputStream(contents);
        }
    }

}
