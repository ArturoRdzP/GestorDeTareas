package AccionesprimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import BaseDeDatos.ConexionBaseDeDatos;
import Logica.Usuario;

@ManagedBean
@ViewScoped
public class VistaProfesores implements Serializable {
	private String nombreMateria;
	protected  String claveGrupo;
	private String img;
	private String claveMateria;
	private List<VistaProfesores>lista=new ArrayList<VistaProfesores>();
	public VistaProfesores() {}
	private static final long serialVersionUID = 2L;
	private String claveUsuari;
	private String correo;
	private String nombre;
	private String claveUsuario;
	private String nombreUsuario;
	public VistaProfesores(String nombreMateria, String claveGrupo, String img, String claveMateria, String nombre,String nombreUsuario2) {
		
		this.nombreMateria = nombreMateria;
		this.claveGrupo = claveGrupo;
		this.img = img;
		this.claveMateria = claveMateria;
		this.nombre=nombre;
		this.nombreUsuario=nombreUsuario2;
	}
	@PostConstruct
    public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
        Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            // Ahora puedes acceder a los datos del usuario desde la instancia 'usuario'
        	 claveUsuari=usuario.getClave_usuario();
        	 correo=usuario.getCorreo();       	       	
        	 lista=ConexionBaseDeDatos.consultarDatos(claveUsuari);
        	 System.out.println(lista);
        	 for (VistaProfesores profesor : lista) {
        		    String claveUsuarioProfesor = profesor.getClaveUsuari();
        		    System.out.println(claveUsuarioProfesor);

        		        nombreUsuario = profesor.getNombreUsuario();
        		        break;  // Agrega un break para salir del bucle una vez que encuentres la coincidencia
        	 }
        	 System.out.println("Nombre de usuario después de inicializar: " + nombreUsuario);
        	 System.out.println("Lista después de inicializar: " + lista);
    }
	/**
	 * @return the nombreMateria
	 */
	public String getNombreMateria() {
		return nombreMateria;
	}
	/**
	 * @return the claveGrupo
	 */
	public String getClaveGrupo() {
		return claveGrupo;
	}
	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}
	/**
	 * @return the claveMateria
	 */
	public String getClaveMateria() {
		return claveMateria;
	}
	/**
	 * @param nombreMateria the nombreMateria to set
	 */
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	/**
	 * @param claveGrupo the claveGrupo to set
	 */
	public void setClaveGrupo(String claveGrupo) {
		this.claveGrupo = claveGrupo;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @param claveMateria the claveMateria to set
	 */
	public void setClaveMateria(String claveMateria) {
		this.claveMateria = claveMateria;
	}
	/**
	 * @return the lista
	 */
	public List<VistaProfesores> getLista() {
		return lista;
	}
	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<VistaProfesores> lista) {
		this.lista = lista;
	}
	/**
	 * @return the claveUsuari
	 */
	public String getClaveUsuari() {
		return claveUsuari;
	}
	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param claveUsuari the claveUsuari to set
	 */
	public void setClaveUsuari(String claveUsuari) {
		this.claveUsuari = claveUsuari;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the claveUsuario
	 */
	public String getClaveUsuario() {
		return claveUsuario;
	}
	/**
	 * @param claveUsuario the claveUsuario to set
	 */
	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}
	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		
		    return nombreUsuario; 
	}
	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
}
