/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigera.dao.impl;

import com.sigera.dao.MaterialDao;
import com.sigera.entidad.Material;
import com.sigera.exceptions.DataBaseException;
import static com.sigera.hibernate.HibernateImpl.log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository(value = "materiaImp")
public class MaterialImp implements MaterialDao, Serializable {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void agregar(Material t) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.save(t);
        } catch (HibernateException e) {
            log.error(String.format("[HibernateImpl/agregar] %s", e.getMessage()), e);
            throw new DataBaseException("Ha existido un error al guardar la información");
        } catch (Exception e) {
            log.error(String.format("[HibernateImpl/agregar] %s", e.getMessage()), e);
            throw new DataBaseException("Ha existido un error al guardar la información");
        }
    }

    @Override
    public void actualizar(Material t) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.update(t);
        } catch (HibernateException e) {
            log.error(String.format("[HibernateImpl/actualizar] %s", e.getMessage()), e);
            throw new DataBaseException("Ha existido un error al actualizar la información");
        } catch (Exception e) {
            log.error(String.format("[HibernateImpl/actualizar] %s", e.getMessage()), e);
            throw new DataBaseException("Ha existido un error al actualizar la información");
        }
    }

    @Override
    public void eliminar(Material t) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.delete(t);
        } catch (HibernateException e) {
            log.error(String.format("[HibernateImpl/eliminar] %s", e.getMessage()), e);
            throw new DataBaseException("Ha existido un error al guardar la información");
        } catch (Exception e) {
            log.error(String.format("[HibernateImpl/eliminar] %s", e.getMessage()), e);
            throw new DataBaseException("Ha existido un error al guardar la información");
        }
    }

    @Override
    public Material obtenerEntidad(Integer id) {
        Material t = null;
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            t = (Material) session.get(Material.class, id);
        } catch (HibernateException e) {
            log.error(String.format("[HibernateImpl/obtenerEntidad] %s", e.getMessage()), e);
            throw new DataBaseException("Ha existido un error al guardar la información");
        } catch (Exception e) {
            log.error(String.format("[HibernateImpl/obtenerEntidad] %s", e.getMessage()), e);
            throw new DataBaseException("Ha existido un error al guardar la información");
        }
        return t;
    }

    @Override
    public List<Material> obtenerTodos() {
        List<Material> lista = new ArrayList<Material>();
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            lista = session.createCriteria(Material.class).list();
        } catch (HibernateException e) {
            log.error(String.format("[HibernateImpl/obtenerTodos] %s", e.getMessage()), e);
            throw new DataBaseException("Ha existido un error al guardar la información");
        } catch (Exception e) {
            log.error(String.format("[HibernateImpl/obtenerTodos] %s", e.getMessage()), e);
            throw new DataBaseException("Ha existido un error al guardar la información");
        }
        return lista;
    }

    @Override
    public List<Material> obtenerTodosActivos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recargarEntidad(Material t) {
        Session session = null;
        session = sessionFactory.getCurrentSession();
        session.refresh(t);
    }

}
