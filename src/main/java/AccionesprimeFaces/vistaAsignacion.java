package AccionesprimeFaces;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class vistaAsignacion implements Serializable{
	private int id;
	private String titulo;
	private String descipcion;
	protected  int grupo_id;
	private Date fecha_creacion;
	private Date fechaVencimiento;
	
	
	public vistaAsignacion(int id, String titulo, String descipcion, int grupo_id, Date fecha_creacion,
			Date fechaVencimiento) {
		
		this.id = id;
		this.titulo = titulo;
		this.descipcion = descipcion;
		this.grupo_id = grupo_id;
		this.fecha_creacion = fecha_creacion;
		this.fechaVencimiento = fechaVencimiento;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}


	/**
	 * @return the descipcion
	 */
	public String getDescipcion() {
		return descipcion;
	}


	/**
	 * @return the grupo_id
	 */
	public int getGrupo_id() {
		return grupo_id;
	}


	/**
	 * @return the fecha_creacion
	 */
	public Date getFecha_creacion() {
		return fecha_creacion;
	}


	/**
	 * @return the fechaVencimiento
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	/**
	 * @param descipcion the descipcion to set
	 */
	public void setDescipcion(String descipcion) {
		this.descipcion = descipcion;
	}


	/**
	 * @param grupo_id the grupo_id to set
	 */
	public void setGrupo_id(int grupo_id) {
		this.grupo_id = grupo_id;
	}


	/**
	 * @param fecha_creacion the fecha_creacion to set
	 */
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}


	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	private static final long serialVersionUID = 3L;

}
