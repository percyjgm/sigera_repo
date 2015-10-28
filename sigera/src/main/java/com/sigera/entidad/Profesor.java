package com.sigera.entidad;

import java.io.Serializable;
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

@Entity
@Table(name = "profesor", catalog = "db_sigera")
public class Profesor implements Serializable {

    private Integer id;
    private Persona persona;
    private boolean estado;
    private Set<Seccion> seccions = new HashSet(0);
    private Set<ActividadesExtracurriculares> actividadesExtracurriculareses = new HashSet(0);
    private Set<CursoPorProfesor> cursoPorProfesors = new HashSet(0);
    
    public Profesor() {
    }

    @Id
    @Column(name = "ID_PROFESOR", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSONA", nullable = false)
    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Column(name = "TY_ESTADO", nullable = false)
    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

   
    

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profesor")
    public Set<ActividadesExtracurriculares> getActividadesExtracurriculareses() {
        return this.actividadesExtracurriculareses;
    }
 @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="tutor", catalog="db_sigera", joinColumns = { 
        @JoinColumn(name="ID_PROFESOR", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="ID_SECCION", nullable=false, updatable=false) })
    public Set<Seccion> getSeccions() {
        return seccions;
    }

    public void setSeccions(Set<Seccion> seccions) {
        this.seccions = seccions;
    }

    public void setActividadesExtracurriculareses(Set<ActividadesExtracurriculares> actividadesExtracurriculareses) {
        this.actividadesExtracurriculareses = actividadesExtracurriculareses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profesor")
    public Set<CursoPorProfesor> getCursoPorProfesors() {
        return this.cursoPorProfesors;
    }

    public void setCursoPorProfesors(Set<CursoPorProfesor> cursoPorProfesors) {
        this.cursoPorProfesors = cursoPorProfesors;
    }

}
