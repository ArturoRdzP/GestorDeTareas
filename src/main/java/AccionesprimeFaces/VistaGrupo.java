package AccionesprimeFaces;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class VistaGrupo implements Serializable{

	private String grupoClave; 
	private String nombreUsuario;
	private String correo;
	private String claveUsuari;
	private static final long serialVersionUID = 10L;
	public VistaGrupo() {}
	@PostConstruct
    public void init() {
        // Recuperar el parámetro de la clave del grupo
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, String> parameterMap = externalContext.getRequestParameterMap();
        grupoClave = parameterMap.get("grupoClave");
        nombreUsuario = parameterMap.get("nombreUsuario");
        correo = parameterMap.get("correo");
        claveUsuari = parameterMap.get("claveUsuari");
        System.out.print("entro" + grupoClave);
    }
	/**
	 * @return the grupoClave
	 */
	public String getGrupoClave() {
		return grupoClave;
	}
	/**
	 * @param grupoClave the grupoClave to set
	 */
	public void setGrupoClave(String grupoClave) {
		this.grupoClave = grupoClave;
	}
	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @return the claveUsuari
	 */
	public String getClaveUsuari() {
		return claveUsuari;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * @param claveUsuari the claveUsuari to set
	 */
	public void setClaveUsuari(String claveUsuari) {
		this.claveUsuari = claveUsuari;
	}
	
}
