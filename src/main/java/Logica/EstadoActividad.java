package Logica;

public interface EstadoActividad {
	
	public void marcarPendiente(Actividad actividad);
	public void marcarSubido(Actividad actividad);
	public void marcarCalificado(Actividad actividad);
}
