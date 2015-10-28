package com.sigera.jsf.componentes;

import com.sigera.utils.Utilitario;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Luis Alonso Ballena Garcia
 */
@FacesValidator(value = "dniValidator")
public class DniValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent componente, Object value) throws ValidatorException {
        if (value instanceof String) {
            String campo = (String) value;
            if (Utilitario.esNulo(campo)) {
                return;
            }
            if (campo.length() != 8) {
                FacesMessage facesMessage = JsfMessage.getMessage("dni_range", "msg", "8");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(facesMessage);
            }
            if (!Utilitario.esSoloNumero(campo)) {
                FacesMessage facesMessage = JsfMessage.getMessage("dni_number", "msg");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(facesMessage);
            }
        }
    }

    @Override
    public String toString() {
        return "DniValidator{" + "}";
    }

    
    
}
