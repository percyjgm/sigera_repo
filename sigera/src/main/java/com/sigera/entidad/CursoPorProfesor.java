package com.sigera.entidad;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso_por_profesor", catalog = "db_sigera")
public class CursoPorProfesor implements java.io.Serializable {

    private int id;
    private Curso curso;
    private Horario horario;
    private Profesor profesor;
    private Set<Asistencia> asistencias = new HashSet<Asistencia>(0);
    private Set<Examen> examenes = new HashSet(0);
    private Set<Tarea> tareas = new HashSet(0);

    public CursoPorProfesor() {
    }


    @Id
    @Column(name = "ID_CURSO_POR_PROFESOR", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CURSO", nullable = false)
    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HORARIO", nullable = false)
    public Horario getHorario() {
        return this.horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PROFESOR", nullable = false)
    public Profesor getProfesor() {
        return this.profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "primaryKey.cursoPorProfesor", cascade = CascadeType.ALL)
    public Set<Asistencia> getAsistencias() {
        return this.asistencias;
    }

    public void setAsistencias(Set<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cursoPorProfesor")
    public Set<Examen> getExamenes() {
        return this.examenes;
    }

    public void setExamenes(Set<Examen> examenes) {
        this.examenes = examenes;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cursoPorProfesor")
    public Set<Tarea> getTareas() {
        return this.tareas;
    }

    public void setTareas(Set<Tarea> tareas) {
        this.tareas = tareas;
    }

}
