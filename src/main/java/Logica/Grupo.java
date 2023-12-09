package Logica;

import java.util.ArrayList;


public class Grupo implements Observer{
	private String clave;
	private Profesor profesor;
	private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	private ArrayList<Asignacion> asignaciones = new ArrayList<Asignacion>();
	private Materia materia;
	
	public void agregarAlumno(Alumno alumno, Administrador administrador) {
		
	}
	public void eliminarAlumno(Alumno alumno, Administrador administrador) {
		
	}
	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}
	

}
