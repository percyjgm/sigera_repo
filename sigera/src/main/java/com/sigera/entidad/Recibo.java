package com.sigera.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "recibo", catalog = "db_sigera")
public class Recibo implements Serializable {

    private Integer id;
    private Alumno alumno;
    private TipoPago tipoPago;
    private double subtotal;
    private double igv;
    private double mora;
    private double total;
    private Date fechaEmision;

    public Recibo() {
    }

    @Id
    @Column(name = "ID_RECIBO", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ALUMNO", nullable = false)
    public Alumno getAlumno() {
        return this.alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_PAGO", nullable = false)
    public TipoPago getTipoPago() {
        return this.tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Column(name = "DB_SUBTOTAL", nullable = false, precision = 22, scale = 0)
    public double getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Column(name = "DB_IGV", nullable = false, precision = 22, scale = 0)
    public double getIgv() {
        return this.igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    @Column(name = "DB_MORA", nullable = false, precision = 22, scale = 0)
    public double getMora() {
        return this.mora;
    }

    public void setMora(double mora) {
        this.mora = mora;
    }

    @Column(name = "DB_TOTAL", nullable = false, precision = 22, scale = 0)
    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_FECHA_EMISION", nullable = false, length = 19)
    public Date getFechaEmision() {
        return this.fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

}
