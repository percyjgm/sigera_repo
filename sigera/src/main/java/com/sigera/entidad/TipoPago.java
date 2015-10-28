package com.sigera.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_pago", catalog = "db_sigera")
public class TipoPago implements Serializable {

    private Integer id;
    private String nombre;
    private double precio;
    private Set<Recibo> recibo = new HashSet(0);

    public TipoPago() {
    }

    @Id
    @Column(name = "ID_TIPO_PAGO", unique = true, nullable = false)
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

    @Column(name = "DB_PRECIO", nullable = false, precision = 22, scale = 0)
    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoPago")
    public Set<Recibo> getRecibo() {
        return this.recibo;
    }

    public void setRecibo(Set<Recibo> recibo) {
        this.recibo = recibo;
    }

}
