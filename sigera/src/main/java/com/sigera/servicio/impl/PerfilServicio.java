/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigera.servicio.impl;

import com.sigera.dao.ModuloDao;
import com.sigera.dao.PerfilDao;
import com.sigera.dao.PermisoDao;
import com.sigera.entidad.Modulo;
import com.sigera.entidad.Perfil;
import com.sigera.entidad.Permiso;
import com.sigera.servicio.IPerfilServicio;
import com.sigera.utils.Utilitario;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrador
 */

@Service
@Transactional(readOnly = true)
public class PerfilServicio implements IPerfilServicio, Serializable{
private static final long serialVersionUID = -4111128316806300754L;


    @Autowired
    PerfilDao perfilDao;
    @Autowired
    PermisoDao permisoDao;
    @Autowired
    ModuloDao moduloDao;

    @Override
    public List<Permiso> obtenerPermisosPorPerfil(Integer id) {
        return (List<Permiso>) permisoDao.getPermisosPorPerfil(id);
    }

    @Override
    public List<Modulo> obtenerModulos() {

        return moduloDao.obtenerTodos();
    }

    @Transactional(readOnly = false)
    @Override
    public void actualizarModulo(Modulo modulo) {
        moduloDao.actualizar(modulo);
        Utilitario.enviarMensajeGlobalValido("Se ha actualizado correctamente");
    }
    
    @Override
    public Modulo obtenerModuloPorId(Integer id) {
        return moduloDao.obtenerEntidad(id);
    }

    @Override
    public Perfil obtenerPerfilId(Integer id) {
        return perfilDao.obtenerEntidad(id);
    }

    @Override
    public List<Modulo> cargarModuloConPermiso(Integer id) {
        return ensamblarModulos((List<Permiso>) permisoDao.obtenerEntidad(id), moduloDao.obtenerTodos());
    }

    private List<Permiso> ensamblarPermisos(List<Permiso> permisos, Perfil perfil) {

        for (Permiso permiso : permisos) {
            permiso.setPerfil(perfil);
        }
        return permisos;
    }

    private List<Modulo> ensamblarModulos(List<Permiso> permisos, List<Modulo> modulos) {
        int i = 0;
        for (Modulo mod : modulos) {
            i = 0;
            for (Permiso permi : permisos) {
                if (mod.getId().intValue() == permi.getModulo().getId().intValue()) {
                    mod.setPermiso(permi);
                    permisos.remove(i);
                    break;
                }
                i++;
            }
        }
        return modulos;
    }

    @Override
    @Transactional(readOnly = false)
    public void registrarPerfil(Perfil perfil, List<Permiso> permisos) {
        permisos = ensamblarPermisos(permisos, perfil);
        perfil.setPermisos(new HashSet<Permiso>(permisos));
        perfilDao.agregar(perfil);
        Utilitario.enviarMensajeGlobalValido("Se ha registrado correctamente.");
    }

    @Override
    @Transactional(readOnly = false)
    public void actualizarPerfil(Perfil perfil, List<Permiso> permisos) {
        permisos = ensamblarPermisos(permisos, perfil);
        perfil.setPermisos(new HashSet<Permiso>(permisos));
        perfilDao.actualizar(perfil);
        Utilitario.enviarMensajeGlobalValido("Se ha actualizado correctamente.");
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminarPerfil(Perfil perfil) {
       
        perfilDao.eliminar(perfil);
        Utilitario.enviarMensajeGlobalValido("Se ha eliminado registro correctamente.");
    }

    @Override
    public Perfil obtenerPerfilesPorPermisos(Integer id) {
        return perfilDao.obtenerPerfilConPermisosPorId(id).get(0);
    }

}
