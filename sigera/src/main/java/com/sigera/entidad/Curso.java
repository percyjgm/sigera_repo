package com.sigera.entidad;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "curso", catalog = "db_sigera")
public class Curso implements java.io.Serializable {

    private Integer idCurso;
    private Seccion seccion;
    private String nombre;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Set<CursoPorProfesor> cursoPorProfesors = new HashSet(0);

    public Curso() {
    }
    
    @Id
    @Column(name = "ID_CURSO", unique = true, nullable = false)
    public Integer getIdCurso() {
        return this.idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SECCION", nullable = false)
    public Seccion getSeccion() {
        return this.seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    @Column(name = "VC_NOMBRE", nullable = false, length = 45)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")
    public Set<CursoPorProfesor> getCursoPorProfesors() {
        return this.cursoPorProfesors;
    }

    public void setCursoPorProfesors(Set<CursoPorProfesor> cursoPorProfesors) {
        this.cursoPorProfesors = cursoPorProfesors;
    }

}
