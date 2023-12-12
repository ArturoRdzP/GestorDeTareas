package Logica;

import java.util.ArrayList;
import java.util.List;


public class Calificacion {
	private Double valorDouble;
	private ArrayList<Criterio> criterios = new ArrayList<Criterio>();
	
	public ArrayList<Criterio> mostrarCriterios() {
		return criterios;
	}
	public double calificar(List<Criterio> criteriosEvaluados) {
		return valorDouble;
		
	}
}	
