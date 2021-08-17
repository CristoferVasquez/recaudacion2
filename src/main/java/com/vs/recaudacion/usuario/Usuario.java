package com.vs.recaudacion.usuario;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vs.recaudacion.archivo.Archivo;

@Entity

public class Usuario {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod;
	@Column
	private String rut;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String email;
	@Column
	private String genero;
	
	@JsonIgnore
	@OneToMany (mappedBy="usuario")
	private Set<Archivo> archivos = new HashSet<>();
	
	

	public Usuario() {
	
	}



	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Set<Archivo> getArchivos() {
		return archivos;
	}

	public void setArchivos(Set<Archivo> archivos) {
		this.archivos = archivos;
	}
	
	
	}