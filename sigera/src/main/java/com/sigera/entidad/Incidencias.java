package com.sigera.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "incidencias", catalog = "db_sigera")
public class Incidencias implements Serializable {

    private Integer id;
    private Alumno alumno;
    private TipoIncidencia tipoIncidencia;
    private String descripcion;
    private Date fechaIncidencia;
    private Date fechaRegistro;

    private Set<ActividadesExtracurriculares> actividadesExtracurriculareses = new HashSet(0);

    public Incidencias() {
    }

    @Id
    @Column(name = "ID_INCIDENCIAS", unique = true, nullable = false)
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
    @JoinColumn(name = "ID_TIPO_INCIDENCIA", nullable = false)
    public TipoIncidencia getTipoIncidencia() {
        return this.tipoIncidencia;
    }

    public void setTipoIncidencia(TipoIncidencia tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    @Column(name = "VC_DESCRIPCION", nullable = false, length = 555)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_FECHA_INCIDENCIA", nullable = false, length = 19)
    public Date getFechaIncidencia() {
        return this.fechaIncidencia;
    }

    public void setFechaIncidencia(Date fechaIncidencia) {
        this.fechaIncidencia = fechaIncidencia;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_FECHA_REGISTRO", length = 19)
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "incidenciases")
    public Set<ActividadesExtracurriculares> getActividadesExtracurriculareses() {
        return actividadesExtracurriculareses;
    }

    public void setActividadesExtracurriculareses(Set<ActividadesExtracurriculares> actividadesExtracurriculareses) {
        this.actividadesExtracurriculareses = actividadesExtracurriculareses;
    }

}
