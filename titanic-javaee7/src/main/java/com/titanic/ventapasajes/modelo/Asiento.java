package com.titanic.ventapasajes.modelo;

/**
 * Created by josediaz on 12/13/15.
 */
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by josediaz on 12/11/15.
 */


@Entity
@Table(name = "pvm_asiento")
public class Asiento implements Serializable{


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long ideAsiento;
    private String numeroAsiento;
    private boolean asiento;  //para ver si es asiento o no es asiento
    private boolean primerPiso;  //para ver si es de primer piso o segundo piso
    private TipoAsiento tipoAsiento;


    private Fila  fila;

    public Asiento(){}

    public Asiento(String numeroAsiento, TipoAsiento tipoAsiento, boolean asiento, boolean primerPiso, Fila fila){
        this.numeroAsiento = numeroAsiento;
        this.tipoAsiento = tipoAsiento;
        this.asiento = asiento;
        this.primerPiso = primerPiso;
        this.fila = fila;
    }


    @Id
    @GeneratedValue
    @Column(name="ide_asiento", nullable = false, length= 10)
    public Long getIdeAsiento() {
        return ideAsiento;
    }

    public void setIdeAsiento(Long ideAsiento) {
        this.ideAsiento = ideAsiento;
    }


    @Column(name="numero_asiento", nullable=true, length=10)
    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    @Column(name="es_asiento")
    public boolean isAsiento() {
        return asiento;
    }

    public void setAsiento(boolean asiento) {
        this.asiento = asiento;
    }


    @Column(name="es_primer_piso")
    public boolean isPrimerPiso() {
        return primerPiso;
    }

    public void setPrimerPiso(boolean primerPiso) {
        this.primerPiso = primerPiso;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_asiento", nullable=false, length = 50)
    public TipoAsiento getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(TipoAsiento tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }



    @ManyToOne
    @JoinColumn(name = "ide_fila", nullable = false)
    public Fila getFila() {
        return fila;
    }


    public void setFila(Fila fila) {
        this.fila = fila;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((ideAsiento == null) ? 0 : ideAsiento.hashCode());
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
        Asiento other = (Asiento) obj;
        if (ideAsiento == null) {
            if (other.ideAsiento != null)
                return false;
        } else if (!ideAsiento.equals(other.ideAsiento))
            return false;
        return true;
    }

}