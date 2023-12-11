package Logica;

import java.util.List;

public class Profesor extends Usuario implements Observer {

	private String no_profesor;

	public Profesor(String no_profesor, String nombre, String correo, String rol, String contraseña, String imagen) {
		super(nombre, correo, rol, contraseña, imagen);
		this.no_profesor = no_profesor;
	}

	public void asignarActividad(Actividad actividad) {
	}

	public double calificarAsignacion(Asignacion asignacion) {
		return 0;
	}

	public void configurarRubrica(Asignacion asignacion, List<Criterio> criterios) {
	}

	@Override
	public void enviarCorreo() {
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
	}

}
