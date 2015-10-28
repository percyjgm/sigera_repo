package com.sigera.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matricula", catalog = "db_sigera")
public class Matricula implements Serializable {

    private Integer id;
    private Alumno alumno;
    private Grado grado;
    private boolean estado;

    public Matricula() {
    }

    @Id
    @Column(name = "ID_MATRICULA", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ALUMNO", nullable = false)
    public Alumno getAlumno() {
        return this.alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_GRADO", nullable = false)
    public Grado getGrado() {
        return this.grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    @Column(name = "TY_ESTADO", nullable = false)
    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
