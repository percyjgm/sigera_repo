package com.sigera.jsf.componentes;

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
@FacesValidator(value = "selectListValidator")
public class SelectListValidator implements Validator {

    private static final Logger log = Logger.getLogger(SelectListValidator.class.getPackage().getName());

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Integer valueInteger = getValueInteger(component);
        if (valueInteger == null || valueInteger.intValue() == 0) {
            FacesMessage facesMessage = JsfMessage.getMessage("select_list", "msg", getFieldLabel(component));
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
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

    protected Integer getValueInteger(UIComponent component) {
        Integer value = (Integer) component.getAttributes().get("valueInteger");
        return value;
    }

}
