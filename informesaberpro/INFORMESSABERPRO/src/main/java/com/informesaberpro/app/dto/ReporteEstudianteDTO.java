package com.informesaberpro.app.dto;

import com.informesaberpro.app.entity.Estudiante; 
import com.informesaberpro.app.entity.ResultadoPrueba;

public class ReporteEstudianteDTO {
	private Estudiante estudiante; 
	private ResultadoPrueba resultadoPrueba;
	public ReporteEstudianteDTO(Estudiante estudiante, ResultadoPrueba resultadoPrueba) {
	    this.estudiante = estudiante;
	    this.resultadoPrueba = resultadoPrueba;
	}

	public Estudiante getEstudiante() { return estudiante; }
	public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
	public ResultadoPrueba getResultadoPrueba() { return resultadoPrueba; }
	public void setResultadoPrueba(ResultadoPrueba resultadoPrueba) { this.resultadoPrueba = resultadoPrueba; }
}
