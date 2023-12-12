package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import interfaces.observer;

public class Grupo  implements observer, Serializable {
	private static final long serialVersionUID = 1L;
    private String clave;
    private String profesor;
    private List<Alumno> alumnos = new ArrayList<Alumno>();
    private List<Asignacion> asignaciones = new ArrayList<Asignacion>();
    private Materia materia;
    private Grupo grupo;
    private String imagen;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    @Override
    public void actualizar() {
        // TODO Auto-generated method stub
    }

    public Grupo(String claveGrupo, String claveProfesor, Materia claveMateria) {
        this.clave = claveGrupo;
        this.profesor = claveProfesor;
        this.materia = claveMateria;
    }

    public Grupo() {
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public String getClave() {
        return clave;
    }

    public String getProfesor() {
        return profesor;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }
	
public void agregarAlumno(Alumno alumno, Administrador administrador) {
		
	}
	public void eliminarAlumno(Alumno alumno, Administrador administrador) {
		
	}
	public Materia getMateria() {
	    // Puedes implementar lógica para obtener la materia asociada al grupo
	    return materia;
	}

	
}