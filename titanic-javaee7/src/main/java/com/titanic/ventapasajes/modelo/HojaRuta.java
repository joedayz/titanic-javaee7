package com.titanic.ventapasajes.modelo;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by josediaz on 1/11/16.
 */

@Entity
@Table(name = "pvm_hoja_ruta")
public class HojaRuta implements Serializable {



    private static final long serialVersionUID = 1L;




    private Long ideHojaRuta;
    private String codigoHojaRuta;
    private Seguridad seguridad;
    private Programacion programacion;
    private List<HConductor> conductores;
    private List<Tripulante> tripulantes;
    private EstadoHojaRuta estadoHojaRuta;
    private Date fechaRegistro;



    @Id
    @GeneratedValue
    @Column(name="ide_hoja_ruta", nullable = false, length= 10)
    public Long getIdeHojaRuta() {
        return ideHojaRuta;
    }

    public void setIdeHojaRuta(Long ideHojaRuta) {
        this.ideHojaRuta = ideHojaRuta;
    }


    @Column(name="codigo_hoja_ruta", nullable=true, length = 255)
    public String getCodigoHojaRuta() {
        return codigoHojaRuta;
    }

    public void setCodigoHojaRuta(String codigoHojaRuta) {
        this.codigoHojaRuta = codigoHojaRuta;
    }

    @Transient
    public Seguridad getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(Seguridad seguridad) {
        this.seguridad = seguridad;
    }


    @ManyToOne
    @JoinColumn(name = "ide_programacion", nullable = false)
    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.LAZY)
    @JoinTable(name="pvr_hoja_ruta_conductores",
            joinColumns={@JoinColumn(name="ide_hoja_ruta", referencedColumnName="ide_hoja_ruta")},
            inverseJoinColumns={@JoinColumn(name="ide_conductor", referencedColumnName="ide_conductor")})
    public List<HConductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<HConductor> conductores) {
        this.conductores = conductores;
    }

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.LAZY)
    @JoinTable(name="pvr_hoja_ruta_tripulantes",
            joinColumns={@JoinColumn(name="ide_hoja_ruta", referencedColumnName="ide_hoja_ruta")},
            inverseJoinColumns={@JoinColumn(name="ide_tripulante", referencedColumnName="ide_tripulante")})
    public List<Tripulante> getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(List<Tripulante> tripulantes) {
        this.tripulantes = tripulantes;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="estado", nullable=false, length = 50)
    public EstadoHojaRuta getEstadoHojaRuta() {
        return estadoHojaRuta;
    }

    public void setEstadoHojaRuta(EstadoHojaRuta estadoHojaRuta) {
        this.estadoHojaRuta = estadoHojaRuta;
    }


    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro", nullable = false)
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HojaRuta hojaRuta = (HojaRuta) o;
        return Objects.equals(ideHojaRuta, hojaRuta.ideHojaRuta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ideHojaRuta);
    }

    @Override
    public String toString() {
        return "HojaRuta{" +
                "ideHojaRuta=" + ideHojaRuta +
                ", codigoHojaRuta='" + codigoHojaRuta + '\'' +
                ", seguridad=" + seguridad +
                ", programacion=" + programacion +
                ", conductores=" + conductores +
                ", tripulantes=" + tripulantes +
                ", estadoHojaRuta=" + estadoHojaRuta +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
