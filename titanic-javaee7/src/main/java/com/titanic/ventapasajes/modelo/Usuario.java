package com.titanic.ventapasajes.modelo;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="pvm_usuario")
public class Usuario  implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long ideUsuario;
	private String nombreUsuario;
	private String email;
    private String dni;
	private String password;
    private Sexo sexo;
	private List<Grupo> grupos = new ArrayList<Grupo>();
    private boolean activo;
    
    private String colorPopup;
	
	@Id
	@GeneratedValue
	@Column(name="ide_usuario", nullable=false, length=10)
	public Long getIdeUsuario() {
		return ideUsuario;
	}
	public void setIdeUsuario(Long ideUsuario) {
		this.ideUsuario = ideUsuario;
	}


	@NotBlank
	@Column(name="nombre_usuario", nullable=false, unique=true,  length=50)
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@NotBlank
	@Column(name="email", nullable=false, unique=true,  length=50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@NotBlank
	@Column(name="password", nullable=false,  length=50)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany
	@JoinTable(name = "pvr_usuario_grupo", 
	joinColumns = @JoinColumn(name="ide_usuario"),
			inverseJoinColumns = @JoinColumn(name = "ide_grupo"))
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}


    @Column(name="activo")
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


    @Column(name="dni", nullable=false, unique=true,  length=10)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ideUsuario == null) ? 0 : ideUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (ideUsuario == null) {
			if (other.ideUsuario != null)
				return false;
		} else if (!ideUsuario.equals(other.ideUsuario))
			return false;
		return true;
	}

	
	
	@Column(name="color_usuario", nullable=true,  length=50)
    public String getColorPopup() {
		return colorPopup;
	}
	public void setColorPopup(String colorPopup) {
		this.colorPopup = colorPopup;
	}
	@Override
    public String toString() {
        return "Usuario{" +
                "ideUsuario=" + ideUsuario +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", grupos=" + grupos +
                ", activo=" + activo +
                '}';
    }
}
