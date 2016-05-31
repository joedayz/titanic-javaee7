package com.titanic.ventapasajes.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by josediaz on 12/27/15.
 */
@Entity
@Table(name = "pvm_boleto")
public class Boleto implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long ideBoleto;
    private String numeroBoleto;


    private boolean asiento;  //para ver si es asiento o no es asiento
    private boolean primerPiso;  //para ver si es de primer piso o segundo piso

    private EstadoAsiento estadoBoleto;
    private FilaBoleto filaBoleto;

    private TipoAsiento calidad;

    private BigDecimal precio;
    private Cliente cliente;
    private Terminal terminal;

    private Usuario usuario;
    private Boolean presentoCartaNotarial;

    //campos para facilidad en la generacion del reporte
    private String numeroDocumento;
    private String nombresCliente;
    private Date fechaVenta;
    private String horaSalida;
    private String origen;
    private String destino;


    @Id
    @GeneratedValue
    @Column(name="ide_boleto", nullable = false, length= 10)
    public Long getIdeBoleto() {
        return ideBoleto;
    }

    public void setIdeBoleto(Long ideBoleto) {
        this.ideBoleto = ideBoleto;
    }


    @Size(max = 10)
    @Column(name="numero_boleto", nullable=false, length=10)
    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }


    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="estado_boleto", nullable=false, length = 50)
    public EstadoAsiento getEstadoBoleto() {
        return estadoBoleto;
    }

    public void setEstadoBoleto(EstadoAsiento estadoBoleto) {
        this.estadoBoleto = estadoBoleto;
    }



    @ManyToOne
    @JoinColumn(name = "ide_fila", nullable = false)
    public FilaBoleto getFilaBoleto() {
        return filaBoleto;
    }

    public void setFilaBoleto(FilaBoleto filaBoleto) {
        this.filaBoleto = filaBoleto;
    }



    @Enumerated(EnumType.STRING)
    @Column(name="tipo_asiento", nullable=true, length = 50)
    public TipoAsiento getCalidad() {
        return calidad;
    }

    public void setCalidad(TipoAsiento calidad) {
        this.calidad = calidad;
    }



    @NotNull
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }


    @ManyToOne
    @JoinColumn(name = "ide_cliente", nullable = true)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    @ManyToOne
    @JoinColumn(name = "ide_terminal", nullable = true)
    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    @ManyToOne
    @JoinColumn(name = "vendedor", nullable = true)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @Column(name="presento_carta_notarial", nullable = true)
    public Boolean getPresentoCartaNotarial() {
        return presentoCartaNotarial;
    }

    public void setPresentoCartaNotarial(Boolean presentoCartaNotarial) {
        this.presentoCartaNotarial = presentoCartaNotarial;
    }

    @Column(name="numero_documento", nullable=true, length=10)
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }


    @Column(name="nombre_cliente", nullable=true, length = 255)
    public String getNombresCliente() {
        return nombresCliente;
    }

    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_venta", nullable = true)
    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Column(name="hora_salida", nullable=true, length = 10)
    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Column(name="origen", nullable=true, length = 50)
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Column(name="destino", nullable=true, length = 50)
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((ideBoleto == null) ? 0 : ideBoleto.hashCode());
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
        Boleto other = (Boleto) obj;
        if (ideBoleto == null) {
            if (other.ideBoleto != null)
                return false;
        } else if (!ideBoleto.equals(other.ideBoleto))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Boleto{" +
                "ideBoleto=" + ideBoleto +
                ", numeroBoleto='" + numeroBoleto + '\'' +
                ", asiento=" + asiento +
                ", primerPiso=" + primerPiso +
                ", estadoBoleto=" + estadoBoleto +
                ", filaBoleto=" + filaBoleto +
                ", calidad=" + calidad +
                ", precio=" + precio +
                ", cliente=" + cliente +
                ", terminal=" + terminal +
                ", usuario=" + usuario +
                ", presentoCartaNotarial=" + presentoCartaNotarial +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", nombresCliente='" + nombresCliente + '\'' +
                ", fechaVenta=" + fechaVenta +
                ", horaSalida='" + horaSalida + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                '}';
    }
}
