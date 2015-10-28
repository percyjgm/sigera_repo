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
@Table(name = "tipo_apoderado", catalog = "db_sigera")
public class TipoApoderado implements java.io.Serializable {

    private int id;
    private String descripcion;
    private Set<Apoderado> apoderados = new HashSet(0);

    public TipoApoderado() {
    }

    @Id
    @Column(name = "ID_TIPO_APODERADO", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "VC_DESCRIPCION", nullable = false, length = 100)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoApoderado")
    public Set<Apoderado> getApoderados() {
        return this.apoderados;
    }

    public void setApoderados(Set<Apoderado> apoderados) {
        this.apoderados = apoderados;
    }

}
