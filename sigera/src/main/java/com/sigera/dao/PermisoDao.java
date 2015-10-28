/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigera.dao;

import com.sigera.entidad.Permiso;

import java.util.List;

/**
 *
 * @author Administrador
 */
public interface PermisoDao {

    public void agregar(Permiso t);

    public void actualizar(Permiso t);

    public void eliminar(Permiso t);

    public Permiso obtenerEntidad(Integer id);

    public List<Permiso> obtenerTodos();

    /**
     * Este metodo nos permite traer todos los registros que tienen estado 1
     * (Activo). Lanza una excepcion si la entidad a traer no tiene una columna
     * estado.
     */
    public List<Permiso> obtenerTodosActivos();

    public void recargarEntidad(Permiso t);

    public List<Permiso> getPermisosPorPerfil(Integer id);
}
