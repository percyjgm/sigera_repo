package com.sigera.entidad;

import java.util.Date;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "asistencia")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.alumno",
            joinColumns = @JoinColumn(name = "ID_ALUMNO", nullable = false)),
    @AssociationOverride(name = "primaryKey.cursoPorProfesor",
            joinColumns = @JoinColumn(name = "ID_CURSO_POR_PROFESOR", nullable = false))})
public class Asistencia implements java.io.Serializable {

    @EmbeddedId
    private AsistenciaId primaryKey = new AsistenciaId();

    public AsistenciaId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(AsistenciaId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Asistencia() {
    }

    @Transient
    public Alumno getAlumno() {
        return getPrimaryKey().getAlumno();
    }

    public void setAlumno(Alumno alumno) {
        getPrimaryKey().setAlumno(alumno);
    }

    @Transient
    public CursoPorProfesor getCursoPorProfesor() {
        return getPrimaryKey().getCursoPorProfesor();
    }

    public void setCursoPorProfesor(CursoPorProfesor cursoporporfesor) {
        getPrimaryKey().setCursoPorProfesor(cursoporporfesor);
    }

    @Column(name = "VC_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "TY_ASISTIR", nullable = false)
    private boolean asistir;

    @Column(name = "TY_FALTA", nullable = false)
    private boolean falta;

    @Column(name = "TY_TARDANZA", nullable = false)
    private boolean tardanza;

    @Column(name = "TY_JUSTIFICADO", nullable = false)
    private boolean justificado;

    @Column(name = "DT_FECHA_REGISTRO")
    private Date fechaRegistro;

    @Column(name = "DT_FECHA_MODIFICACION")
    private Date fechaModificacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAsistir() {
        return asistir;
    }

    public void setAsistir(boolean asistir) {
        this.asistir = asistir;
    }

    public boolean isFalta() {
        return falta;
    }

    public void setFalta(boolean falta) {
        this.falta = falta;
    }

    public boolean isTardanza() {
        return tardanza;
    }

    public void setTardanza(boolean tardanza) {
        this.tardanza = tardanza;
    }

    public boolean isJustificado() {
        return justificado;
    }

    public void setJustificado(boolean justificado) {
        this.justificado = justificado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Asistencia that = (Asistencia) o;

        if (getPrimaryKey() != null ? !getPrimaryKey().equals(that.getPrimaryKey())
                : that.getPrimaryKey() != null) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        return (getPrimaryKey() != null ? getPrimaryKey().hashCode() : 0);
    }
}
