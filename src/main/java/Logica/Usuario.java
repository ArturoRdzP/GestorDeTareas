package Logica;

import java.io.IOException;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import BaseDeDatos.ProxyBasedeDatos;

@ManagedBean
@SessionScoped
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String clave_usuario;

	protected String nombre;
	protected String contraseña;
	protected String rol;
	protected String correo;
	protected List<Grupo> grupos = new ArrayList<Grupo>();
	protected List<Usuario> usuario = new ArrayList<Usuario>();

	
	public Usuario() {}
	public Usuario(String clave_usuario2, String nombre2, String correo2, String rol2, String contraseña2) {
		this.clave_usuario = clave_usuario2;
		this.nombre=nombre2;
		this.correo=correo2;
		this.rol=rol2;
		this.contraseña = contraseña2;
		
	}

	public void validadUsuario() throws IOException {
		usuario = ProxyBasedeDatos.metoRealConsultaUsuario();
	    for (Usuario usuario1 : usuario) {
	    	
	        if (correo.equals(usuario1.getCorreo()) && contraseña.equals(usuario1.getContraseña())) {
	            // Generar token y guardar en la sesión
	            this.clave_usuario = usuario1.getClave_usuario();
	            String token = generarToken();  
	            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userToken", token);
	            if (usuario1.getRol().equals("profesor")) {
	                // Establecer usuario en la sesión
	                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this);
	                this.redireccionar("darhsbord.xhtml");
	              
	            }

			}
		}
	}

	private String generarToken() {
		// Puedes usar bibliotecas especializadas o implementar tu lógica de generación
		// de tokens aquí
		SecureRandom random = new SecureRandom();
		byte[] tokenBytes = new byte[32];
		random.nextBytes(tokenBytes);
		return Base64.getUrlEncoder().encodeToString(tokenBytes);
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

	private void redireccionar(String pagina) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(pagina);
	}

	/**
	 * @return the grupos
	 */
	public List<Grupo> getGrupos() {
		return grupos;
	}

	/**
	 * @return the usuario
	 */
	public List<Usuario> getUsuario() {
		return usuario;
	}

	/**
	 * @param grupos the grupos to set
	 */
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the clave_usuario
	 */
	public String getClave_usuario() {
		return clave_usuario;
	}

	/**
	 * @param clave_usuario the clave_usuario to set
	 */
	public void setClave_usuario(String clave_usuario) {
		this.clave_usuario = clave_usuario;
	}
	public void enviarCorreo() {
	};
	public void cerrarSesion() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        redireccionar("login.xhtml");
    }
}