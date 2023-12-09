package Logica;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import BaseDeDatos.ProxyBasedeDatos;
@ManagedBean
@SessionScoped
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String contraseña;
	private String rol;
	private String correo;
	private List<Grupo> grupo=new ArrayList<Grupo>();
	private List<Usuario> usuario=new ArrayList<Usuario>();
	public Usuario(String nombre, String correo, String rol, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.contraseña = contraseña;
    }
	 public Usuario() {
	    }
	 public void validadUsuario() throws IOException {
	        usuario = ProxyBasedeDatos.metoRealConsultaUsuario();
	        for (Usuario usuario1 : usuario) {
	            if (correo.equals(usuario1.getCorreo()) && contraseña.equals(usuario1.getContraseña())) {
	                System.out.println(correo + " entro");
	               if(usuario1.getRol().equals("profesor")) {
	                this.redireccionar("darhsbord.xhtml");}
	            }
	        }
	       
	    }
		
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}
	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}
	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @return the grupo
	 */
	public List<Grupo> getGrupo() {
		return grupo;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(List<Grupo> grupo) {
		this.grupo = grupo;
	}
	
	private void redireccionar(String pagina) throws IOException {
		ExternalContext ec= FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(pagina);
	}
	
}
