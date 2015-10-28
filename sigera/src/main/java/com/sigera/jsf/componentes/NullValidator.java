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
@FacesValidator(value = "nullValidator")
public class NullValidator implements Validator {
    private static final Logger log = Logger.getLogger(NullValidator.class.getPackage().getName());
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        log.debug("Validando el NullValidator");
        log.debug("El valor del Field "+getFieldLabel(component));
        if (value == null || Utilitario.esNulo(value.toString())) {
            FacesMessage facesMessage = JsfMessage.getMessage("required", "msg", getFieldLabel(component));
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
//            context.addMessage(null, facesMessage);
            throw new ValidatorException(facesMessage);
        }
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
        return "NullValidator";
    }
    
    

}
