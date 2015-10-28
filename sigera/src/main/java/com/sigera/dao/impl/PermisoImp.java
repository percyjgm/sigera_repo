/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigera.dao.impl;

import com.sigera.dao.PermisoDao;
import com.sigera.entidad.Permiso;
import com.sigera.exceptions.DataBaseException;
import com.sigera.hibernate.HibernateImpl;
import static com.sigera.hibernate.HibernateImpl.log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */

@Repository(value = "permisoImp")
public class PermisoImp implements PermisoDao, Serializable{

     @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Permiso> getPermisosPorPerfil(Integer id) {
       List<Permiso> auxPermiso = new ArrayList();
      Session session =   sessionFactory.getCurrentSession();
       try{
            Criteria criteria = session.createCriteria(Permiso.class,"permi")
                    .add(Restrictions.eq("permi.perfil.id",id)).addOrder(Order.asc("permi.modulo.id"));
            auxPermiso = criteria.list();
        }catch(HibernateException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return auxPermiso;
    }

    @Override
    public void agregar(Permiso t) {
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
    public void actualizar(Permiso t) {
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
    public void eliminar(Permiso t) {
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
    public Permiso obtenerEntidad(Integer id) {
       Permiso t = null;
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            t = (Permiso) session.get(Permiso.class, id);
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
    public List<Permiso> obtenerTodos() {
        List<Permiso> lista = new ArrayList<Permiso>();
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            lista = session.createCriteria(Permiso.class).list();
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
    public List<Permiso> obtenerTodosActivos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recargarEntidad(Permiso t) {
        Session session = null;
        session = sessionFactory.getCurrentSession();
        session.refresh(t);    
    }
    
}
