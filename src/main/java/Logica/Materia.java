package Logica;

import BaseDeDatos.ConexionBaseDeDatos;
import java.util.ArrayList;

public class Materia {
    
    private String clave;
    private String nombre;
    private int unidades;
    
    public Materia(String clave, String nombre, int unidades) {
        this.clave = clave;
        this.nombre = nombre;
        this.unidades = unidades;
    }
    
    public void agregarMateria(Materia materia, Administrador administrador) {
        ConexionBaseDeDatos.crearMateria(materia);
    }
    
    public void eliminarMateria(Materia materia, Administrador administrador) {
        ConexionBaseDeDatos.eliminarMateria(materia);
    }
    
    public String getClave() {
        return clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getUnidades() {
        return unidades;
    }
    
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
}
