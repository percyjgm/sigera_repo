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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "actividades_extracurriculares", catalog = "db_sigera")
public class ActividadesExtracurriculares implements Serializable {

    private Integer id;
    private Profesor profesor;
    private String direccion;
    private String referencia;
    private int numeroContacto;
    private Date fechaInicio;
    private Date fechaRetorno;
    private Date fechaCreacion;
    private Date fechaModificacion;
 
     private Set<Incidencias> incidenciases = new HashSet(0);
    public ActividadesExtracurriculares() {
    }

    @Id
    @Column(name = "ID_ACTIVIDADES_EXTRACURRICULARES", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PROFESOR", nullable = false)
    public Profesor getProfesor() {
        return this.profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Column(name = "VC_DIRECCION", nullable = false, length = 45)
    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "VC_REFERENCIA", nullable = false, length = 45)
    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Column(name = "IN_NUMERO_CONTACTO", nullable = false)
    public int getNumeroContacto() {
        return this.numeroContacto;
    }

    public void setNumeroContacto(int numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_FECHA_INICIO", nullable = false, length = 19)
    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_FECHA_RETORNO", nullable = false, length = 19)
    public Date getFechaRetorno() {
        return this.fechaRetorno;
    }

    public void setFechaRetorno(Date fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
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

   
@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="actividades_extracurriculares_por_incidencias", catalog="db_sigera", joinColumns = { 
        @JoinColumn(name="ID_ACTIVIDADES_EXTRACURRICULARES", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="ID_INCIDENCIAS", nullable=false, updatable=false) })
    public Set<Incidencias> getIncidenciases() {
        return incidenciases;
    }

    public void setIncidenciases(Set<Incidencias> incidenciases) {
        this.incidenciases = incidenciases;
    }

}
