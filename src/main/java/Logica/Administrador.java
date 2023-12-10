package Logica;

import java.util.ArrayList;

public class Administrador extends Usuario{
	
	public void agregarUsuario(Usuario usuario) {
		
	}
	public void eliminarUsuario(Usuario usuario) {
		
	}
	
	public void crearGrupo(Profesor profesor, ArrayList<Alumno> alumnos, Materia materia) {
		
	}
	
	public void crearMateria(Materia materia) {
		materia.agregarMateria(materia, Administrador.this);
	}
	public void eliminarMateria(Materia materia) {
		materia.eliminarMateria(materia, Administrador.this);
	}
}
