package Logica;

import java.util.ArrayList;

public class Materia {
	private String clave;
	private String nombre;
	private String imagen;
	private ArrayList<String> unidades;
	
	public Materia(String imagen, String nombre2) {
		// TODO Auto-generated constructor stub
		this.nombre=nombre2;
		this.imagen=imagen;
	}
	public Materia() {}
	public void agregarMateria(Materia materia, Administrador administrador) {
		
	}
	public void eliminarMateria(Materia materia, Administrador administrador) {
		
	}
	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * @return the unidades
	 */
	public ArrayList<String> getUnidades() {
		return unidades;
	}
	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	 * @param unidades the unidades to set
	 */
	public void setUnidades(ArrayList<String> unidades) {
		this.unidades = unidades;
	}
	
}
