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
@Table(name = "tipo_examen", catalog = "db_sigera")
public class TipoExamen implements java.io.Serializable {

    private Integer id;
    private String nombre;
    private Set<Examen> examenes = new HashSet(0);

    public TipoExamen() {
    }

    public TipoExamen(String vcNombre) {
        this.nombre = vcNombre;
    }

    public TipoExamen(String vcNombre, Set examens) {
        this.nombre = vcNombre;
        this.examenes = examens;
    }

    @Id
    @Column(name = "ID_TIPO_EXAMEN", unique = true, nullable = false)
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoExamen")
    public Set<Examen> getExamenes() {
        return this.examenes;
    }

    public void setExamenes(Set<Examen> examenes) {
        this.examenes = examenes;
    }
}
