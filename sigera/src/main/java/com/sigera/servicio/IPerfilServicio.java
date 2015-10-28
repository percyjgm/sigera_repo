/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigera.servicio;

import com.sigera.entidad.Modulo;
import com.sigera.entidad.Perfil;
import com.sigera.entidad.Permiso;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IPerfilServicio {
    public List<Permiso> obtenerPermisosPorPerfil(Integer id);
    
    public List<Modulo> obtenerModulos();
    
    public void registrarPerfil(Perfil perfil, List<Permiso> permisos);
    
    public void actualizarPerfil(Perfil perfil, List<Permiso> permisos);
    
    public void eliminarPerfil(Perfil perfil);
    
    public void actualizarModulo(Modulo modulo);
    
    public Modulo obtenerModuloPorId(Integer id);
    
    public Perfil obtenerPerfilId(Integer id);
    
    public Perfil obtenerPerfilesPorPermisos(Integer id);
    
    public List<Modulo> cargarModuloConPermiso(Integer id);
    
}
