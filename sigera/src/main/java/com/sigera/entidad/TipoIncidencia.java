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
@Table(name = "tipo_incidencia", catalog = "db_sigera")
public class TipoIncidencia implements java.io.Serializable {

    private Integer id;
    private String nombre;
    private Set<Incidencias> incidencias = new HashSet(0);

    public TipoIncidencia() {
    }

    @Id
    @Column(name = "ID_TIPO_INCIDENCIA", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "VC_NOMBRE", nullable = false, length = 100)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoIncidencia")
    public Set<Incidencias> getIncidencias() {
        return this.incidencias;
    }

    public void setIncidencias(Set<Incidencias> incidencias) {
        this.incidencias = incidencias;
    }

}
