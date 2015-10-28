/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigera.dao;

import com.sigera.entidad.ListaMateriales;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface ListaMaterialDao {
    public void agregar(ListaMateriales t);

    public void actualizar(ListaMateriales t);

    public void eliminar(ListaMateriales t);

    public ListaMateriales obtenerEntidad(Integer id);

    public List<ListaMateriales> obtenerTodos();
}
