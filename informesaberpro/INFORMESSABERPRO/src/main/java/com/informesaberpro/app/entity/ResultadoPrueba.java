package com.informesaberpro.app.entity;

import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "resultados_pruebas")

public class ResultadoPrueba {
	@Id
	private String id;
	private String idEstudiante;
	private String numeroRegistro;
	private int puntaje;
	private String saberProMediaNacional; // "Aprobado" o "Reprobado"
	private int nivelSaberPro; // Nuevo campo para el nivel general (1, 2, 3)
	private int comunicacionEscrita;
	private int razonamientoCuantitativo;
	private int lecturaCritica;
	private int competenciasCiudadanas;
	private int ingles;
	private int formulacionProyectos;
	private int pensamientoCientifico;
	private int disenoSoftware;
	private int comunicacionEscritaNivel;
	private int razonamientoCuantitativoNivel;
	private int lecturaCriticaNivel;
	private int competenciasCiudadanasNivel;
	private int inglesNivel;
	private int formulacionProyectosNivel;
	private int pensamientoCientificoNivel;
	private int disenoSoftwareNivel;

	// Constructor vacío
	public ResultadoPrueba() {
	}

	// Getters y Setters
	public String getId() {
	    return id;
	}

	public void setId(String id) {
	    this.id = id;
	}

	public String getIdEstudiante() {
	    return idEstudiante;
	}

	public void setIdEstudiante(String idEstudiante) {
	    this.idEstudiante = idEstudiante;
	}

	public String getNumeroRegistro() {
	    return numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
	    this.numeroRegistro = numeroRegistro;
	}

	public int getPuntaje() {
	    return puntaje;
	}

	public void setPuntaje(int puntaje) {
	    this.puntaje = puntaje;
	}

	public String getSaberProMediaNacional() {
	    return saberProMediaNacional;
	}

	public void setSaberProMediaNacional(String saberProMediaNacional) {
	    this.saberProMediaNacional = saberProMediaNacional;
	}

	public int getNivelSaberPro() {
	    return nivelSaberPro;
	}

	public void setNivelSaberPro(int nivelSaberPro) {
	    this.nivelSaberPro = nivelSaberPro;
	}

	public int getComunicacionEscrita() {
	    return comunicacionEscrita;
	}

	public void setComunicacionEscrita(int comunicacionEscrita) {
	    this.comunicacionEscrita = comunicacionEscrita;
	}

	public int getRazonamientoCuantitativo() {
	    return razonamientoCuantitativo;
	}

	public void setRazonamientoCuantitativo(int razonamientoCuantitativo) {
	    this.razonamientoCuantitativo = razonamientoCuantitativo;
	}

	public int getLecturaCritica() {
	    return lecturaCritica;
	}

	public void setLecturaCritica(int lecturaCritica) {
	    this.lecturaCritica = lecturaCritica;
	}

	public int getCompetenciasCiudadanas() {
	    return competenciasCiudadanas;
	}

	public void setCompetenciasCiudadanas(int competenciasCiudadanas) {
	    this.competenciasCiudadanas = competenciasCiudadanas;
	}

	public int getIngles() {
	    return ingles;
	}

	public void setIngles(int ingles) {
	    this.ingles = ingles;
	}

	public void setFormulacionProyectos(int formulacionProyectos) {
	    this.formulacionProyectos = formulacionProyectos;
	}

	public int getFormulacionProyectos() {
	    return formulacionProyectos;
	}

	public int getPensamientoCientifico() {
	    return pensamientoCientifico;
	}

	public void setPensamientoCientifico(int pensamientoCientifico) {
	    this.pensamientoCientifico = pensamientoCientifico;
	}

	public int getDisenoSoftware() {
	    return disenoSoftware;
	}

	public void setDisenoSoftware(int disenoSoftware) {
	    this.disenoSoftware = disenoSoftware;
	}

	public int getComunicacionEscritaNivel() {
	    return comunicacionEscritaNivel;
	}

	public void setComunicacionEscritaNivel(int comunicacionEscritaNivel) {
	    this.comunicacionEscritaNivel = comunicacionEscritaNivel;
	}

	public int getRazonamientoCuantitativoNivel() {
	    return razonamientoCuantitativoNivel;
	}

	public void setRazonamientoCuantitativoNivel(int razonamientoCuantitativoNivel) {
	    this.razonamientoCuantitativoNivel = razonamientoCuantitativoNivel;
	}

	public int getLecturaCriticaNivel() {
	    return lecturaCriticaNivel;
	}

	public void setLecturaCriticaNivel(int lecturaCriticaNivel) {
	    this.lecturaCriticaNivel = lecturaCriticaNivel;
	}

	public int getCompetenciasCiudadanasNivel() {
	    return competenciasCiudadanasNivel;
	}

	public void setCompetenciasCiudadanasNivel(int competenciasCiudadanasNivel) {
	    this.competenciasCiudadanasNivel = competenciasCiudadanasNivel;
	}

	public int getInglesNivel() {
	    return inglesNivel;
	}

	public void setInglesNivel(int inglesNivel) {
	    this.inglesNivel = inglesNivel;
	}

	public int getFormulacionProyectosNivel() {
	    return formulacionProyectosNivel;
	}

	public void setFormulacionProyectosNivel(int formulacionProyectosNivel) {
	    this.formulacionProyectosNivel = formulacionProyectosNivel;
	}

	public int getPensamientoCientificoNivel() {
	    return pensamientoCientificoNivel;
	}

	public void setPensamientoCientificoNivel(int pensamientoCientificoNivel) {
	    this.pensamientoCientificoNivel = pensamientoCientificoNivel;
	}

	public int getDisenoSoftwareNivel() {
	    return disenoSoftwareNivel;
	}

	public void setDisenoSoftwareNivel(int disenoSoftwareNivel) {
	    this.disenoSoftwareNivel = disenoSoftwareNivel;
	}
}
