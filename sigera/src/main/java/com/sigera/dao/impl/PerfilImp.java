/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigera.dao.impl;

import com.sigera.dao.PerfilDao;
import com.sigera.entidad.Perfil;
import com.sigera.hibernate.HibernateImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository("perfilImp")
public class PerfilImp extends HibernateImpl<Perfil, Integer> implements PerfilDao, Serializable {

    @Override
    public List<Perfil> obtenerPerfilConPermisosPorId(Integer id) {
        List<Perfil> lista = new ArrayList<>();
        Session session = null;
        try {
            session = getSessionFactory().getCurrentSession();
            Criteria criteria = session.createCriteria(Perfil.class, "perfil").
                    createAlias("perfil.permisos", "permiso").add(Restrictions.eq("perfil.id", id));
            lista = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
