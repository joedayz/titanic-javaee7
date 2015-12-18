package com.titanic.ventapasajes.modelo;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by josediaz on 7/24/14.
 */
@Entity
@Table(name = "pvm_tarifa_general")
public class TarifaGeneral implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long ideTarifaGeneral;
    private String tipoPasaje;  //para describir que tipo de pasaje es: adulto, niño, tercera edad
    private TipoAsiento tipoAsiento;
    private BigDecimal precio;
    private Recorrido recorrido;


    @Id
    @GeneratedValue
    @Column(name="ide_tarifa_general", nullable = false, length= 10)
    public Long getIdeTarifaGeneral() {
        return ideTarifaGeneral;
    }

    public void setIdeTarifaGeneral(Long ideTarifaGeneral) {
        this.ideTarifaGeneral = ideTarifaGeneral;
    }

    @NotBlank
    @Column(name="tipo_pasaje", nullable=false, length = 50)
    public String getTipoPasaje() {
        return tipoPasaje;
    }

    public void setTipoPasaje(String tipoPasaje) {
        this.tipoPasaje = tipoPasaje;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_bus",nullable = false, length = 20)
    public TipoAsiento getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(TipoAsiento tipoBus) {
        this.tipoAsiento = tipoBus;
    }

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @ManyToOne
    @JoinColumn(name = "ide_recorrido", nullable = false)
    public Recorrido getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(Recorrido recorrido) {
        this.recorrido = recorrido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TarifaGeneral that = (TarifaGeneral) o;

        if (ideTarifaGeneral != null ? !ideTarifaGeneral.equals(that.ideTarifaGeneral) : that.ideTarifaGeneral != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ideTarifaGeneral != null ? ideTarifaGeneral.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "TarifaGeneral{" +
                "ideTarifaGeneral=" + ideTarifaGeneral +
                ", tipoPasaje='" + tipoPasaje + '\'' +
                ", tipoAsiento=" + tipoAsiento +
                ", precio=" + precio +
                ", recorrido=" + recorrido +
                '}';
    }
}
