package Logica;

import java.util.Date;

public abstract class Actividad {
	private int id;
	private String titulo;
	private String descripcion;
	private Date fechaVencimiento;
	private AgregarActividad estrategia;
	private EstadoActividad estado;
	
	public void realizarTarea() {
		
	}
	public void crearActividad() {
		
	}
	public void marcarPendiente() {
		
	}
	public void marcarSubido() {
		
	}
	public void marcarCalificado() {
		
	}
	
	
}
