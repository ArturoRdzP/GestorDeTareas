package Logica;

import java.util.ArrayList;

public class Administrador extends Usuario{
	
	
	public Administrador(String clave_usuario2, String nombre2, String correo2, String rol2, String contraseña2) {
		super(clave_usuario2, nombre2, correo2, rol2, contraseña2);
		// TODO Auto-generated constructor stub
	}
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
