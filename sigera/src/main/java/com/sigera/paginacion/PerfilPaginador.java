package com.sigera.paginacion;

import com.sigera.entidad.Perfil;
import com.sigera.hibernate.HibernateStringPaginador;
import java.io.Serializable;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrador
 */

@Component
@Paginator(value = Perfil.class)
public class PerfilPaginador extends HibernateStringPaginador implements Serializable{
    private static final long serialVersionUID = -8383879871695823685L;

    @Override
    protected String createFilter() {
        return String.format("%s %s",super.createFilter(),"where perfil.estado = 1");
    }
}
