package com.titanic.ventapasajes.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by josediaz on 12/27/15.
 */
@Entity
@Table(name = "pvm_fila_boleto")
public class FilaBoleto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long ideFila;
    private List<Boleto> boletos;
    private boolean primerPiso;
    private Venta venta;

    @Id
    @GeneratedValue
    @Column(name="ide_fila", nullable = false, length= 10)
    public Long getIdeFila() {
        return ideFila;
    }

    public void setIdeFila(Long ideFila) {
        this.ideFila = ideFila;
    }


    @OneToMany(mappedBy = "filaBoleto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OrderBy("ide_boleto ASC")
    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }


    @Column(name="es_primer_piso")
    public boolean isPrimerPiso() {
        return primerPiso;
    }

    public void setPrimerPiso(boolean primerPiso) {
        this.primerPiso = primerPiso;
    }

    @ManyToOne
    @JoinColumn(name = "ide_venta", nullable = false)
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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
        FilaBoleto other = (FilaBoleto) obj;
        if (ideFila == null) {
            if (other.ideFila != null)
                return false;
        } else if (!ideFila.equals(other.ideFila))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "FilaBoleto{" +
                "ideFila=" + ideFila +
                ", boletos=" + boletos +
                ", primerPiso=" + primerPiso +
                ", venta=" + venta +
                '}';
    }
}
