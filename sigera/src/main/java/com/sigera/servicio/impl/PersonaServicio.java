/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigera.servicio.impl;

import com.sigera.dao.PersonaDao;
import com.sigera.dao.UsuarioDao;
import com.sigera.entidad.Persona;
import com.sigera.entidad.Usuario;
import com.sigera.servicio.IPersonaServicio;
import com.sigera.utils.Utilitario;
import java.io.Serializable;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrador
 */

@Service
@Transactional(readOnly = true)
public class PersonaServicio implements IPersonaServicio, Serializable{

    private static final long serialVersionUID = 2181361854639584422L;
    @Autowired
    PersonaDao personaDao;
    @Autowired
    UsuarioDao usuarioDao;

    @Transactional(readOnly = false)
    @Override
    public void agregarPersona(Persona persona) {
        if (validarDni(persona.getDni())) {
            throw new RuntimeException("El dni ya existe");
        }
        persona.setFechaRegistro(new Date());
        personaDao.agregar(persona);
        Utilitario.enviarMensajeGlobalValido("Se ha ingresado correctamente");    
    }

    @Transactional(readOnly = false)
    @Override
    public void actualizarPersona(Persona persona) {
         String dniOriginal = personaDao.obtenerDniPorId(persona.getIdPersona());
        if(!dniOriginal.equalsIgnoreCase(persona.getDni())){
            if(validarDni(persona.getDni())){
                throw new RuntimeException("El dni ya existe");
            }
        }
        persona.setFechaModificacion(new Date());
        personaDao.actualizar(persona);
        Utilitario.enviarMensajeGlobalValido("Se ha actualizado correctamente");    
    }

    @Transactional(readOnly = false)
    @Override
    public void eliminarPersona(Persona persona) {
        
        personaDao.eliminar(persona);
        Utilitario.enviarMensajeGlobalValido("Se ha eliminado correctamente");    
    }

    @Override
    public Persona obtenerPersona(Integer id) {
        return personaDao.obtenerEntidad(id);    
    }

    @Override
    public boolean existeCuenta(Usuario usuario) {
         return usuarioDao.existeUsuario(usuario);   
    }

    @Override
    public Usuario generarUsuarioSesion(Usuario usuario) {
        if (!existeCuenta(usuario)) {
            Utilitario.enviarMensajeGlobalError("La cuenta y/o clave son incorrectas.");
            return null;
        }
        Usuario aux = usuarioDao.getUsuarioSessionPorNick(usuario.getNick());
        return aux;    
    }
    
    private boolean validarDni(String dni) {
        return personaDao.existeDni(dni) ;
    }
}
