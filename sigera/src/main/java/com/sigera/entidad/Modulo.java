package com.sigera.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

@Entity
@Table(name = "MODULO")
public class Modulo implements Serializable, Comparable<Modulo> {

    private static final long serialVersionUID = 8295057005100088900L;

    public Modulo() {
    }

    @Id
    @GeneratedValue
    @Column(name = "ID_MODULO")
    private Integer id;

    @Column(name = "VC_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "TY_ELIMINAR", nullable = false)
    private boolean eliminar;

    @Column(name = "TY_ACTUALIZAR", nullable = false)
    private boolean actualizar;

    @Column(name = "TY_CREAR", nullable = false)
    private boolean crear;

    @Column(name = "TY_LISTAR", nullable = false)
    private boolean listar;

    @Column(name = "VC_URL", nullable = false)
    private String url;

  
    @Column(name = "VC_CREADO_POR")
    private String creadoPor;

    @Column(name = "DT_FECHA_CREACION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "VC_MODIFICADO_POR")
    private String modificadoPor;

    @Column(name = "DT_FECHA_MODIFICACION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_MODULO_PADRE")
    private ModuloPadre moduloPadre;

    @Transient
    private Permiso permiso;

    public Modulo(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
 @Override
    public int compareTo(Modulo o) {
        if(getId().intValue() > o.getId().intValue())
        {
            return 1;
        }else if(getId().intValue() < o.getId().intValue())
        {
            return -1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return this.getId().intValue() == ((Modulo)obj).getId().intValue();
    }

    @Override
    public String toString() {
        return "Modulo{" + "id=" + id + ", nombre=" + nombre + ", eliminar=" + eliminar + ", actualizar=" + actualizar + ", crear=" + crear + ", listar=" + listar + ", url=" + url +  '}';
    }

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

    public boolean isEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public boolean isActualizar() {
        return actualizar;
    }

    public void setActualizar(boolean actualizar) {
        this.actualizar = actualizar;
    }

    public boolean isCrear() {
        return crear;
    }

    public void setCrear(boolean crear) {
        this.crear = crear;
    }

    public boolean isListar() {
        return listar;
    }

    public void setListar(boolean listar) {
        this.listar = listar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public ModuloPadre getModuloPadre() {
        return moduloPadre;
    }

    public void setModuloPadre(ModuloPadre moduloPadre) {
        this.moduloPadre = moduloPadre;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
   

}
