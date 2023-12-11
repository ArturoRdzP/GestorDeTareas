package Logica;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

public class Asignacion implements Sujeto{
	private int id;
	private String titulo;
	private String descripcion;
	private Date fechaApertura;
	private Date fechaVencimiento;
	private String estado;
	private Grupo grupo;
	private Actividad actividad;
	private Calificacion calificacion;
	private List<Observer> observers = new ArrayList<Observer>();
	
	
	
	
	
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
	public void notificar() {
		// TODO Auto-generated method stub
		
	}
	

}
