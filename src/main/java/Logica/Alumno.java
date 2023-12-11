package Logica;

public class Alumno extends Usuario{
	
	private String clave_alumno;
	private Actividad actividad;
	
	
	
	
	
	public Alumno(String clave_alumno, String nombre, String clave_usuario, String correo, String rol, String contraseña) {
		super(clave_usuario, nombre, correo, rol, contraseña);
		this.clave_alumno = clave_alumno;
	}
	public void mostrarAsignaciones() {
		
		
		
	}
	public void enviarActividad(Actividad actividad) {
		
	}
	
}
