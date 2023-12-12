package Logica;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

public class Asignacion implements Sujeto {

    private int id;
    private String titulo;
    private String descripcion;
    private Date fechaApertura;
    private Date fechaVencimiento;
    private String estado;

//	private Grupo grupo;
    private String grupo;
//	private Actividad actividad;
    private String actividad;
//	private Calificacion calificacion;
    private String calificacion;
    private List<Observer> observers = new ArrayList<Observer>();

    public Asignacion(String titulo, String descripcion, String estado, String grupo, String actividad,
            String calificacion, Date fechaApertura, Date fechaVencimiento) {
        super();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.grupo = grupo;
        this.actividad = actividad;
        this.calificacion = calificacion;
        this.fechaApertura = fechaApertura;
        this.fechaVencimiento = fechaVencimiento;
    }

    public void crearAsignacion(Actividad actividad, Profesor profesor) {
        
    }

    public void publicarAsignacion() {

    }

    public void modificarCriterios() {

    }

    public void cerrarAsignacion(Asignacion asignacion) {

    }

    public ArrayList<Asignacion> mostrarAsignaciones() {
        return null;

    }

    public void registrarObservadores(Observer observer) {
        observers.add(observer);
    }

    public void eliminarObservadores(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notificar() {
        // TODO Auto-generated method stub

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

}
