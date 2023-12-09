package Logica;

import java.util.List;


public class Profesor extends Usuario implements Observer{
	
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
