package com.titanic.ventapasajes.modelo;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by josediaz on 12/18/15.
 */
@Entity
@Table(name = "pvm_conductor")
public class Conductor implements Serializable{



    private static final long serialVersionUID = 1L;

    private Long ideConductor;
    private String nombreConductor;
    private String numeroDocumento;
    private Date fechaNacimiento;

    private String numeroLicencia;
    private Date fechaExpedicion;
    private Date fechaRevalidacion;
    private boolean estado;

    private String entidad;
    private String localidad;
    private String numeroCertificado;
    private Date fechaCaducidad;
    private boolean estadoCapacitacion;

    private Sexo sexo;



    @Id
    @GeneratedValue
    @Column(name="ide_conductor", nullable = false, length= 10)
    public Long getIdeConductor() {
        return ideConductor;
    }

    public void setIdeConductor(Long ideConductor) {
        this.ideConductor = ideConductor;
    }

    @NotBlank
    @Column(name="nombre_conductor", nullable=false, length = 255)
    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }


    @NotBlank
    @Column(name="numero_documento", unique=true, nullable=false, length = 11)
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }



    @Column(name="numero_licencia", unique=true,  length = 11)
    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }



    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_expedicion")
    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }



    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_revalidacion")
    public Date getFechaRevalidacion() {
        return fechaRevalidacion;
    }

    public void setFechaRevalidacion(Date fechaRevalidacion) {
        this.fechaRevalidacion = fechaRevalidacion;
    }


    @Column(name="vigente")
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    @Column(name="nombre_entidad",  length = 255)
    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }


    @Column(name="localidad",  length = 100)
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }


    @Column(name="numero_certificado", length = 20)
    public String getNumeroCertificado() {
        return numeroCertificado;
    }

    public void setNumeroCertificado(String numeroCertificado) {
        this.numeroCertificado = numeroCertificado;
    }



    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_caducidad")
    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Column(name="vigente_capacitacion")
    public boolean isEstadoCapacitacion() {
        return estadoCapacitacion;
    }


    public void setEstadoCapacitacion(boolean estadoCapacitacion) {
        this.estadoCapacitacion = estadoCapacitacion;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="sexo", nullable=false, length = 50)
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conductor other = (Conductor) obj;
        if (ideConductor == null) {
            if (other.ideConductor != null)
                return false;
        } else if (!ideConductor.equals(other.ideConductor))
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((ideConductor == null) ? 0 : ideConductor.hashCode());
        return result;
    }
}
