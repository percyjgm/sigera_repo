/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigera.dao;

import com.sigera.entidad.Modulo;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface ModuloDao{
    public void agregar(Modulo t);
    
    public void actualizar(Modulo t);
    
    public void eliminar(Modulo t);
    
    public Modulo obtenerEntidad(Integer id);
    
    public List<Modulo> obtenerTodos();
    
    /**
     * Este metodo nos permite traer todos los registros que tienen estado 1 (Activo).
     * Lanza una excepcion si la entidad a traer no tiene una columna estado.
     */
    public List<Modulo> obtenerTodosActivos();
    
    public void recargarEntidad(Modulo t);
}
