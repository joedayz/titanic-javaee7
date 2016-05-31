package com.titanic.ventapasajes.modelo;

/**
 * Created by josediaz on 12/18/15.
 */

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
@Entity
@Table(name = "pvm_programacion")
public class Programacion implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -2197964758413800707L;
    private Long ideProgramacion;
    private Recorrido ruta;
    private Bus bus;
    private Date fechaSalida;
    private String horaSalida;
    private Date fechaEstLlegada;
    private String horaLlegada;
    private TipoProgramacion tipoProgramacion;


    @Id
    @GeneratedValue
    @Column(name = "ide_programacion", nullable = false, length = 10)
    public Long getIdeProgramacion() {
        return ideProgramacion;
    }

    public void setIdeProgramacion(Long ideProgramacion) {
        this.ideProgramacion = ideProgramacion;
    }



    @ManyToOne
    @JoinColumn(name = "ide_recorrido", nullable = false)
    public Recorrido getRuta() {
        return ruta;
    }

    public void setRuta(Recorrido ruta) {
        this.ruta = ruta;
    }


    @ManyToOne
    @JoinColumn(name = "ide_bus", nullable = false)
    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }


    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_salida", nullable = false)
    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaProgramacion) {
        this.fechaSalida = fechaProgramacion;
    }


    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_est_llegada", nullable = false)
    public Date getFechaEstLlegada() {
        return fechaEstLlegada;
    }

    public void setFechaEstLlegada(Date fechaEstLlegada) {
        this.fechaEstLlegada = fechaEstLlegada;
    }



    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_programacion", nullable = true, length = 50)
    public TipoProgramacion getTipoProgramacion() {
        return tipoProgramacion;
    }

    public void setTipoProgramacion(TipoProgramacion tipoProgramacion) {
        this.tipoProgramacion = tipoProgramacion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Programacion that = (Programacion) o;

        if (ideProgramacion != null ? !ideProgramacion.equals(that.ideProgramacion) : that.ideProgramacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ideProgramacion != null ? ideProgramacion.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Programacion{" +
                "ideProgramacion=" + ideProgramacion +
                ", fechaProgramacion=" + fechaSalida +
                ", ruta=" + ruta +
                ", bus=" + bus +
                ", horaSalida='" + horaSalida + '\'' +
                ", horaLlegada='" + horaLlegada + '\'' +
                ", tipoProgramacion=" + tipoProgramacion +
                '}';
    }


}
