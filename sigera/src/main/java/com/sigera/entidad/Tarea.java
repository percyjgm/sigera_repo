package com.sigera.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tarea", catalog = "db_sigera")
public class Tarea implements Serializable {

    private Integer id;
    private CursoPorProfesor cursoPorProfesor;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;

    public Tarea() {
    }

    @Id
    @Column(name = "ID_TAREA", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CURSO_POR_PROFESOR", nullable = false)
    public CursoPorProfesor getCursoPorProfesor() {
        return this.cursoPorProfesor;
    }

    public void setCursoPorProfesor(CursoPorProfesor cursoPorProfesor) {
        this.cursoPorProfesor = cursoPorProfesor;
    }

    @Column(name = "VC_NOMBRE", nullable = false, length = 45)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "VC_DESCRIPCION", nullable = false, length = 45)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "TY_ESTADO", nullable = false)
    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_FECHA_CREACION", length = 19)
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_FECHA_MODIFICACION", length = 19)
    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

}
