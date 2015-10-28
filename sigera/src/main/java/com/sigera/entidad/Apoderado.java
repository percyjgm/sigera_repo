package com.sigera.entidad;

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

@Entity
@Table(name = "apoderado", catalog = "db_sigera")
public class Apoderado implements java.io.Serializable {

    private Integer id;
    private TipoApoderado tipoApoderado;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private int telefono;
    private Set<Alumno> alumnos = new HashSet(0);

    public Apoderado() {
    }

    @Id
    @Column(name = "ID_APODERADO", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_APODERADO", nullable = false)
    public TipoApoderado getTipoApoderado() {
        return this.tipoApoderado;
    }

    public void setTipoApoderado(TipoApoderado tipoApoderado) {
        this.tipoApoderado = tipoApoderado;
    }

    @Column(name = "VC_NOMBRE", nullable = false, length = 45)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "VC_APELLIDO_PATERNO", nullable = false, length = 45)
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Column(name = "VC_APELLIDO_MATERNO", length = 45)
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Column(name = "VC_EMAIL", nullable = false, length = 45)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "IN_TELEFONO", nullable = false)
    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "apoderado")
    public Set<Alumno> getAlumnos() {
        return this.alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

}
