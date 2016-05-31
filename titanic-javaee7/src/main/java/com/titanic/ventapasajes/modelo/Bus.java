package com.titanic.ventapasajes.modelo;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by josediaz on 12/13/15.
 */
@Entity
@Table(name = "pvm_bus")
public class Bus implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private Long ideBus;
    private String descripcionBus;
    private String placa;
    private String numeroMotor;
    private Boolean conAireAcondicionado;
    private List<Fila> filas;
    private TipoPlanta tipoPlanta;


    @Id
    @GeneratedValue
    @Column(name="ide_bus", nullable = false, length= 10)
    public Long getIdeBus() {
        return ideBus;
    }

    public void setIdeBus(Long ideBus) {
        this.ideBus = ideBus;
    }


    @NotBlank
    @Column(name="descripcion_bus", nullable=false, length = 255)
    public String getDescripcionBus() {
        return descripcionBus;
    }

    public void setDescripcionBus(String descripcionBus) {
        this.descripcionBus = descripcionBus;
    }

    @NotBlank
    @Column(name="placa", nullable=false, length = 10)
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Column(name="numero_motor", nullable=true, length = 50)
    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    @Column(name="con_aire_acondicionado")
    public Boolean getConAireAcondicionado() {
        return conAireAcondicionado;
    }

    public void setConAireAcondicionado(Boolean conAireAcondicionado) {
        this.conAireAcondicionado = conAireAcondicionado;
    }

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.LAZY)
    @JoinTable(name="pvr_bus_filas",
            joinColumns={@JoinColumn(name="ide_bus", referencedColumnName="ide_bus")},
            inverseJoinColumns={@JoinColumn(name="ide_fila", referencedColumnName="ide_fila")})
    public List<Fila> getFilas() {
        return filas;
    }

    public void setFilas(List<Fila> filas) {
        this.filas = filas;
    }


    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_planta", nullable=false, length = 50)
    public TipoPlanta getTipoPlanta() {
        return tipoPlanta;
    }
    public void setTipoPlanta(TipoPlanta tipoPlanta) {
        this.tipoPlanta = tipoPlanta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ideBus == null) ? 0 : ideBus.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bus other = (Bus) obj;
        if (ideBus == null) {
            if (other.ideBus != null)
                return false;
        } else if (!ideBus.equals(other.ideBus))
            return false;
        return true;
    }

}
