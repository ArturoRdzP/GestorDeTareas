package Logica;

public class Alumno extends Usuario {

	private String no_control;
	private Actividad actividad;

	public Alumno(String no_control, String nombre, String correo, String rol, String contraseña, String imagen) {
		super(nombre, correo, rol, contraseña, imagen);
		this.no_control = no_control;
	}

	public void mostrarAsignaciones() {

	}

	public void enviarActividad(Actividad actividad) {

	}

}
