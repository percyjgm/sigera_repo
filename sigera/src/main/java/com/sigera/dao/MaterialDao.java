/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigera.dao;

import com.sigera.entidad.Material;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface MaterialDao {
    
    public void agregar(Material t);
    
    public void actualizar(Material t);
    
    public void eliminar(Material t);
    
    public Material obtenerEntidad(Integer id);
    
    public List<Material> obtenerTodos();
    
    /**
     * Este metodo nos permite traer todos los registros que tienen estado 1 (Activo).
     * Lanza una excepcion si la entidad a traer no tiene una columna estado.
     */
    public List<Material> obtenerTodosActivos();
    
    public void recargarEntidad(Material t);
}
