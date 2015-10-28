/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigera.jsf.componentes;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author SAM
 */
@FacesValidator(value = "selectOneValidator")
public class SelectOneValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Integer optionSelected = Integer.parseInt(value.toString());
        if (optionSelected == 0) {
            FacesMessage facesMessage = JsfMessage.getMessage("select_option", "msg",getFieldLabel(component));
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

    @Override
    public String toString() {
        return "SelectValidator{" + "}";
    }
    
}
