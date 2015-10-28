package com.sigera.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "horario", catalog = "db_sigera")
public class Horario implements Serializable {

    private Integer id;
    private Salon salon;
    private String diaClases;
    private String horaInicio;
    private String horaFinal;
    private Set<CursoPorProfesor> cursoPorProfesors = new HashSet(0);

    public Horario() {
    }

    @Id
    @Column(name = "ID_HORARIO", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SALON", nullable = false)
    public Salon getSalon() {
        return this.salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    @Column(name = "VC_DIA_CLASES", nullable = false, length = 45)
    public String getDiaClases() {
        return this.diaClases;
    }

    public void setDiaClases(String diaClases) {
        this.diaClases = diaClases;
    }

    @Column(name = "VC_HORA_INICIO", nullable = false, length = 45)
    public String getHoraInicio() {
        return this.horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Column(name = "VC_HORA_FINAL", nullable = false, length = 45)
    public String getHoraFinal() {
        return this.horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "horario")
    public Set<CursoPorProfesor> getCursoPorProfesors() {
        return this.cursoPorProfesors;
    }

    public void setCursoPorProfesors(Set<CursoPorProfesor> cursoPorProfesors) {
        this.cursoPorProfesors = cursoPorProfesors;
    }

}
