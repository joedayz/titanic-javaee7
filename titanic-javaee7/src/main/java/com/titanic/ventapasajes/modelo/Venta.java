package com.titanic.ventapasajes.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by josediaz on 12/27/15.
 */
@Entity
@Table(name = "pvm_venta")
public class Venta implements Serializable {

    private static final long serialVersionUID = -2197964758413800707L;
    private Long ideVenta;
    private Programacion programacion;
    private BigDecimal totalVenta;

    private List<FilaBoleto> filasBoletos;

    @Id
    @GeneratedValue
    @Column(name="ide_venta", nullable = false, length= 10)
    public Long getIdeVenta() {
        return ideVenta;
    }

    public void setIdeVenta(Long ideVenta) {
        this.ideVenta = ideVenta;
    }




    @ManyToOne
    @JoinColumn(name = "ide_programacion", nullable = false)
    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }


    @NotNull
    @Column(name = "total_venta", nullable = false, precision = 10, scale = 2)
    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }




    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<FilaBoleto> getFilasBoletos() {
        return filasBoletos;
    }

    public void setFilasBoletos(List<FilaBoleto> filasBoletos) {
        this.filasBoletos = filasBoletos;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venta venta = (Venta) o;

        if (ideVenta != null ? !ideVenta.equals(venta.ideVenta) : venta.ideVenta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ideVenta != null ? ideVenta.hashCode() : 0;
    }

}
