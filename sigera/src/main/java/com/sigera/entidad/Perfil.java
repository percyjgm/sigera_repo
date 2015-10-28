package com.sigera.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERFIL")
public class Perfil implements Serializable {

    public Perfil() {
    }

    @Id
    @GeneratedValue
    @Column(name = "ID_PERFIL")
    Integer id;

    @Column(name = "VC_NOMBRE", nullable = false)
    String nombre;
     @Column(name = "TY_ESTADO", nullable = false)
    boolean estado;
    

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
    Set<Usuario> usuarios = new HashSet<Usuario>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil", cascade = CascadeType.ALL)
    Set<Permiso> permisos = new HashSet<Permiso>(0);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
