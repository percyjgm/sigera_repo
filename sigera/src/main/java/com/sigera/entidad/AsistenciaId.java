package com.sigera.entidad;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AsistenciaId implements Serializable {

    private Alumno alumno;
    private CursoPorProfesor cursoPorProfesor;

    public AsistenciaId() {
    }

    @ManyToOne
    public Alumno getAlumno() {
        return this.alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @ManyToOne
    public CursoPorProfesor getCursoPorProfesor() {
        return this.cursoPorProfesor;
    }

    public void setCursoPorProfesor(CursoPorProfesor cursoPorProfesor) {
        this.cursoPorProfesor = cursoPorProfesor;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AsistenciaId that = (AsistenciaId) o;

        if (alumno != null ? !alumno.equals(that.alumno) : that.alumno != null) return false;
        if (cursoPorProfesor != null ? !cursoPorProfesor.equals(that.cursoPorProfesor) : that.cursoPorProfesor != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (alumno != null ? alumno.hashCode() : 0);
        result = 31 * result + (cursoPorProfesor != null ? cursoPorProfesor.hashCode() : 0);
        return result;
    }

}
