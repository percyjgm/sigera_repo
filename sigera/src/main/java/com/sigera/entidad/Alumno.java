package com.sigera.entidad;

import java.io.Serializable;
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
@Table(name = "alumno", catalog = "db_sigera")
public class Alumno implements Serializable {

    private Integer idA;
    private Apoderado apoderado;
    private Persona persona;
    private TipoAlumno tipoAlumno;
    private int edad;
    private String colegioProcedencia;
    private Set<Incidencias> incidenciases = new HashSet(0);
    private Set<Matricula> matriculas = new HashSet(0);
    private Set<Asistencia> asistencias = new HashSet<Asistencia>(0);
    private Set<Recibo> recibos = new HashSet(0);
    
    private Set<Examen> examenes = new HashSet(0);
    public Alumno() {
    }

    @Id
    @Column(name = "ID_ALUMNO", unique = true, nullable = false)
    public Integer getIdA() {
        return this.idA;
    }

    public void setIdA(Integer idA) {
        this.idA = idA;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_APODERADO", nullable = false)
    public Apoderado getApoderado() {
        return this.apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSONA", nullable = false)
    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_ALUMNO", nullable = false)
    public TipoAlumno getTipoAlumno() {
        return this.tipoAlumno;
    }

    public void setTipoAlumno(TipoAlumno tipoAlumno) {
        this.tipoAlumno = tipoAlumno;
    }

    @Column(name = "VC_EDAD", nullable = false)
    public int getVcEdad() {
        return this.edad;
    }

    public void setVcEdad(int vcEdad) {
        this.edad = vcEdad;
    }

    @Column(name = "VC_COLEGIO_PROCEDENCIA", length = 100)
    public String getColegioProcedencia() {
        return this.colegioProcedencia;
    }

    public void setColegioProcedencia(String colegioProcedencia) {
        this.colegioProcedencia = colegioProcedencia;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "alumno")
    public Set<Incidencias> getIncidenciases() {
        return this.incidenciases;
    }

    public void setIncidenciases(Set<Incidencias> incidenciases) {
        this.incidenciases = incidenciases;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "alumno")
    public Set<Matricula> getMatriculas() {
        return this.matriculas;
    }

    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "primaryKey.alumno", cascade = CascadeType.ALL)
    public Set<Asistencia> getAsistencias() {
        return this.asistencias;
    }

    public void setAsistencias(Set<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "alumno")
    public Set<Recibo> getRecibos() {
        return this.recibos;
    }

    public void setRecibos(Set<Recibo> recibos) {
        this.recibos = recibos;
    }
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "alumno")
	public Set<Examen> getExamenes() {
        return this.examenes;
    }

    public void setExamenes(Set<Examen> examenes) {
        this.examenes = examenes;
    }
}
