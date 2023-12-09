package Logica;

import java.util.ArrayList;
import java.util.List;

public abstract class Criterio {
	
	private AgregarCriterio estrategiaCriterio;
	private String descripcion;
	private int porcentaje;
	private List<Criterio> criterios = new ArrayList<Criterio>();
	
	public Criterio(String descripcion, int porcentaje) {
		this.descripcion = descripcion;
		this.porcentaje = porcentaje;
	}
	
	public void agregarCriterio(Criterio criterio) {
		
	}
	public void eliminarCriterio(Criterio criterio) {
		
	}
	
	

}
