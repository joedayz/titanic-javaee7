package com.titanic.ventapasajes.modelo;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by josediaz on 7/24/14.
 */
@Entity
@Table(name = "pvm_recorrido")
public class Recorrido implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private Long ideRecorrido;
    private String codeRuta;
    private String ruta;  //nombre corto FIORI-CHICLAYO   FIORI-ZAPALLAL-CHICLAYO PLAZANORTE-CHICLAYO
    private Terminal origen;
    private Terminal destino;
    private List<TarifaGeneral> precios;


    @Id
    @GeneratedValue
    @Column(name="ide_recorrido", nullable = false, length= 10)
    public Long getIdeRecorrido() {
        return ideRecorrido;
    }

    public void setIdeRecorrido(Long ideRecorrido) {
        this.ideRecorrido = ideRecorrido;
    }


    @NotBlank
    @Column(name="code_ruta", nullable=false, length = 50)
    public String getCodeRuta() {
        return codeRuta;
    }

    public void setCodeRuta(String codeRuta) {
        this.codeRuta = codeRuta;
    }

    @NotBlank
    @Column(name="ruta", nullable=false, length = 500)
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }


    @ManyToOne(cascade = CascadeType.ALL)
         @JoinColumn(name = "terminal_origen", nullable = false)
         public Terminal getOrigen() {
        return origen;
    }

    public void setOrigen(Terminal origen) {
        this.origen = origen;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "terminal_destino", nullable = false)
    public Terminal getDestino() {
        return destino;
    }

    public void setDestino(Terminal destino) {
        this.destino = destino;
    }



    @OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true , fetch = FetchType.LAZY)
    @JoinTable(name="pvr_recorrido_tarifa_general", joinColumns={@JoinColumn(name="ide_recorrido", referencedColumnName="ide_recorrido")}, inverseJoinColumns={@JoinColumn(name="ide_tarifa_general", referencedColumnName="ide_tarifa_general")})
    public List<TarifaGeneral> getPrecios() {
        return precios;
    }

    public void setPrecios(List<TarifaGeneral> precios) {
        this.precios = precios;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recorrido recorrido = (Recorrido) o;

        if (ideRecorrido != null ? !ideRecorrido.equals(recorrido.ideRecorrido) : recorrido.ideRecorrido != null)
            return false;

        return true;
    }




    @Override
    public int hashCode() {
        return ideRecorrido != null ? ideRecorrido.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Recorrido{" +
                "ideRecorrido=" + ideRecorrido +
                ", codeRuta='" + codeRuta + '\'' +
                ", ruta='" + ruta + '\'' +
                ", origen=" + origen +
                ", destino=" + destino +
                ", precios=" + precios +
                '}';
    }
}
