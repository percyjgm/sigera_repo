package com.sigera.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "seccion", catalog = "db_sigera")
public class Seccion implements Serializable {

    private Integer id;
    private Grado grado;
    private String nombre;
    private Set<Profesor> profesors = new HashSet(0);
    private Set<Curso> cursos = new HashSet(0);

    public Seccion() {
    }

    @Id
    @Column(name = "ID_SECCION", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_GRADO", nullable = false)
    public Grado getGrado() {
        return this.grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    @Column(name = "VC_NOMBRE", nullable = false, length = 45)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="seccions")
    public Set<Profesor> getProfesores() {
        return this.profesors;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesors = profesores;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seccion")
    public Set<Curso> getCursos() {
        return this.cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

}
