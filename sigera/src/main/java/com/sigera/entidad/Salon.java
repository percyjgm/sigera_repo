package com.sigera.entidad;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "salon", catalog = "db_sigera")
public class Salon implements java.io.Serializable {

    private Integer id;
    private String nombre;
    private boolean estado;
    private Set<Horario> horarios = new HashSet(0);

    public Salon() {
    }

    public Salon(String vcNombre, boolean tyEstado) {
        this.nombre = vcNombre;
        this.estado = tyEstado;
    }

    public Salon(String vcNombre, boolean tyEstado, Set horarios) {
        this.nombre = vcNombre;
        this.estado = tyEstado;
        this.horarios = horarios;
    }

    @Id
    @Column(name = "ID_SALON", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "VC_NOMBRE", nullable = false, length = 45)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "TY_ESTADO", nullable = false)
    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "salon")
    public Set<Horario> getHorarios() {
        return this.horarios;
    }

    public void setHorarios(Set<Horario> horarios) {
        this.horarios = horarios;
    }

}
