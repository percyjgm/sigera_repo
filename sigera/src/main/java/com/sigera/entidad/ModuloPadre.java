package com.sigera.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MODULO_PADRE")
public class ModuloPadre implements Serializable, Comparable<ModuloPadre> {

    @Id
    @GeneratedValue
    @Column(name = "ID_MODULO_PADRE")
    Integer id;

    @Column(name = "VC_NOMBRE")
    String nombre;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "moduloPadre")
    Set<Modulo> modulos = new HashSet<Modulo>(0);

    public ModuloPadre() {
    }

    public ModuloPadre(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public int compareTo(ModuloPadre o) {
       if(getId().intValue() > o.getId().intValue())
        {
            return 1;
        }else if(getId().intValue() < o.getId().intValue()){
            return -1;
        }
        return 0;
    }
     private static final long serialVersionUID = 5484956788727859988L;
    @Override
    public String toString() {
        return String.format("ModuloPadre{id = %d, nombre = %s}",getId(),getNombre());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }
    
}