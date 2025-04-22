package com.informesaberpro.app.entity;

import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "estudiantes")

public class Estudiante {

	@Id
	private String id;
	private String tipoDocumento;
	private String numeroDocumento;
	private String primerApellido;
	private String segundoApellido;
	private String primerNombre;
	private String segundoNombre;
	private String correoElectronico;
	private String numeroTelefono;

	// Constructor vacío
	public Estudiante() {
	}

	// Getters y Setters
	public String getId() {
	    return id;
	}

	public void setId(String id) {
	    this.id = id;
	}

	public String getTipoDocumento() {
	    return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
	    this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
	    return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
	    this.numeroDocumento = numeroDocumento;
	}

	public String getPrimerApellido() {
	    return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
	    this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
	    return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
	    this.segundoApellido = segundoApellido;
	}

	public String getPrimerNombre() {
	    return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
	    this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
	    return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
	    this.segundoNombre = segundoNombre;
	}

	public String getCorreoElectronico() {
	    return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
	    this.correoElectronico = correoElectronico;
	}

	public String getNumeroTelefono() {
	    return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
	    this.numeroTelefono = numeroTelefono;
	}
}

