package com.vs.recaudacion.archivo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.vs.recaudacion.usuario.Usuario;


@Entity
public class Archivo {

	@Id
	private String codFile;
	@Column 
	private String nombreDocumento;
	@Column 
	private String url;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_cod",referencedColumnName="cod")
	private Usuario usuario;
	

	public Archivo() {
		
	}


	public String getCodFile() {
		return codFile;
	}


	public void setCodFile(String codFile) {
		this.codFile = codFile;
	}


	public String getNombreDocumento() {
		return nombreDocumento;
	}


	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	
}
