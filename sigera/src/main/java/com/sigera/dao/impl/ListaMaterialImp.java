/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigera.dao.impl;

import com.sigera.dao.ListaMaterialDao;
import com.sigera.entidad.ListaMateriales;
import com.sigera.entidad.Material;
import com.sigera.exceptions.DataBaseException;
import static com.sigera.hibernate.HibernateImpl.log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository(value = "listamateriaImp")
public class ListaMaterialImp implements ListaMaterialDao, Serializable {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void agregar(ListaMateriales t) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.save(t);
        } catch (HibernateException e) {

            throw new DataBaseException("Ha existido un error al guardar la información");
        } catch (Exception e) {

            throw new DataBaseException("Ha existido un error al guardar la información");
        }
    }

    @Override
    public void actualizar(ListaMateriales t) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.update(t);
        } catch (HibernateException e) {

            throw new DataBaseException("Ha existido un error al actualizar la información");
        } catch (Exception e) {

            throw new DataBaseException("Ha existido un error al actualizar la información");
        }
    }

    @Override
    public void eliminar(ListaMateriales t) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.delete(t);
        } catch (HibernateException e) {

            throw new DataBaseException("Ha existido un error al actualizar la información");
        } catch (Exception e) {

            throw new DataBaseException("Ha existido un error al actualizar la información");
        }
    }

    @Override
    public ListaMateriales obtenerEntidad(Integer id) {
        ListaMateriales t = null;
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            t = (ListaMateriales) session.get(ListaMateriales.class, id);
        } catch (HibernateException e) {
            
            throw new DataBaseException("Ha existido un error al guardar la información");
        } catch (Exception e) {
            
            throw new DataBaseException("Ha existido un error al guardar la información");
        }   
        return t;
    }

    @Override
    public List<ListaMateriales> obtenerTodos() {
        List<ListaMateriales> lista = new ArrayList<ListaMateriales>();
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            lista = session.createCriteria(Material.class).list();
        } catch (HibernateException e) {
           
            throw new DataBaseException("Ha existido un error al guardar la información");
        } catch (Exception e) {
            
            throw new DataBaseException("Ha existido un error al guardar la información");
        }
        return lista;
    }

}
