package com.sigera.jsf.componentes;

import java.io.IOException;
import java.io.InputStream;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Luis Alonso Ballena Garcia
 */
public class StringUploadFile implements UploadedFile{
    String fileName  = "";

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public InputStream getInputstream() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public byte[] getContents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getContentType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(String nombre) throws Exception {
        fileName = nombre;
    }

}
