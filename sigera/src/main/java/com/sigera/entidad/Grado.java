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
@Table(name = "grado", catalog = "db_sigera")
public class Grado implements java.io.Serializable {

    private Integer idGrado;
    private String vcNombre;
    private Set<ListaMateriales> listaMaterialeses = new HashSet(0);
    private Set<Seccion> seccions = new HashSet(0);
    private Set<Matricula> matriculas = new HashSet(0);

    public Grado() {
    }

    @Id
    @Column(name = "ID_GRADO", unique = true, nullable = false)
    public Integer getIdGrado() {
        return this.idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    @Column(name = "VC_NOMBRE", nullable = false, length = 45)
    public String getVcNombre() {
        return this.vcNombre;
    }

    public void setVcNombre(String vcNombre) {
        this.vcNombre = vcNombre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grado")
    public Set<ListaMateriales> getListaMaterialeses() {
        return this.listaMaterialeses;
    }

    public void setListaMaterialeses(Set<ListaMateriales> listaMaterialeses) {
        this.listaMaterialeses = listaMaterialeses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grado")
    public Set<Seccion> getSeccions() {
        return this.seccions;
    }

    public void setSeccions(Set<Seccion> seccions) {
        this.seccions = seccions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grado")
    public Set<Matricula> getMatriculas() {
        return this.matriculas;
    }

    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

}
