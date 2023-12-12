package Logica;



public abstract class Actividad {
    private String titulo;
    private String descripcion;
    private AgregarActividad estrategia;
    private EstadoActividad estado;
    private String documento;

    public Actividad(String titulo, String descripcion, EstadoActividad estado, String documento) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.documento = documento;
    }

    public void realizarTarea() {

    }

    public void crearActividad() {
        
    }

    public void marcarPendiente() {

    }

    public void marcarSubido() {

    }

    public void marcarCalificado() {

    }

}
