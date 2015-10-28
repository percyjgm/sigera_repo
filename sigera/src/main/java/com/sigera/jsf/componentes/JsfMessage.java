package com.sigera.jsf.componentes;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Luis Alonso Ballena Garcia
 */
public class JsfMessage {

    public static FacesMessage getMessage(String key , String bundleName, Object ... params) 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        Application app = context.getApplication();
        ResourceBundle bundle = app.getResourceBundle(context, bundleName);
        String message = MessageFormat.format(bundle.getString(key),params);
        return new FacesMessage(message,message);
    }



}
