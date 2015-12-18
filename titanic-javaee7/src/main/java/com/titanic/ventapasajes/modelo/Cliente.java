package com.titanic.ventapasajes.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@Entity
@Table(name = "pvm_cliente")
public class Cliente implements Serializable{


    private static final long serialVersionUID = 1L;

	private Long ideCliente;
	private String nombreCliente;
	private String email;
	private String numeroDocumento;
	private TipoPersona tipoPersona;
	private TipoDocumento tipoDocumento;
	private Sexo sexo;
    private int edad;
	private String numeroTelefono;
    private boolean debePresentarCartaNotarial = false;
	
	@Id
	@GeneratedValue
	@Column(name="ide_cliente", nullable = false, length= 10)
	public Long getIdeCliente() {
		return ideCliente;
	}
	public void setIdeCliente(Long ideCliente) {
		this.ideCliente = ideCliente;
	}
	
	@NotBlank
	@Column(name="nombre_cliente", nullable=false, length = 255)
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_persona", nullable=false, length = 50)
	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}
	
	public void setTipoPersona(TipoPersona tipo) {
		this.tipoPersona = tipo;
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
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_documento", nullable=false, length = 50)
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Column(name="email", unique=true, nullable=true, length = 100)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotBlank
	@Column(name="numero_documento", unique=true, nullable=false, length = 11)
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	@Column(name="numero_telefono",  nullable=true, length = 100)
	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	@Column(name="edad", nullable = false, length = 3)
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        return numeroDocumento;

    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ideCliente == null) ? 0 : ideCliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (ideCliente == null) {
			if (other.ideCliente != null)
				return false;
		} else if (!ideCliente.equals(other.ideCliente))
			return false;
		return true;
	}

    @Transient
    public boolean isDebePresentarCartaNotarial() {
        return debePresentarCartaNotarial;
    }

    public void setDebePresentarCartaNotarial(boolean debePresentarCartaNotarial) {
        this.debePresentarCartaNotarial = debePresentarCartaNotarial;
    }
}
