package com.titanic.ventapasajes.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pvm_grupo")
public class Grupo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long ideGrupo;
	private String nombreGrupo;
	private String descripcion;
	
	@Id
	@GeneratedValue
	@Column(name="ide_grupo", nullable=false, length=10)
	public Long getIdeGrupo() {
		return ideGrupo;
	}
	public void setIdeGrupo(Long ideGrupo) {
		this.ideGrupo = ideGrupo;
	}
	@Column(name="nombre_grupo", nullable=false,length=255 )
	public String getNombreGrupo() {
		return nombreGrupo;
	}
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}
	@Column(name="descripcion", length=355)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ideGrupo == null) ? 0 : ideGrupo.hashCode());
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
		Grupo other = (Grupo) obj;
		if (ideGrupo == null) {
			if (other.ideGrupo != null)
				return false;
		} else if (!ideGrupo.equals(other.ideGrupo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Grupo [ideGrupo=" + ideGrupo + ", nombreGrupo=" + nombreGrupo
				+ ", descripcion=" + descripcion + "]";
	}

	
}
