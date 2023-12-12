package Logica;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Observer;

import interfaces.Sujeto;
import interfaces.observer;

public class Asignacion implements Sujeto{
	private int id;
	private String titulo;
	private String descripcion;
	private Date fechaVencimiento;
	private String estado;
	private Grupo grupo;
	private Actividad actividad;
	private Calificacion calificacion;
	private List<observer> observers = new ArrayList<observer>();
	
	public void crearAsignacion(Actividad actividad, Profesor profesor) {
		
	}
	
	public void publicarAsignacion() {
		
	}
	public void modificarCriterios() {
		
	}
	public void cerrarAsignacion(Asignacion asignacion) {
		
	}
	public ArrayList<Asignacion> mostrarAsignaciones() {
		return null;
		
	}
	public void registrarObservadores(Observer observer) {
		
	}
	public void eliminarObservadores(Observer observer) {
		
	}
	

	@Override
	public void registrarObserver(observer ob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarObserver(observer ob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nortificar() {
		// TODO Auto-generated method stub
		
	}
	

}
