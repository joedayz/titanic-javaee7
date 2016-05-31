package com.titanic.ventapasajes.modelo;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by josediaz on 1/11/16.
 */
@Entity
@Table(name = "pvm_tripulante")
public class Tripulante implements Serializable{


    private static final long serialVersionUID = 1L;


    private Long ideTripulante;
    private TipoDocumento tipoDocumento;
    private String nroDocumento;
    private Seguridad seguridad;
    private String nombres;
    private String apellidos;
    private Sexo sexo;
    private Date fechaNacimiento;

    private HojaRuta hojaRuta;


    @Id
    @GeneratedValue
    @Column(name="ide_tripulante", nullable = false, length= 10)
    public Long getIdeTripulante() {
        return ideTripulante;
    }

    public void setIdeTripulante(Long ideTripulante) {
        this.ideTripulante = ideTripulante;
    }



    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_documento", nullable=false, length = 50)
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    @NotBlank
    @Column(name="numero_documento", unique=true, nullable=false, length = 11)
    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    @Transient
    public Seguridad getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(Seguridad seguridad) {
        this.seguridad = seguridad;
    }

    @NotBlank
    @Column(name="nombres", nullable=false, length = 255)
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @NotBlank
    @Column(name="apellidos", nullable=false, length = 255)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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


    @ManyToOne
    @JoinColumn(name = "ide_hoja_ruta", nullable = false)
    public HojaRuta getHojaRuta() {
        return hojaRuta;
    }

    public void setHojaRuta(HojaRuta hojaRuta) {
        this.hojaRuta = hojaRuta;
    }



    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tripulante that = (Tripulante) o;
        return Objects.equals(ideTripulante, that.ideTripulante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ideTripulante);
    }

    @Override
    public String toString() {
        return "Tripulante{" +
                "ideTripulante=" + ideTripulante +
                ", tipoDocumento=" + tipoDocumento +
                ", nroDocumento='" + nroDocumento + '\'' +
                ", seguridad=" + seguridad +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", sexo=" + sexo +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
