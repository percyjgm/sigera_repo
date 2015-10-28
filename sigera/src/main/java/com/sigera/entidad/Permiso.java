package com.sigera.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERMISO")
public class Permiso implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID_PERMISO")        
    Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERFIL", nullable = false)        
    Perfil perfil;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_MODULO", nullable = false)
    Modulo modulo;
    
    @Column(name = "TY_CREAR", nullable = false)
    Boolean crear;
    
    @Column(name = "TY_LISTAR", nullable = false)
    Boolean listar;
    
    @Column(name = "TY_ACTUALIZAR", nullable = false)
    Boolean actualizar;
    
    @Column(name = "TY_ELIMINAR", nullable = false)
    Boolean eliminar;

    public Permiso() {
        crear = false;
        listar = false;
        actualizar = false;
        eliminar = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Boolean getCrear() {
        return crear;
    }

    public void setCrear(Boolean crear) {
        this.crear = crear;
    }

    public Boolean getListar() {
        return listar;
    }

    public void setListar(Boolean listar) {
        this.listar = listar;
    }

    public Boolean getActualizar() {
        return actualizar;
    }

    public void setActualizar(Boolean actualizar) {
        this.actualizar = actualizar;
    }

    public Boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(Boolean eliminar) {
        this.eliminar = eliminar;
    }
    
    

   

}
