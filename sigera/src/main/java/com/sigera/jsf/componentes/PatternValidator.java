package com.sigera.jsf.componentes;

import com.sigera.utils.Utilitario;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.apache.log4j.Logger;

/**
 *
 * @author Luis Alonso Ballena Garcia
 */
@FacesValidator(value = "patternValidator")
public class PatternValidator implements Validator {
    
    private static final Logger log = Logger.getLogger(PatternValidator.class.getPackage().getName());
    private static final String EMAIL = "email";    
    private static final String ONLY_LETTER = "only_letter";
    private static final String ALFA_NUMERICO = "alfa_numerico";

    private String type;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        log.debug("Validando el PatternValidator");
        if (value instanceof String) {
            convertType(component);
            if (type != null) {
                validateType(type, value.toString(), context,component);
            }
        }
    }

    private void validateType(String type, String value, FacesContext context ,UIComponent component) 
    throws ValidatorException
    {
        ValidatorException exception = null;
        switch (type) {
            case EMAIL:
                if (!Utilitario.esCorreoValido(value)) {
                    FacesMessage facesMessage = JsfMessage.getMessage("validate_email", "msg");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                    exception = new ValidatorException(facesMessage);
                }
                break;
            case ONLY_LETTER:
                if (!Utilitario.esSoloLetras(value)) {
                    FacesMessage facesMessage = JsfMessage.getMessage("validate_letter", "msg",getFieldLabel(component));
                    facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                    exception = new ValidatorException(facesMessage);
                }
                break;
            case ALFA_NUMERICO:
                if (!Utilitario.esAlfaNumerico(value)) {
                    FacesMessage facesMessage = JsfMessage.getMessage("validate_alfaNumerico", "msg");
                    facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                    exception = new ValidatorException(facesMessage);
                }
                break;
        }
        if(exception != null){
            throw exception;
        }
    }

    public void convertType(UIComponent component) {
        type = (String) component.getAttributes().get("type");
    }
    
    protected String getFieldLabel(UIComponent component) {
        String field = (String) component.getAttributes().get("fieldLabel");
        if (field == null) {
            field = "Desconocido";
        }
        return field;
    }

    @Override
    public String toString() {
        return "PatternValidator{" + "type=" + type + "}";
    }    
    
}
