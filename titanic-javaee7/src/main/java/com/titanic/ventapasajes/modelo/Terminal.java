package com.titanic.ventapasajes.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "pvm_terminal")
public class Terminal implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private Long ideTerminal;
	private String codeTerminal;
	private String nombreTerminal;
	private String direccionTerminal;
    private String telefonosTerminal;

    public Terminal(){

    }

    public Terminal(Long ideTerminal, String nombreTerminal, String direccionTerminal, String telefonosTerminal) {
        this.ideTerminal = ideTerminal;
        this.nombreTerminal = nombreTerminal;
        this.direccionTerminal = direccionTerminal;
        this.telefonosTerminal = telefonosTerminal;
    }

    @Id
	@GeneratedValue
	@Column(name="ide_terminal", nullable = false, length= 10)
	public Long getIdeTerminal() {
		return ideTerminal;
	}
	public void setIdeTerminal(Long ideTerminal) {
		this.ideTerminal = ideTerminal;
	}

    @NotBlank
    @Column(name="code_terminal", nullable=false, length = 20)
    public String getCodeTerminal() {
        return codeTerminal;
    }

    public void setCodeTerminal(String codeTerminal) {
        this.codeTerminal = codeTerminal;
    }





    @NotBlank
	@Column(name="nombre_terminal", nullable=false, length = 255)
	public String getNombreTerminal() {
		return nombreTerminal;
	}
	public void setNombreTerminal(String nombreTerminal) {
		this.nombreTerminal = nombreTerminal;
	}
	
	@NotNull
	@Column(name="direccion_terminal", nullable=false, length = 1000)
	public String getDireccionTerminal() {
		return direccionTerminal;
	}
	public void setDireccionTerminal(String direccionTerminal) {
		this.direccionTerminal = direccionTerminal;
	}

    @Column(name="telefonos_terminal", nullable=true, length = 100)
    public String getTelefonosTerminal() {
        return telefonosTerminal;
    }

    public void setTelefonosTerminal(String telefonosTerminal) {
        this.telefonosTerminal = telefonosTerminal;
    }


    @Override
    public String toString() {
        return "Terminal{" +
                "ideTerminal=" + ideTerminal +
                ", nombreTerminal='" + nombreTerminal + '\'' +
                ", direccionTerminal='" + direccionTerminal + '\'' +
                ", telefonosTerminal='" + telefonosTerminal + '\'' +
                '}';
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ideTerminal == null) ? 0 : ideTerminal.hashCode());
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
		Terminal other = (Terminal) obj;
		if (ideTerminal == null) {
			if (other.ideTerminal != null)
				return false;
		} else if (!ideTerminal.equals(other.ideTerminal))
			return false;
		return true;
	}
	
	
	
}
