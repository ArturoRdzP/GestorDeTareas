package Logica;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.context.FacesContext;
import BaseDeDatos.ConexionBaseDeDatos;
import interfaces.observer;

public class Profesor extends Usuario implements observer {
	  public Profesor(String clave_usuario2, String nombre2, String correo2, String rol2, String contraseña2) {
		super(clave_usuario2, nombre2, correo2, rol2, contraseña2);
		// TODO Auto-generated constructor stub
	}
	  public Profesor() {}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	List<Materia>materia=new ArrayList<Materia>();
	
	
	 
	@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}
	public void asignarActividad() {
		
		
	}
	public void asignarActividad(Actividad actividad) {
	}
	public double calificarAsignacion(Asignacion asignacion) {
		return 0;
	}
	public void configurarRubrica(Asignacion asignacion, List<Criterio> criterios) {		
	}
	
	public void enviarCorreo() {
	}
	
	 
}
