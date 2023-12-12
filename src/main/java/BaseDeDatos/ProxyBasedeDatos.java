package BaseDeDatos;

import java.util.ArrayList;
import java.util.List;

import Logica.Grupo;
import Logica.Profesor;
import Logica.Usuario;

public class ProxyBasedeDatos {
	private static List<Usuario> usuarioProxy=new ArrayList<Usuario>();
	
	private ProxyBasedeDatos() {}
	public static  List<Usuario> metoProxyConsultaUsuario() {
		try {
			return usuarioProxy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarioProxy;				
	}
	public static   List<Usuario> metoRealConsultaUsuario()
	{
		try {
			usuarioProxy=ConexionBaseDeDatos.obtenerDatosUsuario();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarioProxy;	
	}
	
}
