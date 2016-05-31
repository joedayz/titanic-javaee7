package com.titanic.ventapasajes.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "pvm_fila")
public class Fila implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long ideFila;
    private List<Asiento> asientos;
    private boolean primerPiso;
    private Bus bus;




    @Id
    @GeneratedValue
    @Column(name="ide_fila", nullable = false, length= 10)
    public Long getIdeFila() {
        return ideFila;
    }

    public void setIdeFila(Long ideAsiento) {
        this.ideFila = ideAsiento;
    }

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.LAZY)
    @JoinTable(name="pvr_fila_asientos",
            joinColumns={@JoinColumn(name="ide_fila", referencedColumnName="ide_fila")},
            inverseJoinColumns={@JoinColumn(name="ide_asiento", referencedColumnName="ide_asiento")})
    public List<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asiento> asientos) {
        this.asientos = asientos;
    }


    @Column(name="es_primer_piso")
    public boolean isPrimerPiso() {
        return primerPiso;
    }

    public void setPrimerPiso(boolean primerPiso) {
        this.primerPiso = primerPiso;
    }

    @ManyToOne
    @JoinColumn(name = "ide_bus", nullable = false)
    public Bus getBus() {
        return bus;
    }



    public void setBus(Bus bus) {
        this.bus = bus;
    }






    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((ideFila == null) ? 0 : ideFila.hashCode());
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
        Fila other = (Fila) obj;
        if (ideFila == null) {
            if (other.ideFila != null)
                return false;
        } else if (!ideFila.equals(other.ideFila))
            return false;
        return true;
    }




}