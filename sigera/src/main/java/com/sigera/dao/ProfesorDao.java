/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigera.dao;

import com.sigera.entidad.Profesor;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface ProfesorDao {
    public void agregar(Profesor t);

    public void actualizar(Profesor t);

    public void eliminar(Profesor t);

    public Profesor obtenerEntidad(Integer id);

    public List<Profesor> obtenerTodos();

    /**
     * Este metodo nos permite traer todos los registros que tienen estado 1
     * (Activo). Lanza una excepcion si la entidad a traer no tiene una columna
     * estado.
     */
    public List<Profesor> obtenerTodosActivos();

    public void recargarEntidad(Profesor t);

    public List<Profesor> getPermisosPorPerfil(Integer id);
}
