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
@Table(name = "EXAMEN")
public class Examen implements Serializable {

    private Integer id;
    private CursoPorProfesor cursoPorProfesor;
    private TipoExamen tipoExamen;
    private int nota;
    private Date fechaExamen;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Alumno alumno;
    public Examen() {
    }
    
    @Id
    @Column(name = "ID_EXAMEN", unique = true, nullable = false)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_EXAMEN", nullable = false)
    public TipoExamen getTipoExamen() {
        return this.tipoExamen;
    }

    public void setTipoExamen(TipoExamen tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    @Column(name = "IN_NOTA", nullable = false)
    public int getNota() {
        return this.nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_FECHA_EXAMEN", nullable = false, length = 19)
    public Date getFechaExamen() {
        return this.fechaExamen;
    }

    public void setFechaExamen(Date fechaExamen) {
        this.fechaExamen = fechaExamen;
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

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ALUMNO", nullable = false)
    public Alumno getAlumno() {
        return this.alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
