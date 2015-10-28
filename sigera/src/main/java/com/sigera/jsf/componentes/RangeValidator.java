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
@FacesValidator(value = "rangeValidator")
public class RangeValidator implements Validator {

    private static final Logger log = Logger.getLogger(RangeValidator.class.getPackage().getName());
    private Double maximo = Double.MAX_VALUE;
    private Double minimo = 0.0;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        log.debug("Validando el RangeValidator");
        if (value instanceof String) {
            validarString(context, component, value);
        }else if(value instanceof Integer)
        {
            /**Esta parte se lo dejare a alguien **/
        }
    }

    private void validarString(FacesContext context, UIComponent component, Object value) {
        String cadena = (String) value;
        if (Utilitario.esNulo(cadena)) {
            return;
        }
        if (!Utilitario.esRangoValido(cadena, getMinimo(component).intValue(), getMaximo(component).intValue())) {
            FacesMessage facesMessage = JsfMessage.getMessage("range_string", "msg", getFieldLabel(component), minimo.intValue(), maximo.intValue());
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

    public Double getMaximo(UIComponent component) {
        String field = (String) component.getAttributes().get("maximo");
        if (field != null) {
            maximo = Double.valueOf(field);
        }
        return maximo;
    }

    public Double getMinimo(UIComponent component) {
        String field = (String) component.getAttributes().get("minimo");
        if (field != null) {
            minimo = Double.valueOf(field);
        }
        return minimo;
    }

    @Override
    public String toString() {
        return "RangeValidator{" + "maximo=" + maximo + ", minimo=" + minimo + "}";
    }
    
    

}
